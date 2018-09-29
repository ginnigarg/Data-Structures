import java.util.*;
import java.io.*;

public class SlidingWindowMax {

  static void rearrange(Deque<Integer> q, int i, int[] arr) {
    if(q.isEmpty() == false) {
      if(arr[i] >= arr[q.peek()]) {
        q.clear();
      } else {
        while(arr[i] >= arr[q.peekLast()]) {
          q.removeLast();
        }  
      }
    }
    q.push(i);
  }

  static void slidingMax(int[] arr, int w) {
    System.out.println("");
    Deque<Integer> q = new LinkedList<>();
    for(int  i = 0 ; i < w; i++) {
      rearrange(q, i, arr);
      System.out.println(arr[q.peek()]);
    }
    for(int i = w; i < arr.length; i++) {
      int index = q.peek();
      //if(index == i - w) System.out.println(arr[q.pop()]);
      //else System.out.println(arr[q.peek()]);
      if(index == i - w) q.pop();
      rearrange(q, i, arr);
      System.out.println(arr[q.peek()]);
    }
    System.out.println(arr[q.pop()]);
  }

  public static void main(String args[]) {
    Scanner sc =  new Scanner(System.in);
    int size;
    size = sc.nextInt();
    int[] arr = new int[size];
    for(int i  = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    slidingMax(arr, 3);
  }








}
