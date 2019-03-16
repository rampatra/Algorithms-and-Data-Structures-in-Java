package com.rampatra.stacks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author rampatra
 * @since 9/15/15
 */
public class BalancingParenthesis {

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

        // obvious check as the i/p only consists of parenthesis
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
     * Reads the file specified in {@param filePath} line by line
     * and checks if parenthesis are well-formed or not.
     *
     * @param filePath
     */
    public static void readFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(isWellFormed(line) ? "True" : "False");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starting point of the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        readFile(args[0]);
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
