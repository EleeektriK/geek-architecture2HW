package ru.geekbrains;

import java.util.List;

public interface RequestParser {

     default String pars(List<String> Parsing) {
        String [] parts = Parsing.get(0).split(" ");
        return parts[1];
    }


}
