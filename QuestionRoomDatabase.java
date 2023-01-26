package com.sirmishonline.javaquizapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Questions.class}, version = 2)
public abstract class QuestionRoomDatabase extends RoomDatabase {

    private static QuestionRoomDatabase INSTANCE;


    public abstract QuestionDao QuestionDao();

    public static synchronized QuestionRoomDatabase getInstance(final Context context){

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuestionRoomDatabase.class, "questions_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(RoomDBCallback)
                    .build();
        }

        return INSTANCE;

    }

    private static RoomDatabase.Callback RoomDBCallback = new RoomDatabase.Callback(){


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {

        private QuestionDao QuestionDao;


        private PopulateDbAsyncTask(QuestionRoomDatabase db){

            QuestionDao = db.QuestionDao();

        }

        @Override
        protected Void doInBackground(Void... voids){

                    QuestionDao.insert(new Questions("What is Android?","OS","Browser","software","Hard Drive", 1, "", "Biology", 1994));
            QuestionDao.insert(new Questions("RAM Stands for what ?","Operating System","Browser","Random Access Memory","CD Project",3, "", "maths", 2000));
            QuestionDao.insert(new Questions("Chrome is what ?","System Software","Browser","Middle Ware","Windows",1, "", "physics", 2022));
            QuestionDao.insert(new Questions("HTML is what ?","Scripting Language","Programming Language","Software","Hyper Text Markup Language",4, "", "english", 2002 ));
            QuestionDao.insert(new Questions("Unity is used for ?","Game Development","Web Development","Graphics Design","3-D Modeling",2, "", "chemistry", 2021));
            QuestionDao.insert(new Questions("What is OS","Hardware","System Software","PC Software","Hard Drive",2, "", "agric",2020));
            QuestionDao.insert(new Questions("IP stand for what? ","Language","Internet Protocol","Graphics","Random",2, "", "economics", 2010));
            QuestionDao.insert(new Questions("Adam called Eve woman because she was _________", "A. A resemblance of man", "B. A helper of man", "C. Mother of mankind", "D. Made out of man", 4, "Correct Answer: D " +



                    "Genesis 3:20", "CRS", 2018));


            return null;
        }

    }




}
