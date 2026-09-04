import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * A simple array-based implementation of the {@link java.util.Set} interface.
 * This class serves as a standalone Java code exercise, demonstrating basic
 * set operations such as adding elements while ensuring uniqueness, and removing elements.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class MySet implements Set {
  private int size;
  private int index;
  private Object[] O = new Object[1000];

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (O[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object[] toArray() {
    return O;
  }

  @Override
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
   * Adds the specified element to this set if it is not already present.
   */
  @Override
  public boolean add(Object e) {
    int i = 0;
    for (; i < size; i++) {
      if (O[i].equals(e)) {
        break;
      }
    }
    if (i == size) {
      O[index] = e;
      size++;
      index++;
      return true;
    }
    return false;
  }

  /**
   * Removes the specified element from this set if it is present.
   */
  @Override
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
        O[i] = O[i + 1];
      }
      index--;
      size--;
      return true;
    }
    return false;
  }

  @Override
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
      flag = false;
      System.out.println("Not Possible");
    }
    return flag;
  }

  @Override
  public boolean addAll(Collection c) {
    boolean setChanged = false;
    Object[] x = c.toArray();
    for (int i = 0; i < c.size(); ) {
      if (this.contains(x[i])) {
        i++;
      } else {
        this.add(x[i]);
        i++;
        setChanged = true;
      }
    }
    return setChanged;
  }

  @Override
  public boolean retainAll(Collection c) {
    boolean setChanged = false;
    for (Object object : this.O) {
      if (!c.contains(object)) {
        this.remove(object);
        setChanged = true;
      }
    }
    return setChanged;
  }

  @Override
  public boolean removeAll(Collection c) {
    boolean setChanged = false;
    for (Object object : this.O) {
      if (c.contains(object)) {
        this.remove(object);
        setChanged = true;
      }
    }
    return setChanged;
  }

  @Override
  public void clear() {
    for (int i = size - 1; i >= 0; i--) {
      remove(O[i]);
    }
    index = 0;
    size = 0;
  }
}
