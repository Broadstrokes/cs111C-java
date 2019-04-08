public class Student implements Comparable<Student> {

    private String name;
    private String id;
    private boolean paid;

    public Student(String name, String id, boolean paid) {
        this.name = name;
        this.id = id;
        this.paid = paid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean isTuitionPaid() { return this.paid; }


    @Override
    public String toString() { return "Name: " + name + " Id: " + id; }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student other = (Student) obj;
            return name.equals(other.name) && id.equals(other.id);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Student otherStudent) {
        return id.compareTo(otherStudent.id);
        //return name.compareTo(otherStudent.name);
    }


}
