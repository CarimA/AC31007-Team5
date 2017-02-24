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
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author finlaybrooker
 */
public class Quiz {
    
    int id;
    String title;
    String module;
    Date dateCreated;
    boolean available;
    List<Question> questions;

    public Quiz() {
    }
//
    public Quiz(int id, String title, String module, Date dateCreated, boolean available, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.module = module;
        this.dateCreated = dateCreated;
        this.available = available;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    
    public static Quiz fetch(Connection connection, int id) throws SQLException {
        Quiz q = new Quiz();
        
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM quiz where qId = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
          
        if (!rs.next()) {
            System.out.println("Quiz not found");
        }
        
        String title = rs.getString("Title");
        String module = rs.getString("Module");
        Date dc = rs.getDate("DateCreated");
        int available = rs.getInt("Available");
        
        rs.close();
        statement.close();
        
        if (available == 0) {
            q.setAvailable(false);
        } else {
            q.setAvailable(true);
        }
        
        q.setId(id);
        q.setDateCreated(dc);
        q.setModule(module);
        q.setTitle(title);
        q.fetchQuestions(connection);
        
        
        connection.close();
        
        return q;
    }
    
    
        public void fetchQuestions(Connection connection) throws SQLException  {
        List<Question> questionList = new ArrayList();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM question where QuizID = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            Question temp = new Question();
            temp.setId(rs.getInt("questionId"));
            temp.setNumber(rs.getInt("Number"));
            temp.setQuestion(rs.getString("Question"));
            temp.setPoints(rs.getInt("Points"));
            temp.setAnswers(temp.fetchAnswers(connection, id));
            
            //Get image as well?
            
            questionList.add(temp);
        }
        
        setQuestions(questionList);
    }
}
