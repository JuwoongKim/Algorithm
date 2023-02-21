#include <iostream>    
#include <cstdio>
using namespace std;

int main(void)
{
	int i = 0;
	int sum = 0;
	int number;
	cin >> number;
		
	for (i = 0; i < number; i++)
	{
		int input;
		scanf("%1d", &input);
		sum += input;
	}

	cout << sum;
}
