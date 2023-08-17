package org.example;

import java.util.HashMap;
import java.util.Map;

public class CharactersCompression {
    public static String betterCompression(String S) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                int frequency = 0;

                // Get the frequency of the character
                while (i + 1 < S.length() && Character.isDigit(S.charAt(i + 1))) {
                    frequency = frequency * 10 + (S.charAt(i + 1) - '0');
                    i++;
                }

                // Update the frequency in the map
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + frequency);
            }
        }

        // Build the compressed string
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }

        return sb.toString();
    }
}

/*
Cosider a string, S, that is a series of characters, each followed by its frequecy as un integer. The string is not compresed correctly, so there may be multiple occurrences of the same character. A properly compresed string will consist of one instance of each character in that character within the string.

example
The string 'a3c9b2c1' has two instances where 'c' is followed by a count: once with 9 occurrences, and again with 1, It should be compressed to 'a3b2c10'.

function description
Complete the function betterCompession in the eitor below.

betterCompression has the following parameter:
S: a compressed string

returns :
string: the properly compressed string

Constrains:
1<= size of S <= 100000
'a' <= Characters in S <= 'z'
1<=frequency of each character in S <= 1000

input format for custom testing:
The first line contains a string, S.

Sample Case 0:
Sample input

STDIN  FUNCTION
----------  -----------------
a12b56c1 -> S = 'a12b56c1'

Sample output
a12b56c1
 */