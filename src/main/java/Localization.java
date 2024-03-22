import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    public static void main(String[] args) {

        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());
        System.out.println(locale.getISO3Country());
        System.out.println(locale.getISO3Language());
        System.out.println(locale.getLanguage());

        Date currentDate = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(locale.getLanguage().equals("en")) {
            ResourceBundle r = ResourceBundle.getBundle("messages", locale);
            System.out.println(r.getString("greetings"));
            System.out.println(df.format(currentDate));
            System.out.println(df2.format(currentDate));
        }
    }
}
