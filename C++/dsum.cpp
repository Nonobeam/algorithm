#include <iostream>

using namespace std;

int main(){
    int a;
    cin >> a;
    int ans = 0;
    int temp = a;
    while (temp > 0){
        ans = ans + temp % 10;
        temp = temp/10;
    }
    cout << ans;
}
