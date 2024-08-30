#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr, int begin, int end);

/*
 * QUICK SORT ALGORITHM
 * 
 1: One number (typically the last element) is chosen as the pivot.
 2: Numbers lower than the pivot move to the left side and numbers higher than the pivot move to the right side
 3: Recursively repeat for the left/right subarrays with the stopping condition as an array with 0 or 1 elements
 *
 * O(NlogN), non-comparison/unstable, inplace, divide and conquer, partitioning, recursion
 * 
 */

void sort(vector<int>& arr, int begin, int end) {
    if (end <= begin) return; // BASE CONDITION: subarray with 0 or 1 elements

    // PARTITIONING
    int pivot = end;
    int x = begin-1;
    int y = begin;
    while (y != pivot) {
        if (arr[y] > arr[pivot]) {
            y++;
        } else if (arr[y] <= arr[pivot]) {
            x++;
            int temp = arr[y];
            arr[y] = arr[x];
            arr[x] = temp;
            y++;
        }
    }

    // move pivot to the middle of subarray
    x++;
    int temp = arr[y];
    arr[y] = arr[x];
    arr[x] = temp;
    pivot = x;

    // RECURSION: sort the left and right subarrays
    sort(arr, begin, pivot-1);
    sort(arr, pivot+1, end);
}

int main() {
    vector<int> arr = {6, 3, -1, 0, 4, 2, 1, 3, 5}; // -1 0 1 2 3 3 4 5 6
    sort(arr, 0, 8);
    for (int i : arr) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}