/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import java.sql.Date;
/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
public class QuizModel {

    int quizId;
    String title;
    String module;
    Date dateCreated;
    int available;
    boolean complete;
    int score;

    public QuizModel(int quizId, String title, String module, Date dateCreated, int available, boolean complete, int score) {
        this.quizId = quizId;
        this.title = title;
        this.module = module;
        this.dateCreated = dateCreated;
        this.available = available;
        this.complete = complete;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
