package me.ramswaroop;

import me.ramswaroop.common.LinkedQueue;
import me.ramswaroop.common.LinkedStack;
import me.ramswaroop.utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k1, k2;
        Scanner in = new Scanner(System.in);
        LinkedStack<Integer> stack = new LinkedStack<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        firstLoop:
        while (true) {
            Utils.println("Choose module:");
            Utils.println("==============");
            Utils.println("1. Stack");
            Utils.println("2. Queue");
            Utils.println("3. BST");
            Utils.println("4. Exit");
            k1 = Integer.parseInt(in.nextLine());
            switch (k1) {
                case 1:
                    while (true) {
                        Utils.println("Select operation:");
                        Utils.println("=================");
                        Utils.println("1. Push");
                        Utils.println("2. Pop");
                        Utils.println("3. Peek");
                        Utils.println("4. Print");
                        Utils.println("5. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        switch (k2) {
                            case 1:
                                Utils.println("Enter value:");
                                int input = Integer.parseInt(in.nextLine());
                                stack.push(input);
                                stack.print();
                                break;
                            case 2:
                                stack.pop();
                                stack.print();
                                break;
                            case 3:
                                stack.peek();
                                stack.print();
                                break;
                            case 4:
                                stack.print();
                                break;
                            case 5:
                                continue firstLoop;
                            default:
                                Utils.println("Wrong choice!");
                        }
                    }
                case 2:
                    while (true) {
                        Utils.println("Select operation:");
                        Utils.println("=================");
                        Utils.println("1. Add");
                        Utils.println("2. Remove");
                        Utils.println("3. Front Element");
                        Utils.println("4. Print");
                        Utils.println("5. Exit module");
                        k2 = Integer.parseInt(in.nextLine());
                        switch (k2) {
                            case 1:
                                Utils.println("Enter value:");
                                int input = Integer.parseInt(in.nextLine());
                                queue.add(input);
                                queue.print();
                                break;
                            case 2:
                                queue.remove();
                                queue.print();
                                break;
                            case 3:
                                queue.element();
                                queue.print();
                                break;
                            case 4:
                                queue.print();
                                break;
                            case 5:
                                continue firstLoop;
                            default:
                                Utils.println("Wrong choice!");
                        }
                    }
                case 3:
                    break;
                case 4:
                    Utils.println("Exiting...");
                    System.exit(0);
                default:
                    Utils.println("Wrong choice!");
            }
        }
    }
}
