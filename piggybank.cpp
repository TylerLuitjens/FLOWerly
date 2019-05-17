#include <fstream>
#include <stdio.h>
#include <iostream>
#include <math.h>

void help();

using namespace std;

int main(){

  string cmd;
  cout << "Welcome to your PiggyBank" << endl;
  cout << "-------------------------" << endl;
  cout << endl;

  while(cmd.compare("exit") != 0){

    std::fstream file;
    cout << "Please enter a command >> ";
    cin >> cmd;

    if(cmd.compare("help") == 0)
      help();

    else if(cmd.compare("deposit") == 0){
      string filename;
      cout << "Where do you want this money allocated? " ;
      cin >> filename;
      filename = "."+filename+".pgb";

      file.open(filename, std::fstream::out | fstream::in);
      string line;
      double price = 0;
      double curBalance = 0;

      if(!file){
        cout << "Looks like this is the first deposit. First things first, what is the price of the product? ";
        cin >> price;
      }
      else{
        string filestatus;
        getline(file, filestatus);
        getline(file, line);
        price = stoi(line);
        getline(file, line);
        curBalance = stoi(line);
      }

      cout << "How much did you deposit? ";//TODO make sure allocation is not locked first
      double dep;
      cin >> dep;

      curBalance += dep;

      cout << "You now have $" << curBalance << " saved up. That means you only need to save $" << price-curBalance << " more!" <<endl;

      file.close();
      file.open(filename, fstream::in | fstream::out | fstream::trunc);
      file << "unlocked";
      file << endl;
      file << price;
      file << endl;
      file << curBalance;
      file.close();
    }

    else if(cmd.compare("delete") == 0){//TODO make sure file is not locked first
      string filename;
      cout << "What file would you like to delete: ";
      cin >> filename;
      file.open("."+filename+".pgb", fstream::in | fstream::out);
      string filestatus;
      getline(file, filestatus);
      file.close();
      if(filestatus.compare("unlocked") == 0){
        cout << "WARNING: This will PERMANENTLY delete all data associated with " << filename <<". Are you POSITIVE you would like to continue(y/n)? ";
        string resp;
        cin >> resp;
        if(resp.compare("y") == 0){
          string SysCommand = "rm ./." + filename + ".pgb";
          system(SysCommand.c_str());
          cout << filename << " has been deleted" << endl;
        }
        else
          cout << filename << " has not been deleted. Directing back to safety now." << endl;
      }
      else{
        cout << "This file is locked and cannot be deleted at this time. If you wish to delete it, please unlock it first." << endl;
      }
    }

    else if(cmd.compare("edit") == 0){
      cout << "Which allocation's price would you like to edit? ";
      string filename, filestatus;
      cin >> filename;
      double NewPrice, OldPrice, curBalance;

      filename = "."+filename+".pgb";

      std::fstream file;
      file.open(filename, std::fstream::out | fstream::in);
      string line;

      if(!file){
        cout << "Looks like that allocation doesn't exist. Please try again " << endl;
      }
      else{
        getline(file, filestatus);
        getline(file, line);
        OldPrice = stoi(line);
        getline(file, line);
        curBalance = stoi(line);

        if(filestatus.compare("unlocked") == 0){
          cout << "What is the new price? ";
          cin >> NewPrice;
          cout << "The price has been changed from $" << OldPrice << " to $" << NewPrice << endl;

          file.close();
          file.open(filename, fstream::in | fstream::out | fstream::trunc);
          file << NewPrice;
          file << endl;
          file << curBalance;
          file.close(); 
        }
        else
          cout << "This file has been locked and therfore cannot be edited. To make a change, please unlock the file first" << endl;
      }
    }

    else if (cmd.compare("lock") == 0 || cmd.compare("unlock") == 0 || cmd.compare("complete") == 0){
      
      cout << "Which allocation's status would you like to edit? ";
      string filename, filestatus;
      cin >> filename;
      double price, curBalance;

      filename = "."+filename+".pgb";

      std::fstream file;
      file.open(filename, std::fstream::out | fstream::in);
      string line;

      if(!file){
        cout << "Looks like that allocation doesn't exist. Please try again " << endl;
      }
      else{
        getline(file, filestatus);
        getline(file, line);
        price = stoi(line);
        getline(file, line);
        curBalance = stoi(line);
        
        cout << "What is the new status? (unlocked, locked, or completed) ";
        string newStatus;
        cin >> newStatus;
        cout << "Status has been changed from " << filestatus << " to " << newStatus << " for " << filename << endl;
        file.close();
        file.open(filename, fstream::in | fstream::out | fstream::trunc);
        file << newStatus;
        file << endl;
        file << price;
        file << endl;
        file << curBalance;
        file.close(); 
      }
     
    }

    else if(cmd.compare("exit") != 0){
      cout << "I'm sorry that command isn't recognized. To see a list of valid commands, type 'help'" << endl;
    }

  }

  cout << "Saving data..." << endl;
  cout << "Exiting" << endl;
	return 0;
}

void help(){
  cout << endl;
  cout << "Command List" << endl;
  cout << "------------" << endl;
  cout << endl;
//  cout << "list - list all current saving allocations" << endl; //TODO make it so current contributions are also printed out along with their names
//  cout << "duplicate - copy an allocation's data to another allocation name of your choice" << endl; //TODO
  cout << "help - list out all available commands" << endl;
  cout << "deposit - add a deposit to an existing or new allocation" << endl;
  cout << "delete - remove an allocation. WARNING this will completely remove all data pertaining to the given allocation, with no way to recover it. Use with caution." << endl;
  cout << "lock - keep the allocation, but make it so no more deposits can be made" << endl;
  cout << "unlock - set the allocation so deposits can be made again" << endl;
  cout << "complete - locks the allocation and shows the system that you officially hit your goal" << endl;
  cout << "edit - allows you to adjust the price of an existing allocation" << endl;
  cout << "exit - exit the program" << endl;
  cout << endl;
}
