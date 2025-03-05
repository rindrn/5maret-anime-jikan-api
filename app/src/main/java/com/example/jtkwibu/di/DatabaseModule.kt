package com.example.jtkwibu.di

import android.content.Context
import androidx.room.Room
import com.example.jtkwibu.data.AppDatabase
import com.example.jtkwibu.data.AnimeDao
import com.example.jtkwibu.data.ProfileDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "jtkwibu_db"
        ).build()
    }

    @Provides
    fun provideAnimeDao(db: AppDatabase): AnimeDao = db.animeDao()

    @Provides
    fun provideProfileDao(db: AppDatabase): ProfileDao = db.profileDao()
}
