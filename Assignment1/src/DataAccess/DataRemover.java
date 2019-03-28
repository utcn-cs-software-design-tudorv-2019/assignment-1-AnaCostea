package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataRemover {
    private static final String REMOVE_CLIENT = "DELETE FROM client1 WHERE id = ?";
    private static final String REMOVE_STUDENT = "DELETE FROM student WHERE nrIdentificare = ?";
    private static final String REMOVE_ENROLMENT = "DELETE FROM enrolment1 WHERE id = ?";

    public static void deleteClient(int id) {
        assert (DataRetriever.findClientById(id) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(REMOVE_CLIENT);
            findStatement.setInt(1, id);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void deleteStudent(int nrIdentificare) {
        assert (DataRetriever.findStudentById(nrIdentificare) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(REMOVE_STUDENT);
            findStatement.setInt(1, nrIdentificare);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }


    public static void deleteEnrolment(int id) {
        assert (DataRetriever.findEnrolmentById(id) != null);
        Connection connection = DataAccess.getConnection();
        PreparedStatement findStatement = null;
        try {
            assert connection != null;
            findStatement = connection.prepareStatement(REMOVE_ENROLMENT);
            findStatement.setInt(1, id);
            findStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataAccess.close(findStatement);
        DataAccess.close(connection);
    }

}
