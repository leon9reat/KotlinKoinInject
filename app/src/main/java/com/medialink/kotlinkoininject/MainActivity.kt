package com.medialink.kotlinkoininject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.data.observe(this, Observer {
            Log.d(TAG, "onCreate: "+it.size)
        })

        userViewModel.loadingState.observe(this, Observer {
            if (it == LoadingState.LOADING) {
                Log.d(TAG, "onCreate: lagi loading")
            } else if (it == LoadingState.LOADED) {
                Log.d(TAG, "onCreate: sudah selesai loading")
            } else {
                Log.d(TAG, "onCreate: "+it.msg)
            }
        })
    }
}