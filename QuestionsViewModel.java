package com.sirmishonline.javaquizapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class QuestionsViewModel extends AndroidViewModel {
    private QuestionsRepository mRepository;
    private LiveData<List<Questions>> mAllQuestions;

    //public QuestionsViewModel(Application application){
     //   super(application);
     //   mRepository = new QuestionsRepository(application);
     //   mAllQuestions = mRepository.getmAllQuestions();

    public QuestionsViewModel(Application application){
        super(application);
        mRepository = new QuestionsRepository(application);



    }
    //LiveData<List<Questions>> getmAllQuestions()
     //   {
     //       return mAllQuestions;
    // }

    LiveData<List<Questions>> getQuestionsBySubjectsAndYear(String subjects, int year){
        mAllQuestions = mRepository.getQuestions(subjects, year);
        return mAllQuestions;
    }
}
