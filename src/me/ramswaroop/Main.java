package me.ramswaroop;

import me.ramswaroop.common.*;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        int k1, k2;
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new LinkedStack<>();
        Queue<Integer> queue = new LinkedQueue<>();
        LinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        chooseModule:
        while (true) {
            out.println("Choose module:");
            out.println("==============");
            out.println("1. Stack");
            out.println("2. Queue");
            out.println("3. SingleLinkedList");
            out.println("4. Exit");
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
                        out.println("7. Print");
                        out.println("8. Exit module");
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
                                singleLinkedList.printList();
                                break;
                            case 8:
                                continue chooseModule;
                            default:
                                out.println("Wrong choice!");
                        }
                    }
                case 4:
                    out.println("Exiting...");
                    System.exit(0);
                default:
                    out.println("Wrong choice!");
            }
        }
    }
}
