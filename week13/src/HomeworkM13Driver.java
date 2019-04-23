import java.util.*;

@SuppressWarnings("Duplicates")
public class HomeworkM13Driver {

    public static void main(String[] args) {

        System.out.println("*****TESTING CLIENT VIEW SPLICE");
        QueueInterface<Integer> q1 = new LinkedQueue<Integer>();
        QueueInterface<Integer> q2 = new LinkedQueue<Integer>();
        splice(q1, q2);
        System.out.println("q1 empty: \ntrue\n" + q1.isEmpty());
        System.out.println("q2 empty: \ntrue\n" + q2.isEmpty());
        q1.enqueue(4);
        q1.enqueue(8);
        q1.enqueue(9);
        q1.enqueue(2);
        splice(q1, q2);
        System.out.println("\nq1 contains: \n4 8 9 2");
        ((LinkedQueue<Integer>) q1).display();
        System.out.println("q2 still empty: \ntrue\n" + q2.isEmpty());

        q2.enqueue(1);
        q2.enqueue(3);
        q2.enqueue(7);
        q2.enqueue(6);
        q2.enqueue(3);
        q2.enqueue(1);
        splice(q1, q2);
        System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6 3 1");
        ((LinkedQueue<Integer>) q1).display();
        System.out.println("q2 still contains: \n1 3 7 6 3 1");
        ((LinkedQueue<Integer>) q2).display();

        System.out.println("\n\n*****TESTING ARRAYQUEUE SPLICE");
        ArrayQueue<String> wordQueue1 = new ArrayQueue<String>();
        ArrayQueue<String> wordQueue2 = new ArrayQueue<String>();
        splice(wordQueue1, wordQueue2);
        System.out.println("wordQueue1 empty: \ntrue\n" + wordQueue1.isEmpty());
        System.out.println("wordQueue2 empty: \ntrue\n" + wordQueue2.isEmpty());
        wordQueue1.enqueue("a");
        wordQueue1.enqueue("b");
        wordQueue1.enqueue("c");
        wordQueue1.enqueue("a");
        wordQueue1.splice(wordQueue2);
        System.out.println("\nwordQueue1 contains: \na b c a");
        wordQueue1.display();
        System.out.println("wordQueue2 still empty: \ntrue\n" + wordQueue2.isEmpty());
        wordQueue2.enqueue("d");
        wordQueue2.enqueue("e");
        wordQueue2.enqueue("f");
        wordQueue2.enqueue("e");
        wordQueue1.splice(wordQueue2);
        System.out.println("\nwordQueue1 contains: \na b c a d e f e");
        wordQueue1.display();
        System.out.println("wordQueue2 still contains: \nd e f e");
        wordQueue2.display();


        ArrayQueue<Integer> aq1 = new ArrayQueue<Integer>(4);
        aq1.enqueue(99);
        aq1.enqueue(99);
        aq1.enqueue(99);
        aq1.enqueue(4);
        aq1.dequeue(); // these lines included so that the contents of the array wrap around for testing purposes
        aq1.dequeue();
        aq1.dequeue();
        aq1.enqueue(8);
        aq1.enqueue(9);
        aq1.enqueue(2);

        ArrayQueue<Integer> aq2 = new ArrayQueue<Integer>(4);
        aq2.enqueue(99);
        aq2.enqueue(99);
        aq2.enqueue(99);
        aq2.enqueue(1);
        aq2.dequeue(); // these lines included so that the contents of the array wrap around for testing purposes
        aq2.dequeue();
        aq2.dequeue();
        aq2.enqueue(3);
        aq2.enqueue(7);
        aq2.enqueue(6);

        aq1.splice(aq2);
        System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6");
        aq1.display();
        System.out.println("q2 still contains: \n1 3 7 6");
        aq2.display();

        System.out.println("\n\n*****TESTING LINKEDQUEUE SPLICE");
        LinkedQueue<Integer> lq1 = new LinkedQueue<Integer>();
        LinkedQueue<Integer> lq2 = new LinkedQueue<Integer>();
        lq1.splice(lq2);
        System.out.println("lq1 empty: \ntrue\n" + lq1.isEmpty());
        System.out.println("lq2 empty: \ntrue\n" + lq2.isEmpty());
        lq1.enqueue(4);
        lq1.enqueue(8);
        lq1.enqueue(9);
        lq1.enqueue(2);
        lq1.splice(lq2);
        System.out.println("\nlq1 contains: \n4 8 9 2");
        lq1.display();
        System.out.println("lq2 still empty (and no exception thrown): \ntrue\n" + lq2.isEmpty());

        lq2.enqueue(1);
        lq2.enqueue(3);
        lq2.enqueue(7);
        lq2.enqueue(6);
        lq1.splice(lq2);
        System.out.println("\nq1 contains: \n4 8 9 2 1 3 7 6");
        lq1.display();
        System.out.println("q2 still contains: \n1 3 7 6");
        lq2.display();


//        test0();
//        test1();
        test3();
    }


    public static void test3() {
        DequeStack<String> stack = new DequeStack<>();

        stack.push("ant");
        stack.push("bear");
        stack.push("cat");
        stack.push("dog");
        stack.push("elephant");

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println();

        stack.push("ant");
        stack.push("bear");
        stack.push("cat");
        stack.push("dog");
        stack.push("elephant");
        stack.push("frog");
        stack.push("giraffe");

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

//    public static void test2() {
//        pq1.add(1d) // pq1: 1d
//        pq1.add(2e) // pq1: 1d, 2e
//        pq1.add(1a) // pq1: 1d, 1a, 2e
//        pq1.add(2a) // pq1: 1d, 1a, 2e, 2a
//        pq1.add(1c) // pq1: 1d, 1a, 1c, 2e, 2a
//        pq1.add(1e); // pq1: 1d, 1a, 1c, 1e, 2e, 2a
//        pq1.remove() // pq1: 1a, 1c, 1e, 2e, 2a
//        pq1.add(pq1.remove()) // pq1: 1c, 1e, 1a, 2e, 2a
//        pq1.add(pq1.getFront()) // pq1: 1c, 1e, 1a, 1c, 2e, 2a
//        pq1.remove() // pq1: 1e, 1a, 1c, 2e, 2a
//        pq1.remove() // pq1: 1a, 1c, 2e, 2a
//        pq1.remove(); // pq1: 1c, 2e, 2a
//        pq1.remove(); // pq1: 2e, 2a
//    }

    public static void test1() {
        DriverUtil.printDashes();
        DriverUtil.printNameOfCurrMethod();
        DriverUtil.printDashes();

        DequeInterface<String> dq1 = new LinkedDeque<String>();
        DequeInterface<String> dq2 = new LinkedDeque<String>();
        dq1.addToFront("x"); // dq1: x
        dq1.addToFront("y"); // dq1: yx
        dq1.addToBack("z"); // dq1: yxz
        dq2.addToFront("a"); // dq1: yxz | dq2: a
        dq2.addToBack("b"); // dq1: yxz | dq2: ab
        dq2.addToBack(dq1.removeBack()); // dq1: yx | dq2: abz
        dq1.addToFront(dq2.getBack()); // dq1: zyx | dq2: abz
        dq1.addToFront(dq2.getBack()); // dq1: zzyx | dq2: abz
        dq2.addToFront(dq2.removeFront()); // dq1: zzyx | dq2: abz
        dq1.addToBack(dq2.getFront()); // dq1: zzyxa | dq2: abz
        dq2.addToBack(dq2.removeFront()); // dq1: azzyxa | dq2: bza

        String dq1String = "";
        while(!dq1.isEmpty()) {
            dq1String += dq1.removeFront();
        }
        String dq2String = "";
        while(!dq2.isEmpty()) {
            dq2String += dq2.removeFront();
        }

        DriverUtil.println("DQ1: " + dq1String);
        DriverUtil.println("DQ2: " + dq2String);

    }

    public static void test0(){
        DriverUtil.printDashes();
        DriverUtil.printNameOfCurrMethod();
        DriverUtil.printDashes();

        QueueInterface<String> q1 = new LinkedQueue<String>();
        QueueInterface<String> q2 = new LinkedQueue<String>();
        q1.enqueue("x");
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q1.enqueue("y");
        q2.enqueue("a");
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q2.enqueue("b");
        q1.enqueue(q2.getFront());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q2.enqueue(q1.dequeue());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q2.enqueue(q1.getFront());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q2.dequeue();
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q1.enqueue(q2.getFront());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q1.enqueue(q1.dequeue());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
        q2.enqueue(q1.getFront());
        DriverUtil.print("Q1: "); ((LinkedQueue<String>) q1).display();
        DriverUtil.print("Q2: "); ((LinkedQueue<String>) q2).display();
    }


    // note: don't worry about generics here; i've omitted them and supressed the
    // warnings so you can focus on the queue logic
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void splice(QueueInterface firstQueue, QueueInterface secondQueue) {
        LinkedQueue tempQ = new LinkedQueue();

        while(!secondQueue.isEmpty()) {
            firstQueue.enqueue(secondQueue.getFront());
            tempQ.enqueue(secondQueue.dequeue());
        }

        while(!tempQ.isEmpty()) {
            secondQueue.enqueue(tempQ.dequeue());
        }
    }

}