package service

import javax.inject.{Inject, Singleton}
import model.dto.{MasterDTO, PetDTO, RoleDTO}
import repository.{MasterRepository, PetRepository, RoleRepository}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class EntityService @Inject()(petRepository: PetRepository,
                              masterRepository: MasterRepository,
                              roleRepository: RoleRepository,
                              executionContext: ExecutionContext) {

  def newMaster(masterDTO: MasterDTO): Future[MasterDTO] = Future {
    val dao = masterDTO.toDAO
    masterRepository.insert(dao)
    dao.toDTO
  }(executionContext)

  def readMaster(masterId: Int): Future[MasterDTO] = Future {
    masterRepository.find(masterId).map(_.toDTO).orNull
  }(executionContext)

  def newRole(roleDTO: RoleDTO): Future[RoleDTO] = Future {
    val dao = roleDTO.toDAO
    roleRepository.insert(dao)
    dao.toDTO
  }(executionContext)

  def allRoles(): Future[List[RoleDTO]] = Future {
    roleRepository.listAll().map(_.toDTO)
  }(executionContext)

  def newPet(petDTO: PetDTO): Future[PetDTO] = Future {
    val dao = petDTO.toDAO
    petRepository.insert(dao)
    dao.toDTO
  }(executionContext)

  def getPet(petId: Int): Future[PetDTO] = Future {
    petRepository.find(petId).map(_.toDTO).orNull
  }(executionContext)
}
