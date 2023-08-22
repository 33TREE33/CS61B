public class OffByOne implements CharacterComparator {

    private char toLowerCase(char ch) {
        if (ch > 'A' && ch < 'Z') {
            return (char) (ch + 'a' - 'A');
        }
        return ch;
    }
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
