package model.dao

import java.util

import javax.persistence._
import model.dto.PetDTO
import scala.collection.JavaConverters._

@Table(name = "pet")
@Entity
class Pet {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "pet_id")
  var petId: Int = _

  @Column(name = "pet_name")
  var petName: String = _

  @ManyToOne
  var master: Master = _

  @ManyToMany(cascade = Array(CascadeType.MERGE))
  var roles: util.List[Role] = new util.ArrayList[Role]()

  def assignMaster(master: Master): Unit = {
    this.master = master
  }

  def assignRole(role: Role): Unit = {
    roles.add(role)
    role.assignPet(this)
  }

  def toDTO: PetDTO = {
    PetDTO(Some(petId), petName, Some(roles.asScala.toList.map(_.toDTO)))
  }
}

