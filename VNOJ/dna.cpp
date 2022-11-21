#include <iostream>
#include <string>

using namespace std;

string stra;
int n;
string strb[100];


int main(){

    cin >> stra;
    cin >> n;

    int m = stra.size();
    for (int i = 0; i < n; i++){
        cin >> strb[i];
    }

    for (int i = 0; i < n; i++){
        int dem = 0;
        string test = {strb[i]};
        for (int j = 0; j < m; j++){
            if(test[j] != stra[j]){
                dem++;
            }

        }
        if (dem <= 2) cout << i+1 <<" ";
    }
}
