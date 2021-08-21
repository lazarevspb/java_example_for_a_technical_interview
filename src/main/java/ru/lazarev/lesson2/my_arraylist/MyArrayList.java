package ru.lazarev.lesson2.my_arraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayList<T> {

  private final int DEFAULT_CAPACITY = 10;
  Object[] array = new Object[DEFAULT_CAPACITY];
  private int pointer;

  public int size() {
    return (int) Arrays.stream(array).filter(Objects::nonNull).count();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public boolean contains(Object T) {
    return Arrays.asList(array).contains(T);
  }

  public Iterator<T> iterator() {
    return new ListIterator();
  }

  public Object[] toArray() {
    return Arrays.stream(array).filter(Objects::nonNull).toArray();
  }

  public boolean add(T o) {
    if (pointer != array.length) {
      addElement(o);
      return true;
    } else if (pointer == array.length) {
      increasingTheArray();
      addElement(o);
      return true;
    }
    return false;

  }

  private void addElement(T o) {
    array[pointer] = o;
    pointer++;
  }

  private void increasingTheArray() {
    Object[] newArray = new Object[array.length * 2];
    System.arraycopy(array, 0, newArray, 0, pointer - 1);
    array = newArray;
  }

  public boolean remove(Object o) {
    for (int i = 0, listSize = array.length; i < listSize; i++) {
      if (o.equals(array[i])) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  public void remove(int index) {
    checkCapacity(index);

    T obj = get(index);

    Object[] tempArray = new Object[array.length];

    if (index >= 0) {
      System.arraycopy(array, 0, tempArray, 0, index);
    }
    if (size() - index >= 0) {
      System.arraycopy(array, index + 1, tempArray, index, size() - index);
    }
    array = tempArray;
  }

  private void checkCapacity(int index) {
    if (size() < index || index < 0) {
      throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
    } else {
      if (size() == array.length) {
        riseArray();
      }
    }
  }

  private void riseArray() {
    Object[] tempArray;
    tempArray = array;
    array = new Object[array.length + array.length / 2];
    System.arraycopy(tempArray, 0, array, 0, tempArray.length);
  }


  public boolean addAll(int index, Collection<? extends T> c) {
    Object[] subArray = c.toArray();
    if (subArray.length == 0) {
      return false;
    }
    for (int i = 0; i < c.size(); i++) {
      add(index, (T) subArray[i]);
      index++;
    }
    return true;
  }

  public T get(int index) {
    return (T) array[index];
  }


  public void add(int index, T element) {
    if (pointer == array.length - 1) {
      resize(array.length << 1);
    }
    array[pointer++] = element;
  }

  private void resize(int newLength) {
    Object[] newArray = new Object[newLength];
    System.arraycopy(array, 0, newArray, 0, pointer);
    array = newArray;
  }

  private class ListIterator implements Iterator<T> {


    private int currentIndex;

    @Override
    public boolean hasNext() {
      return currentIndex < size();
    }

    @Override
    public T next() {
      return (T) array[currentIndex++];
    }
  }
}
