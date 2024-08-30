#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr, int k);

/*
 * COUNTING SORT ALGORITHM
 * 
 * All values are within the range of 1 to K and another array is used to count the frequencies of each value.
 * That frequency array is used to build up the new sorted array.
 *
 * O(N + K), stable, not in-place, non-comparison
 * 
 */

void sort(vector<int>& arr, int k) {
    vector<int> counts(k);
    for (int i = 0; i < arr.size(); i++) {
        counts[arr[i]-1]++;
    }

    int j = 0;
    for (int i = 0; i < arr.size(); i++) {
        if (counts[j] == 0) {
            j++;
            i--;
            continue;
        }
        arr[i] = j+1;
        counts[j]--;
    }
}

int main() {
    vector<int> arr = {3, 2, 5, 4, 4, 1, 3, 2, 5, 2, 4, 2}; // 1 2 2 2 2 3 3 4 4 4 5 5
    int k = 5;
    sort(arr, k);
    for (int i : arr) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}