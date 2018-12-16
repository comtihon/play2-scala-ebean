// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/vtikhonov/github/play2-scala-ebean/conf/routes
// @DATE:Thu Dec 13 09:50:32 CET 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  SystemController_3: controllers.SystemController,
  // @LINE:3
  MasterController_1: controllers.MasterController,
  // @LINE:7
  PetController_2: controllers.PetController,
  // @LINE:12
  RoleController_0: controllers.RoleController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    SystemController_3: controllers.SystemController,
    // @LINE:3
    MasterController_1: controllers.MasterController,
    // @LINE:7
    PetController_2: controllers.PetController,
    // @LINE:12
    RoleController_0: controllers.RoleController
  ) = this(errorHandler, SystemController_3, MasterController_1, PetController_2, RoleController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, SystemController_3, MasterController_1, PetController_2, RoleController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.SystemController.healthCheck"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/master/""" + "$" + """id<[^/]+>""", """controllers.MasterController.getMaster(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/master""", """controllers.MasterController.createMaster"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/master/""" + "$" + """masterId<[^/]+>""", """controllers.MasterController.assignPet(masterId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/pet/""" + "$" + """pid<[^/]+>""", """controllers.PetController.getPet(pid:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/pet""", """controllers.PetController.createPet"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/pet/""" + "$" + """masterId<[^/]+>/""" + "$" + """roleName<[^/]+>""", """controllers.PetController.getSuitable(masterId:Int, roleName:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/pet/""" + "$" + """petId<[^/]+>""", """controllers.PetController.assignRoles(petId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/roles""", """controllers.RoleController.allRoles"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/v1/roles""", """controllers.RoleController.createRole"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_SystemController_healthCheck0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_SystemController_healthCheck0_invoker = createInvoker(
    SystemController_3.healthCheck,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SystemController",
      "healthCheck",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_MasterController_getMaster1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/master/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MasterController_getMaster1_invoker = createInvoker(
    MasterController_1.getMaster(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MasterController",
      "getMaster",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """api/v1/master/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_MasterController_createMaster2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/master")))
  )
  private[this] lazy val controllers_MasterController_createMaster2_invoker = createInvoker(
    MasterController_1.createMaster,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MasterController",
      "createMaster",
      Nil,
      "POST",
      this.prefix + """api/v1/master""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_MasterController_assignPet3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/master/"), DynamicPart("masterId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_MasterController_assignPet3_invoker = createInvoker(
    MasterController_1.assignPet(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MasterController",
      "assignPet",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """api/v1/master/""" + "$" + """masterId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PetController_getPet4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/pet/"), DynamicPart("pid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PetController_getPet4_invoker = createInvoker(
    PetController_2.getPet(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PetController",
      "getPet",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """api/v1/pet/""" + "$" + """pid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PetController_createPet5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/pet")))
  )
  private[this] lazy val controllers_PetController_createPet5_invoker = createInvoker(
    PetController_2.createPet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PetController",
      "createPet",
      Nil,
      "POST",
      this.prefix + """api/v1/pet""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PetController_getSuitable6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/pet/"), DynamicPart("masterId", """[^/]+""",true), StaticPart("/"), DynamicPart("roleName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PetController_getSuitable6_invoker = createInvoker(
    PetController_2.getSuitable(fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PetController",
      "getSuitable",
      Seq(classOf[Int], classOf[String]),
      "GET",
      this.prefix + """api/v1/pet/""" + "$" + """masterId<[^/]+>/""" + "$" + """roleName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PetController_assignRoles7_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/pet/"), DynamicPart("petId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PetController_assignRoles7_invoker = createInvoker(
    PetController_2.assignRoles(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PetController",
      "assignRoles",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """api/v1/pet/""" + "$" + """petId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_RoleController_allRoles8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/roles")))
  )
  private[this] lazy val controllers_RoleController_allRoles8_invoker = createInvoker(
    RoleController_0.allRoles,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "allRoles",
      Nil,
      "GET",
      this.prefix + """api/v1/roles""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_RoleController_createRole9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/v1/roles")))
  )
  private[this] lazy val controllers_RoleController_createRole9_invoker = createInvoker(
    RoleController_0.createRole,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RoleController",
      "createRole",
      Nil,
      "POST",
      this.prefix + """api/v1/roles""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_SystemController_healthCheck0_route(params@_) =>
      call { 
        controllers_SystemController_healthCheck0_invoker.call(SystemController_3.healthCheck)
      }
  
    // @LINE:3
    case controllers_MasterController_getMaster1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_MasterController_getMaster1_invoker.call(MasterController_1.getMaster(id))
      }
  
    // @LINE:4
    case controllers_MasterController_createMaster2_route(params@_) =>
      call { 
        controllers_MasterController_createMaster2_invoker.call(MasterController_1.createMaster)
      }
  
    // @LINE:5
    case controllers_MasterController_assignPet3_route(params@_) =>
      call(params.fromPath[Int]("masterId", None)) { (masterId) =>
        controllers_MasterController_assignPet3_invoker.call(MasterController_1.assignPet(masterId))
      }
  
    // @LINE:7
    case controllers_PetController_getPet4_route(params@_) =>
      call(params.fromPath[Int]("pid", None)) { (pid) =>
        controllers_PetController_getPet4_invoker.call(PetController_2.getPet(pid))
      }
  
    // @LINE:8
    case controllers_PetController_createPet5_route(params@_) =>
      call { 
        controllers_PetController_createPet5_invoker.call(PetController_2.createPet)
      }
  
    // @LINE:9
    case controllers_PetController_getSuitable6_route(params@_) =>
      call(params.fromPath[Int]("masterId", None), params.fromPath[String]("roleName", None)) { (masterId, roleName) =>
        controllers_PetController_getSuitable6_invoker.call(PetController_2.getSuitable(masterId, roleName))
      }
  
    // @LINE:10
    case controllers_PetController_assignRoles7_route(params@_) =>
      call(params.fromPath[Int]("petId", None)) { (petId) =>
        controllers_PetController_assignRoles7_invoker.call(PetController_2.assignRoles(petId))
      }
  
    // @LINE:12
    case controllers_RoleController_allRoles8_route(params@_) =>
      call { 
        controllers_RoleController_allRoles8_invoker.call(RoleController_0.allRoles)
      }
  
    // @LINE:13
    case controllers_RoleController_createRole9_route(params@_) =>
      call { 
        controllers_RoleController_createRole9_invoker.call(RoleController_0.createRole)
      }
  }
}
