
# Design Patterns

Design Patterns are reusable and commonly used solutions to recurring software design problems.

They provide a standard way to design classes and objects and make code easier to understand, maintain, reuse, and extend.

---

# Types of Design Patterns

Design Patterns are mainly divided into three types:

```text
                         DESIGN PATTERNS
                                |
             ┌──────────────────┼──────────────────┐
             ↓                  ↓                  ↓
        CREATIONAL          STRUCTURAL         BEHAVIORAL
             |                  |                  |
             ↓                  ↓                  ↓
       Object Creation     Object Structure   Object Behavior
````

---

# 1. Creational Design Patterns

## Definition

> Creational Design Patterns deal with the process of creating objects.

### Simple Meaning

They help us decide **how objects should be created**.

### Main Question

```text
How should we create objects?
```

## Types

```text
                    CREATIONAL
                         |
        ┌────────────────┼────────────────┐
        ↓                ↓                ↓
    Singleton          Factory          Builder
        |                |
        ↓                ↓
   One Object      Object Creation
                         |
                    ┌────┴─────┐
                    ↓          ↓
             Factory Method  Abstract Factory

                         |
                         ↓
                     Prototype
```

## Important Creational Patterns

### 1. Singleton

Ensures that a class has **only one instance** and provides a global access point to it.

Examples:

* Database connection
* Logger
* Configuration manager

### 2. Factory Method

Creates objects without exposing the exact object creation logic to the client.

### 3. Abstract Factory

Provides an interface for creating **families of related objects**.

### 4. Builder

Builds complex objects **step by step**.

### 5. Prototype

Creates a new object by **copying an existing object**.

## Creational Flow

```text
Object Creation
      ↓
Creational Patterns
      ↓
How should objects be created?
      |
      ├── Singleton
      ├── Factory Method
      ├── Abstract Factory
      ├── Builder
      └── Prototype
```

---

# 2. Structural Design Patterns

## Definition

> Structural Design Patterns deal with how classes and objects are combined to form larger structures.

### Simple Meaning

They help us decide **how objects and classes should be connected or structured**.

### Main Question

```text
How should objects/classes be connected?
```

## Types

```text
                    STRUCTURAL
                         |
        ┌────────────────┼──────────────────┐
        ↓                ↓                  ↓
      Adapter         Decorator           Facade
        |                |                  |
        ↓                ↓                  ↓
    Connect          Add Behavior       Simplify
  Different          Dynamically        Complex System
  Interfaces
        |
        ├───────────────┬──────────────────┐
        ↓               ↓                  ↓
      Proxy          Composite           Bridge
        |               |                  |
        ↓               ↓                  ↓
 Control Access     Tree Structure   Separate Abstraction
                                     from Implementation

                         |
                         ↓
                     Flyweight
                         |
                         ↓
                   Share Objects
```

## Important Structural Patterns

### 1. Adapter

Allows **incompatible interfaces** to work together.

```text
Client → Adapter → Existing Class
```

### 2. Decorator

Adds new behavior to an object **without modifying its original class**.

```text
Object
  ↓
Decorator
  ↓
Additional Behavior
```

### 3. Facade

Provides a **simple interface** to a complex subsystem.

```text
Client
  ↓
Facade
  ↓
Complex Subsystems
```

### 4. Proxy

Provides a **placeholder/control object** that controls access to another object.

```text
Client
  ↓
Proxy
  ↓
Real Object
```

### 5. Composite

Treats individual objects and groups of objects **uniformly**, commonly using tree structures.

```text
Component
   |
   ├── Leaf
   |
   └── Composite
          |
          ├── Leaf
          └── Leaf
```

### 6. Bridge

Separates **abstraction from implementation** so both can vary independently.

### 7. Flyweight

Shares common object data to **reduce memory usage**.

## Structural Flow

```text
Class/Object Structure
          ↓
Structural Patterns
          ↓
How should classes/objects be connected?
          |
          ├── Adapter
          ├── Decorator
          ├── Facade
          ├── Proxy
          ├── Composite
          ├── Bridge
          └── Flyweight
```

---

# 3. Behavioral Design Patterns

## Definition

> Behavioral Design Patterns deal with communication and interaction between objects.

### Simple Meaning

They help us decide **how objects should communicate and behave**.

### Main Question

```text
How should objects communicate?
```

## Types

```text
                     BEHAVIORAL
                          |
       ┌──────────────────┼───────────────────┐
       ↓                  ↓                   ↓
    Observer           Strategy            Command
       |                  |                   |
       ↓                  ↓                   ↓
  Notify Objects     Change Algorithm     Encapsulate
                                          Request
       |
       ├──────────────────┬──────────────────┐
       ↓                  ↓                  ↓
     State          Chain of Responsibility  Iterator
       |                  |                  |
       ↓                  ↓                  ↓
 Change Behavior      Pass Request       Traverse
 Based on State       Through Chain      Collection

                          |
             ┌────────────┼────────────┐
             ↓            ↓            ↓
       Template Method  Mediator     Memento
             |            |            |
             ↓            ↓            ↓
       Define Algorithm  Central     Save/Restore
                         Communication   State

                          |
                    ┌─────┴─────┐
                    ↓           ↓
                 Visitor    Interpreter
                    |           |
                    ↓           ↓
              Add Operations  Interpret
```

## Important Behavioral Patterns

### 1. Observer

When one object changes, its dependent objects are **automatically notified**.

```text
Subject
   ↓
Observers
 ├── Observer 1
 ├── Observer 2
 └── Observer 3
```

Examples:

* YouTube notifications
* Stock price updates

### 2. Strategy

Allows us to select/change an algorithm or behavior at runtime.

```text
Context
   ↓
Strategy
 ├── Strategy A
 ├── Strategy B
 └── Strategy C
```

### 3. Command

Encapsulates a request as an object.

```text
Invoker → Command → Receiver
```

### 4. State

Allows an object to change its behavior when its internal state changes.

```text
Object
  ↓
Current State
  ↓
Behavior Changes
```

### 5. Chain of Responsibility

Passes a request through a chain of handlers until one handler handles it.

```text
Request
   ↓
Handler 1
   ↓
Handler 2
   ↓
Handler 3
```

### 6. Template Method

Defines the overall algorithm structure while allowing subclasses to customize specific steps.

### 7. Iterator

Provides a way to traverse elements of a collection without exposing its internal structure.

### 8. Mediator

Uses a central object to control communication between multiple objects.

```text
Object A ──┐
Object B ──┼──→ Mediator
Object C ──┘
```

### 9. Memento

Allows an object's state to be saved and restored later.

Example:

* Undo functionality

### 10. Visitor

Allows adding new operations to objects without modifying their classes.

### 11. Interpreter

Defines a representation and interpretation mechanism for a language or grammar.

## Behavioral Flow

```text
Object Communication
        ↓
Behavioral Patterns
        ↓
How should objects communicate?
        |
        ├── Observer
        ├── Strategy
        ├── Command
        ├── State
        ├── Chain of Responsibility
        ├── Template Method
        ├── Iterator
        ├── Mediator
        ├── Memento
        ├── Visitor
        └── Interpreter
```

---



# Quick Revision

| Category       | Main Purpose                    | Important Patterns                                                                                                              |
| -------------- | ------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| **Creational** | Object Creation                 | Singleton, Factory, Abstract Factory, Builder, Prototype                                                                        |
| **Structural** | Object/Class Structure          | Adapter, Decorator, Facade, Proxy, Composite, Bridge, Flyweight                                                                 |
| **Behavioral** | Object Communication & Behavior | Observer, Strategy, Command, State, Chain of Responsibility, Iterator, Mediator, Memento, Visitor, Template Method, Interpreter |

---

# Easy Memory Trick

```text
CREATIONAL
    ↓
CREATE
    ↓
How to create objects?


STRUCTURAL
    ↓
STRUCTURE
    ↓
How to connect/organize objects?


BEHAVIORAL
    ↓
BEHAVIOR
    ↓
How should objects communicate?
```

---

# Main Goal

Design Patterns provide **reusable solutions to common software design problems**.

They help us make code:

* Easier to understand
* Easier to maintain
* Easier to extend
* More reusable
* Less tightly coupled

```
```
