package com.example.radiofree.app.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.radiofree.app.data.appdatabase.Repository

class ViewModelFactorys(val repository: Repository):  ViewModelProvider.Factory {
    override fun <T: ViewModel> create(ModelClass: Class<T>): T{
        @Suppress("UNCHECKEDS_CAST")

        if(ModelClass.isAssignableFrom(ViewModelClass::class.java)){
          return   ViewModelClass(repository) as T
        }
        throw IllegalArgumentException("viewmodel inválida")
    }
}