/**
 * @author: Peter
 * @date: 27/03/2021
 * @description:
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFoundTest {
    private static UnionFind set1 = new UnionFind(8);

    @Test
    public void testBasics() {
        assertEquals(-1, set1.parent[1]);
        assertEquals(-1, set1.parent[4]);
        assertEquals(-1, set1.parent[7]);
    }

    @Test
    public void testParent() {
        assertEquals(-1, set1.parent[0]);
        set1.union(1, 2);
        assertEquals(-2, set1.parent[1]);
        assertEquals(1, set1.parent[2]);
        set1.union(0, 1);
        assertEquals(-3, set1.parent[1]);
        assertEquals(1, set1.parent[0]);
    }

    @Test
    public void testSizeOf() {
        assertEquals(3, set1.sizeOf(1));
    }

    @Test
    public void testConnected() {
        set1.connected(1, 2);
    }
}
