package ru.lazarev.lesson2.my_linkedlist;

public class Node<E> {

  Node<E> previous;
  Node<E> next;
  Object data;

  public Node() {
  }

  public void setPrevious(Node<E> previous) {
    this.previous = previous;
  }



  public void setNext(Node<E> next) {
    this.next = next;
  }


  public void setData(Object data) {
    this.data = data;
  }
}

