package com.example.zametco.database.room

import androidx.lifecycle.LiveData
import com.example.zametco.database.DatabaseRepository
import com.example.zametco.models.AppNote

class AppRoomRepository(private val appRoomDao: AppRoomDao): DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
        onSuccess()
    }

}