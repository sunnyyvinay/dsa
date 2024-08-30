#include <iostream>
#include <vector>
using namespace std;

void sort(vector<int>& arr);
void countingSort(vector<int>& arr, int place);

/*
 * RADIX SORT ALGORITHM
 *
 * Use counting sort on each decimal place.
 *
 * O(ND), stable, not in-place, non-comparison
 *
 */

void countingSort(vector<int>& arr, int place) {
    const int max = 10;
    vector<int> output(arr.size());
    vector<int> count(max);

    for (int i = 0; i < max; ++i) count[i] = 0;

    for (int i : arr) count[(i / place) % 10]++;

    // Calculate cumulative count
    for (int i = 1; i < max; i++) count[i] += count[i - 1];

    // Place the elements in sorted order
    for (int i = arr.size() - 1; i >= 0; i--) {
        output[count[(arr[i] / place) % 10] - 1] = arr[i];
        count[(arr[i] / place) % 10]--;
    }

    for (int i = 0; i < arr.size(); i++) arr[i] = output[i];
}

void sort(vector<int>& arr) {
    int max = -1000000;
    for (int i : arr) {
        if (i > max) max = i;
    }

    for (int place = 1; max / place > 0; place *= 10) countingSort(arr, place);
}

int main() {
    vector<int> arr = {4725, 4586, 1330, 8792, 1594, 5729}; // 1330 1594 4586 4725 5729 8792
    sort(arr);
    for (int i : arr) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}