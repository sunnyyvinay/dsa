package sort;

/*
 * Implementation of bucket sort algorithm
 *
 * Bucket Sort uses hashing and makes assumptions about the data. It can sort in O(n) time because of these assumptions. It distributes
 * the items into buckets based on their hashed values (scattering phase). It sorts the items in each bucket, then merges the buckets
 * (gathering phase). The values in bucket X must be greater than the values in bucket X - 1 and less than the values in bucket X + 1.
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            // using linked lists for the buckets
            //buckets[i] = new LinkedList<Integer>();

            // using arraylists as the buckets
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        for (List bucket: buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value: buckets[i]) {
                input[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        return value / 10;
    }
}
