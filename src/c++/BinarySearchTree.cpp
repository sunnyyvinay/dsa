#include <iostream>
using namespace std;

/*
 * BINARY SEARCH TREE (BST) DATA STRUCTURE
 *
 * A BST is a special type of binary tree where left subtree nodes are less and right subtree nodes are greater.
 * You can traverse nodes in 3 ways (in-order, pre-order, post-order).
 *
 * Access: O(log N)
 * Search: O(log N)
 * Insert: O(log N)
 * Remove: O(log N)
 *
 */

struct Node {
    int value;
    Node* left;
    Node* right;
};

class BST {
public:
    BST() {
        root = nullptr;
    }

    ~BST() {
        destruct_tree(root);
    }

    Node* getRoot() {
        return root;
    }

    void in_order_traversal(Node* node) {
        if (node == nullptr) return;

        in_order_traversal(node->left);
        cout << node->value << " ";
        in_order_traversal(node->right);
    }

    void insert(int val) {
        if (root == nullptr) {
            root = new Node;
            root->value = val;
            return;
        }
        Node* node = root;
        while (node != nullptr) {
            if (node->value == val) return;
            else if (node->value > val) {
                if (node->left == nullptr) {
                    node->left = new Node;
                    node->left->value = val;
                    return;
                } else {
                    node = node->left;
                }
            } else if (node->value < val) {
                if (node->right == nullptr) {
                    node->right = new Node;
                    node->right->value = val;
                    return;
                } else {
                    node = node->right;
                }
            }
        }
    }

    bool find(int val) {
        Node* node = root;
        while (node != nullptr) {
            if (node->value == val) return true;
            else if (node->value < val) {
                node = node->right;
            } else if (node->value > val) {
                node = node->left;
            }
        }

        return false;
    }

    void remove(int val) {
        Node* node = root;
        Node* parent;
        while (node != nullptr) {
            if (node->value == val) {
                if (node->left == nullptr && node->right == nullptr) { // LEAF
                    if (parent != nullptr && parent->left == node) {
                        parent->left = nullptr;
                    } else if (parent != nullptr && parent->right == node) {
                        parent->right = nullptr;
                    }
                    delete node;
                    return;
                } else if (node->left == nullptr || node->right == nullptr) { // ONE CHILD
                    if (parent != nullptr && parent->left == node) {
                        parent->left = (node->left == nullptr) ? node->right : node->left;
                    } else if (parent != nullptr && parent->right == node) {
                        parent->right = (node->left == nullptr) ? node->right : node->left;
                    }
                    delete node;
                    return;
                } else { // TWO CHILDREN: take the successor (smallest node in the right subtree) (no left child)
                    Node* successor = node->right;
                    Node* successorParent = node;
                    while (successor->left != nullptr) {
                        successorParent = successor;
                        successor = successor->left;
                    }

                    if (successorParent == node) {
                        node->value = successor->value;
                        node->right = successor->right;
                    } else {
                        successorParent->left = successor->right;
                        node->value = successor->value;
                    }

                    delete successor;
                    return;
                }
            } else if (node->value < val) {
                parent = node;
                node = node->right;
            } else if (node->value > val) {
                parent = node;
                node = node->left;
            }
        }
    }

    int height(Node* node) {
        if (node == nullptr) return -1;

        int leftHeight = height(node->left);
        int rightHeight = height(node->right);
        return max(leftHeight, rightHeight) + 1;
    }

    int getMax() {
        Node* max = root;
        while (max->right != nullptr) {
            max = max->right;
        }
        return max->value;
    }

    int getMin() {
        Node* min = root;
        while (min->left != nullptr) {
            min = min->left;
        }
        return min->value;
    }

    bool isBST(Node* node, int minVal, int maxVal) {
        if (node == nullptr) return true;

        if (node->value < minVal || node->value > maxVal) return false;

        return isBST(node->left, minVal, node->value) && isBST(node->right, node->value, maxVal);
    }
private:
    Node* root;

    void destruct_tree(Node* node) {
        if (node == nullptr) return;

        destruct_tree(node->left);
        destruct_tree(node->right);
        delete node;
    }
};

int main() {
    BST bst;
    bst.insert(8);
    bst.insert(3);
    bst.insert(10);
    bst.insert(1);
    bst.insert(6);
    bst.in_order_traversal(bst.getRoot());                                  // 1 3 6 8 10
    cout << endl << bst.find(6);                                             // true
    cout << endl << bst.find(9) << endl;                                     // false
    bst.insert(4);
    bst.insert(7);
    bst.insert(14);
    bst.insert(13);
    bst.in_order_traversal(bst.getRoot());                                 // 1 3 4 6 7 8 10 13 14
    cout << endl << bst.height(bst.getRoot()) << endl;                     // 3
    cout << bst.getMax() << endl;                                                // 14
    cout << bst.getMin() << endl;                                                // 1
    cout << bst.isBST(bst.getRoot(), INT_MIN, INT_MAX) << endl;  // true
    bst.remove(7);
    bst.in_order_traversal(bst.getRoot());                                 // 1 3 4 6 8 10 13 14
    cout << endl;
    bst.remove(14);
    bst.in_order_traversal(bst.getRoot());                                 // 1 3 4 6 8 10 13
    cout << endl;
    bst.remove(13);
    bst.insert(9);
    bst.insert(11);
    bst.remove(10);                                                         // 1 3 4 6 8 9 11
    bst.in_order_traversal(bst.getRoot());                                // 1 3 4 6 8 9 11
    cout << endl;
    bst.insert(5);
    bst.remove(3);
    bst.in_order_traversal(bst.getRoot());                                // 1 4 5 6 8 9 11

    return 0;
}
