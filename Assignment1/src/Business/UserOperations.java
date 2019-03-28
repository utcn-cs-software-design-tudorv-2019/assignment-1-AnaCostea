package Business;

import DataAccess.DataAdder;
import DataAccess.DataEditer;
import DataAccess.DataRemover;
import DataAccess.DataRetriever;
import Model.Client;
import Model.Student;
import Model.User;

import java.sql.SQLException;
import java.util.List;

public class UserOperations {
    public UserOperations() {}

    public static void addClient(Client client) {
        DataAdder.addClient(client);
    }

    public static void editClient(Client client) {
        DataEditer.editClient(client.getId(), client.getName(), client.getCNP(), client.getAddress());
    }

    public static void deleteClient(Client client) {
        DataRemover.deleteClient(client.getId());
    }

    public static void addStudent(Student student) {
        DataAdder.addStudent(student);
    }

    public static void editStudent(Student student) {
        DataEditer.editStudent(student.getNrIdentificare(), student.getGroup(), student.getEnrolment(), student.getGrades());
    }

    public static void deleteStudent(Student student) {
        DataRemover.deleteStudent(student.getNrIdentificare());
    }


    public static List<Object> getAllClients() {
        return DataRetriever.findClients();
    }

    public static List<Object> getAllStudents() {
        return DataRetriever.findStudents();
    }

    public static List<Object> getAllEnrolments() {
        return DataRetriever.findEnrolments();
    }

    public int userLogin(String username, String password){
        DataRetriever dataRetriever = DataRetriever.getInstance();
        User user;
        user = dataRetriever.findUserByName(username, password);
        if(user.getType().equals("Student")){
            return 1;
        } else if(user.getType().equals("Admin")){
            return 2;
        }
        return 0;
    }

}
