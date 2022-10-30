package ru.geekbrains;

import ru.geekbrains.DataMapper.UserMapper;
import ru.geekbrains.JDBC.DBConnection;
import ru.geekbrains.JDBC.UserName;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HttpServer {

    private static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = new ConsoleLogger();
    private static Integer LoginAttempt = 0;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        while (true) {
            if (LoginAttempt < 5){
                logger.info("Введите действующий ID и Имя пользователя");
                int id = scanner.nextInt();
                String name = scanner.next();
                UserMapper userMapper = new UserMapper(DBConnection.connection);
                if (userMapper.findPost(id, name).isPresent()) {
                    startServer();
                }
                LoginAttempt ++;
            } else {
                logger.info("Пошел прочь, нарушитель");
                break;
            }

        }
}
    public static void startServer (){

        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            logger.info("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                logger.info("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket))).start();
                String exit = scanner.next();
                if(exit.equals("exit")){
                    logger.info("Завершение работы сайта, пожалуйста перезапустите");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
