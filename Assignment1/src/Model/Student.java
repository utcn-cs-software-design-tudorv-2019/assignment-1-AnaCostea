package Model;

public class Student {
    private int studentId;
    private int group;
    private String enrolment;
    private int grades;

    public int getNrIdentificare() {
        return studentId;
    }

    public void setNrIdentificare(int nrIdentificare) {
        this.studentId = nrIdentificare;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(String enrolment) {
        this.enrolment = enrolment;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}
