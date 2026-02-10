package org.crabcraft.trackmaster.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

abstract class Trackable {
    abstract val uid: Int
    abstract var name: String
}

@Entity(tableName = "athletes")
data class Athlete(
    @PrimaryKey(autoGenerate = true) override val uid: Int = 0,
    @ColumnInfo(name = "name") override var name: String,
    @ColumnInfo(name = "records") var records: String
) : Trackable()

@Entity(tableName = "workouts")
data class Workout(
    @PrimaryKey(autoGenerate = true) override val uid: Int = 0,
    @ColumnInfo(name = "name") override var name: String,
    @ColumnInfo(name = "segments") val segments: String
) : Trackable()