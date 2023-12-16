package com.java.iamgroot;

import java.util.Objects;

public class Assert {
    // Reference from https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static boolean equals(Object actual,Object expected,String message) {
        if(Objects.equals(expected, actual)){
            System.out.println(ANSI_GREEN+" "+message+":: Success"+ANSI_RESET);
            return true;
        }
        System.out.println(ANSI_RED+" "+message+":: Expected : "+expected+" Got : "+actual+" instead ! Failed"+ANSI_RESET);
        return false;
    }
}
