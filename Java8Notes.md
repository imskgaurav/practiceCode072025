#Java 8 Features
1.Lambda Expressions
2.Stream API
3.Default Methods in Interfaces
4.Method References
5.Optional Class
6.Date and Time API
7.Functional Interfaces
8.Nashorn JavaScript Engine
9.Repeatable Annotations
10.Type Annotations
11.Parallel Arrays
12.Base64 Encoding and Decoding
13.Concurrency Improvements
14.Collection Enhancements
15.File I/O Improvements (NIO.2)
16.Improved Type Inference
17.Compact Profiles
18.JVM Improvements
19.Garbage Collection Improvements
20.JIT Compiler Improvements
21.Security Enhancements
22.Miscellaneous Improvements
##1.Lambda Expressions>>
Introduced functional programming in Java.
Example
(a,b) -> a + b //Lambda expression for addition
##2.Stream API>>
Facilitates functional-style operations on collections.
Example
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());   
list.stream().filter(x -> x <10).forEach(System.out::println);
>>Functional Interfaces
> An interface with a single abstract method.
> Can have multiple default or static methods.
> Used as the basis for lambda expressions.
> Common functional interfaces in Java 8:
  - `java.util.function.Predicate<T>`: Represents a boolean-valued function of one argument.
  - `java.util.function.Function<T, R>`: Represents a function that takes an argument
  >>Example: Runnable, Callable, Comparator, and new ones like Predicate, Function, Consumer.
> Default Methods in Interfaces
  > Allows adding new methods to interfaces without breaking existing implementations.
  > Methods can have a default implementation.
  >>Example:
  > interface MyInterface {
  >     default void defaultMethod() {
  >         System.out.println("This is a default method");
  >     }
  > }
  > }
>>Method References
> A shorthand notation of a lambda expression to call a method.
  > Can refer to static methods, instance methods, or constructors.
  >>Example:
  > // Static method reference
  > List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  > names.forEach(System.out::println);
  > // Instance method reference
  > List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  > names.sort(String::compareToIgnoreCase);
  > // Constructor reference
  > Supplier<List<String>> listSupplier = ArrayList::new;
  > List<String> list = listSupplier.get();
>>Optional Class
> A container object which may or may not contain a non-null value.
> Helps to avoid null checks and NullPointerExceptions.
>>Example:
> Optional<String> optional = Optional.of("Hello");
> optional.ifPresent(System.out::println); // Prints "Hello"
> String value = optional.orElse("Default Value"); // Returns "Hello"
> Optional<String> emptyOptional = Optional.empty();
> String defaultValue = emptyOptional.orElse("Default Value"); // Returns "Default Value"
>>Date and Time API
> A new set of classes in the `java.time` package to handle date and time.
  > More comprehensive and easier to use than the old `java.util.Date` and `java.util.Calendar`.
  > Immutable and thread-safe.
  > Example classes: `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Duration`, `Period`.
  > Example:
  > LocalDate date = LocalDate.now();
  > LocalDateTime dateTime = LocalDateTime.of(2023, Month.JANUARY, 1, 10, 30);
  > ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
  > Duration duration = Duration.between(startTime, endTime);
  > Period period = Period.between(startDate, endDate);
>>Parallel Arrays:
  > Introduced the `Arrays.parallelSort()` method for parallel sorting of arrays.
  > Utilizes multiple threads for sorting, improving performance on large datasets.
  >>Example:
  > int[] array = {5, 3, 8, 1, 2};
  > Arrays.parallelSort(array);
  > System.out.println(Arrays.toString(array)); // Output: [1, 2, 3, 5, 8]
  > String[] stringArray = {"banana", "apple", "orange"};
  > Arrays.parallelSort(stringArray);
  > System.out.println(Arrays.toString(stringArray)); // Output: [apple, banana, orange]

>>Concurrency Improvements::
> Introduced `CompletableFuture` for asynchronous programming.
> Enhancements to the `ForkJoinPool` for better performance in parallel tasks.
> New methods in `java.util.concurrent` package for better thread management.
>>Example:
> CompletableFuture.supplyAsync(() -> {
>     // Simulate a long-running task
>     try { Thread.sleep(2000); } catch (InterruptedException e)  { e.printStackTrace(); }   
>    return "Hello, World!";    
> }).thenAccept(result -> {
>     System.out.println(result); // Prints "Hello, World!" after 2 seconds
> });
>>Collection Enhancements::
> New methods in the `Collection` interface for better manipulation of collections.
> Examples include `forEach()`, `removeIf()`, `replaceAll()`, and `sort()`. 
> >>Example:
> List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));  
> list.forEach(System.out::println); // Prints each element
> list.removeIf(s -> s.startsWith("b")); // Removes "banana"
> list.replaceAll(String::toUpperCase); // Converts all elements to uppercase
> list.sort(String::compareTo); // Sorts the list
> System.out.println(list); // Output: [APPLE, CHERRY]  
*****Collection Enhancements Example:*****
Good one 👍
Java 8 brought **big enhancements to Collections** — mostly through **Streams API** and **default methods in Collection interfaces**.
Here’s a clear list:
## 🚀 **Collection Enhancements in Java 8**
### 1. **Streams API**
* Added in `java.util.stream`.
* Works on collections to process data in a **functional style**.
* Operations:
    * **Intermediate** → `map()`, `filter()`, `sorted()`, `distinct()`, `limit()`, `skip()`
    * **Terminal** → `forEach()`, `collect()`, `reduce()`, `count()`, `min()`, `max()`
* Example:
  ```java
  List<String> names = Arrays.asList("A", "BB", "CCC");
  ##names.stream().filter(s -> s.length() > 1)
.forEach(System.out::println); // prints BB, CCC
  ### 2. **New Methods in `Collection` Interface**
* **`forEach()`** → Iterate with lambda.
  ```java
  list.forEach(item -> System.out.println(item));
* **`removeIf(Predicate)`** → Remove elements conditionally.
  ```java
list.removeIf(n -> n < 0); // remove negative numbers
  ```
* **`spliterator()`** → Supports parallel processing.

  ```java
  Spliterator<String> sp = list.spliterator();
  sp.forEachRemaining(System.out::println);
  ```

---

### 3. **New Methods in `Map` Interface**
* **`forEach(BiConsumer)`**
  map.forEach((k,v) -> System.out.println(k + " = " + v));
  ```
* **`getOrDefault(key, defaultValue)`**

  ```java
  String val = map.getOrDefault("X", "Not Found");
  ```
* **`putIfAbsent(key, value)`**
  ```java
map.putIfAbsent("A", "Alpha");`
* **`remove(key, value)`** → removes only if key maps to given value.
* **`replace(key, value)` / `replace(key, oldValue, newValue)`**
* **`compute()`, `computeIfAbsent()`, `computeIfPresent()`**

  ```java
map.computeIfAbsent("B", k -> k + "eta"); // adds "B" -> "Beta"
  ```
* **`merge()`**
  ```java
  map.merge("A", 1, Integer::sum);
  ```
### 4. **Collectors (with Streams)**
* Convert streams back to collections.
* Examples:

  ```java
  List<String> list = names.stream().collect(Collectors.toList());
  Set<String> set   = names.stream().collect(Collectors.toSet());
  Map<Integer, String> map = names.stream()
                                  .collect(Collectors.toMap(String::length, s -> s));
  ```

---

### 5. **Parallel Streams**
* Process collections in parallel for performance.
  ```java list.parallelStream().forEach(System.out::println);
  ```
---

✅ **Summary:**
Java 8 made collections **smarter** with:
* **Streams API** for functional-style processing.
* **Default methods** in `Collection` & `Map` (`forEach`, `removeIf`, `putIfAbsent`, etc.).
* **Collectors** for aggregations.
* **Parallel streams** for multi-core processing.
>>>>The execution time varies each run due to factors like:((Refer Program: LoopsPerformance.java))
- **JVM Warm-up:** The Java Virtual Machine optimizes code during execution (JIT compilation), so initial runs may be slower.
- **System Load:** Other processes on your computer can affect CPU and memory availability.
- **Garbage Collection:** Java's automatic memory management may trigger at different times.
- **Caching:** Data or code may be cached differently between runs.
These factors cause small timing differences, even for the same code. For more accurate benchmarking, use tools like JMH (Java Microbenchmark Harness).