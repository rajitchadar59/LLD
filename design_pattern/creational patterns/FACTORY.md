
# Factory Design Pattern

## What is Factory Pattern?

> Factory Pattern is a creational design pattern used to create objects without exposing the object creation logic to the client.

### Simple Meaning

```text
Client
  ↓
Factory
  ↓
Required Object
````

The client tells the Factory which type of object it needs, and the Factory creates and returns that object.

---

# Problem

Suppose we have a `Bike` interface.

```java
interface Bike {

    void start();
}
```

We have different types of bikes:

```text
                    Bike
                      |
        ┌─────────────┼─────────────┐
        ↓             ↓             ↓
      Honda         Yamaha      RoyalEnfield
                                      |
                                      ↓
                                     KTM
```

Each Bike provides its own implementation of `start()`.

```java
class Honda implements Bike {

    public void start() {
        System.out.println("Honda bike started");
    }
}
```

Similarly, we have:

```text
Honda
Yamaha
RoyalEnfield
KTM
```

Now suppose the user gives a bike type:

```java
String type = "honda";
```

We need to create the correct Bike object based on this type.

---

# Without Factory Pattern

Without Factory Pattern, the client itself handles object creation.

```text
User Input
    ↓
   type
    ↓
  Main
    ↓
 if-else
    ↓
┌───┼───────────────┐
↓   ↓               ↓
new Honda()       new Yamaha()
new KTM()         new RoyalEnfield()
```

### Example

```java
String type = "honda";

Bike bike;

if (type.equals("honda")) {

    bike = new Honda();

} else if (type.equals("yamaha")) {

    bike = new Yamaha();

} else if (type.equals("royalenfield")) {

    bike = new RoyalEnfield();

} else if (type.equals("ktm")) {

    bike = new KTM();

} else {

    bike = null;
}
```

Then:

```java
if (bike != null) {
    bike.start();
}
```

---

## Problems Without Factory

### 1. Object creation logic is inside the client

`Main` knows how every Bike object is created.

```text
Main
 ↓
new Honda()
new Yamaha()
new KTM()
new RoyalEnfield()
```

---

### 2. Large if-else

As more Bike types are added, the `if-else` becomes larger.

For example:

```text
Honda
Yamaha
KTM
RoyalEnfield
BMW
Ducati
Suzuki
...
```

---

### 3. Tight Coupling

The client directly depends on concrete classes.

```java
new Honda();
new Yamaha();
new KTM();
```

---

### 4. Creation logic and client logic are mixed

```text
Client Logic
     +
Object Creation Logic
     ↓
    Main
```

This makes the code harder to maintain.

---

# Code

See:

```text
FactoryWithoutPattern.java
```

---

# With Factory Pattern

Factory Pattern moves the object creation logic into a separate class called a **Factory**.

```text
                  Client
                    ↓
              BikeFactory
                    ↓
             createBike()
                    ↓
          ┌─────────┼─────────┐
          ↓         ↓         ↓
        Honda     Yamaha      KTM
```

Now the client does not directly create the Bike object.

Instead:

```java
Bike bike = BikeFactory.createBike("honda");
```

---

# Flow

```text
Client
  ↓
BikeFactory
  ↓
createBike("honda")
  ↓
new Honda()
  ↓
Honda Object
  ↓
bike.start()
```

---

# How Factory Works

## 1. Bike Interface

The `Bike` interface defines the common behavior.

```java
interface Bike {

    void start();
}
```

The client can use the common `Bike` type instead of depending directly on Honda, Yamaha, etc.

---

# 2. Concrete Classes

Different Bike classes implement the `Bike` interface.

### Honda

```java
class Honda implements Bike {

    public void start() {
        System.out.println("Honda bike started");
    }
}
```

### Yamaha

```java
class Yamaha implements Bike {

    public void start() {
        System.out.println("Yamaha bike started");
    }
}
```

### RoyalEnfield

```java
class RoyalEnfield implements Bike {

    public void start() {
        System.out.println("Royal Enfield bike started");
    }
}
```

### KTM

```java
class KTM implements Bike {

    public void start() {
        System.out.println("KTM bike started");
    }
}
```

---

# 3. BikeFactory

The Factory contains the object creation logic.

```java
class BikeFactory {

    public static Bike createBike(String type) {

        if (type.equals("honda")) {

            return new Honda();

        } else if (type.equals("yamaha")) {

            return new Yamaha();

        } else if (type.equals("royalenfield")) {

            return new RoyalEnfield();

        } else if (type.equals("ktm")) {

            return new KTM();
        }

        return null;
    }
}
```

---

# 4. Client

Now the client only asks the Factory for the required Bike.

```java
public class Main {

    public static void main(String[] args) {

        Bike bike = BikeFactory.createBike("honda");

        if (bike != null) {
            bike.start();
        }
    }
}
```

The client does not write:

```java
new Honda();
```

Instead:

```java
BikeFactory.createBike("honda");
```

---

# Why is createBike() Static?

We have:

```java
public static Bike createBike(String type)
```

Because it is `static`, we can call it directly using the class name:

```java
BikeFactory.createBike("honda");
```

We do not need to create a `BikeFactory` object first.

Without `static`:

```java
BikeFactory factory = new BikeFactory();

Bike bike = factory.createBike("honda");
```

With `static`:

```java
Bike bike = BikeFactory.createBike("honda");
```

So:

```text
static method
     ↓
ClassName.method()
     ↓
BikeFactory.createBike()
```

---

# Why is start() Non-Static?

`start()` is a normal non-static method:

```java
void start();
```

It is called using the actual Bike object:

```java
bike.start();
```

The Factory returns an actual object:

```java
return new Honda();
```

So:

```java
Bike bike = BikeFactory.createBike("honda");
```

means:

```text
Bike reference
      ↓
Honda object
```

Then:

```java
bike.start();
```

calls the `Honda` implementation of `start()`.

---

# Interface Reference vs Object

This:

```java
Bike bike = new Honda();
```

does NOT mean that an interface object is created.

It means:

```text
Reference Type → Bike
Actual Object  → Honda
```

Similarly:

```java
Bike bike = BikeFactory.createBike("honda");
```

means:

```text
Bike reference
      ↓
Honda object
```

The interface itself cannot be directly instantiated:

```java
Bike bike = new Bike();   // ❌
```

But an implementation can be assigned to an interface reference:

```java
Bike bike = new Honda();  // ✅
```

---

# Important Point About `new`

Factory Pattern does **not** remove the `new` keyword.

The `new` keyword is still used.

The difference is **where the object is created**.

## Without Factory

```java
Bike bike = new Honda();
```

The client creates the object.

```text
Client
  ↓
new Honda()
```

---

## With Factory

```java
Bike bike = BikeFactory.createBike("honda");
```

The Factory creates the object:

```java
return new Honda();
```

```text
Client
  ↓
Factory
  ↓
new Honda()
```

So the main idea is:

> **Object creation responsibility is moved from the client to the Factory.**

---

# Complete Architecture

```text
                         Bike
                           |
             ┌─────────────┼─────────────┐
             ↓             ↓             ↓
           Honda         Yamaha      RoyalEnfield
                                          |
                                          ↓
                                         KTM

                           ↑
                           |
                      BikeFactory
                           ↑
                           |
                         Client
```

---

# Without Factory vs With Factory

## Without Factory

```text
Main
 ↓
if-else
 ↓
new Honda()
new Yamaha()
new RoyalEnfield()
new KTM()
```

The client is responsible for creating objects.

---

## With Factory

```text
Main
 ↓
BikeFactory
 ↓
createBike("honda")
 ↓
Honda object
```

The Factory is responsible for creating objects.

---

# Comparison

| Without Factory                             | With Factory                           |
| ------------------------------------------- | -------------------------------------- |
| Client creates objects                      | Factory creates objects                |
| Creation logic is inside client             | Creation logic is inside Factory       |
| Client uses `new Honda()`                   | Client uses `BikeFactory.createBike()` |
| Client directly depends on concrete classes | Client mainly works with `Bike`        |
| Creation logic can become large             | Creation logic is centralized          |
| Object creation and client logic are mixed  | Object creation is separated           |
| Harder to change creation logic             | Easier to change creation logic        |

---

# Key Components

## 1. Product

The common interface that defines the behavior.

```java
interface Bike {

    void start();
}
```

---

## 2. Concrete Products

The actual classes that implement the product interface.

```text
Honda
Yamaha
RoyalEnfield
KTM
```

Example:

```java
class Honda implements Bike {

    public void start() {
        System.out.println("Honda bike started");
    }
}
```

---

## 3. Factory

The class responsible for creating objects.

```java
class BikeFactory {

    public static Bike createBike(String type) {

        if (type.equals("honda")) {
            return new Honda();
        }

        if (type.equals("yamaha")) {
            return new Yamaha();
        }

        return null;
    }
}
```

---

## 4. Client

The client requests an object from the Factory.

```java
Bike bike = BikeFactory.createBike("honda");
```

---

# When to Use Factory Pattern?

Factory Pattern is useful when:

1. There are multiple types of related objects.
2. The exact object depends on some input or condition.
3. Object creation logic is becoming complex.
4. We want to separate object creation from client logic.
5. The client should work with an abstraction such as an interface.
6. We want to centralize object creation.

---

# Advantages

* Centralizes object creation.
* Separates object creation from client logic.
* Reduces direct dependency on concrete classes in the client.
* Makes creation logic easier to maintain.
* Makes the client code cleaner.
* Makes it easier to organize creation of multiple related objects.

---

# Disadvantages

* Adds an extra Factory class.
* Factory may become large when many object types are added.
* A large `if-else` or `switch` can make the Factory itself difficult to maintain.
* For very simple object creation, Factory may add unnecessary code.

---

# Real-World Examples

Factory Pattern can be useful for creating:

```text
Bike
Car
Payment
Notification
Database Connection
Logger
Shape
```

For example:

```text
PaymentFactory
      ↓
 ┌────┼────┐
 ↓    ↓    ↓
UPI  Card  Cash
```

Or:

```text
NotificationFactory
      ↓
 ┌────┼─────┐
 ↓    ↓     ↓
Email SMS  Push
```

---

# Example

Suppose the user wants a Honda bike.

## Without Factory

```java
Bike bike = new Honda();

bike.start();
```

The client directly creates Honda.

---

## With Factory

```java
Bike bike = BikeFactory.createBike("honda");

bike.start();
```

The Factory creates Honda.

---

# Main Benefit

The most important idea is:

```text
Without Factory

Client
  ↓
Creates Object


With Factory

Client
  ↓
Requests Object
  ↓
Factory
  ↓
Creates Object
```

The client does not need to know the detailed object creation logic.

---

# Interview Definition

> **Factory Pattern is a creational design pattern that centralizes object creation and allows the client to create objects without directly handling their creation logic.**

---

# Easy Memory Trick

```text
MULTIPLE RELATED OBJECTS
          ↓
    OBJECT CREATION
          ↓
        FACTORY
          ↓
    REQUIRED OBJECT
```

Remember:

```text
Client
  ↓
Factory
  ↓
Object
```
