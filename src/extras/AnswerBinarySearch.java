package extras;

/*
 * Demo of Binary Search on the Answer
 *
 * When we binary search on the answer, we start with a search space, where we know the answer lies in.
 * Then, each iteration of the binary search cuts the search space in half, so the algorithm tests O(logN) values,
 * which is efficient and much better than testing each possible value in the search space.
 *
 * Just like with how we can only do binary search on a sorted array, we can only do binary search on with an answer
 * function that is monotonic:
 * The search space would have to satisfy something like (true true true true true false false false false)
 *
 * If we want the maximum possible value of x (a value in the search space), then
     • If check(x) is true, then check(y) is true for all y ≤ x.
     • If check(x) is false, then check(y) is false for all y ≥ x.

 * If instead we’re looking for the minimum x that satisfies some condition, then
     • If check(x) is true, then check(y) is true for all y ≥ x.
     • If check(x) is false, then check(y) is false for all y ≤ x.
 */

public class AnswerBinarySearch {
    public static void main(String[] args) {
        // Keep input values and call search() function to find value in the search space that works
    }

    static long search() {
        long left = 0;
        long right = (long) 2E9;
        long ans = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                // right = mid;
                left = mid + 1;
                ans = mid;
            } else {
                // left = mid + 1;
                right = mid - 1;
            }
        }

        return ans;
        // return left;
    }

    // This answer function must be MONOTONIC
    static boolean check(long x) {
        // Check function returns true if the answer of x is possible, and false otherwise
        return true;
    }
}

/*
    // Binary search based on interval jumping.
    // We start from the beginning of the array, make jumps, and reduce the jump length as we get closer to the target element.
    static long search() {
        long pos = 0;
        long max = (long) 2E9;
        for(long a = max; a >= 1; a /= 2) {
            while(check(pos+a)) pos += a;
        }
        return pos;
    }
*/

/*
    static int binSearch(int low,int high) {
        if (low == high) return low;
        if (low + 1 == high) {
            if(check(low)) return low;
            return high;
        }
        int mid = (low+high)/2;
        if(check(mid)) return binSearch(low,mid);
        else return binSearch(mid+1,high);
    }
 */