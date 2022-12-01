import org.junit.Test;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";
        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);

        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() throws Exception {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));

        cipher.encryptFile("sonnet18.txt", "sonnet18.enc");
        cipher.encryptFile("sonnet18.enc", "sonnet18-1.txt");
    }

    @Test
    public void caeserTest() {
        Caesar caesar = new Caesar();

        String Q1 = "ABCabcXYZxyz";
        System.out.println(Q1);

        String A1 = "DEFdefABCabc";
        System.out.println(A1);

        String actual = caesar.encrypt(Q1);
        String actual1 = caesar.decrypt(actual);
        System.out.println(actual);
        System.out.println(actual1);

        assertEquals(actual, A1);
        assertEquals(actual1, Q1);
    }

    @Test
    public void seventeenTest() {
        Seventeen seventeen = new Seventeen();

        String Q1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuwvxyz";
        System.out.println(Q1);

        String A1 = "RSTUVWXYZABCDEFGHIJKLMNOPQrstuvwxyzabcdefghijklnmopq";
        System.out.println(A1);

        String actual = seventeen.encrypt(Q1);
        String actual1 = seventeen.decrypt(actual);
        System.out.println(actual);
        System.out.println(actual1);

        assertTrue(actual.equals(A1));
        assertEquals(actual1, Q1);
    }
}