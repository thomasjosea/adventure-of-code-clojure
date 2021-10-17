#!/bin/bash

mapentry() { echo "{ :value \"${password}\" :letter \"${letter}\" :min-occurrences ${min_occurrences} :max-occurrences ${max_occurrences} }"; }
inputfile=../src/input.txt
outputfile=../src/input.clj

allmapentries=""

while read p; do
	min_occurrences=$(echo $p | egrep -o "[0-9]+" | head -1)
	max_occurrences=$(echo $p | egrep -o "[0-9]+" | tail -1)
	password=$(echo $p | egrep -o "[a-z]+" | tail -1)
	letter=$(echo $p | egrep -o "[a-z]+" | head -1)
	allmapentries+="$(mapentry),\n"
done < $inputfile

touch $outputfile
echo "(ns input)" >> $outputfile
echo "(def input [${allmapentries}])" >> $outputfile
