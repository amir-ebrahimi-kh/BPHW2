# Java Data Structures Exercises

This repository contains standalone Java exercises demonstrating custom, array-based implementations of basic data structures. These exercises are written to be clean, simple, and dependency-free.

## Included Exercises

- **MyList.java**: An array-based implementation of the `java.util.List` interface, demonstrating dynamic list operations like appending, removing, and indexing elements.
- **MyMap.java**: An array-based implementation of the `java.util.Map` interface, demonstrating basic key-value pair operations such as putting, getting, and removing values based on unique keys.
- **MySet.java**: An array-based implementation of the `java.util.Set` interface, demonstrating operations that ensure element uniqueness when adding or removing elements.

## How to Compile and Run

These files can be compiled using standard command-line tools without the need for an IDE or build system (like Maven or Gradle).

1. **Compile the source files:**

   ```bash
   javac src/*.java
   ```

   This will generate the compiled `.class` files in the `src/` directory alongside the `.java` source files.

2. **Use the classes:**

   You can write your own `Main.java` file in the root directory to test the implementations:

   ```java
   // Main.java
   public class Main {
       public static void main(String[] args) {
           MyList list = new MyList();
           list.add("Hello");
           list.add("World");
           System.out.println(list.get(0) + " " + list.get(1));
       }
   }
   ```

   Then compile and run your test file alongside the source files:

   ```bash
   javac -cp src Main.java
   java -cp src:. Main
   ```
