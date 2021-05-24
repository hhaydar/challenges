import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Codility Golden Award
https://app.codility.com/cert/view/certNNCZQW-YVUMS9NCWEVRDZN3/
 */

public class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Test Case #1")
    public void testCase1_Solution() {
        int[] A = {2, 3, 3, 4};
        int L=3;
        int R=1;
        assertEquals(3, solution.solution(A,L,R),
                "Function should return 3");
    }

    @Test
    @DisplayName("Test Case #2")
    public void testCase2_Solution() {
        int[] A = {1, 4, 5, 5};
        int L=6;
        int R=4;
        assertEquals(4, solution.solution(A,L,R),
                "Function should return 4");
    }

    @Test
    @DisplayName("Test Case #3")
    public void testCase3_Solution() {
        int[] A = {5, 2, 5, 2};
        int L=8;
        int R=1;
        assertEquals(4, solution.solution(A,L,R),
                "Function should return 4");
    }

    @Test
    @DisplayName("Test Case #4")
    public void testCase4_Solution() {
        int[] A = {1, 5, 5};
        int L=2;
        int R=4;
        assertEquals(2, solution.solution(A,L,R),
                "Function should return 2");
    }

}
