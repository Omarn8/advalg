package coursework;
import java.util.*;

public class Q2 {
	 static boolean areSameSet(Vector<Integer> A, Vector<Integer> B){
	        int n = A.size();
	        if (B.size() != n){
	            return false;
	        }
	        Vector<Boolean> visited = new Vector<Boolean>();
	        for (int i = 0; i < n; i++){
	            visited.add(i, Boolean.FALSE);
	        }
	     
	        for (int i = 0; i < n; i++){
	            int j = 0;
	            for (j = 0; j < n; j++){
	                if (A.get(i) == B.get(j) && visited.get(j) == false){
	                    visited.add(j, Boolean.TRUE);
	                    break;
	                }
	            }
	            if (j == n){
	                return false;
	            }
	        }
	        return true;
	    }
	    public static void main(String[] args){
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
	 
	        if (areSameSet(A, B)){
	            System.out.println("Yes");
	        }
	        else{
	            System.out.println("No");
	        }
	    }
}
