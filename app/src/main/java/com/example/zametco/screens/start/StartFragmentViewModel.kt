package com.example.zametco.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zametco.database.room.AppRoomDatabase
import com.example.zametco.database.room.AppRoomRepository
import com.example.zametco.utilits.REPOSITORY
import com.example.zametco.utilits.TYPE_ROOM

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type:String, onSuccess:() -> Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
        }
    }

}