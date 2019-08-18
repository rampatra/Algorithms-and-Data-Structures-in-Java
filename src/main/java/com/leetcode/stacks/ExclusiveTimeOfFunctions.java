package com.leetcode.stacks;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Link: https://leetcode.com/problems/exclusive-time-of-functions/
 * Description:
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
 *
 * We store logs in timestamp order that describe when a function is entered or exited.
 *
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".  For example, "0:start:3"
 * means the function with id 0 started at the beginning of timestamp 3.  "1:end:2" means the function with id 1 ended
 * at the end of timestamp 2.
 *
 * A function's exclusive time is the number of units of time spent in this function.  Note that this does not include
 * any recursive calls to child functions.
 *
 * The CPU is single threaded which means that only one function is being executed at a given time unit.
 *
 * Return the exclusive time of each function, sorted by their function id.
 *
 * Input:
 * n = 2
 * logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3, 4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
 * Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 *
 *
 * Note:
 * -> 1 <= n <= 100
 * -> Two functions won't start or end at the same time.
 * -> Functions will always log when they exit.
 *
 * @author rampatra
 * @since 2019-08-17
 */
public class ExclusiveTimeOfFunctions {

    /**
     * Runtime: <a href="https://leetcode.com/submissions/detail/252509066/">18 ms</a>.
     *
     * @param n
     * @param logs
     * @return
     */
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (String log : logs) {
            String[] l = log.split(":");
            int id = Integer.parseInt(l[0]);
            String operation = l[1];
            int timestamp = Integer.parseInt(l[2]);

            if (operation.equals("start")) {
                if (!stack.empty()) { // if there are other processes started before, calculate their time until now
                    times[stack.peek().getKey()] += (timestamp - stack.peek().getValue() - 1);
                }
                stack.push(new Pair<>(id, timestamp));
            } else {
                times[id] += timestamp - stack.pop().getValue() + 1;
                if (!stack.isEmpty()) { // if there are other processes, make their start time to now
                    stack.push(new Pair<>(stack.pop().getKey(), timestamp));
                }
            }
        }

        return times;
    }

    public static void main(String[] args) {
        assertEquals("[4]", Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0", "0:start:1", "0:end:2", "0:end:3"))));
        assertEquals("[6]", Arrays.toString(exclusiveTime(1, Arrays.asList("0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5"))));
        assertEquals("[3, 4]", Arrays.toString(exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"))));
    }
}