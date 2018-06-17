package com.ikheiry.roomapp.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ikheiry.roomapp.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
