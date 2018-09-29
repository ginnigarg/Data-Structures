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

int size(stack* mem) {
  return mem->top;
}

int main() {
  stack* Stack = initializeStack();
  int arr[7] = {2, 3, 5, 6, 2, 3};
  int maxArea = arr[0];
  push(Stack, 0);
  for(int i = 1; i < 6;) {
    int temp;
    if(size(Stack) >= 0 && arr[i] < arr[peak(Stack)]) {
      int x = pop(Stack);
      int span = (isEmpty(Stack) ? i : i - peak(Stack));
      temp = arr[x] * span;
      printf("%d %d %d\n", temp, i, peak(Stack));
      if(maxArea < temp) maxArea = temp;
    } else {
      push(Stack, i++);
    }
  }
  printf("Max Area : %d\n", maxArea);
  return 0;
}
