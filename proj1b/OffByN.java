public class OffByN implements CharacterComparator {
    private final int N;

    public OffByN(int Num) {
        this.N = Num;
    }

    private static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 'a' - 'A');
        }
        return ch;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(toLowerCase(x) - toLowerCase(y)) == N;
    }
}
