#include <iostream>
#include <string>
#include <cmath>
#include <unordered_set>
#include <unordered_map>
#include <bitset>
#include <stack>
#include <queue>
#include <vector>
#include <algorithm>
#include <climits>
#define FASTIO cin.tie(NULL); cout.tie(NULL); ios::sync_with_stdio(false);
#define MAX 100001
#define LL long long
#define INF 1e9

using namespace std;
int N;
LL MAP[MAX];
LL Sum[MAX];
LL Answer = 0;

void Input() {
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> MAP[i];
		Sum[i] = Sum[i - 1] + MAP[i];
	}
}

void Settings() {
	for (int i = 1; i < N; i++) {
		Answer += (Sum[N] - Sum[i]) * MAP[i];
	}
}

void Find_Answer() {
	cout << Answer << "\n";
}

int main() {
	FASTIO
	Input();
	Settings();
	Find_Answer();

	return 0;
}