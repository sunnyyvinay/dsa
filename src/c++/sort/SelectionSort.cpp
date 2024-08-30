#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr);

/*
 * SELECTION SORT ALGORITHM
 *
 * Takes the minimum element from the decreasing subarray and swaps it with the element at the current front position.
 *
 * O(N^2), non-comparison/unstable, inplace
 *
 */

void sort(vector<int>& arr) {
    for (int i = 0; i < arr.size(); i++) {
        int minIndex = i;
        for (int j = i; j < arr.size(); j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }

        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}

int main() {
    vector<int> arr = {6, 3, -1, 0, 4, 2, 1, 3, 5}; // -1 0 1 2 3 3 4 5 6
    sort(arr);
    for (int i : arr) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}