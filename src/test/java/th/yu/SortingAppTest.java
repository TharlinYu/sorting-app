package th.yu;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SortingAppTest extends TestCase {

    private final String input;
    private final String expectedOutput;

    public SortingAppTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void testSortingApp() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SortingApp app = new SortingApp();
        app.sortingApp();

        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"3\n9\n5\n7\n2\n8\n1\n6\n4\n0\n", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"},
                {"", "[]"},
                {"1", "[1]"},
                {"3\n9\n5\n7\n2\n8\n1\n6\n4\n0\n9\n131313\n", "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"},
        });
    }

}