public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if (x < 'a' || x > 'z' || y < 'a' || y > 'z') {
            return false;
        }
        return Math.abs(x - y) == N;
    }
}
