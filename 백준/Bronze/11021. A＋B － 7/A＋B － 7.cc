#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;

    for (int i = 1; i <= T; i++) {
        int a;
        int b;
        cin >> a >> b;
        cout << "Case #";
        cout << i;
        cout << ": ";
        cout << a + b << endl;
    }
    return 0;
}