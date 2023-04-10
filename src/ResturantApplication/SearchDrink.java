package ResturantApplication;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchDrink {
	 private static boolean searchFindDrink(Drink drink, String text) {
		return String.valueOf(drink.getNumD()).contains(text)
				|| drink.getNameD().toLowerCase().contains(text.toLowerCase())
				|| String.valueOf(drink.getCostD()).contains(text)
				|| drink.getTypeD().toLowerCase().contains(text.toLowerCase());
	}

	public static ObservableList<Drink> getDrinkList(List<Drink> list , String text){
    	ObservableList<Drink> dList = FXCollections.observableArrayList();
    	for (Drink drink : list) {
			if(searchFindDrink(drink, text)) dList.add(drink);
		}
    	return dList;
	}
    
}
