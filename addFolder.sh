#!/bin/bash
function createDir {
	for dir in $@; do
		if [ ! -d $dir ]; then
			mkdir $dir
		fi
		cd $dir
	done
}

for f in $( ls  ); do
	currDir=$(pwd)
	if [ -d $f ]; then
		cd $currDir
		cd $f
		createDir src main java
		cd $currDir
		cd $f		
		createDir src test java
		cd $currDir
		cd $f		
		createDir src main resources
		cd $currDir
		cd $f
		createDir src test resources
		cd $currDir
		cd $f
		createDir target generated-sources
		cd $currDir
	fi 
done
