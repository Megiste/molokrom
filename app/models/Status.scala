package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Status(id: Long, placeId: Long, state: String, date: java.util.Date, name:String) {
	def getCurrentImageKey():String = {
	
	(	if(this.state == "R") "red" else "green") + "64.png"
	}
}

object Status {
	def hello(text:String, t2:String){
		println(text + "_" + t2)
	}
  
	def   getStatusForPlace(placeId:Long, limit:Int):List[Status]= DB.withConnection { implicit c =>
  SQL("select * from status where place_id= "+placeId + " order by dte_upd desc limit " + limit).as(status *)
  }

  
  def create(placeId: Long, state: String, name: String) = {
	  println("Create !! "+placeId + " state :" + state + " name:" + name)
	  DB.withConnection { implicit c =>
  	  SQL("insert into status (place_id, state, name, dte_upd) values ({placeId},{state},{name}, current_timestamp())")
	  .on('placeId -> placeId,'state -> state,'name -> name).executeUpdate()
	  	}
  }
  
  
  //def hello(id: Int) = {print id}
  
  def delete(id: Long) {}
	  
	def lastStatusForPlace(id:Long):Status =  DB.withConnection {
    implicit c =>
    SQL("select * from status s where s.place_id="+id+" order by s.dte_upd desc limit 1").as(status *).head
	}
	
    val status = {
        get[Long]("id") ~ 
        get[Long]("place_id") ~ 
      get[String]("state") ~ 
      get[java.util.Date]("dte_upd") ~ 
      get[String]("name") map {
        case id~place_id~state~dte_upd~name => Status(id, place_id,state, dte_upd,name)
      }
  } 	 
}