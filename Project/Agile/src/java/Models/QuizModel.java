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
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
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
            connection.close();
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
    
    public void deleteQuiz(int id){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            List<Integer> as = new ArrayList<>();
            
            statement = connection.prepareStatement("Select * From question Where QuizID=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                
                as.add(rs.getInt("questionId"));
            }
            statement.close();
            rs.close();
            for(int i=0;i<as.size();i++){
                deleteQuestion(as.get(i));
            }
            PreparedStatement state;
            state = connection.prepareStatement("DELETE FROM quiz WHERE qId=?");
            state.setInt(1, id);
            state.executeUpdate();
            state.close();
            connection.close();
            deleteResultByQuizID(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuestion(int id){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            List<Integer> as = new ArrayList<>();
            
            statement = connection.prepareStatement("Select * From answer Where QuestionID=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                
                as.add(rs.getInt("aId"));
            }
            statement.close();
            rs.close();
            for(int i=0;i<as.size();i++){
                deleteAnswer(as.get(i));
            }
            PreparedStatement state;
            state = connection.prepareStatement("DELETE FROM question WHERE questionId=?");
            state.setInt(1, id);
            state.executeUpdate();
            state.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAnswer(int id){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM answer WHERE aId=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
            deleteResultByAnswerID(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteResultByAnswerID(int id){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM result_answer WHERE aId=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteResultByQuizID(int id){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM results WHERE QuizID=?");
            statement.setInt(1, id);
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
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getQuestionID(String question,int number,int points,int quizID){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            
            statement = connection.prepareStatement("SELECT 'questionId' FROM Question WHERE (Number,Question,Points,QuizID) VALUES (?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, question);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            statement.executeUpdate();
            
            int questionID = 0;
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                questionID = rs.getInt("questionId");
            }
            statement.close();
            connection.close();
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
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createQuiz(String title, String module){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Quiz (Title, Module) values (?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            statement.execute();
            
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int createQuizReturnId(String title, String module){
        int id = 0;
        Date date = new Date(System.currentTimeMillis());
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Quiz (Title, Module, DateCreated, Available) values (?, ?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            statement.setDate(3, date);
            statement.setBoolean(4, false);
            statement.execute();
            
            statement = connection.prepareStatement("SELECT qId FROM Quiz where (Title, Module) = (?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                id = rs.getInt("qId");
            }
            rs.close();
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

    public void addQuestionWithImage(String question, int number, int points, int quizID, InputStream i) {
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Question (Number,Question,Points,QuizID,Image) VALUES (?,?,?,?,?)");
            statement.setInt(1, number);
            statement.setString(2, question);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            statement.setBlob(5,i);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdFromQ(String question,int number,int points,int quizID) {
                int id = 0;
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("SELECT questionId FROM question where (Question, Number, Points, QuizID) = (?, ?, ?, ?)");
            statement.setString(1, question);
            statement.setInt(2, number);
            statement.setInt(3, points);
            statement.setInt(4, quizID);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                id = rs.getInt("questionId");
            }
            statement.close();
            connection.close();
            System.out.println(id);
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
    
    public ArrayList<Quiz> getAllQuizzes()
    {
        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select * from Quiz");
            while (rs.next())
            {
                Quiz q = new Quiz();
                q.setTitle((rs.getString("Title")));
                q.setModule ((rs.getString("Module")));
                q.setDateCreated((rs.getDate("DateCreated")));
                int uid = rs.getInt("qId");
                q.setId(uid);
                quizzes.add(q);
            }
            rs.close();
            statement.close();
            connection.close();
            return quizzes;
        }
        catch(SQLException e) {
            return quizzes;  
        }
    }
    
    //Not used
    public static List<Answer> getCorrectAnswers(Quiz quiz) {
        List<Answer> correct = new ArrayList();
        List<Question> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            List<Answer> answers = questions.get(i).getAnswers();
            for (int j = 0; j < answers.size(); j++) {
                if (answers.get(j).isRight()) correct.add(answers.get(j));
            }
        }
        return correct;
    }

}
