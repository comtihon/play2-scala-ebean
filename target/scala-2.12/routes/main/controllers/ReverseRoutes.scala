// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/vtikhonov/github/play2-scala-ebean/conf/routes
// @DATE:Thu Dec 13 09:50:32 CET 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:3
  class ReverseMasterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def getMaster(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/master/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:4
    def createMaster(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/master")
    }
  
    // @LINE:5
    def assignPet(masterId:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/v1/master/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("masterId", masterId)))
    }
  
  }

  // @LINE:7
  class ReversePetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getPet(pid:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/pet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("pid", pid)))
    }
  
    // @LINE:9
    def getSuitable(masterId:Int, roleName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/pet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("masterId", masterId)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("roleName", roleName)))
    }
  
    // @LINE:10
    def assignRoles(petId:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/v1/pet/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("petId", petId)))
    }
  
    // @LINE:8
    def createPet(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/pet")
    }
  
  }

  // @LINE:1
  class ReverseSystemController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def healthCheck(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:12
  class ReverseRoleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def createRole(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/v1/roles")
    }
  
    // @LINE:12
    def allRoles(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/v1/roles")
    }
  
  }


}
