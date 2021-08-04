package ru.lazarev.lesson2.my_linkedlist;

public class MyLinkedList<T> {

  private Node<T> first;
  private Node<T> last;
  private int size;

  public void add(T e) {


    Node<T> node = new Node<>();
    if (first == null) {
      node.setNext(null);
      node.setData(e);
      node.setPrevious(null);
      first = node;
      last = node;

    } else {
      node.setPrevious(last);
      node.setNext(null);
      node.setData(e);

      last.setNext(node);
      last = node;
    }
    size++;
  }

  public int size() {
    return size;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size) {
      try {
        throw new Exception();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public T get(int index) {
    rangeCheck(index);
    Node<T> temp = node(index);
    if (temp != null) {
      return (T) temp.data;
    }
    return null;
  }

  public Node<T> node(int index) {
    Node<T> temp = null;
    if (first != null) {
      temp = first;
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    }
    return temp;
  }

  public void remove(int index) {
    Node<T> tempNode = node(index);
    if (tempNode != null) {
      tempNode.previous.next = tempNode.next;
      tempNode.next.previous = tempNode.previous;
      size--;
    }
  }
}