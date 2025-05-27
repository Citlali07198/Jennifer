import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SphereTest {

    @Test
    void testCalculateVolume() {
        double radius = 2.0;
        Sphere sphere = new Sphere(radius);
        double expectedVolume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        assertEquals(expectedVolume, sphere.getVolume(), 0.001);
    }
}
