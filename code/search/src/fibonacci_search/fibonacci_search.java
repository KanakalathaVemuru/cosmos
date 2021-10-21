// search | fibonacci search | c
// Part of Cosmos by OpenGenus Foundation

public class FibonacciSearch {
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int fibMinus1 = 1;
        int fibMinus2 = 0;
        int fibNumber = fibMinus1 + fibMinus2;
        int n = array.length;

        while (fibNumber < n) {
            fibMinus2 = fibMinus1;
            fibMinus1 = fibNumber;
            fibNumber = fibMinus2 + fibMinus1;
        }

        int offset = -1;

        while (fibNumber > 1) {
            int i = Math.min(offset + fibMinus2, n - 1);

            if (array[i].compareTo(key) < 0) {
                fibNumber = fibMinus1;
                fibMinus1 = fibMinus2;
                fibMinus2 = fibNumber - fibMinus1;
                offset = i;
            }
            else if (array[i].compareTo(key) > 0) {
                fibNumber = fibMinus2;
                fibMinus1 = fibMinus1 - fibMinus2;
                fibMinus2 = fibNumber - fibMinus1;
            }
            else {
                return i;
            } 
        }

        if (fibMinus1 == 1 && array[offset + 1] == key) {
            return offset + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512};

        int size = integers.length;
        Integer shouldBeFound = 128;
        FibonacciSearch fsearch = new FibonacciSearch();
        int atIndex = fsearch.find(integers, shouldBeFound);

        System.out.println(
                "Should be found: " + shouldBeFound + ". Found "+ integers[atIndex] + " at index "+ atIndex +". An array length " + size);
    }

}