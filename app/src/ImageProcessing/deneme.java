package ImageProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class deneme {

    public static String getSmallestAndLargest(String s, int k) {
        String[] substrings = new String[s.length() - k + 1];

        for (int i = 0; i <= s.length() - k; i++) {
            // Add a substring of length 'k' to our array
            substrings[i] = s.substring(i, i + k);
        }

        // Sort array
        Arrays.sort(substrings);

        // Set first and last elements as smallest and largest
        String smallest = substrings[0];
        String largest = substrings[substrings.length - 1];

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
