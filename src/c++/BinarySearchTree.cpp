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

    void destruct_tree(Node* node) {
        if (node == nullptr) return;

        destruct_tree(node->left);
        destruct_tree(node->right);
        delete node;
    }

    ~BST() {
        destruct_tree(root);
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
            if (node->value == val) return; // value found
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
                        parent->left = node->left == nullptr ? node->right : node->left;
                    } else if (parent != nullptr && parent->right == node) {
                        parent->right = parent->left = node->left == nullptr ? node->right : node->left;
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
            }
            else if (node->value < val) {
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
            min = min->right;
        }
        return min->value;
    }

    bool isBST(Node* node, Node* left, Node* right) {
        if (node == nullptr) return true;

        if (left != nullptr && left->value >= node->value) return false;
        if (right != nullptr && right->value >= node->value) return false;

        return isBST(node->left, left, node) && isBST(node->right, node, right);
    }
private:
    Node* root;
};

int main() {


    return 0;
}
