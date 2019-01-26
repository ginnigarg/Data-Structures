#include <iostream>
#include <stack>
using namespace std;

int main() {
    int tc;
    cin >> tc;
    while(tc--) {
        int n;
        cin >> n;
        int* arr = new int[n];
        int* ans = new int[n];
        for(int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        int i = 1;
        stack<int> st;
        st.push(0);
        ans[0] = 1;
        while(i < n) {
            if(st.empty() == true || arr[st.top()] > arr[i]) {
                ans[i] = st.empty() ?  (i + 1) : (i - st.top());
                st.push(i++);
            } else {
                st.pop();
            }
        }
        for(int i = 0; i < n; i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
        
    }
    return 0;
}
