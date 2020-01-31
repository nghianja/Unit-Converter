package converter

import java.util.Scanner

fun convert(local: Double, fromUnit: String, toUnit: String) {
    var lMeasure = ""
    var base = 0.0
    var converted = 0.0
    var cMeasure = ""
    when (fromUnit) {
        "m", "meter", "meters" -> {
            lMeasure = if (local == 1.0) "meter" else "meters"
            base = local
        }
        "km", "kilometer", "kilometers" -> {
            lMeasure = if (local == 1.0) "kilometer" else "kilometers"
            base = local * 1000
        }
        "cm", "centimeter", "centimeters" -> {
            lMeasure = if (local == 1.0) "centimeter" else "centimeters"
            base = local * 0.01
        }
        "mm", "millimeter", "millimeters" -> {
            lMeasure = if (local == 1.0) "millimeter" else "millimeters"
            base = local * 0.001
        }
        "mi", "mile", "miles" -> {
            lMeasure = if (local == 1.0) "mile" else "miles"
            base = local * 1609.35
        }
        "yd", "yard", "yards" -> {
            lMeasure = if (local == 1.0) "yard" else "yards"
            base = local * 0.9144
        }
        "ft", "foot", "feet" -> {
            lMeasure = if (local == 1.0) "foot" else "feet"
            base = local * 0.3048
        }
        "in", "inch", "inches" -> {
            lMeasure = if (local == 1.0) "inch" else "inches"
            base = local * 0.0254
        }
        "g", "gram", "grams" -> {
            lMeasure = if (local == 1.0) "gram" else "grams"
            base = local
        }
        "kg", "kilogram", "kilograms" ->  {
            lMeasure = if (local == 1.0) "kilogram" else "kilograms"
            base = local * 1000
        }
        "mg", "milligram", "milligrams" -> {
            lMeasure = if (local == 1.0) "milligram" else "milligrams"
            base = local * 0.001
        }
        "lb", "pound", "pounds" -> {
            lMeasure = if (local == 1.0) "pound" else "pounds"
            base = local * 453.592
        }
        "oz", "ounce", "ounces" -> {
            lMeasure = if (local == 1.0) "ounce" else "ounces"
            base = local * 28.3495
        }
    }
    when (toUnit) {
        "m", "meter", "meters" -> {
            converted = base
            cMeasure = if (converted == 1.0) "meter" else "meters"
        }
        "km", "kilometer", "kilometers" -> {
            converted = base * 0.001
            cMeasure = if (converted == 1.0) "kilometer" else "kilometers"
        }
        "cm", "centimeter", "centimeters" -> {
            converted = base * 100
            cMeasure = if (converted == 1.0) "centimeter" else "centimeters"
        }
        "mm", "millimeter", "millimeters" -> {
            converted = base * 1000
            cMeasure = if (converted == 1.0) "millimeter" else "millimeters"
        }
        "mi", "mile", "miles" -> {
            converted = base / 1609.35
            cMeasure = if (converted == 1.0) "mile" else "miles"
        }
        "yd", "yard", "yards" -> {
            converted = base / 0.9144
            cMeasure = if (converted == 1.0) "yard" else "yards"
        }
        "ft", "foot", "feet" -> {
            converted = base / 0.3048
            cMeasure = if (converted == 1.0) "foot" else "feet"
        }
        "in", "inch", "inches" -> {
            converted = base / 0.0254
            cMeasure = if (converted == 1.0) "inch" else "inches"
        }
        "g", "gram", "grams" -> {
            converted = base
            cMeasure = if (converted == 1.0) "gram" else "grams"
        }
        "kg", "kilogram", "kilograms" ->  {
            converted = base / 1000
            cMeasure = if (converted == 1.0) "kilogram" else "kilograms"
        }
        "mg", "milligram", "milligrams" -> {
            converted = base * 1000
            cMeasure = if (converted == 1.0) "milligram" else "milligrams"
        }
        "lb", "pound", "pounds" -> {
            converted = base / 453.592
            cMeasure = if (converted == 1.0) "pound" else "pounds"
        }
        "oz", "ounce", "ounces" -> {
            converted = base / 28.3495
            cMeasure = if (converted == 1.0) "ounce" else "ounces"
        }
    }
    println("$local $lMeasure is $converted $cMeasure")
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Enter what you want to convert (or exit): ")
        val input = scanner.nextLine().split(" ")
        if (input[0] == "exit") break
        convert(input[0].toDouble(), input[1].toLowerCase(), input[3].toLowerCase())
    }
}
