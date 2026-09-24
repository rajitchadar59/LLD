# Singleton Design Pattern

## What is Singleton?

> Singleton Pattern ensures that a class has only one instance throughout the application and provides a single access point to that instance.

### Simple Meaning

```text
Only ONE object of the class
          ↓
All users/services get
the SAME object
```

---

# Without Singleton Pattern

In the normal approach, the constructor is accessible.

So every time we use `new`, a new object is created.

```text
new DatabaseService() → Object 1
new DatabaseService() → Object 2
new DatabaseService() → Object 3
```

Therefore:

```text
service1 != service2
service2 != service3
```

### Code

See `WithoutSingleton.java`.

---

# With Singleton Pattern

In Singleton:

1. Constructor is `private`.
2. One static instance is maintained.
3. `getInstance()` returns that same instance.
4. The object is created only when it is needed.

```text
getInstance()
      ↓
Is instance null?
   /          \
 Yes           No
  ↓             ↓
Create       Return
Object       Same Object
  \            /
   \----------/
```

### Code

See `WithSingleton.java`.

---

# Comparison

| Without Singleton | With Singleton |
|---|---|
| Constructor can be called directly | Constructor is private |
| `new` creates a new object every time | `getInstance()` returns the same object |
| Multiple instances possible | Only one instance |
| `service1 == service2` → `false` | `service1 == service2` → `true` |

---

# Example

Suppose three services need the database service:

```java
DatabaseService service1 = DatabaseService.getInstance();
DatabaseService service2 = DatabaseService.getInstance();
DatabaseService service3 = DatabaseService.getInstance();
```

All three references point to the same object:

```text
              DatabaseService
                    ↑
        ┌───────────┼───────────┐
        │           │           │
     service1    service2    service3
        │           │           │
        └───────────┴───────────┘
              SAME OBJECT
```

---

# Key Components

## 1. Private Constructor

```java
private DatabaseService() {
}
```

Prevents direct object creation:

```java
new DatabaseService(); // ❌
```

## 2. Static Instance

```java
private static DatabaseService instance;
```

Stores the single object.

## 3. getInstance()

```java
public static DatabaseService getInstance()
```

Provides the single access point to the object.

---

# Interview Definition

> **Singleton is a creational design pattern that ensures a class has only one instance and provides a global access point to that instance.**

---

# Easy Memory Trick

```text
PRIVATE CONSTRUCTOR
        ↓
No direct new
        ↓
STATIC INSTANCE
        ↓
One shared object
        ↓
getInstance()
        ↓
Same object every time
```
