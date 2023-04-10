module ResturantProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.base;
	
	opens ResturantApplication to javafx.graphics, javafx.fxml , javafx.base;
	
}
