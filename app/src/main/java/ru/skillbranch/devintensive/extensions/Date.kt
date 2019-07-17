package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units:TimeUnits) :Date {

    this.time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    return this
}
fun Date.humanizeDiff(): String {
    val timeDiff = Date().time - this.time
    var different:String = ""
    different = when((timeDiff).toInt()){
        in 0..SECOND -> "только что"
        in (SECOND)..(SECOND*45) -> "несколько секунд назад"
        in (SECOND*45)..(SECOND*75) -> "минуту назад"
        in (SECOND*75)..(MINUTE*45) -> TimeUnits.MINUTE.plural((timeDiff / MINUTE).toInt())
        in (MINUTE*45)..(MINUTE*75) -> "час назад"
        in (MINUTE*75)..(HOUR*22) -> TimeUnits.HOUR.plural((timeDiff / HOUR).toInt())
        in (HOUR*22)..(HOUR*26) -> "день назад"
        in (HOUR*26)..(DAY*360) -> TimeUnits.DAY.plural((timeDiff / DAY).toInt())
        else -> "более года назад"
    }
    return different
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun TimeUnits.plural(value:Int):String{
    var answ =""
    when (this){
        TimeUnits.SECOND -> {
           answ = "Not supported"
        }
        TimeUnits.MINUTE -> {
            answ = when (value){
               1,21,31,41 -> "$value минуту назад"
               2,3,4,12,13,14,22,23,24,32,33,34,42,43,44 -> "$value минуты назад"
               else -> "$value минут назад"
            }
        }
        TimeUnits.HOUR -> {
            answ = when (value) {
                1, 21, 31, 41 -> "$value час назад"
                2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44 -> "$value часа назад"
                else -> "$value часов назад"
            }
        }
        TimeUnits.DAY -> {
            answ = when (value){
                1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 121, 131 ,141, 151, 161, 171, 181, 191, 201, 221, 231,
                241, 251, 261, 271, 281, 291, 301, 321, 331, 341, 351 -> "$value день назад"
                2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54, 62, 63, 64, 72, 73, 74, 82, 83, 84, 92,
                93, 94, 102, 103, 104, 122, 123, 124, 132, 133, 134, 142, 143, 144, 152, 153, 154,
                162, 163, 164, 172, 173, 174, 182, 183, 184, 192, 193, 194, 202, 203, 204, 222, 223,
                224, 232, 233, 234, 242, 243, 244, 252, 253, 254, 262, 263, 264, 272, 273, 274, 282, 283, 284, 292,
                293, 294, 302, 303, 304, 322, 323, 324, 332, 333, 334, 342, 343, 344, 352, 353, 354 -> "$value дня назад"
                else -> "$value дней назад"
            }
        }
    }
    return answ
}