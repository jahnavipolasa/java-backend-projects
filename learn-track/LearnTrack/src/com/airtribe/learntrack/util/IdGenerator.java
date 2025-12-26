package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int id=0;

    public static int generateId(){
        id=id+1;
       return id;
    }
}
