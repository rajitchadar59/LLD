# Prototype Design Pattern

## What is Prototype?

> Prototype is a creational design pattern that creates new objects by copying an existing object instead of creating the object from scratch.

### Simple Meaning

```text
Existing Object
      ↓
   clone()
      ↓
Copied Object
````

Instead of creating every object using `new`, we create one **prototype object** and create new objects by cloning it.

---

# Real World Example

Suppose a college needs ID cards for many students.

An ID card contains:

```text
College Name
Branch
Year
Name
```

Most information is common:

```text
College → Jabalpur Engineering College
Branch  → CSE
Year    → 3rd Year
```

Only the student's name changes.

Instead of creating every ID card from scratch, we can create one ID card as a **Prototype** and clone it.

```text
              ID Card Prototype
                     ↓
                   clone()
            ┌────────┼────────┐
            ↓        ↓        ↓
          Rajit     Aman     Rohit
```

---

# Without Prototype Pattern

Without Prototype Pattern, we create every ID card using `new`.

```text
Every Student
      ↓
new IDCard(...)
      ↓
New Object
```

### Example

```java
IDCard rajit = new IDCard(
        "Jabalpur Engineering College",
        "CSE",
        "3rd Year",
        "Rajit"
);

IDCard aman = new IDCard(
        "Jabalpur Engineering College",
        "CSE",
        "3rd Year",
        "Aman"
);

IDCard rohit = new IDCard(
        "Jabalpur Engineering College",
        "CSE",
        "3rd Year",
        "Rohit"
);
```

The same information has to be passed again and again.

### Problem

```text
new IDCard(...)
new IDCard(...)
new IDCard(...)
        ↓
Repeated Object Creation
```

If the ID card contains many fields, the constructor becomes more difficult to use.

---

# With Prototype Pattern

First, create one original ID card.

```text
             Prototype
                 ↓
              clone()
                 ↓
       ┌─────────┼─────────┐
       ↓         ↓         ↓
     Rajit      Aman      Rohit
```

### Example

```java
IDCard prototype = new IDCard(
        "Jabalpur Engineering College",
        "CSE",
        "3rd Year",
        ""
);
```

Now clone it:

```java
IDCard rajit = prototype.clone();
rajit.name = "Rajit";

IDCard aman = prototype.clone();
aman.name = "Aman";

IDCard rohit = prototype.clone();
rohit.name = "Rohit";
```

The common information is already present in the prototype.

---

# Complete Example

## IDCard

```java
class IDCard implements Cloneable {

    String college;
    String branch;
    String year;
    String name;

    IDCard(String college, String branch, String year, String name) {

        this.college = college;
        this.branch = branch;
        this.year = year;
        this.name = name;
    }

    public IDCard clone() {

        try {

            return (IDCard) super.clone();

        } catch (CloneNotSupportedException e) {

            throw new RuntimeException(e);
        }
    }

    void display() {

        System.out.println("College : " + college);
        System.out.println("Name    : " + name);
        System.out.println("Branch  : " + branch);
        System.out.println("Year    : " + year);
        System.out.println();
    }
}
```

---

# Main

```java
public class PrototypeWithPattern {

    public static void main(String[] args) {

        // Original object / Prototype
        IDCard prototype = new IDCard(
                "Jabalpur Engineering College",
                "CSE",
                "3rd Year",
                ""
        );

        // Clone prototype
        IDCard rajit = prototype.clone();
        rajit.name = "Rajit";

        IDCard aman = prototype.clone();
        aman.name = "Aman";

        IDCard rohit = prototype.clone();
        rohit.name = "Rohit";

        rajit.display();
        aman.display();
        rohit.display();
    }
}
```

---

# How Prototype Works

```text
Create Original Object
          ↓
       Prototype
          ↓
       clone()
          ↓
     New Object
          ↓
Change Required Fields
          ↓
      Final Object
```

For our ID card:

```text
             Prototype
                 |
                 | college = JEC
                 | branch  = CSE
                 | year    = 3rd Year
                 |
                 ↓
               clone()
                 |
        ┌────────┼────────┐
        ↓        ↓        ↓
      Rajit     Aman     Rohit
```

---

# What is Cloneable?

`Cloneable` is a **marker interface** in Java.

It indicates that an object can be cloned.

```java
class IDCard implements Cloneable {
}
```

### Important

`Cloneable` does **not** contain a `clone()` method.

It simply tells Java that the object is allowed to be cloned using `super.clone()`.

```text
Cloneable
    ↓
Allows cloning
    ↓
super.clone()
    ↓
Object Copy
```

---

# Why do we use `super.clone()`?

`clone()` is originally defined in the `Object` class.

```java
return (IDCard) super.clone();
```

Here:

```text
super.clone()
      ↓
Object class clone()
      ↓
Creates a copy
```

The returned object is cast to `IDCard`.

```java
(IDCard) super.clone()
```

---

# Why `implements Cloneable`?

If a class does not implement `Cloneable` and we call:

```java
super.clone();
```

Java throws:

```text
CloneNotSupportedException
```

Therefore:

```java
class IDCard implements Cloneable
```

allows the object to be cloned.

---

# Prototype Flow

```text
              IDCard
             Prototype
                 ↓
              clone()
                 ↓
       ┌─────────┼─────────┐
       ↓         ↓         ↓
   IDCard      IDCard     IDCard
    Rajit       Aman       Rohit
```

---

# Without Prototype vs With Prototype

| Without Prototype                | With Prototype             |
| -------------------------------- | -------------------------- |
| Create every object from scratch | Create one prototype       |
| Uses `new` repeatedly            | Uses `clone()`             |
| Common values are repeated       | Common values are copied   |
| More object creation code        | Less creation code         |
| Useful for simple objects        | Useful for complex objects |

---

# Main Difference

### Without Pattern

```java
new IDCard(...);
new IDCard(...);
new IDCard(...);
```

### With Prototype

```java
IDCard prototype = new IDCard(...);

IDCard rajit = prototype.clone();
IDCard aman = prototype.clone();
IDCard rohit = prototype.clone();
```

---

# Prototype vs Factory

Both are Creational Design Patterns, but their approach is different.

## Factory Pattern

Factory creates a new object using a factory.

```text
Factory
   ↓
Create
   ↓
New Object
```

Example:

```java
Bike bike = BikeFactory.createBike("honda");
```

---

## Prototype Pattern

Prototype creates a new object by copying an existing object.

```text
Existing Object
      ↓
    clone()
      ↓
New Object
```

Example:

```java
IDCard copy = prototype.clone();
```

### Easy Memory Trick

```text
Factory
   ↓
CREATE


Prototype
   ↓
COPY
```

---

# Key Components

## 1. Prototype

The existing object that will be copied.

```java
IDCard prototype;
```

---

## 2. Clone Method

Used to create a copy.

```java
public IDCard clone() {

    try {
        return (IDCard) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
    }
}
```

---

## 3. Cloneable

Marker interface that allows cloning.

```java
class IDCard implements Cloneable {
}
```

---

## 4. Client

The client uses the prototype to create copies.

```java
IDCard rajit = prototype.clone();
```

---

# When to Use Prototype Pattern?

Prototype Pattern is useful when:

1. Object creation is expensive.
2. Object has many fields.
3. Object has complex configuration.
4. Many objects have similar properties.
5. We can create one object and copy it.
6. Creating objects from scratch repeatedly is unnecessary.

---

# Real World Examples

Prototype Pattern can be useful for:

```text
ID Cards
Documents
Game Characters
UI Components
Configuration Objects
Database Objects
Complex Reports
```

For example:

```text
Original Report
      ↓
    clone()
      ↓
Report for Student 1
Report for Student 2
Report for Student 3
```

---

# Advantages

* Avoids repeated object creation.
* Useful for complex objects.
* Can reduce object creation cost.
* Allows easy copying of existing configurations.
* New objects can be created from a ready-made prototype.

---

# Disadvantages

* Cloning can become complicated for objects containing other objects.
* Deep copy and shallow copy need to be understood.
* `Cloneable` and `clone()` have some Java-specific limitations.
* Not necessary for simple objects.

---

# Shallow Copy

In a shallow copy, primitive values and references are copied, but referenced objects may still be shared.

```text
Original
   |
   └── Address Object
          ↑
          |
       Shared
          |
   └── Clone
```

So both objects can refer to the same nested object.

---

# Deep Copy

In a deep copy, nested objects are also copied.

```text
Original
   |
   └── Address Object

Clone
   |
   └── New Address Object
```

The original and clone have separate nested objects.

---

# Important Note

For simple fields like:

```java
String
int
boolean
double
```

the basic `super.clone()` example is enough to understand the Prototype Pattern.

For objects containing other mutable objects, we need to carefully handle shallow vs deep copying.

---

# Complete Flow

```text
                  PROTOTYPE
                     |
                     ↓
             Existing Object
                     |
                     ↓
                  clone()
                     |
          ┌──────────┼──────────┐
          ↓          ↓          ↓
       Copy 1      Copy 2      Copy 3
          ↓          ↓          ↓
        Rajit       Aman       Rohit
```

---

# Interview Definition

> **Prototype Pattern is a creational design pattern that creates new objects by copying an existing object called a prototype.**

---
