package util

import java.util._

import java.text._

case class Misc()

object Misc {

def getCurrentDate() : String ={
	formatDate(new Date())
}

def formatDate(date:Date) : String ={
	val simpleDateFormat = new SimpleDateFormat("EEEE dd MMM HH'h'mm",Locale.FRENCH)
	simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
	simpleDateFormat.format(date)
}

def prettyPrintDuration(min:Int):String = {
    if(min > 36 * 60) "> 36h"
    else if(min>=1440) "" + min/1440 + " j" + prettyPrintDuration(min%1440) else if (min>=60) "" + min/60 + " h " + prettyPrintDuration(min%60) else  min + " min" 
}

}