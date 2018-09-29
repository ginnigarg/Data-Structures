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
  int arr[7] = {100, 80, 60, 70, 60, 75, 85};
  int dist[7];
  int max = 1;
  push(Stack, 0);
  dist[0] = 1;
  for(int i = 1; i < 7;) {
    if(arr[i] < arr[peak(Stack)]) {
      dist[i] = isEmpty(Stack) ? i + 1 : i - peak(Stack);
      push(Stack, i);
      if(max < dist[i]) {
         max = dist[i];
      }
      i++;
    }else {
      pop(Stack);
    }
  }
  
  for(int i = 0; i < 7; i++) {
    printf("%d ", dist[i]);
  }

  printf("\nMax : %d\n", max);
  return 0;
}
