package com.dicoding.infobanjir

import android.Manifest
import android.os.*
import android.widget.*
import androidx.activity.result.contract.*
import androidx.appcompat.app.*
import androidx.navigation.*
import androidx.navigation.ui.*
import com.dicoding.infobanjir.databinding.*
import com.google.android.material.bottomnavigation.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                showToast("Notifications permission granted")
            } else {
                showToast("Notifications will not show without permission")
            }
        }

        requestPermissionLauncher.launch(Manifest.permission.ACCESS_NOTIFICATION_POLICY)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_dashboard,
            R.id.nav_news,
            R.id.nav_contact,
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
