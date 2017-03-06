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
public class ResultModel {

    int id;
    int quizId;
    Date date;
    String personId;
    int score;

    public ResultModel(int id, int quizId, Date date, String personId, int score) {
        this.id = id;
        this.quizId = quizId;
        this.date = date;
        this.personId = personId;
        this.score = score;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
