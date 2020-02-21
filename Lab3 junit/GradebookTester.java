import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
     
	GradeBook g1, g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2=new GradeBook(5);
		g1.addScore(10.0);
		g1.addScore(11.0);
		g2.addScore(12.0);
		g2.addScore(13.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void test() {
		assertTrue(g1.toString().equals("10.0 11.0 "));
		assertEquals(2, g1.getScoreSize());
		assertEquals(21, g1.sum(), .0001);
		assertEquals(10, g1.minimum(), .001);
		assertEquals(11, g1.finalScore());
		
		assertTrue(g2.toString().equals("12.0 13.0 "));
		assertEquals(2, g2.getScoreSize());
		assertEquals(25, g2.sum(), .0001);
		assertEquals(12, g2.minimum(), .001);
		assertEquals(13, g2.finalScore());
	}

}
