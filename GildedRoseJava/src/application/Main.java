package application;
import application.TableViewController;
import application.Inventory;
import application.Item;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;




public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("interface graphique vanilla sceneBuilder.fxml"));
	        primaryStage.setTitle("Hello World");
	        primaryStage.setScene(new Scene(root, 700, 600));
	        primaryStage.show();
	                
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
