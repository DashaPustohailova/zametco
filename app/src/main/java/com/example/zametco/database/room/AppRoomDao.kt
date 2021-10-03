package com.example.zametco.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.zametco.models.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM notes_tables")
    fun getAllNotes():LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)
}