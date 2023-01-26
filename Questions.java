package com.sirmishonline.javaquizapp;

import android.media.audiofx.DynamicsProcessing;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Nullable;


@Entity(tableName = "questions_table")
public class Questions {

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "question")
    private String question;

    @ColumnInfo(name = "optA")
    private String optA;

    @ColumnInfo(name = "optB")
    private String optB;

    @ColumnInfo(name = "optC")
    private String optC;

    @ColumnInfo(name = "optD")
    private String optD;

    @ColumnInfo(name = "answer")
    private int answer;

    @ColumnInfo(name = "explanation")
    private String explanation;

    @ColumnInfo(name = "subjects")
    private String subjects;

    @ColumnInfo(name = "year")
    private int year;




    public Questions( String question, String optA, String optB, String optC, String optD, int answer,String explanation, String subjects, int year) {
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.answer = answer;
        this.explanation = explanation;
        this.subjects = subjects;
        this.year = year;
    }

    Questions() {
        this.question = question;
        this.optA = "optA";
        this.optB = "";
        this.optC = "";
        this.optD = "";
        this.explanation = "";
        this.subjects = "";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}