package ResturantApplication;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Scene scene;
	public static Stage primaryStage;
	@Override
	public void start(Stage stage) {
		try {
			// Login view 
			// username = 'admin'
			// passwprd = '123456'
			Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
		    primaryStage = stage;
		    scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("لوحه تسجيل دخول"); 
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
