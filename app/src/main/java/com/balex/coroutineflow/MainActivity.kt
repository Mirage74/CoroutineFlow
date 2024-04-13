package com.balex.coroutineflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.balex.coroutineflow.databinding.ActivityMainBinding
import com.balex.coroutineflow.lessons.lesson2.UsersActivity
import com.balex.coroutineflow.crypto_app.CryptoActivity
import com.balex.coroutineflow.team_score.TeamScoreActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonUsersActivity.setOnClickListener {
            startActivity(UsersActivity.newIntent(this))
        }
        binding.buttonCryptoActivity.setOnClickListener {
            startActivity(CryptoActivity.newIntent(this))
        }
        binding.teamScoreActivity.setOnClickListener {
            startActivity(TeamScoreActivity.newIntent(this))
        }
    }
}