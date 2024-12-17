#include <iostream>
#include <vector>
using namespace std;

vector<int> merge_sort(vector<int> arr);

/*
 * MERGE SORT ALGORITHM
 *
 * This sort algorithm using Divide and Conquer. The array is recursively split in half until all subarrays have 1 or 0 elements.
 * Then each of these subarrays is merged using the merging algorithm.
 *
 * O(NlogN), stable, comparison, NOT inplace, recursion, merging, divide and conquer
 * 
 */

vector<int> merge_sort(vector<int> arr) {
    // BASE CASE
    if (arr.size() <= 1) return arr;

    // DIVIDE STEP
    int mid = arr.size() / 2;
    vector<int> arr1, arr2;
    for (int i = 0; i < mid; i++) arr1.push_back(arr[i]);
    for (int i = mid; i < arr.size(); i++) arr2.push_back(arr[i]);

    // RECURSE STEP
    vector<int> sorted_arr1 = merge_sort(arr1);
    vector<int> sorted_arr2 = merge_sort(arr2);

    // MERGE/RECOMBINE STEP
    vector<int> sorted_arr = {};
    int i1 = 0;
    int i2 = 0;
    while (i1 < sorted_arr1.size() && i2 < sorted_arr2.size()) {
        if (sorted_arr1[i1] <= sorted_arr2[i2]) {
            sorted_arr.push_back(sorted_arr1[i1]);
            i1++;
        } else {
            sorted_arr.push_back(sorted_arr2[i2]);
            i2++;
        }
    }
    while (i1 < sorted_arr1.size()) {
        sorted_arr.push_back(sorted_arr1[i1]);
        i1++;
    }
    while (i2 < sorted_arr2.size()) {
        sorted_arr.push_back(sorted_arr2[i2]);
        i2++;
    }

    return sorted_arr;
}

int main() {
    vector<int> arr = {6, 3, -1, 0, 4, 2, 1, 3, 5}; // -1 0 1 2 3 3 4 5 6
    vector<int> sorted = merge_sort(arr);
    for (int i : sorted) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}