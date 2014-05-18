batchless2css-maven-plugin
==========================

Multithreaded LESS to CSS Compiler Maven Plugin

This maven plugin can be when large number of LESS files needs to be compiled to css.


Usage 
-----


	 -Dcompress     : compress css files, default : false
	 -Dexclude      : file match pattern to exclude in directory scan, default : .module.less
	 -DfailOnError  : terminate if compilation error occurs, default : true
	 -Dforce        : if false, compile only when file input file is changed
	                 (including the imports), default : false
	 -Dinclude      : file match pattern to include in directory scan, default : .less
	 -Doutputas     : string will appended to output file, default : .gen.css
	 -Dpath         : file match pattern to include in directory scan, default : current directory
	 -DnoOfThreads  : no of threads used for processing, default : 6
	 -DmapFolder    : Ex. /less/#/css/ if string '/less/' is found in filepath, replace the it with '/css/', 
	 		 Generated css files with put in new mapped folder. 
	 		 Allows comma seperated multiple values Ex. /less/#/css/,/lessmodules/#/cssmodules/
 
Compatibility 
-------
Compatible with less-1.5.1.js 
https://github.com/less/less.js

Support
-------
Found an issue or feature request
https://github.com/kiranbagul/batchless2css-maven-plugin/issues

Contributor
-----------
Abhishek Ash (ash.abhishek@gmail.com)

Libraries Used
--------------
batchless2css

License
-------
MIT License (MIT)

