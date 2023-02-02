package model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("New coordinate in up direction")
    void up() {
        Coordinate c1 = new Coordinate('c',2);
        Coordinate c2 = new Coordinate('c',3).up();
        assertAll(
        () -> assertEquals(c1,c2),
        () -> assertEquals(new Coordinate('a',2),new Coordinate('a',3).up()),
        () -> assertEquals(new Coordinate('a',2),new Coordinate('a',3).up()),
        () -> assertEquals(new Coordinate('f',6),new Coordinate('F',7).up())
                );

    }

    @Test
    void down() {
    }

    @Test
    void left() {
    }

    @Test
    void right() {
    }

    @Test
    void diagonalUpLeft() {
    }

    @Test
    void diagonalUpRight() {
    }

    @Test
    void diagonalDownLeft() {
    }

    @Test
    void diagonalDownRight() {
    }
}