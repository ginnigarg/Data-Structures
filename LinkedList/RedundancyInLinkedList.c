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
  Node* temp = *head;

  if(pos == 0) {
    *head = temp->next;
    //free(temp);
  }

  for(int i = 0; i < pos; i++) {
    temp = temp->next;
  }
  
  Node* tempNext = temp->next;
  temp->next = temp->next->next;
  free(tempNext);
}

int check(Node* start, Node* end, int data) {
  int i = 0;
  Node* temp = start;
  while(temp->next != end) {
    if(temp->data == data) {
      return i;
    }
    i++;
    temp = temp->next;
  }
  return -1;
}

void deleteRedundancy(Node** head) {
  Node* temp = *head;
  while(temp->next != NULL) {
      int x = check(*head, temp, temp->data);
      if(x != -1) {
        printf("%d\n", x);
        deleteAt(head, x);
      }
      temp = temp->next;
  }
}

int main() {

  Node* head = NULL;

  for(int i = 0; i < 10; i+=2) {
    insert(&head, i);
    insert(&head, i);
  }

/*  for(int i = 1; i < 10; i+=2) {
    insert(&head, i);
    insert(&head, i);
  }*/
  
  print(head);

  deleteRedundancy(&head);

  print(head);

  return 0;
}
