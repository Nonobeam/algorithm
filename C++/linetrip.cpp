include <iostream>
#include <algorithm>
using namespace std;


int main()
{
    int N, length = 0;
    cin >> N;
    int a[N];
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    
    sort(a, a + N);
    
    
    length = max(abs(a[0])*2, max(abs(a[N - 1] - a[0])*2, a[N - 1]*2));
    
    cout << length;
    return 0;
}
