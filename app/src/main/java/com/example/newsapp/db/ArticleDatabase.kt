package com.example.newsapp.db

import android.content.Context
import androidx.room.*
import com.example.newsapp.models.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = createDatabase(context)
                }

                return instance
            }
        }

        private fun createDatabase(context: Context): ArticleDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}