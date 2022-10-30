package ru.geekbrains.JDBC;

import java.sql.SQLException;
import java.util.Arrays;

public interface SQLCommand {

     default void insert(String Field1, String Field2) throws SQLException {
        DBConnection.statement.executeUpdate("INSERT INTO username (name, post) VALUE (' " + Field1 + "', '" + Field2 +"')");
    }

    default void update(int i, String... Field) throws SQLException {
        DBConnection.statement.executeUpdate("UPDATE username SET  name = '" + Arrays.toString(Field) +"', post = '" + Arrays.toString(Field) +"' WHERE id = " + i);
    }

    default void delete(int i) throws SQLException {
        DBConnection.statement.executeUpdate("DELETE FROM username WHERE id = " + i);
    }

}
