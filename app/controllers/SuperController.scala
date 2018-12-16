package controllers

import net.logstash.logback.marker.LogstashMarker
import play.api.MarkerContext
import play.api.i18n.I18nSupport
import play.api.mvc.{InjectedController, RequestHeader}

trait RequestMarkerContext {

  import net.logstash.logback.marker.Markers

  private def marker(tuple: (String, Any)) = Markers.append(tuple._1, tuple._2)

  private implicit class RichLogstashMarker(marker1: LogstashMarker) {
    def &&(marker2: LogstashMarker): LogstashMarker = marker1.and(marker2)
  }

  implicit def requestHeaderToMarkerContext(implicit request: RequestHeader): MarkerContext = {
    MarkerContext {
      marker("id" -> request.id) && marker("host" -> request.host) && marker("remoteAddress" -> request.remoteAddress)
    }
  }
}

abstract class SuperController extends InjectedController with RequestMarkerContext with I18nSupport {

}

