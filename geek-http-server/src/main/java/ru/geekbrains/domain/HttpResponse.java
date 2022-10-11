package ru.geekbrains.domain;

import ru.geekbrains.SocketService;

public class HttpResponse {

    private SocketService socketService;
    private String statusCode;
    private static  String WWW = "C:/Java/geek-architecture-123/www/index.html";
    private String htmlCode;
    private String status;
    private String contentType;
    private String charset;

    private HttpResponse(){
    }

    public HttpResponse(SocketService socketService) {
        this.socketService = socketService;
    }

    public static   String getWWW() {
        return WWW;
    }

    public SocketService getSocketService() {
        return socketService;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getHtmlCode() {
        return htmlCode;
    }

    public String getStatus() {
        return status;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCharset() {
        return charset;
    }

    public static class BuilderResponse{
        private final HttpResponse httpResponse;

        public BuilderResponse(){
            this.httpResponse = new HttpResponse();
        }

        public BuilderResponse withHtmlCode(String htmlCode){
            this.httpResponse.htmlCode = htmlCode;
            return this;
        }

        public BuilderResponse withStatusCode(String statusCode){
            this.httpResponse.statusCode = statusCode;
            return this;
        }

        public BuilderResponse withStatus(String status){
            this.httpResponse.status = status;
            return this;
        }

        public BuilderResponse withContentType(String contentType){
            this.httpResponse.contentType = contentType;
            return this;
        }

        public BuilderResponse withCharset(String charset){
            this.httpResponse.charset = charset;
            return this;
        }

        public HttpResponse build(){
            return this.httpResponse;
        }



    }
}
