import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    //Uncomment this class once you've created your Palindrome class.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(2);

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("abc"));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("ab", offByOne));
        assertTrue(palindrome.isPalindrome("aaabbb", offByOne));
        assertFalse(palindrome.isPalindrome("abc", offByOne));
        assertFalse(palindrome.isPalindrome("aaaa", offByOne));
        assertTrue(palindrome.isPalindrome("aacc", offByN));
        assertTrue(palindrome.isPalindrome("aaaccc", offByN));
        assertTrue(palindrome.isPalindrome("aaacc", offByN));
        assertFalse(palindrome.isPalindrome("aacs", offByN));
    }
}
