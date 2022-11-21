#include <iostream>

using namespace std;

int main(){
    int N;
    cin >> N;
    int h[100000], cp[10000];          
    for (int i = 1; i <= N; i++) {
        cin >> h[i];
    }
    
    cp[1] = 0;
    cp[2] = abs(h[2] - h[1]);
    for (int i = 3; i <= N; i++){               //chay tu 3 roi ghi lai cao mang cp
        cp[i] = min(cp[i - 2] + abs(h[i] - h[i - 2]), cp[i - 1] + abs(h[i] - h[i - 1])); // so sanh nhay 1 voi nhay 2
    }                
    
    std::cout << cp[N] << std::endl;
    
}
