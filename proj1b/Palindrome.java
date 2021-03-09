/**
 * @author: Peter
 * @date: 08/03/2021
 * @description: A class for palindrome operations.
 */
public class Palindrome {

    /**Given a string, this function will give a deque with the same order as the string.*/
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>(); //new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }


    /**Helper function to achieve the function of judging the palindrome using recursive method.*/
    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() <= 1) {
            return true;
        }
        char first = deque.removeFirst();
        char last = deque.removeLast();
        if (first == last) {
            return isPalindromeHelper(deque);
        }
        return false;
    }


    /**Check whether a string should be a palindrome or not. If it is a palindrome, it returns ture, otherwise,
     * returns false.
     */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }


    /**Helper function for overloading isPalindrome.*/
    public boolean isPalindromeHelper(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() <= 1) {
            return true;
        }
        char first = deque.removeFirst();
        char last = deque.removeLast();
        if (cc.equalChars(first, last)) {
            return isPalindromeHelper(deque, cc);
        }
        return false;
    }


    /**Overload isPalindrome function. It returns true if the difference between characters of the corresponding
     * position is one, otherwise, returns false.
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque, cc);
    }

}
