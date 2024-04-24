package com.dicoding.infobanjir.activity

import android.annotation.*
import android.content.*
import android.os.*
import androidx.activity.*
import androidx.appcompat.app.*
import androidx.core.view.*
import androidx.lifecycle.*
import com.dicoding.infobanjir.*
import com.dicoding.infobanjir.R
import com.dicoding.infobanjir.core.preference.*

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    private val DELAY: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {

        val pref = SettingPreferences.getInstance(application.dataStore)

        val viewModel =
            ViewModelProvider(this, SettingViewModelFactory(pref))[SettingViewModel::class.java]
        viewModel.getThemeSettings().observe(this) { settings ->
            if (settings) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}