package com.example.zametco.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.zametco.utilits.REPOSITORY

class MainFragmentViewModel(application: Application):AndroidViewModel(application) {
    val allNotes = REPOSITORY.allNotes
}