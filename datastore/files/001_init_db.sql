drop database latam;
create database latam;
use latam;

CREATE USER 'sgalvez'@'localhost' IDENTIFIED BY 't4st';
GRANT ALL PRIVILEGES ON *.* TO 'sgalvez'@'localhost' WITH GRANT OPTION;
CREATE USER 'sgalvez'@'%' IDENTIFIED BY 't4st';
GRANT ALL PRIVILEGES ON *.* TO 'sgalvez'@'%' WITH GRANT OPTION;
