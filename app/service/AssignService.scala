package service

import javax.inject.{Inject, Singleton}
import model.dto.{MasterDTO, PetDTO, RoleDTO}
import repository.{MasterRepository, PetRepository, RoleRepository}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AssignService @Inject()(petRepository: PetRepository,
                              masterRepository: MasterRepository,
                              roleRepository: RoleRepository,
                              executionContext: ExecutionContext) {

  def assignPet(masterId: Int, pet: PetDTO): Future[MasterDTO] = Future {
    val masterDao = masterRepository
      .find(masterId)
      .getOrElse(throw new Exception(s"No master for id: $masterId"))
    val petDao = petRepository
      .find(pet.id.getOrElse(throw new Exception("pet's id should be specified")))
      .getOrElse(petRepository.insert(pet.toDAO))
    masterDao.assignPet(petDao)
    masterRepository.update(masterDao)
    masterDao.toDTO
  }(executionContext)

  def assignRole(petId: Int, roles: List[RoleDTO]): Future[PetDTO] = Future {
    val petDao = petRepository
      .find(petId)
      .getOrElse(throw new Exception(s"No pet for id: $petId"))
    roles
      .map(dto => roleRepository.find(dto.roleName).getOrElse(roleRepository.insert(dto.toDAO)))
      .foreach(petDao.assignRole)
    petRepository.update(petDao)
    petDao.toDTO
  }(executionContext)

  def getSuitable(masterId: Int, roleName: String): Future[List[PetDTO]] = Future {
    val masterDao = masterRepository.find(masterId).getOrElse(throw new Exception(s"No master for id: $masterId"))
    val roleDao = roleRepository.find(roleName).getOrElse(throw new Exception(s"No role for name $roleName"))
    val suitable = petRepository.getMasterWithSuitablePets(masterDao.masterId, roleDao.roleName)
    suitable.map(_.toDTO)
  }(executionContext)
}
