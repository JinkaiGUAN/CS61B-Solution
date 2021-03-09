/**
 * @author: Peter
 * @date: 08/03/2021
 * @description: A class containing JUnit tests for palindrome.
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == 1;
    }

}
