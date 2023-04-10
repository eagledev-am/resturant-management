# resturant-management
Resturant management desktop application using javafx and mysql database 
## How to get 
1- Clone the project by using
```
git clone https://github.com/eagledev-am/resturant-management.git
```
2- Configure build path of the project to add [javafx sdk](https://www.oracle.com/java/technologies/install-javafx-sdk.html) and [mysqlconector](https://dev.mysql.com/downloads/connector/j/)

3- configure database configuration in [DB.java](https://github.com/eagledev-am/resturant-management/blob/main/src/ResturantApplication/Db.java) 

## DataBase 
#### meals
```
CREATE TABLE `meals` (
  `numM` int(11) DEFAULT NULL,
  `nameM` varchar(100) DEFAULT NULL,
  `typeM` varchar(100) DEFAULT NULL,
  `priceM` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

```
#### drinks
```
CREATE TABLE `drinks` (
  `numD` int(11) DEFAULT NULL,
  `nameD` varchar(100) DEFAULT NULL,
  `typeD` varchar(100) DEFAULT NULL,
  `priceD` float DEFAULT NULL
)
```
