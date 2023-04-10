package ResturantApplication;

import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainMenuController implements Initializable {

	@FXML
	private ComboBox<String> comboDrink;

	@FXML
	private ComboBox<String> comboMeal;

	@FXML
	private TextField drinkCountField;

	@FXML
	private TextField drinkNameField;

	@FXML
	private TextField drinkNumField;

	@FXML
	private Pane drinkPane;

	@FXML
	private TextField drinkPriceField;

	@FXML
	private TextField mealCountField;

	@FXML
	private TextField mealNameField;

	@FXML
	private TextField mealNumField;

	@FXML
	private TextField mealPriceField;

	@FXML
	private Pane mealsPane;

	@FXML
	private Button outButton;

	@FXML
	private TableView<Meal> mealTable;

	@FXML
	private TableColumn<Meal, Integer> mealNumColumn;

	@FXML
	private TableColumn<Meal, String> mealNameColumn;

	@FXML
	private TableColumn<Meal, String> mealTypeColumn;

	@FXML
	private TableColumn<Meal, Float> mealPriceColumn;

	@FXML
	private TableView<Drink> drinkTable;

	@FXML
	private TableColumn<Drink, Integer> drinkNumColumn;

	@FXML
	private TableColumn<Drink, String> drinkNameColumn;

	@FXML
	private TableColumn<Drink, String> drinkTypeColumn;

	@FXML
	private TableColumn<Drink, Float> drinkPriceColumn;

	@FXML
	private TextField searchDrinkField;

	@FXML
	private TextField searchMealField;

	private static ObservableList<Drink> drinklist = FXCollections.observableArrayList(DrinkDAo.getDrinks());

	private static ObservableList<Meal> mealList = FXCollections.observableArrayList(MealDao.getMeals());

	@FXML
	void enter(MouseEvent e) {
		((Button) e.getSource()).setScaleX(1.1);
		((Button) e.getSource()).setScaleY(1.1);
		((Button) e.getSource()).setTextFill(javafx.scene.paint.Color.BLUE);
	}

	@FXML
	void exit(MouseEvent e) {
		((Button) e.getSource()).setScaleX(1);
		((Button) e.getSource()).setScaleY(1);
		((Button) e.getSource()).setTextFill(Color.BLACK);
	}

	/**
	 * this function used to insert drink
	 * 
	 * @param event
	 */

	@FXML
	void insertDrink(ActionEvent event) {
		try {
			int num = Integer.parseInt(drinkNumField.getText());
			String name = drinkNameField.getText();
			String type = comboDrink.getSelectionModel().getSelectedItem();
			float price = Float.parseFloat(drinkPriceField.getText());
			Drink drink = new Drink(num, name, type, price);
			try {
				DrinkDAo.insert(drink);
				drinkTable.getItems().add(drink);
				drinkCountField.setText(DrinkDAo.count() + "");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}
	}

	/**
	 * this function used to insert meal
	 * 
	 * @param event
	 */

	@FXML
	void insertMeal(ActionEvent event) {
		try {
			int num = Integer.parseInt(mealNumField.getText());
			String name = mealNameField.getText();
			String type = comboMeal.getSelectionModel().getSelectedItem();
			float price = Float.parseFloat(mealPriceField.getText());

			Meal meal = new Meal(num, name, type, price);

			try {
				MealDao.insert(meal);
				mealTable.getItems().add(meal);
				mealCountField.setText(MealDao.count() + "");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}

	}

	/**
	 * this function used to update drink data
	 * 
	 * @param event
	 */
	@FXML
	void updateDrink(ActionEvent event) {
		try {
			int num = Integer.parseInt(drinkNumField.getText());
			String name = drinkNameField.getText();
			String type = comboDrink.getSelectionModel().getSelectedItem();
			float price = Float.parseFloat(drinkPriceField.getText());
			Drink drink = new Drink(num, name, type, price);
			try {
				DrinkDAo.update(drink);
				drinkTable.setItems(DrinkDAo.getDrinks());
			} catch (SQLException e) {
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}
	}

	/**
	 * this function used to update meal data
	 * 
	 * @param event
	 */
	@FXML
	void updateMeal(ActionEvent event) {
		try {
			int num = Integer.parseInt(mealNumField.getText());
			String name = mealNameField.getText();
			String type = comboMeal.getSelectionModel().getSelectedItem();
			float price = Float.parseFloat(mealPriceField.getText());
			Meal meal = new Meal(num, name, type, price);
			try {
				MealDao.update(meal);
				mealTable.setItems(MealDao.getMeals());
			} catch (SQLException e) {
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}

	}

	/**
	 * this function used to delete data of a drink
	 * 
	 * @param event
	 */
	@FXML
	void deleteDrink(ActionEvent event) {
		try {
			Drink drink = drinkTable.getSelectionModel().getSelectedItem();
			try {
				DrinkDAo.delete(drink.getNumD());
				drinkTable.getItems().remove(drink);
				drinkCountField.setText(DrinkDAo.count() + "");
			} catch (SQLException e) {
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}
	}

	/**
	 * this function used to delete data of meal
	 * 
	 * @param event
	 */
	@FXML
	void deleteMeal(ActionEvent event) {
		try {
			Meal meal = mealTable.getSelectionModel().getSelectedItem();
			try {
				MealDao.delete(meal.getNumM());
				mealTable.getItems().remove(meal);
				mealCountField.setText(MealDao.count() + "");
			} catch (SQLException e) {
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "قم بادخال قيم صحيحه");
		}
	}

	/**
	 * this function used to clear text fields
	 * 
	 * @param event
	 */
	@FXML
	void clearFieldsDrinks(ActionEvent event) {
		drinkNumField.clear();
		drinkNameField.clear();
		drinkPriceField.clear();
		comboDrink.setValue("");
	}

	/**
	 * this function used to clear text fields
	 * 
	 * @param event
	 */
	@FXML
	void clearFieldsMeals(ActionEvent event) {
		mealNameField.clear();
		mealNumField.clear();
		mealPriceField.clear();
		comboDrink.setValue("");
	}

	/**
	 * this function used to get the data of selected row to the text fields
	 * 
	 * @param event
	 */
	@FXML
	void getRowDataDriink(MouseEvent event) {
		try {
			Drink drink = drinkTable.getSelectionModel().getSelectedItem();
			drinkNumField.setText(drink.getNumD() + "");
			drinkNameField.setText(drink.getNameD());
			drinkPriceField.setText(drink.getCostD() + "");
			comboDrink.setValue(drink.getTypeD());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * this function used to get the data of selected row to the text fields
	 * 
	 * @param event
	 */
	@FXML
	void getRowDataMeal(MouseEvent event) {
		try {
			Meal meal = mealTable.getSelectionModel().getSelectedItem();
			mealNameField.setText(meal.getNameM());
			mealNumField.setText(meal.getNumM() + "");
			mealPriceField.setText(meal.getCostM() + "");
			comboMeal.setValue(meal.getTypeM());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@FXML
	void searchDrinks(KeyEvent event) {
		searchDrinkField.textProperty().addListener((Observable, oldValue, newValue) -> {
			drinkTable.setItems(SearchDrink.getDrinkList(drinklist, newValue));
		});
	}

	
	@FXML
	void searchMeal(KeyEvent event) {
		searchMealField.textProperty().addListener((Observable, oldValue, newValue) -> {
			mealTable.setItems(SearchMeal.getDrinkList(mealList, newValue));
		});
	}

	/**
	 * this function used to log out
	 * 
	 * @param event
	 */

	@FXML
	void goOut(ActionEvent event) {
		Platform.exit();
	}

	/**
	 * 
	 * @param event this function used to show drink pane
	 */
	@FXML
	void showDrinks(ActionEvent event) {
		drinkPane.setVisible(true);
		mealsPane.setVisible(false);

	}

	/**
	 * 
	 * @param event this function used to show meal pane
	 */
	@FXML
	void showMeals(ActionEvent event) {
		drinkPane.setVisible(false);
		mealsPane.setVisible(true);
	}

	/**
	 * used to load data from DB
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int nMeal = MealDao.count();
		int nDrink = DrinkDAo.count();
		drinkCountField.setText(String.valueOf(nDrink));
		mealCountField.setText(String.valueOf(nMeal));

//	     meal table
		mealNumColumn.setCellValueFactory(new PropertyValueFactory<Meal, Integer>("numM"));
		mealNameColumn.setCellValueFactory(new PropertyValueFactory<Meal, String>("nameM"));
		mealTypeColumn.setCellValueFactory(new PropertyValueFactory<Meal, String>("typeM"));
		mealPriceColumn.setCellValueFactory(new PropertyValueFactory<Meal, Float>("costM"));
		mealTable.setItems(mealList);

//      drink table 
		drinkNumColumn.setCellValueFactory(new PropertyValueFactory<Drink, Integer>("numD"));
		drinkNameColumn.setCellValueFactory(new PropertyValueFactory<Drink, String>("nameD"));
		drinkTypeColumn.setCellValueFactory(new PropertyValueFactory<Drink, String>("typeD"));
		drinkPriceColumn.setCellValueFactory(new PropertyValueFactory<Drink, Float>("costD"));
		drinkTable.setItems(drinklist);

		ObservableList<String> list = FXCollections.observableArrayList("اسماك", "مشاوي", "لحوم", "وجبات سريعه");
		ObservableList<String> list2 = FXCollections.observableArrayList("بارد", "ساخن");
		comboDrink.setItems(list2);
		comboMeal.setItems(list);
	}

}
