import java.util.*
import kotlin.io.*
import kotlin.text.*

/**
Gary is an avid hiker.
He tracks his hikes meticulously, paying close attention to small details like topography.
During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U , or a downhill, D step.
Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude.
We define the following terms:

A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is s = [DDUUUUDD], he first enters a valley 2 units deep.
Then he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.

Function Description

Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.
countingValleys has the following parameter(s):
n: the number of steps Gary takes
s: a string describing his path

Input Format

The first line contains an integer n, the number of steps in Gary's hike.
The second line contains a single string ,s of n characters that describe his path.

Output Format

Print a single integer that denotes the number of valleys Gary walked through during his hike.

 */
// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var countValleys = 0
    var isValley = false
    var referece = 0
    if (s.elementAt(0) == 'D') {
        isValley = true
        referece--
    } else {
        referece++
    }
    for ((index, value) in s.withIndex()) {
        if (index == 0) continue
        if (value == 'D') {
            if (referece == 0 || referece < 0) {
                isValley = true
            }
            referece--
        } else {
            referece++
        }
        if (referece == 0 && isValley) {
            countValleys++
            isValley = false
        }
    }
    return countValleys
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}