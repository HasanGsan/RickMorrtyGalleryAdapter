package com.example.test_solo_project_h.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.test_solo_project_h.R
import com.example.test_solo_project_h.databinding.ActivityMainBinding
import com.example.test_solo_project_h.network.NetworkConnect
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        //Тестируем






        //Тестируем



        // Настройка навигации
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
            ?: NavHostFragment.create(R.navigation.nav_panel_fragment).also {
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainerView, it)
                }
            }



        // Инициализация BottomNavigationView
        val btnNavView = findViewById<BottomNavigationView>(R.id.but_nav_view_act)
        btnNavView.setupWithNavController(navHostFragment.navController)
        // Инициализация BottomNavigationView





        // Обработка сетевого подключения
        val inflateLayout = findViewById<View>(R.id.network_error)
        val networkConnection = NetworkConnect(application)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                Toast.makeText(this, "Соединение восстановлено", Toast.LENGTH_SHORT).show()
                inflateLayout.visibility = View.GONE
            } else {
                inflateLayout.visibility = View.VISIBLE
                Toast.makeText(this, "Соединение потеряно", Toast.LENGTH_SHORT).show()
            }
        }
        // Обработка сетевого подключения



    }







}