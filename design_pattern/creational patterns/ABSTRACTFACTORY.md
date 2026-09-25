# Abstract Factory Design Pattern

## What is Abstract Factory?

> Abstract Factory is a creational design pattern used to create families of related objects without directly creating their concrete classes.

### Simple Meaning

```text
Related Products
      ↓
Abstract Factory
      ↓
Product Family
      ↓
Bike + Engine
````

For our example:

```text
Honda Family
    ↓
Honda Bike
Honda Engine
```

```text
Yamaha Family
    ↓
Yamaha Bike
Yamaha Engine
```

```text
Royal Enfield Family
    ↓
Royal Enfield Bike
Royal Enfield Engine
```

```text
KTM Family
    ↓
KTM Bike
KTM Engine
```

---

# Problem

Suppose we have different types of bikes:

```text
Honda
Yamaha
Royal Enfield
KTM
```

Every bike has:

```text
Bike
Engine
```

So each bike belongs to a family of related products.

For example:

```text
Honda Family
    ↓
Honda Bike
Honda Engine
```

Both products belong to Honda.

Similarly:

```text
Yamaha Family
    ↓
Yamaha Bike
Yamaha Engine
```

---

# Product Interfaces

We first create interfaces for our products.

## Bike

```java
interface Bike {

    void start();
}
```

## BikeEngine

```java
interface BikeEngine {

    void engineStart();
}
```

These interfaces provide common behavior for all bikes and engines.

---

# Concrete Products

Now we create different implementations.

## Honda Family

```text
Honda
HondaEngine
```

## Yamaha Family

```text
Yamaha
YamahaEngine
```

## Royal Enfield Family

```text
RoyalEnfield
RoyalEnfieldEngine
```

## KTM Family

```text
KTM
KTMEngine
```

---

# Without Abstract Factory

Without the pattern, the client itself creates the required bike and engine.

```text
Client
  ↓
if-else
  ↓
┌─────────────────────────────┐
│                             │
↓                             ↓
Honda                       Yamaha
↓                             ↓
Honda Bike                 Yamaha Bike
Honda Engine               Yamaha Engine
```

### Example

```java
String type = "honda";

Bike bike;
BikeEngine engine;

if (type.equals("honda")) {

    bike = new Honda();
    engine = new HondaEngine();

} else if (type.equals("yamaha")) {

    bike = new Yamaha();
    engine = new YamahaEngine();

} else if (type.equals("royalenfield")) {

    bike = new RoyalEnfield();
    engine = new RoyalEnfieldEngine();

} else if (type.equals("ktm")) {

    bike = new KTM();
    engine = new KTMEngine();

} else {

    bike = null;
    engine = null;
}
```

Then:

```java
if (bike != null && engine != null) {

    bike.start();
    engine.engineStart();
}
```

---

# Problems Without Abstract Factory

## 1. Client creates concrete objects

The client directly knows:

```java
new Honda();
new HondaEngine();

new Yamaha();
new YamahaEngine();
```

---

## 2. Large if-else

As more bike families are added, the client code becomes larger.

```text
Honda
Yamaha
Royal Enfield
KTM
BMW
Ducati
Suzuki
...
```

---

## 3. Object creation logic is inside the client

```text
Client
   ↓
Object Creation
   ↓
new Honda()
new HondaEngine()
new Yamaha()
new YamahaEngine()
```

The client is responsible for creating the complete product family.

---

## 4. Related products can become mismatched

For example:

```java
Bike bike = new Honda();

BikeEngine engine = new YamahaEngine();
```

This is technically possible, but the products belong to different families.

We want:

```text
Honda
 ↓
Honda Bike + Honda Engine
```

not:

```text
Honda Bike + Yamaha Engine
```

---

# With Abstract Factory

Abstract Factory moves the creation of related products into separate Factory classes.

```text
                 BikeFactory
                      |
          ┌───────────┼───────────┐
          ↓           ↓           ↓
    HondaFactory  YamahaFactory  KTMFactory
          ↓           ↓           ↓
       Honda       Yamaha        KTM
       Family      Family        Family
```

Each factory creates its own complete family.

---

# Abstract Factory Interface

We create an interface called `BikeFactory`.

```java
interface BikeFactory {

    Bike createBike();

    BikeEngine createEngine();
}
```

This factory defines methods for creating:

```text
Bike
Engine
```

---

# Honda Factory

```java
class HondaFactory implements BikeFactory {

    public Bike createBike() {

        return new Honda();
    }

    public BikeEngine createEngine() {

        return new HondaEngine();
    }
}
```

HondaFactory creates:

```text
HondaFactory
     ↓
┌────┴─────┐
↓          ↓
Honda   HondaEngine
```

Both belong to the Honda family.

---

# Yamaha Factory

```java
class YamahaFactory implements BikeFactory {

    public Bike createBike() {

        return new Yamaha();
    }

    public BikeEngine createEngine() {

        return new YamahaEngine();
    }
}
```

YamahaFactory creates:

```text
YamahaFactory
     ↓
┌────┴──────┐
↓           ↓
Yamaha   YamahaEngine
```

---

# Royal Enfield Factory

```java
class RoyalEnfieldFactory implements BikeFactory {

    public Bike createBike() {

        return new RoyalEnfield();
    }

    public BikeEngine createEngine() {

        return new RoyalEnfieldEngine();
    }
}
```

---

# KTM Factory

```java
class KTMFactory implements BikeFactory {

    public Bike createBike() {

        return new KTM();
    }

    public BikeEngine createEngine() {

        return new KTMEngine();
    }
}
```

---

# Client

Now the client does not directly create the concrete Bike or Engine.

```java
BikeFactory factory = new HondaFactory();

Bike bike = factory.createBike();

BikeEngine engine = factory.createEngine();

bike.start();

engine.engineStart();
```

---

# Complete Flow

```text
                         BikeFactory
                              |
              ┌───────────────┼───────────────┐
              ↓               ↓               ↓
       HondaFactory     YamahaFactory     KTMFactory
              ↓               ↓               ↓
       ┌──────┴──────┐ ┌──────┴──────┐ ┌──────┴──────┐
       ↓             ↓ ↓             ↓ ↓             ↓
    Honda       HondaEngine       Yamaha       YamahaEngine
     Bike                          Bike
```

The important point is:

```text
One Factory
     ↓
Complete Related Family
```

---

# How It Works

Suppose we want Honda.

We create:

```java
BikeFactory factory = new HondaFactory();
```

Now `factory` points to:

```text
HondaFactory
```

Then:

```java
Bike bike = factory.createBike();
```

returns:

```text
Honda object
```

And:

```java
BikeEngine engine = factory.createEngine();
```

returns:

```text
HondaEngine object
```

So:

```text
HondaFactory
      ↓
┌─────┴─────┐
↓           ↓
Honda    HondaEngine
```

---

# Important Concept

The main idea of Abstract Factory is:

> **One Factory creates a family of related objects.**

For example:

```text
HondaFactory
     ↓
Honda Bike
Honda Engine
```

```text
YamahaFactory
     ↓
Yamaha Bike
Yamaha Engine
```

---

# Factory Pattern vs Abstract Factory

## Factory Pattern

Our previous Factory Pattern was:

```text
BikeFactory
      ↓
createBike()
      ↓
Honda / Yamaha / KTM
```

Example:

```java
Bike bike = BikeFactory.createBike("honda");
```

It focuses mainly on creating a **Bike**.

---

# Abstract Factory

Abstract Factory creates multiple related products:

```text
HondaFactory
      ↓
┌─────────────┐
↓             ↓
Honda Bike   Honda Engine
```

Example:

```java
BikeFactory factory = new HondaFactory();

Bike bike = factory.createBike();

BikeEngine engine = factory.createEngine();
```

---

# Simple Difference

```text
Factory Pattern

Factory
   ↓
One Product
   ↓
Bike
```

```text
Abstract Factory

Factory
   ↓
Product Family
   ↓
┌──────────────┐
↓              ↓
Bike         Engine
```

---

# Comparison

| Factory Pattern             | Abstract Factory                     |
| --------------------------- | ------------------------------------ |
| Creates one type of product | Creates a family of related products |
| Focuses on one product      | Focuses on multiple related products |
| `BikeFactory` creates Bike  | `HondaFactory` creates Bike + Engine |
| Simpler                     | More complex                         |
| One product hierarchy       | Multiple product hierarchies         |

---

# Key Components

## 1. Abstract Products

These are the product interfaces.

```java
interface Bike {

    void start();
}
```

```java
interface BikeEngine {

    void engineStart();
}
```

---

## 2. Concrete Products

These are actual implementations.

```text
Honda
Yamaha
RoyalEnfield
KTM
```

and:

```text
HondaEngine
YamahaEngine
RoyalEnfieldEngine
KTMEngine
```

---

## 3. Abstract Factory

This defines methods for creating all related products.

```java
interface BikeFactory {

    Bike createBike();

    BikeEngine createEngine();
}
```

---

## 4. Concrete Factories

Each factory creates one complete product family.

```text
HondaFactory
YamahaFactory
RoyalEnfieldFactory
KTMFactory
```

---

## 5. Client

The client uses the Factory interface.

```java
BikeFactory factory = new HondaFactory();

Bike bike = factory.createBike();

BikeEngine engine = factory.createEngine();
```

The client does not need:

```java
new Honda();
new HondaEngine();
```

---

# When to Use Abstract Factory?

Abstract Factory is useful when:

1. There are multiple related products.
2. Products belong to different families.
3. We want to create compatible products together.
4. We want to hide concrete product classes.
5. The client should work with interfaces.
6. We need to switch between complete product families.

---

# Advantages

* Creates related objects as a family.
* Keeps related products together.
* Prevents accidental mixing of product families.
* Hides concrete object creation from the client.
* Reduces direct dependency on concrete classes.
* Makes switching between product families easier.
* Follows programming to interfaces.

---

# Disadvantages

* Requires more classes.
* Requires more interfaces.
* Code becomes more complex.
* Adding a new product type may require changes in every Factory.
* Not useful for very simple object creation.

---

# Real World Idea

The same concept can be used for different vehicle families.

```text
HondaFactory
     ↓
Honda Bike
Honda Engine
```

```text
YamahaFactory
     ↓
Yamaha Bike
Yamaha Engine
```

The Factory ensures that related products come from the same family.

---

# Example

Suppose the user wants a Honda bike.

```java
BikeFactory factory = new HondaFactory();

Bike bike = factory.createBike();

BikeEngine engine = factory.createEngine();

bike.start();

engine.engineStart();
```

Output:

```text
Honda bike started
Honda engine started
```

If we change:

```java
BikeFactory factory = new YamahaFactory();
```

then we get:

```text
Yamaha bike started
Yamaha engine started
```

The client code remains the same.

---

# Main Benefit

```text
Without Abstract Factory

Client
   ↓
Creates Bike
Creates Engine
   ↓
Must know concrete classes
```

With Abstract Factory:

```text
Client
   ↓
Abstract Factory
   ↓
Complete Product Family
   ↓
Bike + Engine
```

---

# Easy Memory Trick

```text
RELATED PRODUCTS
       ↓
PRODUCT FAMILY
       ↓
ABSTRACT FACTORY
       ↓
COMPATIBLE OBJECTS
```

For our Bike example:

```text
Honda Family
     ↓
Honda Bike + Honda Engine
```

```text
Yamaha Family
     ↓
Yamaha Bike + Yamaha Engine
```

---

# Interview Definition

> **Abstract Factory is a creational design pattern that provides an interface for creating families of related or compatible objects without specifying their concrete classes.**

---

# One-Line Memory Trick

> **Factory = One type of object.**

> **Abstract Factory = Family of related objects.**

```text
Factory
   ↓
Bike


Abstract Factory
   ↓
Bike + Engine
```

---

# Files

```text
AbstractFactoryWithoutPattern.java
AbstractFactoryWithPattern.java
README.md
```

`AbstractFactoryWithoutPattern.java` contains the normal approach where the client creates the concrete Bike and Engine objects.

`AbstractFactoryWithPattern.java` contains the Abstract Factory approach where each Factory creates a complete Bike family.

