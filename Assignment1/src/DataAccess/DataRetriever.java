package DataAccess;

import Model.*;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRetriever {
    private static final String FIND_CLIENT_BY_ID = "SELECT * FROM client1 WHERE id = ?";
    private static final String FIND_CLIENTS = "SELECT * FROM client1";
    private static final String FIND_STUDENT_BY_ID = "SELECT * FROM student WHERE nrIdentificare = ? ";
    private static final String FIND_STUDENTS = "SELECT * FROM student";
    private static final String FIND_ENROLMENT_BY_ID = "SELECT * FROM enrolment1 WHERE id = ?";
    private static final String FIND_ENROLMENTS = "SELECT * FROM enrolment1";
    private static final String FIND_USER_BY_ID = "SELECT * FROM user1 WHERE id = ?";
    private static final String FIND_USERS = "SELECT * FROM user1";
    private static final String FIND_USER_BY_NAME = "SELECT * FROM user1 WHERE username = ? AND password = ?";
    private static DataRetriever dataRetriever = null;


    public static Client findClientById(int id) {
        Client toReturn = new Client();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_CLIENT_BY_ID);
            findStatement.setInt(1, id);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            if (resultSet.next()) {
                int idClient = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String CNP = resultSet.getString("CNP");
                String address = resultSet.getString("address");
                toReturn.setId(idClient);
                toReturn.setName(name);
                toReturn.setCNP(CNP);
                toReturn.setAddress(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }


    public static Student findStudentById(int id) {
        Student toReturn = new Student();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_STUDENT_BY_ID);
            findStatement.setInt(1, id);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            if (resultSet.next()) {
                int idStudent = resultSet.getInt("nrIdentificare");
                int group = resultSet.getInt("grupa");
                String enrolment = resultSet.getString("enrolment");
                int grades = resultSet.getInt("grades");
                toReturn.setNrIdentificare(idStudent);
                toReturn.setGroup(group);
                toReturn.setEnrolment(enrolment);
                toReturn.setGrades(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }


    public static Enrolment findEnrolmentById(int id) {
        Enrolment toReturn = new Enrolment();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_ENROLMENT_BY_ID);
            findStatement.setInt(1, id);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            if (resultSet.next()) {
                int idEnrolment = resultSet.getInt("id");
                int idStudent = resultSet.getInt("idStudent");
                String exams = resultSet.getString("exams");
                int grades = resultSet.getInt("grades");
                toReturn.setId(idEnrolment);
                toReturn.setIdStudent(idStudent);
                toReturn.setExams(exams);
                toReturn.setGrades(grades);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }

    public static User findUserById(int id) {
        User toReturn = new User();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_USER_BY_ID);
            findStatement.setInt(1, id);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            if (resultSet.next()) {
                int idUser = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type");
                toReturn.setId(idUser);
                toReturn.setUsername(username);
                toReturn.setPassword(password);
                toReturn.setRole(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }

    public static DataRetriever getInstance(){
        if(dataRetriever == null){
            dataRetriever = new DataRetriever();
        }
        return dataRetriever;
    }

    private Map<String,String> user;
    public User findUserByName(String username, String password) {
        User toReturn = new User();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_USER_BY_NAME);
            findStatement.setString(1, username);
            findStatement.setString(2, password);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            if (resultSet.next()) {
                int idUser = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String parola = resultSet.getString("password");
                String type = resultSet.getString("type");
                toReturn.setId(idUser);
                toReturn.setUsername(name);
                toReturn.setPassword(parola);
                toReturn.setRole(type);
            }


        } catch (SQLException e) {
            JOptionPane optionPane = new JOptionPane("Cannot get users from database!", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("Error");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }



    public static List<Object> findClients() {
        List<Object> toReturn = new ArrayList<>();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_CLIENTS);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            while (resultSet.next()) {
                Client client = new Client();
                int idClient = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String CNP = resultSet.getString("CNP");
                String address = resultSet.getString("address");
                client.setId(idClient);
                client.setName(name);
                client.setCNP(CNP);
                client.setAddress(address);
                toReturn.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }


    public static List<Object> findStudents() {
        List<Object> toReturn = new ArrayList<>();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_STUDENTS);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            while (resultSet.next()) {
                Student  student = new Student();
                int idStudent = resultSet.getInt("nrIdentificare");
                int group = resultSet.getInt("grupa");
                String enrolment = resultSet.getString("enrolment");
                int grades = resultSet.getInt("grades");

                student.setNrIdentificare(idStudent);
                student.setGroup(group);
                student.setEnrolment(enrolment);
                student.setGrades(grades);
                toReturn.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }


    public static List<Object> findEnrolments() {
        List<Object> toReturn = new ArrayList<>();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_ENROLMENTS);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            while (resultSet.next()) {
                Enrolment enrolment = new Enrolment();
                int idEnrolment = resultSet.getInt("id");
                int idStudent = resultSet.getInt("idStudent");
                String exams = resultSet.getString("exams");
                int grades = resultSet.getInt("grades");
                enrolment.setId(idEnrolment);
                enrolment.setIdStudent(idStudent);
                enrolment.setExams(exams);
                enrolment.setGrades(grades);
                toReturn.add(enrolment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }

    public static List<Object> findUsers() {
        List<Object> toReturn = new ArrayList<>();
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(FIND_USERS);
            resultSet = findStatement.executeQuery();
            assert resultSet != null;
            while (resultSet.next()) {
                User user = new User();
                int idUser = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type");
                user.setId(idUser);
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(type);
                toReturn.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(resultSet);
        DataAccess.close(findStatement);
        DataAccess.close(connection);
        return toReturn;
    }


}
