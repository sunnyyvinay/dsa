#include <iostream>
using namespace std;

const int MAX_SIZE = 50;

/*
 * HEAP DATA STRUCTURE (PRIORITY QUEUE)
 *
 * It uses a complete binary tree to hold data where the top N-1 levels are completely filled and the bottom-level nodes are as far left as possible.
 * A max heap can be implemented using an array and using the rules of parent/child indices.
 *
 * Find max/min: O(1)
 * Insert: O(log N)
 * Remove: O(log N)
 * Heapify from array: O(N)
 *
 */

class Heap {
public:
    Heap(int arr[], int n) {
        size = n;
        for (int i = 0; i < n; i++) max_heap[i] = arr[i];

        // build the max heap by heapifying every node starting with the first non-leaf node
        int start = (size / 2) - 1;
        for (int i = start; i >= 0; i--) {
            heapify(i);
        }
    }

    void heapify(int i) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left < size && max_heap[left] > max_heap[largest]) largest = left;
        if (right < size && max_heap[right] > max_heap[largest]) largest = right;

        if (largest != i) {
            int temp = max_heap[largest];
            max_heap[largest] = max_heap[i];
            max_heap[i] = temp;

            heapify(largest);
        }
    }

    void insert(int val) {
        max_heap[size] = val;
        int i = size;
        int parent = (i-1) / 2;
        size++;
        while (i < size && max_heap[i] > max_heap[parent]) {
            int temp = max_heap[parent];
            max_heap[parent] = max_heap[i];
            max_heap[i] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    int removeMax() {
        int max = max_heap[0];
        max_heap[0] = max_heap[size-1];
        size--;
        int i = 0;
        int left = 2*i+1;
        int right = 2*i+2;
        while ((left < size && max_heap[i] < max_heap[left]) || (right < size && max_heap[i] < max_heap[right])) {
            if (right >= size || max_heap[left] > max_heap[right]) {
                int temp = max_heap[left];
                max_heap[left] = max_heap[i];
                max_heap[i] = temp;
                i = left;
                left = 2*i+1;
                right = 2*i+2;
            } else if (max_heap[left] < max_heap[right]) {
                int temp = max_heap[right];
                max_heap[right] = max_heap[i];
                max_heap[i] = temp;
                i = right;
                left = 2*i+1;
                right = 2*i+2;
            }
        }

        return max;
    }

    void printArr() {
        for (int i = 0; i < size; i++) {
            cout << max_heap[i] << " ";
        }
        cout << endl;
    }
private:
    int max_heap[MAX_SIZE]{};
    int size;
};

int main() {
    int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
    Heap heap(arr, 11);
    heap.printArr(); // 17 15 13 9 6 5 10 4 8 3 1
    heap.removeMax();
    heap.printArr(); // 15 9 13 8 6 5 10 4 1 3
    heap.insert(7);
    heap.printArr(); // 15 9 13 8 7 5 10 4 1 3 6

    return 0;
}