package converter

import java.lang.Exception
import java.util.Scanner

enum class Measurement(val measure: String, val singular: String, val plural: String) {
    M("Length", "meter", "meters"),
    KM("Length", "kilometer", "kilometers"),
    CM("Length", "centimeter", "centimeters"),
    MM("Length", "millimeter", "millimeters"),
    MI("Length", "mile", "miles"),
    YD("Length", "yard", "yards"),
    FT("Length", "foot", "feet"),
    IN("Length", "inch", "inches"),
    G("Weight", "gram", "grams"),
    KG("Weight", "kilogram", "kilograms"),
    MG("Weight", "milligram", "milligrams"),
    LB("Weight", "pound", "pounds"),
    OZ("Weight", "ounce", "ounces"),
    C("Temperature", "degree Celsius", "degrees Celsius"),
    F("Temperature", "degree Fahrenheit", "degrees Fahrenheit"),
    K("Temperature", "Kelvin", "Kelvins"),
    UK("Unknown", "???", "???");

    companion object {
        fun getMeasurement(name: String): Measurement {
            val lowerCaseName = name.toLowerCase()
            for (enum in Measurement.values()) {
                if (enum.name.toLowerCase() == lowerCaseName ||
                    enum.singular.toLowerCase() == lowerCaseName ||
                    enum.plural.toLowerCase() == lowerCaseName ||
                    (("celsius" == lowerCaseName || "dc" == lowerCaseName) && enum.name == "C") ||
                    (("fahrenheit" == lowerCaseName || "df" == lowerCaseName) && enum.name == "F")) {
                    return enum
                }
            }
            return UK
        }
    }

    fun getUnits(value: Double): String {
        return if (value == 1.0) singular else plural
    }
}

fun isConvertible(local: Double, from: Measurement, to: Measurement): Boolean {
    if (from.measure != to.measure || from == Measurement.UK) {
        println("Conversion from ${from.plural} to ${to.plural} is impossible")
        return false
    }
    if (local < 0 && (from.measure == "Length" || from.measure == "Weight")) {
        println("${from.measure} shouldn't be negative")
        return false
    }
    return true
}

fun convert(local: Double, from: Measurement, to: Measurement) {
    if (!isConvertible(local, from, to)) return
    var base = 0.0
    var converted = 0.0
    when (from) {
        Measurement.M -> base = local
        Measurement.KM -> base = local * 1000
        Measurement.CM -> base = local * 0.01
        Measurement.MM -> base = local * 0.001
        Measurement.MI -> base = local * 1609.35
        Measurement.YD -> base = local * 0.9144
        Measurement.FT -> base = local * 0.3048
        Measurement.IN -> base = local * 0.0254
        Measurement.G -> base = local
        Measurement.KG -> base = local * 1000
        Measurement.MG -> base = local * 0.001
        Measurement.LB -> base = local * 453.592
        Measurement.OZ -> base = local * 28.3495
        Measurement.C -> base = local
        Measurement.F -> base = (local - 32) * 5 / 9
        Measurement.K -> base = local - 273.15
        Measurement.UK -> base = 0.0
    }
    when (to) {
        Measurement.M -> converted = base
        Measurement.KM -> converted = base / 1000
        Measurement.CM -> converted = base / 0.01
        Measurement.MM -> converted = base / 0.001
        Measurement.MI -> converted = base / 1609.35
        Measurement.YD -> converted = base / 0.9144
        Measurement.FT -> converted = base / 0.3048
        Measurement.IN -> converted = base / 0.0254
        Measurement.G -> converted = base
        Measurement.KG -> converted = base / 1000
        Measurement.MG -> converted = base / 0.001
        Measurement.LB -> converted = base / 453.592
        Measurement.OZ -> converted = base / 28.3495
        Measurement.C -> converted = base
        Measurement.F -> converted = base * 9 / 5 + 32
        Measurement.K -> converted = base + 273.15
        Measurement.UK -> converted = 0.0
    }
    println("$local ${from.getUnits(local)} is $converted ${to.getUnits(converted)}")
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Enter what you want to convert (or exit): ")
        val input = scanner.nextLine().split(" ")
        if (input[0] == "exit") break
        try {
            val iterator = input.iterator()
            val number = iterator.next().toDouble()
            var from = iterator.next().toLowerCase()
            if (from == "degree" || from == "degrees") {
                from = from + " " + iterator.next()
            }
            val random = iterator.next()
            var to = iterator.next().toLowerCase()
            if (to == "degree" || to == "degrees") {
                to = to + " " + iterator.next()
            }
            convert(number, Measurement.getMeasurement(from), Measurement.getMeasurement(to))
        } catch (e: Exception) {
            println("Parse error")
        }
    }
}
