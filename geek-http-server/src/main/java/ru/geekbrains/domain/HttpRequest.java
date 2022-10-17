package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

import java.util.List;

public class HttpRequest {

    private List<String> headers;

    private SocketService socketService;



    public HttpRequest(List<String> headers) {

        this.headers = headers;

    }

    public HttpRequest(SocketService socketService) {
        this.socketService = socketService;
    }

    public HttpRequest() {

    }


    public List<String> getHeaders() {
        return headers = socketService.readRequest();
    }
}
