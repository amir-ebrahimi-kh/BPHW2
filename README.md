# Custom Data Structures in Java

This repository contains standalone implementations of fundamental data structures: a List, Map, and Set. Built from scratch using core Java arrays, these exercises explore the internal mechanics of collection types without relying on the Java Collections Framework.

## Implementation Details

- **MyList**: A sequence mimicking `java.util.List`. It supports sequential access, index-based insertion, and dynamic element removal by shifting elements.
- **MyMap**: An associative array mimicking `java.util.Map`. It maintains key-value pairs using parallel arrays, providing fundamental mapping operations.
- **MySet**: A collection mimicking `java.util.Set` that ensures element uniqueness by internally validating elements against existing entries before insertion.

## Complexity Analysis

The classes use fixed-size arrays under the hood. As such, they rely heavily on linear scans for search and validation, which dictates their performance characteristics.

| Data Structure | Operation | Best Case | Average Case | Worst Case |
| -------------- | --------- | --------- | ------------ | ---------- |
| **MyList**     | Insert    | O(1)      | O(1)         | O(1)*      |
|                | Search    | O(1)      | O(n)         | O(n)       |
|                | Delete    | O(1)      | O(n)         | O(n)       |
| **MyMap**      | Insert    | O(1)      | O(n)         | O(n)       |
|                | Search    | O(1)      | O(n)         | O(n)       |
|                | Delete    | O(1)      | O(n)         | O(n)       |
| **MySet**      | Insert    | O(1)      | O(n)         | O(n)       |
|                | Search    | O(1)      | O(n)         | O(n)       |
|                | Delete    | O(1)      | O(n)         | O(n)       |

*\* Note: Appending to the end of `MyList` is O(1). Inserting at a specific index via `add(index, element)` is O(n) due to shifting elements.*

### Memory and Collision Handling

- **Capacity Management**: These implementations allocate fixed-size arrays (capacity of 1000) at initialization. They do not currently implement dynamic resizing (e.g., allocating a larger array and copying elements) when the capacity is exceeded.
- **Map Mechanics**: Because `MyMap` is implemented as an associative array utilizing a linear scan rather than a true hash table, there are no traditional "hash collisions". Instead, duplicate keys are prevented by executing an O(n) search prior to every insertion; if the key already exists, the associated value is simply overwritten.

## Compilation and Execution

The source files can be compiled directly via the command line without build tools.

1. **Compile the source files:**
   ```bash
   javac src/*.java
   ```

2. **Test the structures:**
   Create a `Main.java` in the root directory to instantiate and test the classes:

   ```java
   public class Main {
       public static void main(String[] args) {
           MyList list = new MyList();
           list.add("First");
           list.add("Second");
           System.out.println("List element 0: " + list.get(0));
       }
   }
   ```

   Compile and run your test file alongside the source files:
   ```bash
   javac -cp src Main.java
   java -cp src:. Main
   ```
