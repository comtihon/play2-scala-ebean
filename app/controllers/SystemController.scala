package controllers

import javax.inject.Inject
import play.api.Logger
import play.api.db.Database
import play.api.libs.json.Json


class SystemController @Inject()(database: Database) extends SuperController {
  private val logger = Logger(getClass)

  def healthCheck() = Action { implicit request =>
    val conn = database.getConnection()
    try {
      val stmt = conn.createStatement
      stmt.executeUpdate("select 1;")
      logger.debug("health check OK")
      Ok(Json.obj("health" -> "OK"))
    } catch {
      case e: Exception =>
        logger.warn("health check BAD. DB connection down", e)
        InternalServerError(Json.obj("health" -> s"HealthCheck failed: $e"))
    } finally {
      conn.close()
    }
  }
}
