package ExamPrep;

import com.sun.source.doctree.LiteralTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem1OsPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputTasks = scanner.nextLine().split(", ");
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();

        for (String num : inputTasks) {
            tasksStack.push(Integer.parseInt(num));
        }

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        String[] inputThreads = scanner.nextLine().split(" ");

        for (String number : inputThreads) {
            threadsQueue.add(Integer.parseInt(number));
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (true) {

                if (tasksStack.peek() != taskToKill) {
                    if (tasksStack.peek() <= threadsQueue.peek()) {
                        tasksStack.pop();
                        threadsQueue.poll();
                    } else {
                        threadsQueue.poll();
                    }
                } else {
                    System.out.printf("Thread with value %d killed task %d%n", threadsQueue.peek(), tasksStack.pop());
                    for (Integer thread : threadsQueue) {
                        System.out.print(thread + " ");
                    }
                    break;
                }

        }
    }
}
