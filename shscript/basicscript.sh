#!/bin/bash
for filename in ./*.cpp; do
  [ -e "$filename" ] || continue
  # ... rest of the loop's body
done

touch tempfile.txt
chmod 777 tempfile.txt
#export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:.:/appropriate/directory
