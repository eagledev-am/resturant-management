package ResturantApplication;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchMeal {
	private static boolean searchFindDrink(Meal Meal, String text) {
		return String.valueOf(Meal.getNumM()).contains(text)
				|| Meal.getNameM().toLowerCase().contains(text.toLowerCase())
				|| String.valueOf(Meal.getCostM()).contains(text)
				|| Meal.getTypeM().toLowerCase().contains(text.toLowerCase());
	}

	public static ObservableList<Meal> getDrinkList(List<Meal> list, String text) {
		ObservableList<Meal> dList = FXCollections.observableArrayList();
		for (Meal Meal : list) {
			if (searchFindDrink(Meal, text))
				dList.add(Meal);
		}
		return dList;
	}

}
