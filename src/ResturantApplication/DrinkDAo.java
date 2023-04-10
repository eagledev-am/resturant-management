package ResturantApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DrinkDAo {

	public static int count() {

		int number = 0;
		try {
			Connection connection = Db.connect();
			PreparedStatement statement = connection.prepareStatement("select count(*) from drinks");

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				number = set.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return number;
	}

	// insert into DB
	public static void insert(Drink drink) throws SQLException {
		Connection connection = Db.connect();
		PreparedStatement statement = connection.prepareStatement("insert into drinks values ( ? , ? , ? , ?)");
		statement.setInt(1, drink.getNumD());
		statement.setString(2, drink.getNameD());
		statement.setString(3, drink.getTypeD());
		statement.setFloat(4, drink.getCostD());
		statement.execute();
	}

	// update DB
	public static boolean update(Drink drink) throws SQLException {
		Connection connection = Db.connect();
		boolean check = false;
		try {

			PreparedStatement statement = connection
					.prepareStatement("update drinks set nameD = ? , typeD = ? , priceD = ? where numD = ?");
			statement.setString(1, drink.getNameD());
			statement.setString(2, drink.getTypeD());
			statement.setFloat(3, drink.getCostD());
			statement.setInt(4, drink.getNumD());
			check = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return check;
	}

	public static Boolean delete(int numD) throws SQLException {
		Connection connection = Db.connect();
		PreparedStatement statement = connection.prepareStatement("delete from drinks where numD = ?");
		statement.setInt(1, numD);
		Boolean checkBoolean = statement.executeUpdate() > 0;

		return checkBoolean;
	}

	// select all data of DB
	public static ObservableList<Drink> getDrinks() {
		ObservableList<Drink> list = FXCollections.observableArrayList();
		try {
			Connection connection = Db.connect();
			PreparedStatement statement = connection.prepareStatement("select * from drinks");

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				int numD = set.getInt(1);
				String nameD = set.getString(2);
				String typeD = set.getString(3);
				float costD = set.getFloat(4);
				list.add(new Drink(numD, nameD, typeD, costD));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}


}
