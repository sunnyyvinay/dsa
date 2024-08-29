#include <iostream>
#include <vector>
using namespace std;

int search(vector<int>& arr, int target);

/*
 * BINARY SEARCH ALGORITHM
 *
 * Fast O(logN) search algorithm for sorted arrays.
 * Works by repeatedly dividing the array in half based on the target value.
 *
 */

int search(vector<int>& arr, int target) {
    int l = 0;
    int r = arr.size()-1;
    while (l <= r) {
        int mid = (l+r) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            r = mid - 1;
        } else if (arr[mid] < target) {
            l = mid + 1;
        }
    }

    return -1;
}

int main() {
    vector<int> arr = {-1,0,3,5,9,12};
    cout << search(arr, 3) << endl; // 2
    cout << search(arr, 4) << endl; // -1

    return 0;
}