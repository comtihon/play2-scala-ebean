// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/vtikhonov/github/play2-scala-ebean/conf/routes
// @DATE:Thu Dec 13 09:50:32 CET 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:3
  class ReverseMasterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def getMaster: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MasterController.getMaster",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/master/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:4
    def createMaster: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MasterController.createMaster",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/master"})
        }
      """
    )
  
    // @LINE:5
    def assignPet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MasterController.assignPet",
      """
        function(masterId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/master/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("masterId", masterId0))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReversePetController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getPet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PetController.getPet",
      """
        function(pid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/pet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("pid", pid0))})
        }
      """
    )
  
    // @LINE:9
    def getSuitable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PetController.getSuitable",
      """
        function(masterId0,roleName1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/pet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("masterId", masterId0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("roleName", roleName1))})
        }
      """
    )
  
    // @LINE:10
    def assignRoles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PetController.assignRoles",
      """
        function(petId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/pet/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("petId", petId0))})
        }
      """
    )
  
    // @LINE:8
    def createPet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PetController.createPet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/pet"})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseSystemController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def healthCheck: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SystemController.healthCheck",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseRoleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def createRole: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.createRole",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/roles"})
        }
      """
    )
  
    // @LINE:12
    def allRoles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RoleController.allRoles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/v1/roles"})
        }
      """
    )
  
  }


}
