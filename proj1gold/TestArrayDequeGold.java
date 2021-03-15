/**
 * @author: Peter
 * @date: 15/03/2021
 * @description:
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private static StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();
    private static ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();

    @Test
    public void testAddFirstLast() {
        int num = 10;
        for (int i = 0; i < num; i ++) {
            double seed = StdRandom.uniform();
            if (seed < 0.5) {
                stu1.addFirst(i);
                sol1.addFirst(i);
            } else {
                stu1.addLast(i);
                sol1.addLast(i);
            }
        }
        for (int i = 0; i < num; i ++) {
            assertEquals(sol1.get(i), stu1.get(i));

        }

        for (int i = 0; i < num; i++) {
            Integer expect = sol1.removeLast();
            Integer actual = stu1.removeLast();
            String message = "Oops! removeLast() method may get something wrong!\n" + "Expected is " + expect +
                    ", while actual is " + actual + ".\n";
            assertEquals(message, expect, actual);
        }
    }

}
