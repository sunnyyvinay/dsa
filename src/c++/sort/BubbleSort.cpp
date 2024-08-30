#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr);

/*
 * BUBBLE SORT ALGORITHM
 * 
 * Repeatedly swaps the adjacent elements if they are in wrong order.
 * It stops when it goes through one pass without any swaps.
 *
 * O(N^2), comparison/stable, inplace
 * 
 */

void sort(vector<int>& arr) {
    bool swap = true;
    while (swap) {
        swap = false;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
                swap = true;
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