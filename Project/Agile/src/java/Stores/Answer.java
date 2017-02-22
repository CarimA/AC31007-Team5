/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import java.util.UUID;

/**
 *
 * @author finlaybrooker
 */
public class Answer {
//
    int id;
    int number;
    String answer;
    String explanation;
    boolean right;
    
    public Answer() {
    }

    public Answer(int id, int number, String answer, String explanation, boolean right) {
        this.id = id;
        this.number = number;
        this.answer = answer;
        this.explanation = explanation;
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    
}
