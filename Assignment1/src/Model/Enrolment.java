package Model;

public class Enrolment {
    private int courseId;
    private int studentId;
    private String exams;
    private int grades;

    public int getId() {
        return courseId;
    }

    public void setId(int id) {
        this.courseId = id;
    }

    public int getIdStudent() {
        return studentId;
    }

    public void setIdStudent(int idStudent) {
        this.studentId = idStudent;
    }

    public String getExams() {
        return exams;
    }

    public void setExams(String exams) {
        this.exams = exams;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}
