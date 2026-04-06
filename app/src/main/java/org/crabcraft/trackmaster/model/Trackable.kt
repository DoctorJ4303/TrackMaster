package org.crabcraft.trackmaster.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

abstract class Trackable {
    abstract val uid: Int
    abstract var name: String
}

@SerialName("athlete")
@Entity(tableName = "athletes")
data class Athlete(
    @PrimaryKey(autoGenerate = true) override val uid: Int = 0,
    @ColumnInfo(name = "name") override var name: String
) : Trackable()

@SerialName("workout")
@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true) override val uid: Int = 0,
    @ColumnInfo(name = "name") override var name: String
) : Trackable()

@Serializable
enum class TrackableType { ATHLETE, WORKOUT }