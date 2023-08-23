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
            char front = charDeque.removeFirst();
            char behind = charDeque.removeLast();
            if (front < 'A' || front > 'z'
                    || behind < 'A' || behind > 'z') {
                return false;
            }
            if (front != behind) {
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
            char front = charDeque.removeFirst();
            char behind = charDeque.removeLast();
            if (front < 'A' || front > 'z'
                || behind < 'A' || behind > 'z') {
                return false;
            }
            if (!cc.equalChars(front, behind)) {
                return false;
            }
        }
        return true;
    }
}
