#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr, int begin, int end);

/*
 * MERGE SORT ALGORITHM
 *
 * The array is recursively split in half until all subarrays have 1 or 0 elements.
 * Then each of these subarrays is merged using the merging algorithm.
 *
 * O(NlogN), stable, comparison, NOT inplace, recursion, merging, divide and conquer
 * 
 */

void sort(vector<int>& arr, int begin, int end) {
    if (end <= begin) return;

    int mid = (begin + end) / 2;
    sort(arr, begin, mid);
    sort(arr, mid+1, end);

    // MERGE INTO 1 ARRAY
    vector<int> temp = {};
    int i1 = begin;
    int i2 = mid+1;
    while (i1 <= mid && i2 <= end) {
        if (arr[i1] <= arr[i2]) {
            temp.push_back(arr[i1]);
            i1++;
        } else {
            temp.push_back(arr[i2]);
            i2++;
        }
    }
    while (i1 <= mid) {
        temp.push_back(arr[i1]);
        i1++;
    }
    while (i2 <= end) {
        temp.push_back(arr[i2]);
        i2++;
    }

    int i = 0;
    for (int z = begin; z <= end; z++) {
        arr[z] = temp[i];
        i++;
    }
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