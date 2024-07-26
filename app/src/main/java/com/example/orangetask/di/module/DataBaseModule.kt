package com.example.orangetask.di.module

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Room
import com.example.orangetask.dataBase.OrangeTaskDataBase
import com.example.orangetask.dataBase.dao.ProductDao
import com.example.orangetask.dataBase.migration.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "orangeTask.db"

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): OrangeTaskDataBase {
        return Room.databaseBuilder(
            context,
            OrangeTaskDataBase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideProductDao(db: OrangeTaskDataBase): ProductDao {
        return db.productDao()
    }

}