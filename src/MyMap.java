import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * A simple array-based implementation of the {@link java.util.Map} interface.
 * This class serves as a standalone Java code exercise, demonstrating basic
 * map operations such as putting, getting, and removing key-value pairs.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class MyMap implements Map {

  private Object[] k = new Object[1000];
  private Object[] v = new Object[1000];
  private int index = 0;
  private int size = 0;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean containsKey(Object key) {
    int i = 0;
    for (; i < size; i++) {
      if (k[i].equals(key)) {
        break;
      }
    }
    return i < size;
  }

  @Override
  public boolean containsValue(Object value) {
    int i = 0;
    for (; i < size; i++) {
      if (v[i].equals(value)) {
        break;
      }
    }
    return i < size;
  }

  /**
   * Returns the value to which the specified key is mapped.
   */
  @Override
  public Object get(Object key) {
    int i = 0;
    for (; i < size; i++) {
      if (k[i].equals(key)) {
        break;
      }
    }
    return v[i];
  }

  /**
   * Associates the specified value with the specified key in this map.
   */
  @Override
  public Object put(Object key, Object value) {
    if (!containsKey(key)) {
      k[index] = key;
      v[index] = value;
      index++;
      size++;
      return null;
    } else {
      Object x = get(key);
      int i = 0;
      for (; i < size; i++) {
        if (k[i].equals(key)) {
          break;
        }
      }
      v[i] = value;
      return x;
    }
  }

  /**
   * Removes the mapping for a key from this map if it is present.
   */
  @Override
  public Object remove(Object key) {
    if (!containsKey(key)) {
      return null;
    } else {
      int i = 0;
      for (; i < size; i++) {
        if (k[i].equals(key)) {
          break;
        }
      }
      Object x = v[i];
      for (int j = i; i < size; i++) {
        v[j] = v[j + 1];
        k[j] = k[j + 1];
      }
      size--;
      index--;
      return x;
    }
  }

  @Override
  public void putAll(Map m) {
    MyMap x = (MyMap) m;
    for (int i = 0; i < m.size(); i++) {
      this.put(x.k[i], x.v[i]);
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < size; i++) {
      v[i] = null;
      k[i] = null;
    }
    index = 0;
    size = 0;
  }

  @Override
  public Set keySet() {
    MySet x = new MySet();
    for (int i = 0; i < this.size; i++) {
      x.add(k[i]);
    }
    return x;
  }

  @Override
  public Collection values() {
    MyList x = new MyList();
    for (int i = 0; i < size; i++) {
      x.add(v[i]);
    }
    return x;
  }

  @Override
  public Set entrySet() { // I Have No Clue

    return null;
  }
}
