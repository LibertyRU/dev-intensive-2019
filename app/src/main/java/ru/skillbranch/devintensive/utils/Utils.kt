package ru.skillbranch.devintensive.utils

object Utils {
    fun partsFullName(fullName:String?):Pair<String?,String?>{
        val parts : List<String>? = fullName?.split(" ")
                // TO DO FIX ME
        var firstName = parts?.getOrNull(0)
        var lastName =  parts?.getOrNull(1)

        return firstName to lastName
    }
}