package model.dto

import model.dao.{Master, Pet, Role}

case class MasterDTO(id: Option[Int], name: String, pets: Option[List[PetDTO]]) {
  def toDAO: Master = {
    val master = new Master()
    master.masterId = id.getOrElse(0)
    master.masterName = name
    master
  }
}

case class PetDTO(id: Option[Int], petName: String, roles: Option[List[RoleDTO]]) {
  def toDAO: Pet = {
    val pet = new Pet()
    pet.petId = id.getOrElse(0)
    pet.petName = petName
    pet
  }
}

case class RoleDTO(roleName: String, isFixed: Boolean) {
  def toDAO: Role = {
    val role = new Role()
    role.roleName = roleName
    role.isFixed = isFixed
    role
  }
}