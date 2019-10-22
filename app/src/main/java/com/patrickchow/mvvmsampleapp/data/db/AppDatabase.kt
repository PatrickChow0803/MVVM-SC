package com.patrickchow.mvvmsampleapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patrickchow.mvvmsampleapp.data.db.entities.User
import kotlinx.android.synthetic.*

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile //Immediately visible to all the threads
        private var instance: AppDatabase? = null
        private val LOCK = Any() //Prevents two instances of Database

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            //TODO put instance = it into the also block.
            instance ?: buildDatabase(context).also {
            }
        }

        private fun buildDatabase(context: Context) {
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
        }
    }
}