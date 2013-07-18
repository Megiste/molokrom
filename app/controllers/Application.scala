package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models._

//main
object Application extends Controller {
  
  def index = Action {
   Ok(views.html.index(Place.all()))
  }
  
  def places = index
  
  def editStatus(id: Long) = Action {
	implicit request => {
	
	val cookieSet = !request.cookies.get("name").isEmpty
	
    Ok(views.html.update(id, if(cookieSet) statusForm.fill(request.cookies.get("name").get.value) else statusForm))
	}
  }
  
  def history(id: Long) = Action {
    Ok(views.html.history(models.Status.getStatusForPlace(id,100),Place.find(id)))
  }
  
  def createNewStatus(id: Long) = { 
	  Action {
		  
		  
		
	  
	  implicit request => statusForm.bindFromRequest.fold(errors => Redirect(routes.Application.places),
	  t=>{
		  println("req:"+request.body.asFormUrlEncoded.get("action"))
		  val action = request.body.asFormUrlEncoded.get("action").head
		  if(action=="red"){
		    models.Status.create(id,"R",t) 
		   } else {
   		    models.Status.create(id,"G",t) 
		   
		   }
		   
		   Redirect(routes.Application.places).withCookies(Cookie("name", t))})
	  
	
  }}

  
  val statusForm = Form(

	    "name" -> text
	
  )
  
  
}