package day01;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    void addStudentTest() {
        ClassNoteBook classNoteBook = new ClassNoteBook();

        Student s = new Student(1, "John");
        classNoteBook.addStudent(s);

        assertTrue(classNoteBook.getNotebook().keySet().contains(s));
        assertEquals(1, classNoteBook.getNotebook().size());

    }

    @Test
    void testAddStudentInOrder() {
        ClassNoteBook classNoteBook = new ClassNoteBook();

        Student s = new Student(1, "John");
        Student s2 = new Student(3, "John");
        Student s3 = new Student(2, "John");
        classNoteBook.addStudent(s);
        classNoteBook.addStudent(s2);
        classNoteBook.addStudent(s3);

    }

    @Test
    void addMarkTest() {
    }
}