import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("Duplicates")
public class MyDriver {
    public static void main(String[] args) {
        test0();
        test1();
    }



    public static void test0() {
        HashMap<String, Student> studentMap = new HashMap<>();
        Student harry = new Student(1, "Harry", "Stiles", false);
        Student jim = new Student(5, "Jim", "Kramer", false);
        Student konan = new Student(6, "Conan", "O' Brian", false);
        Student barry = new Student(2, "Barry", "Bonds", true);
        Student linda = new Student(8, "Linda", "Smith", true);
        Student kyle = new Student(3, "Kyle", "Chu", false);

        studentMap.put(Integer.toString(harry.getId()), harry);
        studentMap.put(Integer.toString(jim.getId()), jim);
        studentMap.put(Integer.toString(konan.getId()), konan);
        studentMap.put(Integer.toString(barry.getId()), barry);
        studentMap.put(Integer.toString(linda.getId()), linda);
        studentMap.put(Integer.toString(kyle.getId()), kyle);

        System.out.println(studentMap.toString());

        dropUnpaidStudents(studentMap);
        System.out.println(studentMap.toString());

    }

    public static void test1() {
        HashMap<String, Student> studentMap = new HashMap<>();
        Student harry = new Student(1, "Harry", "Stiles", false);
        Student jim = new Student(5, "Jim", "Kramer", false);
        Student konan = new Student(6, "Conan", "O' Brian", false);
        Student barry = new Student(2, "Barry", "Bonds", true);
        Student linda = new Student(8, "Linda", "Smith", true);
        Student kyle = new Student(3, "Kyle", "Chu", false);

        studentMap.put(Integer.toString(harry.getId()), harry);
        studentMap.put(Integer.toString(jim.getId()), jim);
        studentMap.put(Integer.toString(konan.getId()), konan);
        studentMap.put(Integer.toString(barry.getId()), barry);
        studentMap.put(Integer.toString(linda.getId()), linda);
        studentMap.put(Integer.toString(kyle.getId()), kyle);

        System.out.println(studentMap.toString());

        dropUnpaidStudentsUsingIterator(studentMap);
        System.out.println(studentMap.toString());

    }


    // After Java 1.8
    // https://stackoverflow.com/questions/6092642/how-to-remove-a-key-from-hashmap-while-iterating-over-it
    public static void dropUnpaidStudents(HashMap<String, Student> map) {
        map.entrySet().removeIf(entry -> !entry.getValue().hasPaidFees());
    }

    // https://thispointer.com/java-remove-elements-from-hashmap-while-iterating/
    public static void dropUnpaidStudentsUsingIterator(HashMap<String, Student> map) {
        Iterator<String> studentItr = map.keySet().iterator();
        while (studentItr.hasNext()) {
            String key = studentItr.next();
            if (!map.get(key).hasPaidFees()) {
                studentItr.remove();
            }
        }
    }
}

