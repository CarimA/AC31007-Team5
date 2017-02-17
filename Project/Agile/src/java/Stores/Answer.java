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
    UUID id;
    int number;
    String explanation;
    boolean right;
    
    public Answer() {
    }

    public Answer(UUID id, int number, String explanation, boolean right) {
        this.id = id;
        this.number = number;
        this.explanation = explanation;
        this.right = right;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
