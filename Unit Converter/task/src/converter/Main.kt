package converter

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Enter a number of kilometers: ")
    val kilometers = scanner.nextInt()
    println("$kilometers kilometers is ${kilometers * 1000} meters")
}
