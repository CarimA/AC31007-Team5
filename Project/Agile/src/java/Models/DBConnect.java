/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Stores.*;
//import com.mysql.jdbc.Blob;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 *
 * @author danielward
 */
public class DBConnect {
    
    void DBConnect()
    {
        
    }
    
    public void connectToDb()
    {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            
        }
    }
    
    //This doesn't work yet, will fix when i can be aresed.
    public ResultSet getResults(String query)
    {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            rs.close();
            statement.close();
            connection.close();
            return rs;
        }
        catch(SQLException e) {
         return null;  
        }
    }
    
    public Question getQuestion(String id){
        Connection connection;
        Question q = new Question();
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            PreparedStatement statement = connection.prepareStatement("Select * from question where qId = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                q.setQuestion(rs.getString("Question"));
                q.setNumber(rs.getInt("Number"));
                q.setPoints(rs.getInt("points"));
            }
            
            rs.close();
            statement.close();
            connection.close();
            return q;
        }
        catch(SQLException e) {
         return q;  
        }
        
    }
    
    public Answer getAnswer(String id){
        Connection connection;
        Answer a = new Answer();
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            PreparedStatement statement = connection.prepareStatement("Select * from answer where aId = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            // maybe need comment this later
            while(rs.next()){
                a.setAnswer(rs.getString("AnswerText"));
                a.setNumber(rs.getInt("Number"));
                a.setExplanation(rs.getString("Explanation"));
                a.setRight(rs.getBoolean("Right"));
            }
            
            rs.close();
            statement.close();
            connection.close();
            return a;
        }
        catch(SQLException e) {
         return a;  
        }
        
    }
    

    public Vector<Quiz> getQuizzes(String query)
    {
        Connection connection;
        Vector<Quiz> quizzes = new Vector<Quiz>();
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next())
            {
                Quiz q = new Quiz();
                q.setTitle((rs.getString("Title")));
                q.setModule ((rs.getString("Module")));
                q.setDateCreated((rs.getDate("DateCreated")));
                int uid = rs.getInt("qId");
                q.setId(uid);
                
                PreparedStatement state = connection.prepareStatement("Select * from question where QuizID = ?");
                state.setString(1, rs.getString("qId"));
                ResultSet sr = state.executeQuery();
                
                List<Question> qs = new ArrayList<>();
                while(sr.next()){
                    Question quest = new Question();
                    quest.setId(sr.getInt("questionId"));
                    quest.setNumber(sr.getInt("Number"));
                    quest.setQuestion(sr.getString("Question"));
                    quest.setPoints(sr.getInt("points"));
                    //quest.setImage((Blob) sr.getBlob("image"));
                    
                    List<Answer> as = new ArrayList<>();
                    PreparedStatement s = connection.prepareStatement("Select * from answer where QuestionID = ?");
                    s.setString(1,sr.getString("questionId"));
                    ResultSet r = s.executeQuery();
                    while(r.next()){
                        Answer a = new Answer();
                        a.setId(r.getInt("aId"));
                        a.setNumber(r.getInt("Number"));
                        a.setExplanation(query);
                        a.setRight(r.getBoolean("Right"));
                        as.add(a);
                    }
                    r.close();
                    s.close();
                    quest.setAnswers(as);
                    qs.add(quest);
                }
                sr.close();
                state.close();
                q.setQuestions(qs);
                quizzes.add(q);
                
            }
            System.out.println(quizzes.size());
            rs.close();
            statement.close();
            connection.close();
            return quizzes;
        }
        catch(SQLException e) {
            return quizzes;  
        }
    }
    
    public static void main(String[] args)
    {
        DBConnect d = new DBConnect();
        d.connectToDb();
        Vector<Quiz> q = d.getQuizzes("Select * from quiz");
        //Vector<Quiz> q = d.getQuizes("Select * from quiz where qId = 1");
        
        System.out.println(q.size());
        for(Quiz w : q)
        {
            System.out.println(w.getDateCreated());
            System.out.println(w.getModule());
            System.out.println(w.getTitle());
            System.out.println(w.getId());
        }
   }    
}


