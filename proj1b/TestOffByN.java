import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByOne = new OffByN(2);

    // Your tests go here.
    //Uncomment this class once you've created
    // your CharacterComparator interface and OffByOne class. **/
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('b', 'd'));
        assertTrue(offByOne.equalChars('e', 'g'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', 'g'));
        assertFalse(offByOne.equalChars('a', 'm'));
    }
}
