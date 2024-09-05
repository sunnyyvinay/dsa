#include <iostream>
using namespace std;

const int MAX = 50;

/*
 * STACK DATA STRUCTURE
 *
 * Stores elements like a stack with LIFO structure (Last In, First Out)
 *
 * Access (top element): O(1)
 * Insert: O(1)
 * Remove: O(1)
 *
 */

class Stack {
public:
    Stack() {
        top = 0;
    }
    bool isFull() const {
        return top == MAX;
    }
    int peek() {
        return arr[top-1];
    }
    void push(int val) {
        if (!isFull()) {
            arr[top] = val;
            top++;
        }
    }
    int pop() {
        int val = arr[top-1];
        top--;
        return val;
    }
    int getSize() {
        return top;
    }
private:
    int arr[MAX]{};
    int top;
};

int main() {
    Stack stack;
    stack.push(1);
    cout << stack.peek() << endl; // 1
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);
    cout << stack.pop() << endl; // 6
    cout << stack.peek() << endl; // 5

    return 0;
}