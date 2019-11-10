import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.

    static long substrCount(int length, String s) {
        long counter = 0;

        for (int i = 0; i < length; i++) {
            // When the current symbol is in the middle of palindrome, e.g. aba
            int offset = 1;
            while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1)
                    && s.charAt(i + offset) == s.charAt(i - 1)) {
                counter++;
                offset++;
            }
            // For repeatable characters substring, e.g aa
            int repeats = 0;
            while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                repeats++;
                i++;
            }
            // e.g aaa - a, a, a, aa, aa, aaa : 3 + 2 + 1 = 3*(3+1)/2
            counter += repeats * (repeats + 1) / 2;
        }
        return counter + length;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}