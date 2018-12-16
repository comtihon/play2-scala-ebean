package controllers

import javax.inject.Inject
import model.dto.{PetDTO, RoleDTO}
import play.api.libs.json.{Json, OFormat, OWrites, __}
import play.api.mvc.{Action, AnyContent}
import service.{AssignService, EntityService}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

class PetController @Inject()(assignService: AssignService,
                              entityService: EntityService,
                              executionContext: ExecutionContext) extends SuperController {
  def createPet: Action[AnyContent] = Action.async { request =>
    implicit val formatRole: OFormat[RoleDTO] = Json.format[RoleDTO]
    implicit val formatPet: OFormat[PetDTO] = Json.format[PetDTO]
    val parsed = Json.fromJson(request.body.asJson.get)(formatPet)
    val body: PetDTO = parsed.getOrElse(null)
    if (body == null) {
      Future.successful(BadRequest(Json.toJson(Json.obj("error" -> s"Wrong json: $parsed"))))
    } else {
      val dtoFuture = entityService.newPet(body)
      implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
      implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
      dtoFuture.transform {
        case Success(dto) => Try(Ok(Json.toJson(dto)))
        case Failure(e) =>
          e.printStackTrace()
          Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
      }(executionContext)
    }
  }

  def getPet(pid: Int): Action[AnyContent] = Action.async {
    val dtoFuture = entityService.getPet(pid)
    implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
    implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
    dtoFuture.transform {
      case Success(dto) => Try(Ok(Json.toJson(dto)))
      case Failure(e) =>
        e.printStackTrace()
        Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
    }(executionContext)
  }

  def getSuitable(masterId: Int, roleName: String): Action[AnyContent] = Action.async {
    val dtoFuture = assignService.getSuitable(masterId, roleName)
    implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
    implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
    dtoFuture.transform {
      case Success(dto) => Try(Ok(Json.toJson(dto)))
      case Failure(e) =>
        e.printStackTrace()
        Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
    }(executionContext)
  }

  def assignRoles(petId: Int): Action[AnyContent] = Action.async { request =>
    implicit val formatRole: OFormat[RoleDTO] = Json.format[RoleDTO]
    implicit val roleWrapper = (__ \ "roles").format[List[RoleDTO]]
    val parsed = Json.fromJson(request.body.asJson.get)(roleWrapper)
    val roles: List[RoleDTO] = parsed.getOrElse(List.empty)
    if (roles.isEmpty) {
      Future.successful(BadRequest(Json.toJson(Json.obj("error" -> "Roles required"))))
    }else {
      val dtoFuture = assignService.assignRole(petId, roles)
      implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
      implicit val petWrites: OWrites[PetDTO] = Json.writes[PetDTO]
      dtoFuture.transform {
        case Success(dto) => Try(Ok(Json.toJson(dto)))
        case Failure(e) =>
          e.printStackTrace()
          Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
      }(executionContext)
    }
  }
}
