#include <iostream>

using namespace std;

int main() {
    int a, i;
    cin >> a;
    int num = 0;
    for ( int i = 1; i > 0; i++ ){
        if ( a % 2 == 1 ){
            num += 1;
        }
        a /= 2;
        if ( a / 2 == 0){
            break;
        }
    }
    if ( a == 0 ){
        cout << 0;
    }else{
        cout << num + 1;
    }
    return 0;
}
