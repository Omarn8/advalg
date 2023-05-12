package coursework;
import java.util.*;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();     
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            if(!uniqueChars.contains(c)) {
                uniqueChars.add(c);
            }
        }     
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
        scanner.close();
    }
}
