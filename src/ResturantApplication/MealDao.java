package ResturantApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MealDao {
	public static int count() {

		int number = 0;
		try {
			Connection connection = Db.connect();
			PreparedStatement statement = connection.prepareStatement("select count(*) from meals");

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				number = set.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return number;
	}

	public static void insert(Meal meal) throws SQLException {
		Connection connection = Db.connect();
		PreparedStatement statement = connection.prepareStatement("insert into meals values ( ? , ? , ? , ?)");
		statement.setInt(1, meal.getNumM());
		statement.setString(2, meal.getNameM());
		statement.setString(3, meal.getTypeM());
		statement.setFloat(4, meal.getCostM());
		statement.execute();
	}

	public static boolean update(Meal meal) throws SQLException {
		Connection connection = Db.connect();
		boolean check = false;
		try {
			PreparedStatement statement = connection
					.prepareStatement("update meals set nameM = ?, typeM = ? , priceM = ? where numM = ?");
			statement.setString(1, meal.getNameM());
			statement.setString(2, meal.getTypeM());
			statement.setFloat(3, meal.getCostM());
			statement.setInt(4, meal.getNumM());
			check = statement.executeUpdate() > 0;
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
		return check;
	}

	public static Boolean delete(int num) throws SQLException {
		Connection connection = Db.connect();
		PreparedStatement statement;
		Boolean checkBoolean = false;
		try {
			statement = connection.prepareStatement("delete from meals where numM = ?");
			statement.setInt(1, num);
			checkBoolean = statement.executeUpdate() > 0;
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return checkBoolean;
	}

	public static ObservableList<Meal> getMeals() {
		ObservableList<Meal> list = FXCollections.observableArrayList();
		try {
			Connection connection = Db.connect();
			PreparedStatement statement = connection.prepareStatement("select * from meals");

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				int numM = set.getInt(1);
				String nameM = set.getString(2);
				String typeM = set.getString(3);
				float costM = set.getFloat(4);
				list.add(new Meal(numM, nameM, typeM, costM));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}
}
