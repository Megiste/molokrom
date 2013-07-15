package util

import java.util._

import java.text._

case class Misc()

object Misc {

def getCurrentDate() : String ={
	formatDate(new Date())
}

def formatDate(date:Date) : String ={
	
	new SimpleDateFormat("EEEE dd MMM HH'h'mm").format(date)
}

def prettyPrintDuration(min:Int):String = {
	if(min>=1440) "" + min/1440 + " jour(s)" + prettyPrintDuration(min%1440) else if (min>=60) "" + min/60 + " heure(s) " + prettyPrintDuration(min%60) else  min + " min" 
}

}