import org.example.CU;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CUTest {

    private CU cu;

    @BeforeEach
    public void setUp() {
        cu = new CU("Matemática", 3);
    }
    @ParameterizedTest
    @CsvSource({"1, 8.0", "2, 9.0", "3, 10.0"})
    public void testInsertMarkCU(int numStudent, double mark) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(mark, cu.searchStudent(numStudent));
    }


    @Test
    public void testAverageCU() {
        cu.insertMarkCU(1, 10.0);
        cu.insertMarkCU(2, 11.5);
        cu.insertMarkCU(3, 9.0);

        double expectedAverage = (10.0 + 11.5 + 9.0) / 3;

        assertEquals(expectedAverage, cu.averageCU(), 0.01);
    }


    @ParameterizedTest
    @CsvSource({"1, 8.0, false","2, 9.0, false", "3, 10.0, true"})
    public void testIsApproved(int numStudent, double mark, boolean expected) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(expected, cu.isApproved(numStudent));
    }



}
