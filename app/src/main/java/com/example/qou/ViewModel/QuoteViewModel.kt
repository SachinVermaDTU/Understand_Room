package com.example.qou.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.qou.data.db.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(app: Application) : AndroidViewModel(app) {
    private val Database: database= database.getDatabase(app)

    init {
        CoroutineScope(Dispatchers.IO).launch {
            Database.prepopulateDatabase(app, Database)
        }
    }

    // Additional ViewModel logic
}