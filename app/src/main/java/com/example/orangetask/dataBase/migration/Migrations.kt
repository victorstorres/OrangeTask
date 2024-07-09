package com.example.orangetask.dataBase.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2){
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS User (`idUser` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nameUser` TEXT NOT NULL, `logged` INTEGER NOT NULL)")
    }

}