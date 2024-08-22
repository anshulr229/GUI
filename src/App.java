import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {


    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Football Market Value Estimation");
        Label passingLabel = new Label("Passing Skill:");
        TextField passingField = new TextField();
        Label dribblingLabel = new Label("Dribbling Skill:");
        TextField dribblingField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label resultLabel = new Label();


        calculateButton.setOnAction(event -> {
            try {
                double passingSkill = Double.parseDouble(passingField.getText());
                double dribblingSkill = Double.parseDouble(dribblingField.getText());


                double marketValue = 5000 + (passingSkill * 1000) + (dribblingSkill * 1500);


                resultLabel.setText("Estimated Market Value: $" + String.format("%.2f", marketValue));
            } catch (NumberFormatException e) {
                resultLabel.setText("Please enter valid numbers for passing and dribbling skills.");
            }
        });


        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(titleLabel, passingLabel, passingField, dribblingLabel, dribblingField,
                calculateButton, resultLabel);


        Scene scene = new Scene(root, 300, 250);


        primaryStage.setTitle("Football Market Value Estimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
