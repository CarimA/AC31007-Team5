/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import Misc.Helpers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
public class ResultModel {

    int id;
    int quizId;
    Date date;
    String personId;
    int score;

    public ResultModel(int id, int quizId, Date date, String personId, int score) {
        this.id = id;
        this.quizId = quizId;
        this.date = date;
        this.personId = personId;
        this.score = score;
    }
    
    public ResultModel() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public static List<ResultModel> fetch(Connection connection, int id) throws SQLException {
        List<ResultModel> results = new ArrayList();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM results WHERE QuizID = ? ORDER BY PersonID, rId");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        
        
        
        while (rs.next()) {
            ResultModel rm = new ResultModel(rs.getInt("rId"), rs.getInt("QuizID"), rs.getDate("Date"), rs.getString("PersonID"), rs.getInt("Score"));
            results.add(rm);
        }
        
        
        rs.close();
        statement.close();
        connection.close();
        
        return results;
    }
    
    public static int upload(int score, Date date, String pId, int qId, List<Integer> answerIDs) throws SQLException, ClassNotFoundException {
        Connection connection = Helpers.connect();
        int rId = -1;
        PreparedStatement statement = connection.prepareStatement("INSERT INTO results (Score, Date, PersonID, QuizID) values (?, ?, ?, ?)");
        statement.setInt(1, score);
        statement.setDate(2, date);
        statement.setString(3, pId);
        statement.setInt(4, qId);
        statement.execute();
        
        statement = connection.prepareStatement("SELECT rId FROM results ORDER BY rId Desc");
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            rId = rs.getInt("rId");
        } else {
            return rId;
        }
        
        for (int i = 0; i < answerIDs.size(); i++) {
            statement = connection.prepareStatement("INSERT INTO result_answer (ResultID, AnswerID) values (?, ?)");
            statement.setInt(1, rId);
            statement.setInt(2, answerIDs.get(i));
            statement.execute();
        }
        
        statement.close();
        connection.close();
        return rId;
    }
    
    public static ResultModel fetchResultsIndividual(int rId) throws SQLException, ClassNotFoundException {
        Connection connection = Helpers.connect();
        
        String query = "SELECT * FROM results WHERE rId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, rId);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            return new ResultModel(rId, resultSet.getInt("QuizID"), resultSet.getDate("Date"), resultSet.getString("PersonID"), resultSet.getInt("Score"));
        } else {
            return null;
        }
    }

}
