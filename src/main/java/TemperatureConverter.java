public class TemperatureConverter {

    public static void main(String[] args) {
        System.out.println(TemperatureConverter.fartocel(32));
        System.out.println(TemperatureConverter.kelvintoCel(273.15));
    }
    public static double kelvintoCel(double kel) {
        return kel - 273.15;
    }

    public static double fartocel(double far) {
        return (far - 32) * 5 / 9;
    }
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }
}
