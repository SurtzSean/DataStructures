Name: Sean Surtz
CSU ID: 2708486
Assignment 5

Compiling Instructions:
1 in terminal, navigate to the sesurtz_hw5 folder
2 enter 'javac Test.java' to compile
3 to run, enter 'java Test' in terminal

Sample run: 
Array Queue time: 4 milliseconds
Linked List Queue time: 7 milliseconds


Known bugs:
None

Analysis:
For this, the Linked list queue run time is on average slower than the Array Queue run time.
The add and remove methods on both the ArrayQueue and LLQueue should have a runtime both of O(1).
However, the LLQueue has more total primitive operations preformed.  Along with that, all the information in
arrayqueue is stored next to eachother and the storage is allocated before the loop is preformed so that would
probably make it faster.