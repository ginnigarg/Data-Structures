#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct stack {
  int* arr;
  int top;
}stack;

stack* initializeStack() {
  stack * mem = (stack *)malloc(sizeof(stack));
  mem->arr = (int *)malloc(sizeof(int) * 10);
  mem->top = -1;
  return mem;
}

int isEmpty(stack* mem) {
  return ((mem->top) == -1);
}

int isFull(stack* mem) {
  return ((mem->top) == 9);
}

void push(stack* mem, int val) {
  if(isFull(mem)) {
    printf("Stack Overflow\n");
    return;
  }
  mem->top = mem->top + 1;
  mem->arr[mem->top] = val;
}

int pop(stack* mem) {
  if(isEmpty(mem)) {
    printf("Stack Underflow\n");
    return INT_MIN;
  }
  mem->top = mem->top - 1;
  return mem->arr[mem->top + 1];
}

int peak(stack* mem) {
  if(isEmpty(mem)) {
    return INT_MIN;
  }
  return mem->arr[mem->top];
}

int top(stack* mem) {
  return mem->top;
}

int main() {
  stack* Stack = initializeStack();
  printf("Empty : %d\n", isEmpty(Stack));
  printf("Full : %d\n", isFull(Stack));
  pop(Stack);
  for(int i = 0; i < 10; i++) {
    push(Stack, i);
    printf("%d\n", pop(Stack));
  }
  return 0;
}
