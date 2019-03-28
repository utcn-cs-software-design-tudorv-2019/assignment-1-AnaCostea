package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataEditer {
    private static final String EDIT_CLIENT = "UPDATE client1 SET name = ?, CNP = ?, address = ? WHERE id = ?";
    private static final String EDIT_STUDENT = "UPDATE student SET grupa = ?, enrolment = ?, grades = ? WHERE nrIdentificare = ? ";
    private static final String EDIT_ENROLMENT = "UPDATE enrolment1 SET idStudent = ?, exams = ?, grades = ? WHERE id = ?";

    public static void editClient(int id, String name, String CNP, String address) {
        assert (DataRetriever.findClientById(id) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(EDIT_CLIENT);
            findStatement.setInt(4, id);
            findStatement.setString(1, name);
            findStatement.setString(2, CNP);
            findStatement.setString(3, address);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void editStudent(int nrIdentificare, int grupa, String enrolment, int grades) {
        assert (DataRetriever.findStudentById(nrIdentificare) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(EDIT_STUDENT);
            findStatement.setLong(1, grupa);
            findStatement.setString(2, enrolment);
            findStatement.setInt(3, grades);
            findStatement.setLong(4, nrIdentificare);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void editEnrolment(int id, int idStudent, String exams, int grades) {
        assert (DataRetriever.findEnrolmentById(id) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(EDIT_ENROLMENT);
            findStatement.setInt(4, id);
            findStatement.setInt(1, idStudent);
            findStatement.setString(2, exams);
            findStatement.setInt(3, grades);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }
}
