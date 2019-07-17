package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?,String?>{
        val parts : List<String>? = fullName?.split(" ")
        var firstName:String? = ""
        var lastName:String? = ""
        when (fullName){
            "", " "-> {
                firstName = null
                lastName = null
            }
            else -> {
                firstName = parts?.getOrNull(0)
                lastName =  parts?.getOrNull(1)
            }
        }
        return firstName to lastName
    }

    fun toInitials(firstName:String?, lastName:String?):String{
        //Example working
        //Utils.toInitials("john" ,"doe") //JD
        //Utils.toInitials("John", null) //J
        //Utils.toInitials(null, null) //null
        //Utils.toInitials(" ", "") //null
        var f:String? = null
        var l:String? = null
        if (firstName.isNullOrBlank()) {
            f=""
        } else f = firstName.substring(0,1)
        if (lastName.isNullOrBlank()) {
            l=""
        } else l = lastName.substring(0,1)
        if (f.equals(" ") && l.equals("")) {f=null}

        if (f.isNullOrEmpty() && l.isNullOrEmpty()) {f=null}

        return  "$f$l"
    }
}