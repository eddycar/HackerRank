package org.example;

public class Envios {
    public static long getMinimumMoves(int[] quantity) {
        int lengthArray = quantity.length;
        int totalSum = 0;
        for (int i = 0; i < lengthArray; i++) {
            totalSum += quantity[i];
        }

        if (totalSum % 2 != 0) {
            return -1; // No es posible dividir en partes iguales
        }

        int halfSum = totalSum / 2;
        long[][] dp = new long[lengthArray + 1][halfSum + 1];

        // Inicializar la primera columna con infinito, excepto la primera fila
        for (int i = 1; i <= lengthArray; i++) {
            dp[i][0] = Long.MAX_VALUE;
        }

        // Calcular la matriz dp
        for (int i = 1; i <= lengthArray; i++) {
            for (int j = 1; j <= halfSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (quantity[i - 1] <= j && dp[i - 1][j - quantity[i - 1]] != Long.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - quantity[i - 1]] + 1);
                }
            }
        }

        if (dp[lengthArray][halfSum] == Long.MAX_VALUE) {
            return -1; // No es posible dividir en partes iguales
        } else {
            return dp[lengthArray][halfSum];
        }
    }

    public static void main(String[] args) {
        int[] quantity = {1, 4, 4};
        long result = getMinimumMoves(quantity);
        System.out.println(result);
    }
}

/*
There are n types of items in a shop's inventory, where the quantity of the ith item is denoted by quantity[i]. These items are to be shipped in two consignments, where the first consignment contains items of type [1, 2, ..., j], and de second consignment  contains the remaining item types, where j can be chosen such that 1 <= j <n. note that both consignment s must be non-empty, and all items of a type must be in the samee consigment.

the shopkeeper wants the item counts in each consignment to be equal. to achieve this, the shopkeeper can perform the following move any number of times: increase or decrease the quantity of any item type by 1. the quantity of each item type must remain positive throughout.

Find the minimun number of moves in which the total quantities of both consignmentscan be made wqual if the item types are split optimally.

example

consider n=3, quantity=[1, 4, 4].
considering 1-based indexing, increase quantity[3] by 1, so quantity = [1, 4, 5]. partition using j=2 and consignments shiped are [1, 4] and [5]. this is optimal, so return the numbers of operations, 1.

Funcion Description
complete the function getMinimunMoves in the editor below.

getMinimunMoves has the following parameter:
int quantity[n]: the quantities of eachitem type

returns

long int: the minimun moves required to make the sums equl in an optimal division

constraints
2 <= n <= 3exp5

1<= quantity[i] <= 2exp9
 */