import java.util.*;
public class Test {
    
    public static void main (String [] args) {
        int[] test = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] x = new int[][] {{1, 2} , {3, 4, 5} , {-2, 0, 1, 3}};
        Test a = new Test();
        a.reverse(test, 2, 6);
        int[] b = a.join(x);
        Stack <Integer> s = new Stack<>();
        s.push(7);
        while (!s.isEmpty()) {
            int n = s.pop();
            System.out.print(n + " ");
            if (n >= 3) {
                s.push(n-2);
            }
            if (n >= 4) {
                s.push(n-3);
            }
        }
        Queue <Integer> q = new Queue<>();
        q.add(7);
        while (!q.isEmpty()) {
            int n = q.remove();
            System.out.println(n + " ");
            if (n >= 3) {
                q.add(n-2);
            }
            if (n >= 4) {
                q.add(n-3);
            }
        }
    }
    
    public void reverse (int[] a, int i, int j) {
        int[] temp = new int[a.length];
        while (j > i) {
            j--;
            temp[i] = a[j - 1];
        }
    }
    
    public int[] join(int[][] a) {
        int [] temp = new int[a.length];
        int count = 0;
        for (int [] b : a) {
            for (int q : b) {
                temp[count] = q;
            }
            count++;
        }
        return temp;
    }
    
    
    
}