package com.company;

public class Student implements Comparable<Student> {

    private String firstName, lastName;
    private int studentID;

    public Student(String firstName, String lastName, int studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;

    }
    public String getLastName() {
        return lastName;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setStudentID(int studentID) {
        if(studentID >=0 && studentID <= 9999) {
            this.studentID = studentID;
        }
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + " (" + studentID + ")";
    }

    @Override
    public int compareTo(Student other) {
		/*
		if(studentID < other.studentID) {
			return -1;
		} else if(studentID > other.studentID) {
			return 1;
		} else { // the IDs are equal
			assert studentID == other.studentID;
			return 0;
		}
		*/
        return Integer.compare(studentID, other.studentID);
    }

    /*
    @Override
    public int compareTo(Student other) {
        if(lastName.compareTo(other.lastName)==0) { // last names are the same
            return firstName.compareTo(other.firstName);
        } else { // last names are different
            return lastName.compareTo(other.lastName);
        }

    }
    */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Student) {
            Student otherStudent = (Student) other;

            return this.studentID == otherStudent.studentID;
        } else {
            return false;
        }

    }






}

