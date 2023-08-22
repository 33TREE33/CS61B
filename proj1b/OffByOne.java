public class OffByOne implements CharacterComparator {
    public boolean equalChars(char x, char y) {
        if (x < 'a' || x > 'z' || y < 'a' || y > 'z') {
            return false;
        }
        return Math.abs(x - y) == 1;
    }
}
