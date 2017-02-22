 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import com.mysql.jdbc.Blob;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author finlaybrooker
 */
public class Question {
    
    int id;
    int number;
    String question;
    Blob image;
    int points;
    List<Answer> answers;

    public Question() {
    }
//
    public Question(int id, int number, String question, Blob image, int points, List<Answer> answers) {
        this.id = id;
        this.number = number;
        this.question = question;
        this.image = image;
        this.points = points;
        this.answers = answers;
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    
    
}
