#include <iostream>
#include <string>
using namespace std;

const int ALPHABET_SIZE = 26;

/*
 * TRIE DATA STRUCTURE
 *
 * A trie is a modification of a tree used to store words.
 * It starts with an empty root node and every node has 26 child node references (potentially null).
 * We can traverse down a trie to figure out what words are present or not based on null nodes.
 *
 * M is the length of the word.
 * Search: O(M)
 * Insert: O(M)
 * Remove: O(M)
 *
 */

struct Node {
    Node* letters[ALPHABET_SIZE]{}; // English alphabet
    int* val = nullptr;
    Node() {
        for (auto & letter : letters) letter = nullptr; // initialize all letters as NULL
    }
};

class Trie {
public:
    Trie() {
        root = nullptr;
    }

    Node* getRoot() {
        return root;
    }

    void insert(const string& word, int val) {
        if (root == nullptr) {
            root = new Node;
            root->val = new int;
        }

        Node* curr = root;
        for (char i : word) {
            int index = i - 97;
            if ((curr->letters)[index] == nullptr) {
                curr->letters[index] = new Node;
            }
            curr = curr->letters[index];
        }
        curr->val = new int(val);
    }

    int search(const string& word) {
        if (root == nullptr) return false;

        Node* curr = root;
        for (char i : word) {
            int index = i - 97;
            if (curr->letters[index] == nullptr) {
                return -1;
            }
            curr = curr->letters[index];
        }

        if (curr->val != nullptr) return *(curr->val);
        else return -1;
    }

    bool startsWith(const string& prefix) {
        if (root == nullptr) return false;
        Node* curr = root;
        for (char i : prefix) {
            int index = i - 97;
            if (curr->letters[index] == nullptr) {
                return false;
            }
            curr = curr->letters[index];
        }

        return true;
    }

    static bool isEmpty(Node* node) {
        for (auto & letter : node->letters) {
            if (letter != nullptr) return false;
        }

        return true;
    }

    Node* remove(Node* node, const string& word, int depth = 0) {
        if (search(word) == -1) return nullptr;

        if (depth == word.size()) { // at the end of the word
            if (node->val != nullptr) node->val = nullptr;

            if (isEmpty(node)) {
                delete node;
                node = nullptr;
            }

            return node;
        }

        int index = word[depth] - 97;
        node->letters[index] = remove(node->letters[index], word, depth+1);

        if (isEmpty(node) && node->val == nullptr) {
            delete node;
            node = nullptr;
        }

        return node;
    }
private:
    Node* root;
};

int main() {
    Trie trie;
    trie.insert("apple", 5);
    cout << trie.search("apple") << endl;           // 5
    cout << trie.search("app") << endl;             // -1
    cout << trie.startsWith("app") << endl;         // True
    trie.insert("app", 7);
    cout << trie.search("app") << endl;             // 7

    trie.remove(trie.getRoot(), "apple");
    cout << trie.search("apple") << endl;           // -1
    cout << trie.search("app") << endl;             // 7

    return 0;
}