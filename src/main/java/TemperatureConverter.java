public class TemperatureConverter {
    public static double kelvintoCel(double kel) {
        return kel - 273.15;
    }

    public static double fartocel(double far) {
        return (far - 32) * 5 / 9;
    }
}
