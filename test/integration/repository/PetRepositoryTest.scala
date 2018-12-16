package integration.repository

import integration.IntegrationTest
import repository.{MasterRepository, PetRepository, RoleRepository}

import scala.collection.JavaConverters._

class PetRepositoryTest extends IntegrationTest {
  val repo: PetRepository = injector.instanceOf(classOf[PetRepository])

  "Pet" must {
    "be saved" in {
      val pet = newPet("Lassie")
      repo.insert(pet)
      pet.petId must not be 0

      val found = repo.find(pet.petId)
      found mustBe defined
      found.get.petName must be(pet.petName)
    }
    "have role attached" in {
      val pet = newPet("Lassie")
      repo.insert(pet)
      val roleRepo = injector.instanceOf(classOf[RoleRepository])
      val role = newRole("friend")
      roleRepo.insert(role)
      pet.assignRole(role)
      repo.update(pet)
      val foundPet = repo.find(pet.petId).get
      print(foundPet.roles.asScala.toList)
      foundPet.roles must have size 1
      foundPet.roles.asScala.toList.head.roleName must be(role.roleName)
    }
    "by role and master be fetched" in {
      val masterRepo = injector.instanceOf(classOf[MasterRepository])
      val roleRepo = injector.instanceOf(classOf[RoleRepository])

      val master = newMaster("Bob")
      val pet = newPet("Lassie")
      val bullDog = newPet("Killer")
      val role = newRole("friend")
      val role2 = newRole("fight")
      masterRepo.insert(master)
      repo.insert(pet)
      repo.insert(bullDog)
      roleRepo.insert(role)
      roleRepo.insert(role2)

      master.assignPet(pet)
      master.assignPet(bullDog)
      pet.assignRole(role)
      bullDog.assignRole(role2)
      masterRepo.update(master)
      repo.update(pet)
      roleRepo.update(role)
      repo.update(bullDog)
      roleRepo.update(role2)

      val pets = repo.getMasterWithSuitablePets(master.masterId, role.roleName)
      pets must have size 1
      pets.head.petName must be(pet.petName)
    }
  }
}
