#include <iostream>

using namespace std;

int main()
{
    int N, max = 0, count = 0;
    cin >> N;
    long long a[1000];
    for (int i = 0; i < N; i++){
        cin >> a[i];
    }
    for (int i = 0; i < N - 1; i++){
        for (int j = i; j < N; j++){
            if (a[i] > 2*a[j]){
                count++;
            }
        }
    }
    std::cout << count << std::endl;
    return 0;
}
