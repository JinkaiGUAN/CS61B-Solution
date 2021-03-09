/**
 * @author: Peter
 * @date: 09/03/2021
 * @description:
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertFalse(offByN.equalChars('f', 'h'));
    }

}
