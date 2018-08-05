package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(".\\resources\\Front_End_Scene.fxml"));
        
        stage.setTitle("File_categorization");
        stage.setScene(new Scene(root, 600, 400));
     //   stage.setMaxHeight(430);
      //  stage.setMaxWidth(620);
     //   stage.setMinHeight(430);
     //   stage.setMinWidth(620);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
