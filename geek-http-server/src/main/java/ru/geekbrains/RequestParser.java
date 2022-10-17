package ru.geekbrains;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface RequestParser {
    Thread currentThread = Thread.currentThread();

     default String pars(List<String> Parsing) {
        String [] parts = Parsing.get(0).split(" ");
        return parts[1];
    }

    default  String parsThread () {
         String www;
         Thread currentThread = Thread.currentThread();
         String [] pars = currentThread.getName().split("-");
         int i = Integer.parseInt(pars[1]);
         if(i < 5) {
             www  = "C:/Java/geek-architecture-123/www/index.html";
         } else if (i < 10){
             www = "C:/Java/geek-architecture-123/www/index1.html";
         } else {
             www = "C:/Java/geek-architecture-123/www/index2.html";
         }
         return www;
    }

}
