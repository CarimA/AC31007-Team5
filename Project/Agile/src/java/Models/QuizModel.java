/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Misc.Helpers;
import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jimiwesterholm
 */
public class QuizModel {
    Connection connection;
    
    public QuizModel() {
        
    }
    
    public Quiz fetchQuiz(int id) {
        Quiz quiz = null;
        try {
            quiz = Quiz.fetch(Helpers.connect(), id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return quiz;
    }
    
    public Question fetchQuestion(int id){
        Connection connection;
        Question q = new Question();
        try {
            connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("Select * from Question where questionId = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                q.setId(rs.getInt("questionId"));
                q.setNumber(rs.getInt("Number"));
                q.setQuestion(rs.getString("Question"));
                //q.setImage(rs.getBlob("Image");
                q.setPoints(rs.getInt("Points"));
                List<Answer> as = new ArrayList<>();
                    PreparedStatement s = connection.prepareStatement("Select * from answer where QuestionID = ?");
                    s.setString(1,rs.getString("questionId"));
                    ResultSet r = s.executeQuery();
                    while(r.next()){
                        Answer a = new Answer();
                        a.setId(r.getInt("aId"));
                        //maybe there is well
                        a.setAnswer(r.getString("AnswerText"));
                        a.setNumber(r.getInt("Number"));
                        a.setExplanation("Explanation");
                        a.setRight(r.getBoolean("Right"));
                        as.add(a);
                    }
                    r.close();
                    s.close();
                    q.setAnswers(as);
            }
            rs.close();
            statement.close();
            return q;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return q;
    }
    
    public void updateQuiz(int id,String title,String module,boolean available){
        Connection connection;
        System.out.println(available);
        try {
            connection = Helpers.connect();
            
            if(!title.equals("")){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE quiz SET Title = ? WHERE qId = ?");
                statement.setString(1, title);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
                System.out.println(available);
            }
            if(!module.equals("")){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE quiz SET Module = ? WHERE qId = ?"); 
                statement.setString(1, module);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
                System.out.println(available);
            }
            PreparedStatement statement;
            statement = connection.prepareStatement("UPDATE quiz SET Available = ? WHERE qId = ?"); 
            statement.setBoolean(1, available);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            System.out.println(available);
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateQuestion(int id,String question,int points){
        Connection connection;
        
        try {
            connection = Helpers.connect();
            
            if(!question.equals("")){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE question SET Question = ? WHERE questionId = ?");
                statement.setString(1, question);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
                
            }
            if(points != 0){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE question SET Points = ? WHERE questionId = ?"); 
                statement.setInt(1, points);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
            }
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateAnswer(int id,String answer,String explanation,boolean right){
        Connection connection;
        System.out.println(right);
        try {
            connection = Helpers.connect();
            
            if(!answer.equals("")){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE answer SET AnswerText = ? WHERE aId = ?");
                statement.setString(1, answer);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
                
            }
            if(!explanation.equals("")){
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE answer SET Explanation = ? WHERE aId = ?"); 
                statement.setString(1, explanation);
                statement.setInt(2, id);
                statement.executeUpdate();
                statement.close();
            }
            PreparedStatement statement;
            statement = connection.prepareStatement("UPDATE answer SET `Right` = ? WHERE aId = ?"); 
            statement.setBoolean(1, right);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addQuestion(String question,int number,int points,int quizID){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Question (Number,Question,Points,QuizID) VALUES (?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, question);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int addQuestionGetID(String question,int number,int points,int quizID){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Question (Number,Question,Points,QuizID) VALUES (?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, question);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            statement.executeUpdate();
            
            statement = connection.prepareStatement("SELECT 'qId' FROM Question WHERE (Number,Question,Points,QuizID) VALUES (?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, question);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            statement.executeUpdate();
            
            int questionID = 0;
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                questionID = rs.getInt("qId");
            }
            statement.close();
            return questionID;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public void addAnswer(String answer,int number,String explanation, boolean right,int questionID){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Answer (Number,AnswerText,Explanation,`Right`,QuestionID) VALUES (?,?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, answer);
            statement.setString(3, explanation);
            statement.setBoolean(4, right);
            statement.setInt(5, questionID);
            statement.executeUpdate();
            statement.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int createQuiz(String title, String module){
        int id = 0;
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Quiz (Title, Module, DateCreated) values (?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            //Date date = new Date(); SHould work?
            //statement.setString(3, date);
            statement.execute();
            
            statement = connection.prepareStatement("SELECT qId FROM Quiz where (Title, Module, DateCreated) values (?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            //Date date = new Date(); SHould work?
            //statement.setString(3, date);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                id = rs.getInt("qId");
            }
            statement.close();
            connection.close();
            return id;
        }
        catch(SQLException e)
        {
            return 0; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    

}
