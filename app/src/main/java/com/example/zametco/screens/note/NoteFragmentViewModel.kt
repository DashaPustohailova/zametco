package com.example.zametco.screens.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.zametco.models.AppNote
import com.example.zametco.utilits.REPOSITORY
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFragmentViewModel(application:Application):AndroidViewModel(application) {
 fun delete(note: AppNote, onSuccess: () ->Unit){
     viewModelScope.launch(Dispatchers.Main){
         REPOSITORY.delete(note){
             onSuccess()
         }
     }
 }
}