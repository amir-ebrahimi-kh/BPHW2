import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple array-based implementation of the {@link java.util.List} interface.
 * This class serves as a standalone Java code exercise, demonstrating basic
 * list operations such as adding, removing, and retrieving elements.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class MyList implements List {

  private Object[] O = new Object[1000];
  private int index = 0;
  private int size = 0;

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (O[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  public Iterator iterator() {
    return null;
  }

  public Object[] toArray() {
    return O;
  }

  public Object[] toArray(Object[] a) {
    if (size < a.length) {
      for (int i = 0; i < size; i++) {
        a[i] = O[i];
      }
      for (int i = size; i < a.length; i++) {
        a[i] = null;
      }
    } else if (size == a.length) {
      for (int i = 0; i < size; i++) {
        a[i] = O[i];
      }
    } else {
      System.out.println("Not Possible");
    }
    return a;
  }

  /**
   * Appends the specified element to the end of this list.
   */
  @Override
  public boolean add(Object e) {
    this.O[index] = e;
    index++;
    size++;
    return true;
  }

  /**
   * Removes the first occurrence of the specified element from this list, if it is present.
   */
  public boolean remove(Object o) {
    int i = 0;
    for (; i < size; i++) {
      if (O[i].equals(o)) {
        break;
      }
    }
    if (i != size) {
      O[i] = null;
      for (int j = i; j < size; j++) {
        O[j] = O[j + 1];
      }
      index--;
      size--;
      return true;
    }
    return false;
  }

  public boolean containsAll(Collection c) {
    Object[] x = c.toArray();
    boolean flag = false;
    int counter = 0;
    if (size >= c.size()) {
      for (int i = 0; i < c.size(); i++) {
        for (int j = 0; j < size; j++) {
          if (x[i].equals(O[j])) {
            counter++;
          }
        }
      }
      if (counter == c.size()) {
        flag = true;
      }
    } else {
      System.out.println("Not Possible");
    }
    return flag;
  }

  public boolean addAll(Collection c) {
    boolean changed = false;
    Object[] x = c.toArray();
    for (int i = 0; i < x.length; i++) {
      if (true) {
        this.add(x[i]);
        changed = true;
      }
    }
    return changed;
  }

  public boolean addAll(int index, Collection c) {
    boolean flag = false;
    int save = this.index;
    int counter = 0;
    Object[] x = c.toArray();
    counter = c.size();
    for (int i = size - 1; i >= index; i--) {
      O[size + counter] = O[size];
    }
    this.index = index;
    for (int i = 0; i < c.size(); i++) {
      if (true) {
        this.add(x[i]);
      }
    }
    this.index = save + counter;
    return flag;
  }

  public boolean removeAll(Collection c) {
    boolean flag = false;
    for (Object object : O) {
      if (c.contains(object)) {
        this.remove(object);
        flag = true;
      }
    }
    return flag;
  }

  public boolean retainAll(Collection c) {
    boolean flag = false;
    for (Object object : O) {
      if (!c.contains(object)) {
        this.remove(object);
        flag = true;
      }
    }
    return flag;
  }

  public void clear() {
    for (Object object : O) {
      remove(object);
    }
    size = 0;
    index = 0;
  }

  /**
   * Returns the element at the specified position in this list.
   */
  public Object get(int index) {
    return this.O[index];
  }

  public Object set(int index, Object element) {
    Object x = this.O[index];
    this.O[index] = element;
    return x;
  }

  public void add(int index, Object element) {
    for (int i = size; i > index; i--) {
      this.O[i + 1] = this.O[i];
      this.O[index] = element;
    }
    this.index++;
    size++;
  }

  public Object remove(int index) {
    Object x = this.O[index];
    for (int i = index; i < size; i++) {
      this.O[i] = this.O[i + 1];
    }
    this.index--;
    size--;
    return x;
  }

  public int indexOf(Object o) {
    int i = 0;
    for (; i < size; i++) {
      if (O[i].equals(o)) {
        break;
      }
    }
    if (i == size) {
      return -1;
    } else {
      return i;
    }
  }

  public int lastIndexOf(Object o) {
    int i = size - 1;
    for (; i >= 0; i--) {
      if (O[i].equals(o)) {
        break;
      }
    }
    return i;
  }

  public ListIterator listIterator() {
    // TODO Auto-generated method stub
    return null;
  }

  public ListIterator listIterator(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  public MyList subList(int fromIndex, int toIndex) {
    int x = toIndex - fromIndex;
    MyList X = new MyList();
    X.size = x;
    X.index = x;
    for (int i = 0; i < x; i++) {
      X.O[i] = this.O[i + fromIndex];
    }
    return X;
  }
}
