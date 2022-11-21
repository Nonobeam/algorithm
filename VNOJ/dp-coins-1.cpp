#include <iostream>
#include <iomanip>
#include <map>

using namespace std;

const int maxN = 6000;
int N;  //so nguyen duong le
map<long double, long double> a;
long double dp[maxN][maxN];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> N;
    for (int i = 1; i <= N; i++){
        cin >> a[i];
    }
    int xs = N/2 + 1;
    for (int i = 0; i <= N; ++i){
        dp[i][0] = 1;
    }
    for (int i = 1; i <= N; i++){
        for (int j = 1; j <= xs; j++){
            dp[i][j] = dp[i-1][j-1]*a[i] + dp[i-1][j]*(1-a[i]);
        }
    }
    cout << fixed << setprecision(10) <<dp[N][xs];
}
