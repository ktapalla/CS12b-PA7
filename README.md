# README - COSI 12b Programming Assignment 7 

The code provided in this repository contains the solutions to PA7 for COSI 12b - Advanced Programming Techniques in Java. The goal of this assignment is to have implemented an enhanced double linked list data structure useing the ArrayList class, and generics. As this assignment was done for a class, we were limited to using only certain existing Java libraries in our solution. 


## Installation and Execution 

Get the files from GitHub and open your desired application to compile and run Java code. My preferred one is Eclipse. Import the files, and run the program. Normally, I prefer running the program through my computer's terminal, but I was having issues setting it up so that the JUnit test would run, which is why I recommend running it through an application instead. This would allow the user to run the test file included to see that it works, since the solution to the assignment itself has no main method to run. 


## Problem Description - Indexed Double Linked List (IDLL)

The code provided implements a double-linked list with fast accessing through an internal index. The design of the class works as follows: 

### Inner Class - Node<E> 

An inner class called Node<E> is declared and includes the following three data fields: 

* E data - the data associated with the current node 
* Node<E> next - a reference/pointer to the next node 
* Node<E> prev - a reference/pointer to the previous node 

This class also has the following constructors: 

* Node(E elem) - a constructor that creates a node holding elem 
* Node(E elem, Node<E> prev, Node<E> next) - a constructor that creates a node holding elem, with next set as its next node and prev set as its previous node 

### IDLL Class - IDLList<E> 

The class of IDLList<E> includes the declaration of the inner private class Node<E> mentioned above. Furthermore, it also includes the following four data fields: 

* Node<E> head - a reference to the head node of the list (this would be the first node in the list)
* Node<E> tail - a reference to the tail node of the list (this would be the last node in the list) 
* int size - the current size of the list (aka how many nodes are in the list)
* ArrayList<Node<E>> indices - this is an array-based list of references to the nodes of the list 

The following are the methods included to implement funtionality of the indexed double linked list as required by the assignment: 

* public IDLList() - creates an empty double-linked list 
* public boolean add(int index, E elem) - adds elem at position index (counting from wherever the head is); uses the index for fast access 
* public boolean add(E elem) - adds elem at the head (thus making it the first element of the list)
* public boolean append(E elem) - adds elem as the taol of the list (thus making it the last element of the list) 
* public E get(int index) - returns the object at position index form the head, using the index for fast access (Note: indexing starts from 0, so get(0) would return the head element of the list)
* public E getHead() - returns the object at the head 
* public E getTail() - returns the object at the tail 
* public int size() - returns the list size 
* public E remove() - removes and returns the element at the head of the list 
* public E removeLast() - remooves and returns the element at the tail of the list 
* public E removeAt(int index) - removes and returns the element at the index given, index is used for fast access 
* public boolean remove(E elem) - removes the first occurrence of elem in the list and returns true, returns false if elem was not in the list 
* public String toString() - provides a string representation of the list 
