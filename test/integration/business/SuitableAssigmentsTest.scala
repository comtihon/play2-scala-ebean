package integration.business

import integration.IntegrationTest
import play.api.libs.json.{JsValue, Json}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import repository.{MasterRepository, PetRepository}

class SuitableAssigmentsTest extends IntegrationTest {
  "Pets" must {
    "be assigned to masters" in {
      val mRepo = injector.instanceOf(classOf[MasterRepository])
      val master = mRepo.insert(newMaster("Bob"))

      val pRepo = injector.instanceOf(classOf[PetRepository])

      val request = FakeRequest(PUT, "/api/v1/master/%d".format(master.masterId))
        .withHeaders("Content-Type" -> "application/json")
        .withBody(
          """
            |{"pets":[{"id":0,"petName":"test1"}]}
          """.stripMargin)
      val rq = route(app, request).get
      val responseBodyJson: JsValue = Json.parse(contentAsString(rq))
      assert(responseBodyJson.toString() == "{\"id\":1,\"name\":\"Bob\",\"pets\":{\"pets\":[{\"id\":1,\"petName\":\"test1\",\"roles\":[]}]}}")

      val foundPed = pRepo.find(1)
      foundPed mustBe defined
      foundPed.get.petName must be("test1")
      assert(foundPed.get.master == master)
    }
    "be assigned to roles" in {
      val pRepo = injector.instanceOf(classOf[PetRepository])
      val pet = pRepo.insert(newPet("testPet"))

      val request = FakeRequest(PUT, "/api/v1/pet/%d".format(pet.petId))
        .withHeaders("Content-Type" -> "application/json")
        .withBody(
          """
            |{"roles":[{"roleName":"testPets","isFixed":true},{"roleName":"lab0","isFixed":false}]}
          """.stripMargin)
      val rq = route(app, request).get
      val responseBodyJson: JsValue = Json.parse(contentAsString(rq))
      assert(responseBodyJson.toString() ==
        "{\"id\":1,\"petName\":\"testPet\",\"roles\":{\"roles\":[{\"roleName\":\"testPets\",\"isFixed\":true},{\"roleName\":\"lab0\",\"isFixed\":false}]}}")
      val foundPed = pRepo.find(1)
      foundPed mustBe defined
      foundPed.get.roles must have length 2
    }
  }

}
