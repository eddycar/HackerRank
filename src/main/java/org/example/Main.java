package org.example;


public class Main {
    public static void main(String[] args) {
        //Compresion de strings
        String S = "a12b345c6789b5";
        String result = CharactersCompression.betterCompression(S);
        System.out.println(result);

        //conversion a hora militar
        System.out.println( ConvertionToMilitarTime.timeConversion("01:30:00PM"));

    }

}