package com.dicoding.infobanjir.core.preference

import androidx.lifecycle.*
import kotlinx.coroutines.*

class SettingViewModel(private val settings: SettingPreferences) : ViewModel() {

    fun getThemeSettings(): LiveData<Boolean> {
        return settings.getThemeSetting().asLiveData()
    }

    fun saveThemeSettings(isDark: Boolean) {
        viewModelScope.launch {
            settings.saveThemeSetting(isDark)
        }
    }
}