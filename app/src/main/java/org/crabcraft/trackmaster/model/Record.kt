package org.crabcraft.trackmaster.model

import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.times

class Record(duration: Duration = 0.milliseconds, val distance: Int = 0) {
    constructor(durationString: String, distance: Int = 0) : this(durationFromString(durationString), distance)
}

fun durationFromString(timeString: String): Duration {
    val regex = Regex("""(\d{0,2}):(\d{0,2})\.(\d{0,2})""")
    val matchResult = regex.matchEntire(timeString)

    if (matchResult != null) {
        val (minutesStr, secondsStr, millisecondsStr) = matchResult.destructured

        val minutes = minutesStr.toInt()
        val seconds = secondsStr.toInt()
        val milliseconds = millisecondsStr.toInt()

        return minutes.minutes + seconds.seconds + when (millisecondsStr.length) {
            1 -> milliseconds * 100.milliseconds
            2 -> milliseconds * 10.milliseconds
            else -> 0.milliseconds
        }
    } else {
        throw IllegalArgumentException("Invalid time string format. Expected format: mm:ss.ms")
    }
}
