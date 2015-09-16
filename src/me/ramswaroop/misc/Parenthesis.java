package me.ramswaroop.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 9/15/15
 * @time: 11:15 PM
 */
public class Parenthesis {

    private static final char L_PAREN = '(';
    private static final char R_PAREN = ')';
    private static final char L_BRACE = '{';
    private static final char R_BRACE = '}';
    private static final char L_BRACKET = '[';
    private static final char R_BRACKET = ']';

    /**
     * Checks if the parenthesis are well-formed in string {@param input}.
     * <p/>
     * For example,
     * {[()]} : true
     * {[]()[]} : true
     * {[)} : false
     * {(} : false
     *
     * @param input
     * @return {@code true} if parenthesis are well-formed, {@code false} otherwise.
     */
    public static boolean isWellFormed(String input) {
        int len = input.length();
        Stack<Character> stack = new Stack<>();

        // base case
        if (len % 2 != 0) return false;

        for (int i = 0; i < len; i++) {
            char charAtI = input.charAt(i);
            if (charAtI == L_PAREN || charAtI == L_BRACE || charAtI == L_BRACKET) {
                stack.push(charAtI);
            } else if (charAtI == R_PAREN) {
                if (stack.isEmpty() || stack.pop() != L_PAREN) return false;
            } else if (charAtI == R_BRACE) {
                if (stack.isEmpty() || stack.pop() != L_BRACE) return false;
            } else if (charAtI == R_BRACKET) {
                if (stack.isEmpty() || stack.pop() != L_BRACKET) return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * Checks if the parenthesis are well-formed for the entire input.
     *
     * @param filePath
     */
    public static void areParenthesisWellFormed(String filePath) {
        List<String> input = readFile(filePath);
        for (int i = 0; i < input.size(); i++) {
            System.out.println(isWellFormed(input.get(i)) ? "True" : "False");
        }
    }

    /**
     * Reads the file specified in {@param filePath}.
     *
     * @param filePath
     * @return list of strings in each line of the file
     */
    public static List<String> readFile(String filePath) {

        List<String> input = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                input.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    /**
     * Starting point of the program.
     *
     * @param a
     */
    public static void main(String a[]) {
        areParenthesisWellFormed(a[0]);
        System.exit(0);
    }
}

/**
 * Stack implementation using
 * a singly linked list.
 *
 * @param <E>
 */
class Stack<E> {

    private Node<E> top;

    public Stack() {
        top = null;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item
     */
    public E push(E item) {
        top = new Node<>(item, top);
        return item;
    }

    /**
     * Removes the object at the top of this stack and
     * returns it.
     *
     * @return
     */
    public E pop() {
        E item = peek();
        top = top.next;
        return item;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return
     */
    public E peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Generic node for holding values of any object type.
     *
     * @param <E>
     */
    private class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
