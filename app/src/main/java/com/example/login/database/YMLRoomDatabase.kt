package com.example.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.login.dao.RagisterDao
import com.example.login.model.UserModel

@Database(entities = [UserModel::class],version = 2,exportSchema = false)
abstract class YMLRoomDatabase : RoomDatabase(){
     abstract val  registerDao: RagisterDao

    companion object{
        @Volatile
        private var mInstance:YMLRoomDatabase?=null
        fun getInstance(context: Context):YMLRoomDatabase{
            synchronized(this){
                if(mInstance==null){
                    mInstance=Room.databaseBuilder(context.applicationContext,YMLRoomDatabase::class.java,"yml_database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return mInstance!!
            }

        }
    }
}