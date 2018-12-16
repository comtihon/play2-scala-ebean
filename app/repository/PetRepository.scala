package repository

import com.google.inject.ImplementedBy
import model.dao.Pet

@ImplementedBy(classOf[PetRepositoryImpl])
trait PetRepository extends AbstractRepository[Pet] {
  def getMasterWithSuitablePets(masterId: Int, roleName: String): List[Pet]
}
