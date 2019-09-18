Name: Sean Surtz
CSU ID: 2708486
Assignment 6

Compiling Instructions:
1 in terminal, navigate to the sesurtz_hw6 folder with the cd command
2 enter 'javac Test.java' to compile
3 to run, enter 'java Test' in terminal

Sample run: 
ALPQueue
Insert 5000 entries: 0
Remove 5000 entries: 69
Heap
Insert 5000 entries: 3
Remove 5000 entries: 8


Known bugs:
None

Analysis:
ALPQueue insert is slightly faster than HeapPqueue insert.  This makes sense since heapqueue insert takes O(log(n))
and ALPQueue insert takes O(1)  However, HeapPQueue's remove time is significantly faster.  With 5000 entries, the remove time
is roughly 4x faster on average.  This is because the heapPQueue's remove method takes O(log(n)) runtime whereas the ALPQueue
takes O(n).  The larger the number inputted, the larger the difference would be.  Since HeapPQueue is a binary tree, it can remove
items much faster as it does not have to cycle through each item.