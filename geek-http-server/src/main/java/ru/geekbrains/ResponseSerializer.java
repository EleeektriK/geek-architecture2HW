package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public interface ResponseSerializer {

    default String codeError(){
        HttpResponse httpResponse2 = new HttpResponse.BuilderResponse()
                .withHtmlCode("HTTP/1.1\n")
                .withStatusCode("400 ")
                .withStatus("NOT FOUND ")
                .withContentType("Content-Type: text/html; ")
                .withCharset("charset=utf-8\n" +"\n")
                .build();

        return  httpResponse2.getHtmlCode()+httpResponse2.getStatusCode()+httpResponse2.getStatus()+httpResponse2.getContentType()+httpResponse2.getCharset();

    }

    default String codeAnswer(){
        HttpResponse httpResponse1 = new HttpResponse.BuilderResponse()
                .withHtmlCode("HTTP/1.1\n")
                .withStatusCode("200 ")
                .withStatus("OK ")
                .withContentType("Content-Type: text/html; ")
                .withCharset("charset=utf-8\n" + "\n")
                .build();

        return  httpResponse1.getHtmlCode()+httpResponse1.getStatusCode()+httpResponse1.getStatus()+httpResponse1.getContentType()+httpResponse1.getCharset();

    }

    default Reader answerRequest(Path paths) throws IOException {

        return Files.newBufferedReader(paths);

    }


    default Reader dontAnswer(Path path1) throws IOException{
        return new StringReader("<h1>Ошибочка вышла</h1>");
    }
}
