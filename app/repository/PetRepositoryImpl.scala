package repository

import javax.inject.Singleton
import model.dao.Pet
import scala.collection.JavaConverters._


@Singleton
class PetRepositoryImpl extends PetRepository {
  override def getMasterWithSuitablePets(masterId: Int, roleName: String): List[Pet] = {
    ebeanServer.find(classOf[Pet])
      .where()
      .eq("master.masterId", masterId)
      .eq("roles.roleName", roleName)
      .findList()
      .asScala
      .toList
  }
}
