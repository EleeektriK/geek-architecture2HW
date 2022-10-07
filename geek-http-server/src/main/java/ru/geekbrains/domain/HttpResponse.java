package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

import java.io.StringReader;

public class HttpResponse {

    private SocketService socketService;
    private String statusCode;

    private static   String WWW = "C:/Java/geek-architectur2e-123/www/index.html";

    private String file;

    // TODO
    public HttpResponse( String statusCode, String www, String file) {

        this.statusCode = statusCode;
        this.WWW = www;
        this.file = file;
    }

    public HttpResponse(SocketService socketService) {
        this.socketService = socketService;
    }

    public static   String getWWW() {
        return WWW;
    }

    public String getFile() {
        return file = ("HTTP/1.1 200 OK\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n");
    }

    public SocketService getSocketService() {
        return socketService = socketService;
    }

    public String getStatusCode() {
       return statusCode = ("HTTP/1.1 404 NOT_FOUND\n" +
                "Content-Type: text/html; charset=utf-8\n" +
                "\n");
    }


}
