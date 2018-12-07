package application;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.json.*;

public class TableViewController implements Initializable {

	@FXML
	private TableView<Item> GrilleItem;

	@FXML
	private TableColumn<Item, String> ColumnName;

	@FXML
	private TableColumn<Item, String> ColumnSellIn;

	@FXML
	private TableColumn<Item, String> ColumnQuality;

	@FXML
	private Button UpdateButton;

	@FXML
	private Label zoneTxt;



	Item i1 = new Item("+5 Dexterity Vest", 10, 20);
	Item i2=new Item("Aged Brie", 2, 0);
	Item i3=new Item("Elixir of the Mongoose", 5, 7);
	Item i4=new Item("Sulfuras, Hand of Ragnaros", 0, 80);
	Item i5=new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
	Item i6=new Item("Conjured Mana Cake", 3, 6);
	final ObservableList<Item> liste1 = FXCollections.observableArrayList(i1,i2,i3,i4,i5,i6);


	@Override
	public void initialize (URL arg0, ResourceBundle arg1)
	{ 

		ColumnName.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
		ColumnSellIn.setCellValueFactory(new PropertyValueFactory<Item, String>("sellIn"));
		ColumnQuality.setCellValueFactory(new PropertyValueFactory<Item, String>("quality"));

		GrilleItem.setItems(liste1);
	}

	public void uploadJsonFile()
	{     	
		//zoneTxt.setText("La fonction marche");

		File jsonInputFile = new File("truc.json");
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Create JsonReader from Json.
			JsonReader reader = Json.createReader(is);
			// Get the JsonObject structure from JsonReader.
			JsonObject empObj = reader.readObject();
			Inventory recup = new Inventory();


			String bip = empObj.getJsonObject("Inventory");


			
			reader.close();
			//create inventory
			ArrayList<Item> stock = new ArrayList<Item>();
			
			Item test=new Item(empObj.getString("name"),Integer.parseInt(empObj.getString("sellIn")), Integer.parseInt(empObj.getString("quality")));
			stock.add(test);
			final ObservableList<Item> liste1 = FXCollections.observableArrayList(test);

			/*
	            // read string data
	            System.out.println("Emp Name: " + empObj.getString("emp_name"));
	            // read integer data
	            System.out.println("Emp Id: " + empObj.getInt("emp_id"));
	            // read inner json element
	            JsonObject addrObj = empObj.getJsonObject("address");
	            System.out.println("City: " + addrObj.getString("city"));
			 */

			GrilleItem.setItems(liste1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

