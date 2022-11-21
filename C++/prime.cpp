#include <iostream>

using namespace std;

int main() {
    int N;
    int num = 0;
    cin >> N;
    for ( int i = 1; i <= N; i++ ){
        if ( N % i == 0 ){
            num = num + 1;
        }
    }
    if ( num == 2 ){
        cout << "YES";
    }else{
        cout << "NO";
    }
    return 0;
}
