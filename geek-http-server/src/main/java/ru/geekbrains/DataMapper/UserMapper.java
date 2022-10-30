package ru.geekbrains.DataMapper;

import ru.geekbrains.JDBC.SQLCommand;
import ru.geekbrains.JDBC.UserName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMapper implements SQLCommand {
    private final Connection connection;

    private static final Map<Integer, UserName> userNameMap = new HashMap<>();
    private static   int IdName;
    private static String NameName;
    private static String PostPost;


    public UserMapper(Connection connection){
        this.connection = connection;
    }


    public Optional<UserName> findPost (int id, String nameless) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                " SELECT id, name, post FROM username WHERE id = ?"
        );

        UserName userName =  userNameMap.get(id);
        if(userName != null){
            return Optional.of(userName)
                    .filter(userName1 -> userName.getName().equals(nameless));
        }
        try {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                UserName userUserName = new UserName(IdName,NameName,PostPost);
                userUserName.setId(resultSet.getInt(1));
                userUserName.setName(resultSet.getString(2));
                userUserName.setPost(resultSet.getString(3));
                userNameMap.put(id, userUserName);
                return Optional.ofNullable(userNameMap.get(id))
                        .filter(userName1 -> userUserName.getName().equals(nameless));

            }
        } catch (SQLException e){
        throw new IllegalStateException(e);
    }
        return Optional.empty();
    }
}
