#include <iostream>

using namespace std;

int main(){
    int N, K;
    cin >> N >> K;
    int h[100000], cp[10000];          
    for (int i = 1; i <= N; i++) {
        cin >> h[i];
    }
    
    cp[1] = 0;
    for (int i = 2; i <= N; i++){      
        int min1 = 1000000000;
        for (int j = 1; j <= K; j++){\
            if (i - j >= 1){
                min1 = min(min1, cp[i-j] + abs(h[i] - h[i - j]));
            }
        }
        cp[i] = min1;
    }                
    
    std::cout << cp[N] << std::endl;
    
}
