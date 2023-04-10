package ResturantApplication;


import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class LoginController {


    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button enterButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField userName;
    
    @FXML
    private AnchorPane pane;

    @FXML
    void enterClicked(ActionEvent event) throws IOException {
       
    	if(event.getSource()==enterButton) {
    		if(userName.getText().equals("admin") && PasswordField.getText().equals("123456")) {
    		Parent rootParent = FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
    		Stage stage = new Stage();
    		Scene scene = new Scene(rootParent);
    		stage.setResizable(false);
    		stage.setScene(scene); 
			stage.setTitle("اختيارالمشروبات والوجبات");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
			Main.primaryStage.close();
	
         	}
    		else {
				JOptionPane.showMessageDialog(null,  "اسم المستخدم او كلمه المرور خاطئه");
			}
    	}
    	
    	
    }

    @FXML
    void exitCliked(ActionEvent event) {
        if(event.getSource()==exitButton)
        	Platform.exit();
    }

}
