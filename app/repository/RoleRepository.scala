package repository

import com.google.inject.ImplementedBy
import model.dao.Role

@ImplementedBy(classOf[RoleRepositoryImpl])
trait RoleRepository extends AbstractRepository[Role] {

}
