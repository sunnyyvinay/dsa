package extras;

/*
 * Program for generating all subsets of an integer array
 *
 * There are 2^n possible subsets. This is the bitmask method of generating them.
 * 11001 maps to the subset {0, 3, 4}
 * 001 = 0
 * 010 = 1
 *
 * https://usaco.guide/CPH.pdf#page=57
 * https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 */

import java.util.ArrayList;

public class Subsets {
    static void printSubsets(int set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            ArrayList<Integer> list = new ArrayList<>(); // we create a new list for each subset and add the elements to it
            // Current subset
            for (int j = 0; j < n; j++) {
                // (1<<j) is a number with jth bit 1 so when we 'and' them with the subset number we get which numbers are present in the subset and which are not
                if ((i & (1 << j)) > 0) {
                    list.add(set[j]);
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println("}");

            /* CHECK IF CERTAIN SUBSET IS VALID AND INCREMENT ANSWER COUNTER IF SO
            if (valid(list)) {
                ans++;
            }
             */

        }
    }

    public static void main(String[] args) {
        int set[] = {0, 1, 2};
        printSubsets(set);
    }
}
