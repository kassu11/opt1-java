public class LanguageInfo {
    private String country;
    private String language;
    private String name;

    public LanguageInfo(String language, String country, String name) {
        this.language = language;
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String toString() {
        return name;
    }
}
