// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/vtikhonov/github/play2-scala-ebean/conf/routes
// @DATE:Thu Dec 13 09:50:32 CET 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMasterController MasterController = new controllers.ReverseMasterController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePetController PetController = new controllers.ReversePetController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSystemController SystemController = new controllers.ReverseSystemController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRoleController RoleController = new controllers.ReverseRoleController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMasterController MasterController = new controllers.javascript.ReverseMasterController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePetController PetController = new controllers.javascript.ReversePetController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSystemController SystemController = new controllers.javascript.ReverseSystemController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRoleController RoleController = new controllers.javascript.ReverseRoleController(RoutesPrefix.byNamePrefix());
  }

}
