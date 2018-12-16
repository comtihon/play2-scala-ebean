package model.dao

import java.util

import javax.persistence._
import model.dto.MasterDTO
import scala.collection.JavaConverters._


@Table(name = "master")
@Entity
class Master {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "master_id")
  var masterId: Int = _

  @Column(name = "master_name")
  var masterName: String = _

  @OneToMany(cascade = Array(CascadeType.MERGE))
  var pets: util.List[Pet] = new util.ArrayList[Pet]()

  def assignPet(pet: Pet): Unit = {
    pets.add(pet)
    pet.assignMaster(this)
  }

  def toDTO: MasterDTO = {
    MasterDTO(Some(masterId), masterName, Some(pets.asScala.toList.map(_.toDTO)))
  }
}
