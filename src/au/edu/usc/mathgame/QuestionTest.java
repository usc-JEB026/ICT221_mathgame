package au.edu.usc.mathgame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;


public class QuestionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Test
    void testCreate() {
        Question q = new Question(3, 4, "+");
        assertFalse(q.checkAnswer(0));
        assertTrue(q.checkAnswer(7));
    }
    @Test
    void testSubtract() {
        Question q = new Question(1,5,"-");
        assertFalse(q.checkAnswer(0));
        assertTrue(q.checkAnswer(4));
    }
    @Test
    void testDivide() {
        Question q = new Question(3,4,"/");
        assertFalse(q.checkAnswer(0));
        assertTrue(q.checkAnswer(1.3));
    }
    @Test
    void testDisplay() {
        Question q = new Question(3, 4, "+");
        q.showQuestion();
        // \r\n is needed to emulate the println methods CRLF
        assertEquals("What is 3+4?\r\n", outContent.toString());
    }
    @Test
    void testHighScore() {
        HighScores hs = new HighScores();
        //first high score will be zero so 5 should be new high score
        assertTrue(hs.checkHighScore(5) == 5);
        //submitting high score of 3 should not yield high score of 3 because 5 from previous game is higher
        assertFalse(hs.checkHighScore(3)==3);
        //submiting high score of 8 should yield new high score of 8 because its higher than 5
        assertTrue(hs.checkHighScore(8) ==8);
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
