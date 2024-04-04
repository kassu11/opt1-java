import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class GUI extends Application {
    private Label nameText, lastNameText, emailText;
    private Button save;
    Locale locale = new Locale("en", "UK");
    private LocalizationDao localizationDao = new LocalizationDao();

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));

        Scene scene = new Scene(root, 300, 250);
        ComboBox<LanguageInfo> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(new LanguageInfo("en", "UK", "English"), new LanguageInfo("fa", "IR", "Persian"), new LanguageInfo("ja", "JP", "Japanese"));
        comboBox.setValue(new LanguageInfo("en", "UK", "English"));
        nameText = new Label("Button 1");
        lastNameText = new Label("Button 2");
        emailText = new Label("Button 3");
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        save = new Button("Save");

        save.setOnAction(e -> {
            System.out.println("Saved");
            Localization localization = new Localization(textField.getText(), textField2.getText(), textField3.getText(), comboBox.getValue().getLanguage());
            localizationDao.persist(localization);
        });

        comboBox.setOnAction(e -> {
            LanguageInfo selected = comboBox.getValue();
            locale = new Locale(selected.getLanguage(), selected.getCountry());
            updateTexts();
        });

        updateTexts();

        root.add(comboBox, 0, 0);
        root.add(nameText, 0, 1);
        root.add(lastNameText, 0, 2);
        root.add(emailText, 0, 3);
        root.add(textField, 1, 1);
        root.add(textField2, 1, 2);
        root.add(textField3, 1, 3);
        root.add(save, 1, 4);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTexts() {
        ResourceBundle r = ResourceBundle.getBundle("messages", locale);

        nameText.setText(r.getString("firstName"));
        lastNameText.setText(r.getString("lastName"));
        emailText.setText(r.getString("email"));
        save.setText(r.getString("save"));
    }
}
