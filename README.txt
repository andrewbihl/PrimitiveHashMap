This is my submission for the KPCB Engineering fellows application.

The project consists of a class HashMap.java, a Main.java class, a number of .txt files for testing, and a script to run a variety of tests together.


	COMPONENTS

HashMap.java implements a fixed-size hash map using only primitives. It includes the public methods specified in the application prompt:

	constructor(size): return an instance of the class with pre-allocated space for the given number of objects.
	
	boolean set(key, value): stores the given key/value pair in the hash map. Returns a boolean value indicating success / failure of the operation.
	
	get(key): return the value associated with the given key, or null if no value is set.
	
	delete(key): delete the value associated with the given key, returning the value on success or null if the key has no value.
	
	float load(): return a float value representing the load factor (`(items in hash map)/(size of hash map)`) of the data structure. Since the size of the data structure is fixed, this should never be greater than 1.
	
	
	HOW TO RUN

Main.java is the main class that reads in parameters from the command line. To run the project (after compiling with javac), the command line statement should be:
	java Main <Text File to read> <Size of HashMap>
	
The script 'test_script' can also be run. It will run the program with .txt files of varied sizes and with varied hash map sizes for each input file. 
To run, simply enter on the command line:
	 ./test_script 
	
	
	TESTS AND OUTPUT

A text file is used as an easy way to generate objects to be used both as values and as keys. I wanted to be sure that the implementation would work with keys generated based on real objects, and that the values stored could also be real objects. 
Using a text file also makes it very easy to swap out different tests. 
The main class reads in strings word-by-word, and every even-index word (starting at i==0) is used as a key; the following odd-index word  is used as its value. 

When the program is run, it will run 3 tests: 
	First, it will load in all the words and insert them into a HashMap. 
	Then, it will retrieve each of the entries by key. 
	Finally, it will delete each of the entries by key. 
Each test will print out the elapsed time and the final load of the hash map. For the “GET TEST” this should be the same as before the test. For the “DELETE TEST” this should be 0.
The output is printed to the stdout. 

