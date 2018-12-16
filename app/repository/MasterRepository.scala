package repository

import com.google.inject.ImplementedBy
import model.dao.Master

@ImplementedBy(classOf[MasterRepositoryImpl])
trait MasterRepository extends AbstractRepository[Master] {
}
