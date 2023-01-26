package com.sirmishonline.javaquizapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionsRepository {

    private QuestionDao mQuestionDao;
    private LiveData<List<Questions>> mAllQuestions;


    public QuestionsRepository(Application application){
        QuestionRoomDatabase db = QuestionRoomDatabase.getInstance(application);
        mQuestionDao = db.QuestionDao();
        mAllQuestions = mQuestionDao.getAllQuestions();

    }


    //public LiveData<List<Questions>> getmAllQuestions(){
      //  return mAllQuestions;

    public LiveData<List<Questions>> getQuestions(String subjects, int year){

        mAllQuestions = mQuestionDao.getQuestionsBySubjectsAndYear(subjects,year);

        return mAllQuestions;
    }




}
