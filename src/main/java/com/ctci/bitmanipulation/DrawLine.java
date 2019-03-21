package com.ctci.bitmanipulation;

import java.util.Arrays;

/**
 * @author rampatra
 * @since 2019-03-21
 */
public class DrawLine {

    /**
     * A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored
     * in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
     * The height of the screen, of course, can be derived from the length of the array and the width. Implement a
     * function that draws a horizontal line from (xl, y) to ( x2, y).
     * <p>
     * The method signature should look something like:
     * {@code drawline(byte[] screen, int width, int xl, int x2, int y)}
     * <p>
     * Approach:
     * First, find the numbers in which all bits has to be set. Next, find the starting number and apply the mask
     * created from the starting offset. Do the same with the ending number.
     *
     * @param screen
     * @param width
     * @param x1
     * @param x2
     * @param y
     */
    private static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int startFullByte = x1 / 8;
        if (startOffset != 0) {
            startFullByte++;
        }
        int endOffset = x2 % 8;
        int endFullByte = x2 / 8;
        if (endOffset != 7) {
            endFullByte--;
        }

        // all bits have to be set in in-between numbers
        for (int i = startFullByte; i <= endFullByte; i++) {
            screen[width / 8 * y + i] |= (byte) 0xff;
        }

        /* 0xff is an integer literal which is like 000...11111111 (32 bits) but when we
         cast it to a byte, we get rid of the initial 24 bits */
        byte startByteMask = (byte) (0xff >> startOffset);
        byte endByteMask = (byte) ~(0xff >> endOffset + 1);

        if (x1 / 8 == x2 / 8) { // if starting and ending both lie in the same byte
            screen[width / 8 * y + (x1 / 8)] |= (startByteMask & endByteMask);
        } else {
            screen[width / 8 * y + (startFullByte - 1)] |= startByteMask; // only specific bits set in the starting number 
            screen[width / 8 * y + (endFullByte + 1)] |= endByteMask; // only specific bits set in the ending number
        }
    }

    public static void main(String[] args) {
        /*
            Consider the below screen with width 32 as an example:
            
            byte[] screen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
            
            This screen has a width of 32 so you can assume the screen would be looking like:
            
                9 10 11 12
                5  6  7  8
                1  2  3  4
                
            x-axis is 5-20 (5th position to 20th position)
            y-axis is 1
            
            which means our line would lie in numbers 5, 6, and 7
            
            so if you visualize these numbers in bits, it would be like:
            
            00000101 00000110 00000111
                 ^                ^ 
            and after drawing the line, the bits would become:
            
            00000111 11111111 11111111
            
            and in the output we would see:
            
            7, -1, -1 instead of 5, 6, 7
         */
        byte[] screen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("Input: " + Arrays.toString(screen));
        drawLine(screen, 32, 5, 20, 1);
        System.out.println("Output: " + Arrays.toString(screen));
        System.out.println("---");
        screen = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("Input: " + Arrays.toString(screen));
        drawLine(screen, 32, 0, 5, 1);
        System.out.println("Output: " + Arrays.toString(screen));
        System.out.println("---");
        screen = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("Input: " + Arrays.toString(screen));
        drawLine(screen, 32, 3, 7, 1);
        System.out.println("Output: " + Arrays.toString(screen));
        System.out.println("---");
        screen = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("Input: " + Arrays.toString(screen));
        drawLine(screen, 16, 0, 7, 0);
        System.out.println("Output: " + Arrays.toString(screen));
    }
}