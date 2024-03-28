import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class GUI extends Application {
    private Button btn1, btn2, btn3;
    private Label text;
    Locale locale = new Locale("en", "UK");

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        Scene scene = new Scene(root, 300, 250);
        text = new Label("Name");
        btn1 = new Button("Button 1");
        btn2 = new Button("Button 2");
        btn3 = new Button("Button 3");

        btn1.setOnAction(e -> {
            locale = new Locale("en", "UK");
            updateTexts();
        });

        btn2.setOnAction(e -> {
            locale = new Locale("fa", "IR");
            updateTexts();
        });

        btn3.setOnAction(e -> {
            locale = new Locale("ja", "JP");
            updateTexts();
        });

        updateTexts();

        root.getChildren().addAll(btn1, btn2, btn3, text);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTexts() {
        ResourceBundle r = ResourceBundle.getBundle("messages", locale);

        btn1.setText(r.getString("button1"));
        btn2.setText(r.getString("button2"));
        btn3.setText(r.getString("button3"));
        text.setText(r.getString("name"));
    }
}
