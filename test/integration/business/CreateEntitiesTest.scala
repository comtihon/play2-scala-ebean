package integration.business

import integration.IntegrationTest
import play.api.libs.json.{JsValue, Json}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import repository.MasterRepository

class CreateEntitiesTest extends IntegrationTest {

  "Entities" must {

    "be created via controllers" in {

      val request = FakeRequest(POST, "/api/v1/master")
        .withHeaders("Content-Type" -> "application/json")
        .withBody(
          """
            |{"name":"Test"}
          """.stripMargin)

      val rq = route(app, request).get

      val responseBodyJson: JsValue = Json.parse(contentAsString(rq))
      responseBodyJson.toString() must be("{\"id\":1,\"name\":\"Test\",\"pets\":[]}")

      val repo = injector.instanceOf(classOf[MasterRepository])
      val found = repo.find(1)
      found mustBe defined
      found.get.masterName must be("Test")
    }

    "return bad request in case of invalid json" in {
      val request = FakeRequest(POST, "/api/v1/master")
        .withHeaders("Content-Type" -> "application/json")
        .withBody(
          """
            |{"cats":[]}
          """.stripMargin)
      val rq = route(app, request).get
      val responseBodyJson: JsValue = Json.parse(contentAsString(rq))
      assert(responseBodyJson.toString().startsWith("{\"error\":\"Wrong json:"))
    }

    "return error in case of error" in {
      val request = FakeRequest(PUT, "/api/v1/master/1")
        .withHeaders("Content-Type" -> "application/json")
        .withBody(
          """
            |{"pets":[{"petName":"Testie"}]}
          """.stripMargin)
      val rq = route(app, request).get
      val responseBodyJson: JsValue = Json.parse(contentAsString(rq))
      assert(responseBodyJson.toString() == "{\"error\":\"java.lang.Exception: No master for id: 1\"}")
    }
  }
}
