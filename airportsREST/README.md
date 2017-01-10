
mvn clean package docker:build

docker run -it --name airportsrest --link airportsdb:mysql -p 8080:8080 ptii/airportrest

