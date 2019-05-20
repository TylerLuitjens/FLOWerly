#!/bin/bash

echo ""
for filename in ./.*.pgb; do
  prefix="./."
  suffix=".pgb"
  allocation=${filename#"$prefix"}
  allocation=${allocation%"$suffix"}
  echo "${allocation}"
  cat $filename
  echo ""
  echo ""
done
echo ""

#export PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:.:/appropriate/directory
