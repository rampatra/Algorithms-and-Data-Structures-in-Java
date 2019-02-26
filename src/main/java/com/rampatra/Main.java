package com.rampatra;

import com.rampatra.base.CircularSingleLinkedList;
import com.rampatra.base.DoubleLinkedList;
import com.rampatra.base.LinkedList;
import com.rampatra.base.LinkedQueue;
import com.rampatra.base.LinkedStack;
import com.rampatra.base.Queue;
import com.rampatra.base.SingleLinkedList;
import com.rampatra.base.Stack;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        int k1, k2;
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new LinkedStack<>();
        Queue<Integer> queue = new LinkedQueue<>();
        LinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        LinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        LinkedList<Integer> circularSingleLinkedList = new CircularSingleLinkedList<>();
        chooseModule:
        while (true) {
            out.println("Choose module:");
            out.println("==============");
            out.println("1. Stack");
            out.println("2. Queue");
            out.println("3. SingleLinkedList");
            out.println("4. DoubleLinkedList");
            out.println("5. CircularSingleLinkedList");
            out.println("6. CircularDoubleLinkedList");
            out.println("7. Exit");
            k1 = Integer.parseInt(in.nextLine());
            switch (k1) {
                case 1:
                    while (true) {
                        out.println("Select operation:");
                        out.println("=================");
                        out.println("1. Push");
                        out.println("2. Pop");
                        out.println("3. Peek");
                        out.println("4. Print");
                        out.println("5. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        switch (k2) {
                            case 1:
                                out.println("Enter value:");
                                int input = Integer.parseInt(in.nextLine());
                                stack.push(input);
                                stack.print();
                                break;
                            case 2:
                                out.println("Removed element: " + stack.pop());
                                stack.print();
                                break;
                            case 3:
                                out.println("Front element: " + stack.peek());
                                stack.print();
                                break;
                            case 4:
                                stack.print();
                                break;
                            case 5:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 2:
                    while (true) {
                        out.println("Select operation:");
                        out.println("=================");
                        out.println("1. Add");
                        out.println("2. Remove");
                        out.println("3. Front element");
                        out.println("4. Print");
                        out.println("5. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        switch (k2) {
                            case 1:
                                out.println("Enter value:");
                                int input = Integer.parseInt(in.nextLine());
                                queue.add(input);
                                queue.print();
                                break;
                            case 2:
                                out.println("Removed element: " + queue.remove());
                                queue.print();
                                break;
                            case 3:
                                out.println("Front element: " + queue.element());
                                queue.print();
                                break;
                            case 4:
                                queue.print();
                                break;
                            case 5:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 3:
                    while (true) {
                        out.println("Select operation:");
                        out.println("=================");
                        out.println("1. Add");
                        out.println("2. Add at index");
                        out.println("3. Remove");
                        out.println("4. Remove at index");
                        out.println("5. Remove item");
                        out.println("6. Edit item");
                        out.println("7. Delete LinkedList");
                        out.println("8. Print");
                        out.println("9. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        int item, index;
                        switch (k2) {
                            case 1:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                singleLinkedList.add(item);
                                singleLinkedList.printList();
                                break;
                            case 2:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                singleLinkedList.add(index, item);
                                singleLinkedList.printList();
                                break;
                            case 3:
                                out.println("Removed element: " + singleLinkedList.remove());
                                singleLinkedList.printList();
                                break;
                            case 4:
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Removed element: " + singleLinkedList.remove(index));
                                singleLinkedList.printList();
                                break;
                            case 5:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Removed: " + singleLinkedList.removeItem(item));
                                singleLinkedList.printList();
                                break;
                            case 6:
                                out.println("Enter index to edit:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Enter new value:");
                                item = Integer.parseInt(in.nextLine());
                                singleLinkedList.set(index, item);
                                singleLinkedList.printList();
                                break;
                            case 7:
                                singleLinkedList.clear();
                                out.println("LinkedList deleted.");
                                singleLinkedList.printList();
                                break;
                            case 8:
                                singleLinkedList.printList();
                                break;
                            case 9:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 4:
                    while (true) {
                        out.println("Select operation:");
                        out.println("=================");
                        out.println("1. Add");
                        out.println("2. Add at index");
                        out.println("3. Remove");
                        out.println("4. Remove at index");
                        out.println("5. Remove item");
                        out.println("6. Edit item");
                        out.println("7. Delete LinkedList");
                        out.println("8. Print");
                        out.println("9. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        int item, index;
                        switch (k2) {
                            case 1:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                doubleLinkedList.add(item);
                                doubleLinkedList.printList();
                                break;
                            case 2:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                doubleLinkedList.add(index, item);
                                doubleLinkedList.printList();
                                break;
                            case 3:
                                out.println("Removed element: " + doubleLinkedList.remove());
                                doubleLinkedList.printList();
                                break;
                            case 4:
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Removed element: " + doubleLinkedList.remove(index));
                                doubleLinkedList.printList();
                                break;
                            case 5:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Removed: " + doubleLinkedList.removeItem(item));
                                doubleLinkedList.printList();
                                break;
                            case 6:
                                out.println("Enter index to edit:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Enter new value:");
                                item = Integer.parseInt(in.nextLine());
                                doubleLinkedList.set(index, item);
                                doubleLinkedList.printList();
                                break;
                            case 7:
                                doubleLinkedList.clear();
                                out.println("LinkedList deleted.");
                                doubleLinkedList.printList();
                                break;
                            case 8:
                                doubleLinkedList.printList();
                                break;
                            case 9:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 5:
                    while (true) {
                        out.println("Select operation:");
                        out.println("=================");
                        out.println("1. Add");
                        out.println("2. Add at index");
                        out.println("3. Remove");
                        out.println("4. Remove at index");
                        out.println("5. Remove item");
                        out.println("6. Edit item");
                        out.println("7. Delete LinkedList");
                        out.println("8. Print");
                        out.println("9. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        int item, index;
                        switch (k2) {
                            case 1:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                circularSingleLinkedList.add(item);
                                circularSingleLinkedList.printList();
                                break;
                            case 2:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                circularSingleLinkedList.add(index, item);
                                circularSingleLinkedList.printList();
                                break;
                            case 3:
                                out.println("Removed element: " + circularSingleLinkedList.remove());
                                circularSingleLinkedList.printList();
                                break;
                            case 4:
                                out.println("Enter index:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Removed element: " + circularSingleLinkedList.remove(index));
                                circularSingleLinkedList.printList();
                                break;
                            case 5:
                                out.println("Enter value:");
                                item = Integer.parseInt(in.nextLine());
                                out.println("Removed: " + circularSingleLinkedList.removeItem(item));
                                circularSingleLinkedList.printList();
                                break;
                            case 6:
                                out.println("Enter index to edit:");
                                index = Integer.parseInt(in.nextLine());
                                out.println("Enter new value:");
                                item = Integer.parseInt(in.nextLine());
                                circularSingleLinkedList.set(index, item);
                                circularSingleLinkedList.printList();
                                break;
                            case 7:
                                circularSingleLinkedList.clear();
                                out.println("LinkedList deleted.");
                                circularSingleLinkedList.printList();
                                break;
                            case 8:
                                circularSingleLinkedList.printList();
                                break;
                            case 9:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 6:
                    out.println("Yet to be developed!");
                    break;
                case 7:
                    out.println("Exiting...");
                    return;
                default:
                    out.println("Wrong choice!");
            }
        }
    }
}
