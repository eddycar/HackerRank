package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    public static Object lonelyinteger(List<Integer> a) {

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (Integer element : a) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }

        for(Integer number: a){
            if(frequencies.get(number) == 1){
                return number;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(lonelyinteger(List.of(a)));
    }
}

/*
   public static int lonelyinteger(List<Integer> a) {
    // Write your code here
         int result = 0;
        for (int i = 0; i < a.size(); i++) {
            result ^= a.get(i);
        }
        return result;
    }
 */