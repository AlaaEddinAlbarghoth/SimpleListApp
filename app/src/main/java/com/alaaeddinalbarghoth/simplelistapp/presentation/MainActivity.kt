package com.alaaeddinalbarghoth.simplelistapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.alaaeddinalbarghoth.simplelistapp.R
import com.alaaeddinalbarghoth.simplelistapp.databinding.ActivityMainBinding
import com.alaaeddinalbarghoth.simplelistapp.presentation.adapter.FeedsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var feedsAdapter: FeedsAdapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding) {
            lifecycleOwner = this@MainActivity
            this@with.viewModel = this@MainActivity.viewModel
            this@with.feedsAdapter = this@MainActivity.feedsAdapter
        }
    }
}