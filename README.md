# Tower-of-Hanoi
<br>
Author - Taniya Adhikari
<br>
<h1>Project Overview</h1>
The Tower of Hanoi is a classic problem that involves moving a set of disks from one peg to another, following specific rules. This project will implement the Tower of Hanoi algorithm and display the process visually using Java's Swing library for the GUI.
<br>
<h1>Steps to Solve Tower of Hanoi using Recursion:</h1>
<br>
<h4>Base Case:</h4>
If there is only one disk (n = 1), simply move it from the source peg to the destination peg.<br>
<h4>Recursive Case:</h4>
Move n-1 disks from the source peg to the auxiliary peg using the destination peg as auxiliary.<br>
Move the nth disk from the source peg to the destination peg.<br>
Move n-1 disks from the auxiliary peg to the destination peg using the source peg as auxiliary.
<br>
<h1>Running the Code:</h1>
1. Compile and run the TowerOfHanoi.java / TowerOfHanoiGUI.java file.
<br>
2. Adjust numberOfDisks in main to change the number of disks.
