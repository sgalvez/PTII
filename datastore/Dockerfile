from mysql/mysql-server:8.0
ENV MYSQL_DATABASE=latam \
    MYSQL_ROOT_PASSWORD=t4st

ADD files/001_init_db.sql /docker-entrypoint-initdb.d
ADD files/002_airport_table.sql /docker-entrypoint-initdb.d
ADD files/003_airport_list.sql /docker-entrypoint-initdb.d

EXPOSE 3306
