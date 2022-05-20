/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnoGameSimulation;

/**
 *
 * @author Harshilkumar Vaghela 
 * @date October 8,2020(Assignment1)
 */
public class CircularDoublyLinkedList<E> {
    // instance variables of the CircularlyLinkedList
    private static class Node<E> {

        private E element;

        private Node<E> next;
        private Node<E> prev;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            next = n;
            prev=p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
        
        public Node<E> getPrev() {
            return prev;
        }
        
        public void setPrev(Node<E> p) {
            prev = p;
        }
        
        public void setNext(Node<E> n) {
            next = n;
        }
    } 
     
        private Node<E>tailer =null;
        // we store tail (but not head)
    private int size = 0; // number of nodes in the list
    public CircularDoublyLinkedList( ) { 
        
    } // constructs an initially empty list
    // access methods
    public int size( ) { return size; }

    public boolean isEmpty( ) { return size == 0; }

    public E first( ) { // returns (but does not remove) the first element
        if (isEmpty( )) return null;
        return tailer.getNext().getElement( ); // the head is *after* the tail
    }

    public E last( ) { // returns (but does not remove) the last element
        if (isEmpty( )) return null;
        return tailer.getElement( );
    }
    // update methods
    public void rotateForward( ) { // rotate the first element to the back of the list
        if (tailer != null) // if empty, do nothing
            tailer = tailer.getNext( ); // the old head becomes the new tail
    }
    
    public void rotateReverse( ) { // rotate the first element to the back of the list
        if (tailer != null) // if empty, do nothing
            tailer = tailer.getPrev( ); // the old head becomes the new tail
    }
    
    
    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tailer = new Node<>(e, null,null);
            tailer.setNext(tailer);tailer.setPrev(tailer); // link to itself circularly
        } 
        if(size==1){
            Node<E> newest=new Node<>(e,tailer,tailer);
            tailer.setNext(newest);tailer.setPrev(newest);
        }
        else {
            Node<E> newestNext=tailer.getNext();
            Node<E> newest = new Node<>(e,tailer, newestNext);
            tailer.setNext(newest);newestNext.setPrev(newest);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tailer = tailer.getNext( ); // now new element becomes the tail
    }

    public E removeFirst( ) { // removes and returns the first element
        if (isEmpty( )) return null; // nothing to remove
        Node<E> head = tailer.getNext( );
        if (head == tailer) tailer = null; // must be the only node left
        else tailer.setNext(head.getNext( )); // removes ”head” from the list
        size--;
        return head.getElement( );
    }
 }
