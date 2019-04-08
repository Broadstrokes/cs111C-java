import java.util.HashMap;
import java.util.Iterator;

@SuppressWarnings("Duplicates")
public class MyDriver {
    public static void main(String[] args) {
        test0();
        test1();
    }



    public static void test0() {
        HashMap<String, Student> studentMap = new HashMap();
        Student harry = new Student("harry", "1", false);
        Student jim = new Student("jim", "5", false);
        Student konan = new Student("konan", "6", false);
        Student barry = new Student("barry", "2", true);
        Student linda = new Student("linda", "8", false);
        Student kyle = new Student("kyle", "3", false);

        studentMap.put(harry.getId(), harry);
        studentMap.put(jim.getId(), jim);
        studentMap.put(konan.getId(), konan);
        studentMap.put(barry.getId(), barry);
        studentMap.put(linda.getId(), linda);
        studentMap.put(kyle.getId(), kyle);

        System.out.println(studentMap.toString());

        dropUnpaidStudents(studentMap);
        System.out.println(studentMap.toString());

    }

    public static void test1() {
        HashMap<String, Student> studentMap = new HashMap();
        Student harry = new Student("harry", "1", false);
        Student jim = new Student("jim", "5", false);
        Student konan = new Student("konan", "6", false);
        Student barry = new Student("barry", "2", true);
        Student linda = new Student("linda", "8", false);
        Student kyle = new Student("kyle", "3", false);

        studentMap.put(harry.getId(), harry);
        studentMap.put(jim.getId(), jim);
        studentMap.put(konan.getId(), konan);
        studentMap.put(barry.getId(), barry);
        studentMap.put(linda.getId(), linda);
        studentMap.put(kyle.getId(), kyle);

        System.out.println(studentMap.toString());

        dropUnpaidStudentsUsingIterator(studentMap);
        System.out.println(studentMap.toString());

    }


    // After Java 1.8
    // https://stackoverflow.com/questions/6092642/how-to-remove-a-key-from-hashmap-while-iterating-over-it
    public static void dropUnpaidStudents(HashMap<String, Student> map) {
        map.entrySet().removeIf(entry -> !entry.getValue().isTuitionPaid());
    }

    // https://thispointer.com/java-remove-elements-from-hashmap-while-iterating/
    public static void dropUnpaidStudentsUsingIterator(HashMap<String, Student> map) {
        Iterator<String> studentItr = map.keySet().iterator();
        while (studentItr.hasNext()) {
            String key = studentItr.next();
            if (!map.get(key).isTuitionPaid()) {
                studentItr.remove();
            }
        }
    }
}

