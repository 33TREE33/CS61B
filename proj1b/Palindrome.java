public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> charDeque = wordToDeque(word);
        for (int i = 0; i < charDeque.size() / 2; i++) {
            if (charDeque.removeFirst() != charDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> charDeque = wordToDeque(word);
        for (int i = 0; i < charDeque.size() / 2; i++) {
            if (!cc.equalChars(charDeque.removeFirst(), charDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
