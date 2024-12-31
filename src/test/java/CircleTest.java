import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @ParameterizedTest
    @CsvFileSource(resources="/radii.csv", numLinesToSkip = 1)

    public void testCircleArea(int radius, double expected_area){
        Circle circle = new Circle(radius);
        assertEquals(expected_area, circle.circleArea(radius));
    }

    @Test
    public void testCircleArea(){
        Circle circle = new Circle(5);
        assertEquals(78.54, circle.circleArea(5));
    }

}