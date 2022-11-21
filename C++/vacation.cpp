#include <iostream>
#include <algorithm>

using namespace std;

const int maxN = 10e5 + 11;
int n, a, b, c;
int dp[maxN][3];

int main(){

    cin.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> n;
    for (int i = 1; i <= n; i++){
        cin >> a >> b >> c;         // a, b, c 3 cai happiness theo thu tu
        dp[i][0] = max(dp[i-1][1] + a, dp[i-1][2] + a);
        dp[i][1] = max(dp[i-1][0] + b, dp[i-1][2] + b);
        dp[i][2] = max(dp[i-1][1] + c, dp[i-1][0] + c);
    }
    //cout << max(dp[0], dp[1], dp[1])
    int ans = max({dp[n][0], dp[n][1], dp[n][2]});
    cout << ans;
}
