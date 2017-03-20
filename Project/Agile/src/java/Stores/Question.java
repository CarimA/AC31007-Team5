 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

//import com.mysql.jdbc.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    //Blob image;
    int points;
    
    List<Answer> answers;

    public Question() {
    }
//
    public Question(int id, int number, String question, /* Blob image, */ int points, List<Answer> answers) {
        this.id = id;
        this.number = number;
        this.question = question;
        //this.image = image;
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

    
    /*public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }*/
    
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
        
    
    
    public List<Answer> fetchAnswers(Connection connection, int id) throws SQLException {
        List<Answer> answerList = new ArrayList();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM answer where QuestionID = ?");
        statement.setInt(1, this.id);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            Answer a = new Answer();
            a.setId(rs.getInt("aId"));
            a.setNumber(rs.getInt("Number"));
            a.setExplanation(rs.getString("Explanation"));
            a.setAnswer(rs.getString("AnswerText"));         // a.setAnswer(rs.getInt("right"));
            a.setRight(rs.getBoolean("Right"));              // if (rs.getInt("right") == 1) {
            answerList.add(a);                               // a.setRight(true);
        }                                                   //  }else{
                                                            //  a.setRight(false);
        return answerList;                                  //  }
                                                            //  answerList.add(a);
                                                            //  }  
    }                                                       //  return answerList;
                                                            //  }
}                                                           //}
/*
This is snother version that I need to try change for a check


*/
