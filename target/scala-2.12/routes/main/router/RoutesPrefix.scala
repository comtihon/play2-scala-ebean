// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/vtikhonov/github/play2-scala-ebean/conf/routes
// @DATE:Thu Dec 13 09:50:32 CET 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
