package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;


public interface ResponseSerializer {


    default Reader answerRequest(Path paths) throws IOException {

        return Files.newBufferedReader(paths);

    }

    default Reader dontAnswer(Path path1) throws IOException{
        return new StringReader("<h1>Ошибочка вышла</h1>");
    }
}
