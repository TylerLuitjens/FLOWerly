#include <fstream>
#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std;

int main(){
  string filename;
  cout << "Where do you want this money allocated? " ;
  cin >> filename;
  filename = "."+filename+".pgb";

  std::fstream file;
  file.open(filename, std::fstream::out | fstream::in);
  string line;
  double price = 0;
  double curBalance = 0;

  if(!file){
    cout << "Looks like this is the first deposit. First things first, what is the price of the product? ";
    cin >> price;
  }
  else{
    getline(file, line);
    price = stoi(line);
    getline(file, line);
    curBalance = stoi(line);
  }

  cout << "How much did you deposit? ";
  double dep;
  cin >> dep;

  curBalance += dep;

  cout << "You now have $" << curBalance << " saved up. That means you only need to save $" << price-curBalance << " more!" <<endl;

  file.close();
  file.open(filename, fstream::in | fstream::out | fstream::trunc);
  file << price;
  file << endl;
  file << curBalance;
  file.close();

	return 0;
}

