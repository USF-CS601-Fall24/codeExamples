import junit.Circle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** Example of how write parameterized tests */
public class CircleTest {

    @ParameterizedTest
    @MethodSource("loadTestDataArea")
    @DisplayName("Test area: ")
    void testArea(double inputRadius, double expectedArea) {
        System.out.println("Testing area calculation");
        assertEquals(expectedArea, new Circle(inputRadius).area(), 0.0001);
    }

    @ParameterizedTest
    @MethodSource("loadTestDataPerimeter")
    @DisplayName("Test perimeter:")
    void testPerimeter(double inputRadius, double expectedPerimeter) {
        System.out.println("Testing perimeter calculation");
        assertEquals(expectedPerimeter, new Circle(inputRadius).perimeter(), 0.0001);
    }

    static Arguments[] loadTestDataArea() {
        return new Arguments[] {
                Arguments.of(1, Math.PI),
                Arguments.of(2, 4 * Math.PI)
        };
    }

    static Arguments[] loadTestDataPerimeter() {
        return new Arguments[] {
                Arguments.of(1, 2 * Math.PI),
                Arguments.of(2, 4 * Math.PI)
        };
    }

}