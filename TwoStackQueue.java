package week12;
import java.util.*;

/**
 * A first-in-first-out collection of items.
 *
 * @author Aidan Horne.
 */
public class TwoStackQueue<E> implements Queue<E> {
    
    /** Bottom Stack. */
    Stack <E> leftStack = new Stack <E> ();
    /** Top Stack. */
    Stack <E> rightStack = new Stack <E> ();
    /**
     * Return true if and only if this Queue is empty.
     *
     * @return true if this Queue is empty, otherwise false.
     */
    public boolean isEmpty() {
        if (rightStack.empty() || leftStack.empty()) {
            return true;
        }
        return false;
    }
    
    /**
     * Return the length of this Queue.
     *
     * @return the number of items in this Queue.
     */
    public int size() {
        return rightStack.size() + leftStack.size();
    }
    /**
     * Return the item at the front of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E get() {
        if (rightStack.isEmpty() && leftStack.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (rightStack.isEmpty()) {
            while (leftStack.size() != 0) {
                rightStack.push(leftStack.pop());
            }
            return rightStack.peek();
        }
        if (leftStack.isEmpty()) {
            rightStack.peek();
        }
        return rightStack.peek();
    }
    /**
     * Make this Queue empty.
     */
    public void clear() {
        leftStack.clear();
        rightStack.clear();
    }
    
    /**
     * Add an item to the rear of this Queue.
     *
     * @param item the item to be added to the rear of the Queue.
     */
    public void add(E item) {
        leftStack.push(item);
    }
    
    /**
     * Remove and return the front item of this Queue.
     *
     * @return the item at the front of this Queue.
     * @throws EmptyQueueException if this Queue is empty.
     */
    public E remove() {
        if (rightStack.isEmpty() && leftStack.isEmpty()) {
            throw new EmptyQueueException();
        }
        if (rightStack.isEmpty() && !leftStack.isEmpty()) {
            while (leftStack.size() != 0) {
                rightStack.push(leftStack.pop());
            }
            return rightStack.pop();
        }
        if (!rightStack.isEmpty() && leftStack.isEmpty()) {
            return rightStack.pop();
        }
        return rightStack.pop();
    }
      
    
    /**
     * Return a string representation of this queue ordered from front to back.
     *
     * @return a string representation of this Queue.
     */
    public String toString() {
        String str = "";
        if (!rightStack.isEmpty() || !leftStack.isEmpty()) {
            if (rightStack.isEmpty()) {
                return leftStack.toString();
            }
            if (!rightStack.isEmpty()) {
                for (int i = rightStack.size() - 1; i > 0; i--) {
                    str += rightStack.elementAt(i) + ", ";
                }
                str += rightStack.elementAt(0);
                if (!leftStack.isEmpty()) {
                    for (int i = 0; i < leftStack.size(); i++) {
                        str += ", " + leftStack.elementAt(i);
                    }
                }
                str = "[" + str + "]";
                return str;
            }
        }
        
        return "[]";
    }
        
    /** Returns a string representation of both stacks.
      * @return leftStack and rightStack
      */
    public String debug() {
        return leftStack.toString() + rightStack.toString();
    }
}
