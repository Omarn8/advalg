package coursework;
import java.util.*;

public class Task2 {
    static boolean SameSet(Vector<Integer> A, Vector<Integer> B) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            visited.add(A.get(i));
        }
        for (int i = 0; i < B.size(); i++) {
            if (!visited.contains(B.get(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Vector<Integer> A = new Vector<>();
        Vector<Integer> B = new Vector<>();
        A.add(1);
        A.add(15);
        A.add(120);
        A.add(61);
        A.add(8);
        A.add(120);
        A.add(2);
        B.add(2);
        B.add(5);
        B.add(6);
        B.add(8);
        B.add(10);
        B.add(2);
        B.add(2);
        if (SameSet(A, B)) {
            System.out.println("Yes, both sets are the same");
        } else {
            System.out.println("No, both sets are not the same");
        }
    }
}
