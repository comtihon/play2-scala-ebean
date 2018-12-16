package controllers

import javax.inject.Inject
import model.dto.RoleDTO
import play.api.libs.json.{Json, OFormat, OWrites}
import play.api.mvc.{Action, AnyContent}
import service.{AssignService, EntityService}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

class RoleController @Inject()(assignService: AssignService,
                               entityService: EntityService,
                               executionContext: ExecutionContext) extends SuperController {
  def createRole: Action[AnyContent] = Action.async { request =>
    implicit val formatRole: OFormat[RoleDTO] = Json.format[RoleDTO]
    val parsed = Json.fromJson(request.body.asJson.get)
    val body: RoleDTO = parsed.getOrElse(null)
    val dtoFuture = entityService.newRole(body)
    if (body == null) {
      Future.successful(BadRequest(Json.toJson(Json.obj("error" -> s"Wrong json: $parsed"))))
    } else {
      implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
      dtoFuture.transform {
        case Success(dto) => Try(Ok(Json.toJson(dto)))
        case Failure(e) =>
          e.printStackTrace()
          Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
      }(executionContext)
    }
  }

  def allRoles: Action[AnyContent] = Action.async {
    implicit val roleWrites: OWrites[RoleDTO] = Json.writes[RoleDTO]
    val dtoFuture = entityService.allRoles()
    dtoFuture.transform {
      case Success(dto) => Try(Ok(Json.toJson(dto)))
      case Failure(e) =>
        e.printStackTrace()
        Try(BadRequest(Json.toJson(Json.obj("error" -> e.toString))))
    }(executionContext)
  }

}
