#include <iostream>
using namespace std;

const int MAX = 50;

/*
 * QUEUE DATA STRUCTURE
 *
 * Stores elements like a queue or line with FIFO structure (First In, First Out)
 *
 * Access (top element): O(1)
 * Insert: O(1)
 * Remove: O(1)
 *
 */

class Queue {
public:
    Queue() {
        size = 0;
        front = 0;
        rear = -1;
    }
    bool isFull() const {
        return size == MAX;
    }
    int top() {
        return arr[front];
    }
    void enqueue(int val) {
        if (!isFull()) {
            rear = (rear + 1) % MAX;
            arr[rear] = val;
            size++;
        }
    }
    int dequeue() {
        if (size != 0) {
            int val = arr[front];
            front = (front + 1) % MAX;
            size--;
            return val;
        }

        return -1;
    }
private:
    int arr[MAX]{};
    int front;
    int rear;
    int size;
};

int main() {
    Queue q;
    q.enqueue(1);
    cout << q.top() << endl; // 1
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    q.enqueue(6);
    cout << q.dequeue() << endl; // 1
    cout << q.dequeue() << endl; // 2

    return 0;
}