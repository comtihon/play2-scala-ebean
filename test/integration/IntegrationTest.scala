package integration

import io.ebean.{Ebean, EbeanServer}
import model.dao.{Master, Pet, Role}
import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.Application
import play.api.db.Database
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.db.ebean.EbeanConfig

class IntegrationTest extends PlaySpec with GuiceOneAppPerTest with BeforeAndAfterEach {


  def application: Application = new GuiceApplicationBuilder().build()

  val injector: Injector = application.injector
  val ebeanServer: EbeanServer = Ebean.getServer(injector.instanceOf(classOf[EbeanConfig]).defaultServer())

  override def beforeEach() {
  }

  override def afterEach {
    val db: Database = injector.instanceOf(classOf[Database])
    val conn = db.getConnection()
    try {
      val stmt = conn.createStatement
      stmt.executeUpdate("truncate pet_role, pet, role, master;")
      stmt.executeUpdate("alter sequence master_master_id_seq restart 1;")
      stmt.executeUpdate("alter sequence pet_pet_id_seq restart 1;")
    } finally {
      conn.close()
    }
  }

  def newMaster(name: String): Master = {
    val master: Master = new Master()
    master.masterName = name
    master
  }

  def newPet(name: String): Pet = {
    val pet: Pet = new Pet()
    pet.petName = name
    pet
  }

  def newRole(name: String): Role = {
    val role: Role = new Role()
    role.roleName = name
    role
  }
}
