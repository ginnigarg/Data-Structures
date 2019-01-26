#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    int val;
    struct Node* left;
    struct Node* right;
}Node;


Node* insert(Node* root, int data, int val) {
    if(root == NULL) {
        Node* newNode = (Node *)malloc(sizeof(Node));
        newNode->data = data;
        newNode->val = val;
        newNode->left = NULL;
        newNode->right = NULL;
        return newNode;
    }
    if(root->data > data) {
        root->left = insert(root->left, data, val - 1);    
    } else {
        root->right = insert(root->right, data, val + 1);
    }
    return root;
}

Node* queue[100];
int start = 0;
int end = 0;

void push(Node* n) {
    queue[end++] = n;
}

void pop() {
    start++;
}

int size() {
    return end - start;
}

int maximum(int a, int b) {
    return (a > b) ? a : b;
}

int height(Node* root) {
    if(root == NULL) {
        return 0;
    }
    return 1 + maximum(height(root->left), height(root->right));
}


void pre(Node* root, int* arr, int* max, int* min) {
    if(root == NULL) {
        return;
    }
    push(root);
    while(size() > 0) {
        Node* temp = queue[start];
        int h = temp->val;
        pop();
        printf("%d %d\n", temp->data, arr[h]);
        if(arr[h] == -1) {
            arr[h] = temp->data;
            if(*min > h) {
                *min = h;
            }
            if(*max < h) {
                *max = h;
            }
//            printf("%d\n", temp->data);
        }

        printf("%d %d\n", temp->data, arr[h]);
        if(temp->left != NULL) {
            push(temp->left);
        }
        if(temp->right != NULL) {
            push(temp->right);
        }
    }
}

void preorder(Node* root) {

    if(root == NULL) return;
    printf("%d %d\n ", root->data, root->val);
    preorder(root->left);
    preorder(root->right);
}

int main() {
    int n, val;
    scanf("%d", &n);
    Node* root = NULL;
    for(int i = 0; i < n; i++) {
        scanf("%d", &val);
        root = insert(root, val, 0);
    }
    int h = height(root);
    int max = h, min = h;
    int* arr = (int *)malloc(sizeof(int) * (2 * h + 1));
    for(int i = 0; i < (2 * h + 1); i++) {
        arr[i] = -1;
    }
    printf("Pre : \n");
    preorder(root);
    printf("\n");
    pre(root, arr, &max, &min);
}
