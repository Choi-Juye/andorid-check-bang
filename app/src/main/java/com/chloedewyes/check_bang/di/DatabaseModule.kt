package com.chloedewyes.check_bang.di

import android.content.Context
import androidx.room.Room
import com.chloedewyes.check_bang.db.BookItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun createDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            BookItemDatabase::class.java,
            "bookItem_db.db"
        ).build()

    @Singleton
    @Provides
    fun createBookDao(db: BookItemDatabase) = db.getBookDao()
}