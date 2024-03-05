import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void kelvintoCel() {
        assertEquals(0, TemperatureConverter.kelvintoCel(273.15), .1, "273.15 K = 0 C");
        assertEquals(26.8,TemperatureConverter.kelvintoCel(300), .1, "300 K = 26.85 C");
    }

    @Test
    void fartocel() {
        assertEquals(0, TemperatureConverter.fartocel(32), "32 F = 0 C");
        assertEquals(0, TemperatureConverter.fartocel(32), "32 F = 0 C");
    }

    @Test
    void kelvinToFahrenheit() {
        assertEquals(32, TemperatureConverter.kelvinToFahrenheit(273.15), "273.15 K = 32 F");
        assertEquals(80.3, TemperatureConverter.kelvinToFahrenheit(300), .1, "300 K = 80.6 F");
    }
}