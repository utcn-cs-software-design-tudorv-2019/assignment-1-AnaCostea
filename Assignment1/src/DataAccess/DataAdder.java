package DataAccess;

import Model.Client;
import Model.Enrolment;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAdder {
    private static final String ADD_CLIENT = "INSERT INTO client1 " + "VALUES (?, ?, ?, ?);";
    private static final String ADD_STUDENT = "INSERT INTO student " + "VALUES (?, ?, ?, ?);";
    private static final String ADD_ENROLMENT = "INSERT INTO enrolment1 " + "VALUES (?, ?, ?, ?);";


    public static void addClient(Client client) {
        assert (DataRetriever.findClientById(client.getId()) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(ADD_CLIENT);
            findStatement.setInt(1, client.getId());
            findStatement.setString(2, client.getName());
            findStatement.setString(3, client.getCNP());
            findStatement.setString(4, client.getAddress());
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void addStudent(Student student) {
        assert (DataRetriever.findStudentById(student.getNrIdentificare()) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(ADD_STUDENT);
            findStatement.setInt(1, student.getNrIdentificare());
            findStatement.setInt(2, student.getGroup());
            findStatement.setString(3, student.getEnrolment());
            findStatement.setInt(4, student.getGrades());
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void addEnrolment(Enrolment enrolment) {
        assert (DataRetriever.findEnrolmentById(enrolment.getId()) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(ADD_ENROLMENT);
            findStatement.setInt(1, enrolment.getId());
            findStatement.setInt(2, enrolment.getIdStudent());
            findStatement.setString(3, enrolment.getExams());
            findStatement.setInt(4, enrolment.getGrades());
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }

}
