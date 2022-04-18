package com.ann.kont.demo.shortest.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShortedPathServiceTest {
    private final ShortedPathService shortedPathService = new ShortedPathService();

    @Test
    public void testWithLeftTopStartAndSameLength() {
        char[][] matrix = {
                {'S', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(5, actual);
    }

    @Test
    public void testWithLeftTopStartAndBiggerVerticalLength() {
        char[][] matrix = {
                {'S', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1'},
                {'0', '1', '1', '0', '1', '1'},
                {'1', '0', '0', '1', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(11, actual);
    }

    @Test
    public void testWithLeftTopStartAndBiggerHorizontalLength() {
        char[][] matrix = {
                {'S', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(7, actual);
    }

    @Test
    public void testWithMiddleStartAndSameLength() {
        char[][] matrix = {
                {'0', '0', '1', '1'},
                {'1', '1', 'S', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(2, actual);
    }

    @Test
    public void testWithMiddleStartAndBiggerVerticalLength() {
        char[][] matrix = {
                {'1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1'},
                {'0', 'S', '1', '0', '1', '1'},
                {'1', '0', '0', '1', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(10, actual);
    }

    @Test
    public void testWithMiddleStartAndBiggerHorizontalLength() {
        char[][] matrix = {
                {'0', '0', '1', '1'},
                {'1', '1', 'S', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        int actual = shortedPathService.getPath(matrix);
        Assertions.assertEquals(4, actual);
    }

    @Test
    public void testNoStart() {
        char[][] matrix = {
                {'0', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };

        Assertions.assertThrows(RuntimeException.class, () -> shortedPathService.getPath(matrix));
    }
}
