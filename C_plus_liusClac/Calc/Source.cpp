#include <iostream>
#include <string>
#include <stack>
#include <fstream>

using std::cout;
using std::cin;
using std::endl;
using std::string;

std::stack<int> s;

bool is_number(string str) 
{
	return !(str.length()==1 && (str[0]=='+' || str[0]=='-' || str[0]=='*' || str[0]=='/'));
}

bool is_incorrect(string str) 
{
	for(int i = 0;i < str.length();++i)
	{
		if (str[i]>='a' && str[i]<='z' || str[i]>='A' && str[i]<='Z') 
			return 1; 
	}
	return 0;
}

void action(char c) 
{
	int value_1 = s.top();
	s.pop();
	int value_2 = s.top();
	s.pop();
	switch (c)
	{
	case '+': 
		s.push(value_1 + value_2);
		break;
	case '-': 
		s.push(value_2 - value_1);
		break;
	case '*': 
		s.push(value_1 * value_2);
		break;
	case '/': 
		s.push(value_2 / value_1);
		break;
	}
}
				

int main() {
    string example;
	//std::ifstream cin("input.txt");
	getline(cin,example);
	if (example.length() == 0) 
	{
		cout << "Expression not found." << endl;
		return 0;
	}
	while (example.length() != 0) 
	{
		try 
		{
			string element = example.substr(0,example.find(' '));
			if (is_number(element)) 
			{
				if (is_incorrect(element))
					throw "Incorrect variation of value.";
				s.push(stoi(element));
			} else {
				if (s.size() < 2) 
					throw ("Read Error.");
				action(element[0]);
			}
			int pos = example.find(' ');
			if (pos == -1) 
			{
				example = "";
			} else {
				example = example.substr(example.find(' ')+1);
			}
		}
		catch (char *str) 
		{
			cout << str << endl;
			return 0;
		}
	}
	if (s.size() > 1) 
	{
		cout << "Can not reach final resualt." << endl;
		return 0;
	}
	cout << s.top() << endl;
    return 0;
}
