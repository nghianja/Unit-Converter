package converter

import java.util.Scanner

fun main() {
    var measure = ""
    var mlength = 0.0
    val scanner = Scanner(System.`in`)
    print("Enter a number and a measure of length: ")
    val length = scanner.nextDouble()
    when (scanner.next().toLowerCase()) {
        "m", "meter", "meters" -> {
            measure = if (length == 1.0) "meter" else "meters"
            mlength = length
        }
        "km", "kilometer", "kilometers" -> {
            measure = if (length == 1.0) "kilometer" else "kilometers"
            mlength = length * 1000
        }
        "cm", "centimeter", "centimeters" -> {
            measure = if (length == 1.0) "centimeter" else "centimeters"
            mlength = length * 0.01
        }
        "mm", "millimeter", "millimeters" -> {
            measure = if (length == 1.0) "millimeter" else "millimeters"
            mlength = length * 0.001
        }
        "mi", "mile", "miles" -> {
            measure = if (length == 1.0) "mile" else "miles"
            mlength = length * 1609.35
        }
        "yd", "yard", "yards" -> {
            measure = if (length == 1.0) "yard" else "yards"
            mlength = length * 0.9144
        }
        "ft", "foot", "feet" -> {
            measure = if (length == 1.0) "foot" else "feet"
            mlength = length * 0.3048
        }
        "in", "inch", "inches" -> {
            measure = if (length == 1.0) "inch" else "inches"
            mlength = length * 0.0254
        }
    }
    val munit = if (mlength == 1.0) "meter" else "meters"
    println("$length $measure is $mlength $munit")
}
