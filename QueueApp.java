package week12;
import java.util.*;
/**
 * QueueApp to run TwoStackQueue.
 *
 * @author Aidan Horne
 */
public class QueueApp<E> {
    
    /** main method to allow user to manipulate stack.
      * @param args for input.
      */
    public static void main (String [] args) {
        Scanner s = new Scanner(System.in);
        TwoStackQueue <String> queue = new TwoStackQueue <String>();
        while (s.hasNext()) {
            String line = s.nextLine();
            String input = line.substring(0, 1);
            line = line.substring(1);
            Scanner s1 = new Scanner(line);
            if (input.equals("a")) {
                while (s1.hasNext()) {
                    queue.add(s1.next());
                }
            }
            if (input.equals("c")) {
                queue.clear();
            }
            if (input.equals("d")) {
                System.out.println(queue.debug());
            }
            if (input.equals("p")) {
                System.out.println(queue.toString());
            }    
            if (input.equals("s")) {
                System.out.println(queue.size());
            }
            try {
                if (input.equals("g")) {
                    System.out.println(queue.get());
                }
                if (input.equals("r")) {
                    System.out.println(queue.remove());
                }
            } catch (EmptyQueueException e) {}
        }
    }
}
