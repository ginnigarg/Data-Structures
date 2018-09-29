#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node* left;
    struct Node* right;
}


int insert(Node* root, int data) {
    if(root == NULL) {
        Node* newNode = (Node *)malloc(sizeof(Node));
        newNode->data = data;
        newNode->left = NULL;
        newNode->right = NULL;
    }
    if(root->left > item) {
        
    }





}
