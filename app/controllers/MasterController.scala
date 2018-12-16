package controllers


import javax.inject.Inject
import model.dto.{MasterDTO, PetDTO, RoleDTO}
import play.api.libs.json.{Json, OFormat, OWrites}
import play.api.mvc._
import service.{AssignService, EntityService}
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

class MasterController @Inject()(assignService: AssignService,
                                 entityService: EntityService,
                                 executionContext: ExecutionContext) extends SuperController {

  def createMaster: Action[AnyContent] = Action.async { request =>
    implicit val formatRole: OFormat[RoleDTO] = Json.format[RoleDTO]
    implicit val formatPet: OFormat[PetDTO] = Json.format[PetDTO]
    implicit val format: OFormat[MasterDTO] = Json.format[MasterDTO]
    val parsed = Json.fromJson(request.body.asJson.get)(format)
    val body: MasterDTO = parsed.getOrElse(null)
    if (body == null) {
      Future.successful(BadRequest(Json.toJson(Json.obj("error" -> s"Wrong json: $parsed"))))
    } else {
      val dtoFuture = entityService.newMaster(body)
      implicit val masterWrites: OWrites[MasterDTO] = Json.writes[MasterDTO]
      implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
      implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
      dtoFuture.transform {
        case Success(dto) => Try(Ok(Json.toJson(dto)))
        case Failure(e) =>
          e.printStackTrace()
          Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
      }(executionContext)
    }
  }

  def getMaster(id: Int): Action[AnyContent] = Action.async {
    val dtoFuture = entityService.readMaster(id)
    implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
    implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
    implicit val masterWrites: OWrites[MasterDTO] = Json.writes[MasterDTO]
    dtoFuture.transform {
      case Success(dto) => Try(Ok(Json.toJson(dto)))
      case Failure(e) => Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
    }(executionContext)
  }

  def assignPet(masterId: Int): Action[AnyContent] = Action.async { request =>
    implicit val formatRole: OFormat[RoleDTO] = Json.format[RoleDTO]
    implicit val formatPet: OFormat[PetDTO] = Json.format[PetDTO]
    implicit val petWrapper = (__ \ "pets").format[List[PetDTO]]
    val parsed = Json.fromJson(request.body.asJson.get)(petWrapper)
    val pets: List[PetDTO] = parsed.getOrElse(List.empty)
    if (pets.isEmpty) {
      Future.successful(BadRequest(Json.toJson(Json.obj("error" -> "Pet required"))))
    }
    else {
      val pet: PetDTO = pets.head // only first pet is attached
      val dtoFuture = assignService.assignPet(masterId, pet)
      implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
      implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
      implicit val masterWrites: OWrites[MasterDTO] = Json.writes[MasterDTO]
      dtoFuture.transform {
        case Success(dto) => Try(Ok(Json.toJson(dto)))
        case Failure(e) =>
          e.printStackTrace()
          Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
      }(executionContext)
    }
  }
}
