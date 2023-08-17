package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatchingStrings {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> ListOccurrencesNumber = new ArrayList<>();

        for(int i=1; i<queries.size(); i++){
            Integer sumaDeOcurrencias = 0;
            for(int j=1; j<strings.size(); j++){
                if( strings.get(j).equals(queries.get(i)) ){
                    sumaDeOcurrencias ++;
                }
            }
            ListOccurrencesNumber.add(sumaDeOcurrencias);
        }
        return ListOccurrencesNumber;
    }

    public static void main(String[] args) {
       List<String> strings = new ArrayList<>();
       List<String> queries = new ArrayList<>();

       strings.add("4");
       strings.add("aba");
       strings.add("baba");
       strings.add("aba");
       strings.add("xzxb");

       queries.add("3");
       queries.add("aba");
       queries.add("xzxb");
       queries.add("ab");

        System.out.println(matchingStrings(strings, queries));
    }

}


/*
SOLUCION 2
 public static List<Integer> matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        List<Integer> resultsList = new ArrayList<>();

        for (String query : queries) {
            resultsList.add(frequencyMap.getOrDefault(query, 0));
        }

        return resultsList;
    }
 */
