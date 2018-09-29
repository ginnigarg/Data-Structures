#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct Node {
  int data;
  struct Node* next;
}Node;

typedef struct Stack {
  struct Node* top;
}Stack; 

Stack* initializeStack() {
  Stack* newStack = (Stack*)malloc(sizeof(Stack));
  newStack->top = NULL; 
  return newStack;
}

Node* createNewNode() {
  Node* newNode = (Node*)malloc(sizeof(Node));
  return newNode;
}

int isEmpty(Stack* mem) {
  return (mem->top == NULL);
}

void push(Stack* mem, int data) {
  Node* node = createNewNode();
  if(node == NULL) {
    printf("Stack Overflow\n"); 
    return;
  }
  node->data = data;
  node->next = mem->top;
  mem->top = node;
}

int pop(Stack* mem) {
  if(isEmpty(mem)) {
    printf("Stack Underflow\n");
    return INT_MIN;
  }
  int temp = mem->top->data;
  Node* ptr = mem->top;
  mem->top = mem->top->next;
  free(ptr);
  return temp;
}

int top(Stack* mem) {
  if(mem->top == NULL) return INT_MIN;
  return mem->top->data;
}

int main() {
  Stack* stack = initializeStack();
  printf("%d\n", pop(stack));
  printf("%d\n", top(stack));
  for(int i = 0; i < 10; i++) {
    push(stack, i);
    printf("%d\n", pop(stack));
  }
  return 0;
}


