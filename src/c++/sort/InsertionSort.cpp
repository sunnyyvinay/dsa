#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr);

/*
 * INSERTION SORT ALGORITHM
 *
 * Take the first 2 elements and swap them if they are not in order.
 * Then, take the first 3 elements and keep swapping the last element over until it's in order.
 * Repeat for all n elements
 *
 * O(N^2), comparison/stable
 *
 */

void sort(vector<int>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        }
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