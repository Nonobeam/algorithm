#include <iostream>
#include <string>

using namespace std;

const int maxN = 5000;
string S;
int m;
int L[maxN];
int R[maxN];

int main(){


    cin >> S;
    cin >> m;
    for (int i = 0; i < m; i++){
        cin >> L[i] >> R[i];
    }

    for (int i = 0; i < m; i++){
        int t1 = L[i] - 1, t2 = R[i] - 1;
        while (t1 < S.length() || t2 > 0){

            if (S[t1] != S[t2]){
                cout << "NO" << endl;
                break;
            }
            if (t2 - t1 <= 2){
                cout <<"YES" <<endl;
                break;
            }
            t1++;
            t2--;
        }
    }

}
