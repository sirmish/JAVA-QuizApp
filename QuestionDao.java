package com.sirmishonline.javaquizapp;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("SELECT * from questions_table")
    LiveData <List<Questions>> getAllQuestions();

    @Query("SELECT * from questions_table WHERE questions_table.subjects = :subjects AND questions_table.year = :year  ")
    LiveData <List<Questions>> getQuestionsBySubjectsAndYear(String subjects, int year);


    @Insert
    void insert (Questions questions);

}
