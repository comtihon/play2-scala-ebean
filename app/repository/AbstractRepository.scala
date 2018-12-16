package repository

import io.ebean.{Ebean, EbeanServer}
import javax.inject.Inject
import play.db.ebean.EbeanConfig
import scala.reflect._
import scala.collection.JavaConverters._

class AbstractRepository[T: ClassTag] {
  var ebeanServer: EbeanServer = _

  @Inject()
  def setEbeanServer(ebeanConfig: EbeanConfig): Unit = {
    ebeanServer = Ebean.getServer(ebeanConfig.defaultServer())
  }

  def insert(item: T): T = {
    ebeanServer.insert(item)
    item
  }

  def update(item: T): T = {
    ebeanServer.update(item)
    item
  }

  def saveAll(items: List[T]): Unit = {
    ebeanServer.insertAll(items.asJavaCollection)
  }

  def listAll(): List[T] = {
    ebeanServer.find(classTag[T].runtimeClass.asInstanceOf[Class[T]])
      .where().findList().asScala.toList
  }

  def find(id: Any): Option[T] = {
    Option(ebeanServer.find(classTag[T].runtimeClass.asInstanceOf[Class[T]], id))
  }
}
