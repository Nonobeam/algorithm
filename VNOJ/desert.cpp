#include <iostream>

using namespace std;

const int maxN = 2*10e5 + 11;
int n;
long long int c;
int a[maxN];
long long int sum = 0;

int main(){

    cin >> n >> c;
    for(int i = 0; i < n; i++){
        cin >> a[i];
        sum+=a[i];
    }
    if (sum < c) cout << "NO";
    else cout << "YES";
}
