/**
 * @author: Peter
 * @data: 08/03/2021
 * @description: A class for off-by-N comparators.
 */
public class OffByN implements CharacterComparator{
    private int N;

    public OffByN(int n) {
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == N;
    }
}
