package ru.geekbrains.bridge;

import ru.geekbrains.RequestParser;
import ru.geekbrains.memento.MementoWWW;

import java.util.Iterator;

public class WhatTheBridge implements RequestParser {

    private String WWW;

    private MementoWWW mementoWWW;


    public WhatTheBridge() {
    }

    public String requestWWW (){
        for(Integer i : iterable){
            if (i < 5){
              WWW = MementoWWW.getIndex();
                return WWW;
            } else if (i < 7){
               WWW = MementoWWW.getIndex1();
                return WWW;
            } else {
               WWW = MementoWWW.getIndex2();
                return WWW;
            }
        }
        return WWW;

    }

    Iterable<Integer> iterable = new Iterable<Integer>() {
        @Override
        public Iterator<Integer> iterator() {

            return new Iterator<Integer>() {
                private String WWW;
                private int count = 0;
                @Override
                public boolean hasNext() {
                    return count < 10;
                }

                @Override
                public Integer next() {
                    Thread currentThread = Thread.currentThread();
                    String [] pars = currentThread.getName().split("-");
                    int i = Integer.parseInt(pars[1]);

                    return i;
                }
            };
        }
    };
}
