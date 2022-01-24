package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz();

    @Test
    void loadFileTest() {
        Path path = Path.of("src/test/resources/result.txt");
        quiz.loadFile(path);

        assertEquals("ABACD",quiz.getRightAnswers());
        assertEquals(4,quiz.getUserAnswers().size());
    }

    @Test
    void loadFileFailedTest() {
        Path path = Path.of("src/test/resources/wrong.txt");
        Exception exception = assertThrows(IllegalStateException.class,
                () -> quiz.loadFile(path));

        assertEquals("File can not read: " + path,exception.getMessage());
    }

    @Test
    void isAswerRightTest() {
        Path path = Path.of("src/test/resources/result.txt");
        String user = "AB123";
        quiz.loadFile(path);

        assertEquals(true, quiz.isAswerRight(user,1));
        assertEquals(false, quiz.isAswerRight(user,2));
        assertEquals(false, quiz.isAswerRight(user,3));
        assertEquals(false, quiz.isAswerRight(user,4));
        assertEquals(false, quiz.isAswerRight(user,5));

    }

    @Test
    void getUserPointsTest() {
        Path path = Path.of("src/test/resources/result.txt");
        String user = "AB123";
        String user2 = "GH1234";
        quiz.loadFile(path);

        assertEquals(-5,quiz.getUserPoints(user));
        assertEquals(15,quiz.getUserPoints(user2));

    }
}