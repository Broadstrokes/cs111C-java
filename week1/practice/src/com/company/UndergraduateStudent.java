package com.company;

public class UndergraduateStudent extends Student {

    private boolean isTuitionPaid;


    public UndergraduateStudent(String firstName, String lastName, int studentId, boolean tuitionPayed) {
        super(firstName, lastName, studentId);

        this.isTuitionPaid = tuitionPayed;
    }

    public UndergraduateStudent(String firstName, String lastName, int studentId) {
        this(firstName, lastName, studentId, false);
    }

    public boolean getIsTuitionPaid() {
        return isTuitionPaid;
    }

    public void setTuitionPaid(boolean tuitionPaid) {
        isTuitionPaid = tuitionPaid;
    }

    @Override
    public String toString() {
        return String.format("Student: " + getFirstName() + " " + getLastName() + " | ID: " + getStudentID() + " | Tuition Payed? " + getIsTuitionPaid());
    }
}
