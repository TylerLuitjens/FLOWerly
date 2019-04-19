#!/bin/bash

#clean up the files first to avoid errors
rm *.cpp.out #TODO change this to cc instead of cpp
rm *log.txt
for filename in ./*.cpp; do #TODO need to change this to .cc instead of .cpp
  [ -e "$filename" ] || continue
  echo "Compiling $filename..."
  g++ $filename -o $filename.out 2> error_log.txt

  if [ -e $filename.out ]
  then
    echo "  success... executing..."
    ./$filename.out 2> error_log.txt #TODO not actually redirecting the output from the screen
    retVal=$?
    if [ $retVal -ne 0 ];
      then
        echo $filename.out >> run_error_log.txt
    fi

  else
    echo "  error... Logging. Please see errorlog.txt for more details..."
    echo "$filename" >> file_log.txt
    echo "" >> file_log.txt
  fi

  echo ""
done

echo "The following files could not be compiled: "
while read files; do
  echo "$files"
done < file_log.txt

echo "The following files had run-time errors: "
while read files; do
  echo "$files"
done < run_error_log.txt




#export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:.:/appropriate/directory
