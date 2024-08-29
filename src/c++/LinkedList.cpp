#include <iostream>
using namespace std;

/*
 * LINKED LIST DATA STRUCTURE
 *
 * Reserves a new memory block for each item as it's added and links items together like a chain.
 * It can be superior to arrays because element shifting isn't required.
 *
 * Access: O(N)
 * Search: O(N)
 * Insert: O(1) - if you’re at the correct position
 * Remove: O(1) - if you’re at the correct position
 */

struct Node {
    int value;
    Node* next;
};

class LinkedList {
public:
    LinkedList() {
        head = nullptr;
    }
    ~LinkedList() {
        Node* node = head;
        while (node != nullptr) {
            Node* temp = node->next;
            delete node;
            node = temp;
        }
    }
    void print() {
        if (head == nullptr) cout << "Empty linked list.";
        Node* node = head;
        while (node != nullptr) {
            cout << node->value << " ";
            node = node->next;
        }
        cout << endl;
    }
    void addFront(int val) {
        if (head == nullptr) {
            head = new Node;
            head->value = val;
            return;
        }
        Node* temp = head;
        head = new Node;
        head->value = val;
        head->next = temp;
    }
    void addRear(int val) {
        if (head == nullptr) {
            head = new Node;
            head->value = val;
            return;
        }
        Node* node = head;
        while (node->next != nullptr) {
            node = node->next;
        }
        Node* newNode = new Node;
        newNode->value = val;
        node->next = newNode;
    }
    void remove(int val) {
        if (head->value == val) {
            Node* temp = head->next;
            delete head;
            head = temp;
            return;
        }

        Node* node = head;
        while (node != nullptr && node->next->value != val) {
            node = node->next;
        }
        if (node == nullptr) cout << "Element doesn't exist." << endl;
        else {
            Node* temp = node->next;
            node->next = node->next->next;
            delete temp;
        }
    }
private:
    Node* head;
};

int main() {
    LinkedList l;
    l.print(); // EMPTY
    l.addFront(1);
    l.print(); // 1
    l.addRear(2);
    l.addRear(3);
    l.addRear(4);
    l.addRear(5);
    l.print(); // 1 2 3 4 5
    l.addFront(0);
    l.print(); // 0 1 2 3 4 5
    l.remove(3);
    l.print(); // 0 1 2 4 5
    l.remove(0);
    l.print(); // 1 2 4 5
    l.remove(5);
    l.print(); // 1 2 4
    l.addFront(0);
    l.addRear(5);
    l.print(); // 0 1 2 4 5

    return 0;
}
