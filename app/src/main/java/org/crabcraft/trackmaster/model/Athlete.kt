package org.crabcraft.trackmaster.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "athletes")
class Athlete(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "records") var records: String
) {

}

