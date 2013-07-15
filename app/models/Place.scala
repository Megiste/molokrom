package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current
import util._

case class Place(id: Long, label: String) {

	def getCurrentState(): String = {
		Status.lastStatusForPlace(id).state
	}
	
	def getCurrentImageKey():String = {
		val state = getCurrentState()
	(	if(state == "R") "red" else "green") + "64.png"
	}
	
	def getSpanSinceLastUpdate(): Int = {
		val span = java.lang.System.currentTimeMillis() - Status.lastStatusForPlace(id).date.getTime()
		span.intValue()
		(span / (1000 * 60)).intValue()
	}
	
	def getSpanSinceLastUpdatePretty() : String = {
		val minutes=getSpanSinceLastUpdate()
		Misc.prettyPrintDuration(minutes)
		
	}
	
	
}


object Place {
  
  def all(): List[Place] = DB.withConnection { implicit c =>
  SQL("select * from place ").as(place *)
  }
  val place = {
    get[Long]("id") ~ 
    get[String]("label") map {
      case id~label => Place(id, label)
    }
  }
  

def hello(text:String, t2:String){
	Status.hello(text,t2)
}

def find(id: Long):Place = {
	(DB.withConnection { implicit c =>
  SQL("select * from place where id="+id).as(place *)
  }).head
}
  

}