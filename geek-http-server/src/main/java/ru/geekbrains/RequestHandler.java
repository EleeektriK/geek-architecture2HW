package ru.geekbrains;


import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;


public class RequestHandler implements Runnable, RequestParser, ResponseSerializer {

    private static final Logger logger = new ConsoleLogger();

    private final SocketService socketService;

    public RequestHandler(SocketService socketService) {

        this.socketService = socketService;
    }

    @Override
    public void run(){
        HttpRequest httpRequest = new HttpRequest(socketService);
        HttpResponse httpResponse = new HttpResponse(socketService);



        Path path = Paths.get(parsThread(), pars(httpRequest.getHeaders()));


            if (!Files.exists(path)){
                try {
                    httpResponse.getSocketService().writeResponse(codeError(), dontAnswer(path));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                System.out.println(currentThread.getId());
                    httpResponse.getSocketService().writeResponse(codeAnswer(), answerRequest(path));
                    logger.info("Клиент прошел подключение");
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        logger.info("Client disconnected!");
    }

}
