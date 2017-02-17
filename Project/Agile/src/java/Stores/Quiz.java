/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author finlaybrooker
 */
public class Quiz {
    
    UUID id;
    String title;
    String module;
    Date dateCreated;
    boolean avaliable;
    List<Question> questions;

    public Quiz() {
    }
//
    public Quiz(UUID id, String title, String module, Date dateCreated, boolean avaliable, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.module = module;
        this.dateCreated = dateCreated;
        this.avaliable = avaliable;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
   
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
