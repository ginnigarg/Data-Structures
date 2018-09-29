#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
  int data;
  struct Node* next;
}Node;

void print(Node* head) {
  Node* temp = head;
  while(temp != NULL) {
    printf("%d ", temp->data);
    temp = temp->next;
  }
  printf("\n");
}

Node* createNewNode() {
  Node* node = (Node *)malloc(sizeof(Node));
  return node;
}

void insert(Node** head, int data) {
  Node* node = createNewNode();
  node->data = data;
  node->next = *head;
  *head = node;
}

void deleteAt(Node** head, int pos) {
  


}


int main() {

  Node* head = NULL;

  for(int i = 0; i < 10; i+=2) {
    insert(&head, i);
    insert(&head, i);
  }

  for(int i = 1; i < 10; i+=2) {
    insert(&head, i);
    insert(&head, i);
  }
  
  print(head);
  
  return 0;
}
