package com.insanie.fakeapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (version = 1,entities = [User::class])
abstract class SampleDatabase :RoomDatabase(){

    abstract fun userDAO() : UserDAO
    companion object{
        @Volatile
        private var INSTANCE : SampleDatabase? = null
        fun getInstanse(context: Context):SampleDatabase{

            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SampleDatabase::class.java,
                        "sample_databse"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}