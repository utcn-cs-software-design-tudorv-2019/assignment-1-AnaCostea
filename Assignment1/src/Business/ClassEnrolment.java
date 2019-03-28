package Business;

import DataAccess.DataAdder;
import DataAccess.DataRetriever;
import Model.Enrolment;

import java.util.List;

public class ClassEnrolment {
    public ClassEnrolment() {}

    public static void addCourse(Enrolment course) {

        DataAdder.addEnrolment(course);
    }


    public static void addExam(Enrolment exam) {
        DataAdder.addEnrolment(exam);
    }


    public static List<Object> getAllGrades() {
            return DataRetriever.findEnrolments();
    }

}
