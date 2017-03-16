/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

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
public class Answer {
//
    int id;
    int number;
    String answer;
    String explanation;
    boolean right;
    
    public Answer() {
    }
    // in answer maybe need to remove boolean right after I'll check after, remove boolean there and add setRight in question.java
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
    
    public static List<Answer> getStudentAnswers(Connection connection, int rId) throws SQLException {
        List<Answer> answers = new ArrayList();
        List<Integer> answerIDs = new ArrayList();
        
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM result_answer where ResultID = ?");
        statement.setInt(1, rId);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            int aId = rs.getInt("AnswerID");
            answerIDs.add(aId);
        }
        
        //rs.close();
        //statement.close();
        
        for (int i = 0; i < answerIDs.size(); i++) {
            statement = connection.prepareStatement("SELECT * FROM answer where aId = ?");
            statement.setInt(1, answerIDs.get(i));
            rs = statement.executeQuery();
            
            while (rs.next()) {
                Answer a = new Answer(answerIDs.get(i), rs.getInt("Number"), rs.getString("AnswerText"), rs.getString("Explanation"), rs.getBoolean("Right"));
                answers.add(a);
            }
        }
        
        rs.close();
        statement.close();
        connection.close();
        
        return answers;
    }

          
        
        
        
        
        
    
    
}
