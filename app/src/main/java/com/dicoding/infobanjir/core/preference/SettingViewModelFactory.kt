package com.dicoding.infobanjir.core.preference

import androidx.lifecycle.*

@Suppress("UNCHECKED_CAST")
class SettingViewModelFactory(private val pref: SettingPreferences): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingViewModel::class.java)) {
            return SettingViewModel(pref) as T
        }
        throw IllegalStateException("Unknown model class: " + modelClass.name)
    }
}