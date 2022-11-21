#include <iostream>

using namespace std;

long long int n;
long long int sum = 0;


int main(){
    cin >> n;
    if (n % 2 == 0){
        cout << 1 * n/2;
    }else{
        cout << 1 * (n-1)/2 - n;
    }
}
