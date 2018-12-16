package model.dao

import java.util
import javax.persistence._
import model.dto.RoleDTO


@Table(name = "role")
@Entity
class Role {
  @Id
  @Column(name = "role_name")
  var roleName: String = _

  @Column
  var isFixed: Boolean = _

  @ManyToMany(mappedBy = "roles")
  var pets: util.List[Pet] = new util.ArrayList[Pet]()

  def toDTO: RoleDTO = {
    RoleDTO(roleName, isFixed)
  }

  def assignPet(pet: Pet): Unit = {
    pets.add(pet)
  }
}