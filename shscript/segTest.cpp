#include <stdio.h>
#include <iostream>
#include <math.h>
#include <signal.h>

using namespace std;

int main(){
  raise(SIGSEGV);
	return 0;
}

