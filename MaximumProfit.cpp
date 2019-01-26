#include <iostream>
#include <algorithm>
using namespace std;

int func(int* arr, int start, int end) {
    if(start < end) {
        int profit = 0;
        for(int i = start; i <= end; i++) {
            int buy = arr[i];
            int tempProfit1 = 0;
            for(int j = i + 1; j <= end + 1; j++) {
                int tempProfit2 = arr[j] - buy;
                int temp = func(arr, j + 1, end);
                if(temp > 0) {
                    tempProfit2 += temp;
                }
                tempProfit1 = max(tempProfit2, tempProfit1);
            }
            profit = max(profit, tempProfit1);
        }
        return profit;
    }
    return 0;
}


int main() {
    int n;
    cin >> n;
    int* arr = new int[n];
    for(int i = 0; i < n; i++) {
       cin >> arr[i];
    }
    cout << func(arr, 0, n - 2);
    return 0;
}
