package com.example.apilibrary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.apilibrary.models.CommentListItem
import com.example.apilibrary.models.PostListItem

@Database(entities = [PostListItem::class,CommentListItem::class], version = 1)
//@Database(entities = [CommentListItem::class], version = 2)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

    companion object{

        val migration_1_2 = object : Migration(1,2){   // Update Version 1 to 2 Using Migration
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE comments ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }

        }

//    companion object{
// Create Singleton Class

        @Volatile
        private var INSTANCE : PostDatabase? = null

        fun getDatabase(context: Context) : PostDatabase{
            if (INSTANCE == null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        PostDatabase::class.java,
                        "postDB")
                      //  "commentDB")
                        .addMigrations(migration_1_2)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}