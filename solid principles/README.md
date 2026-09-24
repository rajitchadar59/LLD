# S — Single Responsibility Principle (SRP)

## Definition

A class should have only one responsibility and only one reason to change.

## Simple Meaning

One class should focus on one specific job.

## Problem

If a single class handles multiple responsibilities such as:

- User data
- Database operations
- Email sending
- Report generation

then the class becomes difficult to maintain.

A change in one responsibility may affect other responsibilities.

## Solution

Separate different responsibilities into different classes.

For example:

- User → User-related operations
- UserRepository → Database operations
- EmailService → Email operations
- ReportService → Report generation

## Key Point

One Class → One Responsibility → One Reason to Change

## Goal

SRP makes code easier to understand, maintain, test, and modify.


# O — Open/Closed Principle (OCP)

## Definition

Software entities should be open for extension but closed for modification.

## Simple Meaning

We should be able to add new functionality without modifying existing, tested code.

## Problem

Suppose a payment system supports:

- UPI
- Credit Card

If every new payment method requires modifying the existing payment class, the existing code keeps changing.

This can introduce bugs and make the code difficult to maintain.

## Solution

Design the system so that new functionality can be added by extending the existing structure.

For example:

- Payment → Common abstraction
- UPI → Payment implementation
- Card → Payment implementation
- Cash → New payment implementation

Adding Cash Payment should not require changing the existing UPI or Card implementation.

## Key Point

Extend the system instead of repeatedly modifying existing code.

## Goal

OCP makes the system easier to extend while reducing changes to existing code.


# L — Liskov Substitution Principle (LSP)

## Definition

A child class should be able to replace its parent class without breaking the program

## Simple Meaning

If B is a child of A, then B should be usable wherever A is expected.

## Problem

Suppose we have a Bird parent class with a Fly behavior.

Now we create:

- Sparrow
- Penguin

A Sparrow can fly, but a Penguin cannot.

If Penguin inherits a behavior that it cannot properly support, replacing Bird with Penguin may break the program.

## Solution

Design the inheritance hierarchy correctly.

Separate common behavior from behavior that only some subclasses support.

For example:

- Bird → Common bird behavior
- FlyingBird → Flying behavior
- Sparrow → Flying bird
- Penguin → Non-flying bird

## Key Point

A child class should not break the expected behavior of its parent.

## Goal

LSP helps create correct and predictable inheritance relationships.



# I — Interface Segregation Principle (ISP)

## Definition

A class should not be forced to implement methods that it does not use.

## Simple Meaning

Prefer small and specific interfaces instead of one large interface.

## Problem

Suppose we create a Worker interface containing:

- work()
- eat()
- sleep()

A Human may need all three methods.

But a Robot may only need work().

Forcing Robot to implement eat() and sleep() creates unnecessary methods.

## Solution

Split a large interface into smaller and more specific interfaces.

For example:

- Workable → work()
- Eatable → eat()
- Sleepable → sleep()

Now each class implements only the interfaces it actually needs.

## Key Point

Do not force a class to implement unnecessary methods.

## Goal

ISP keeps interfaces simple, focused, and easier to use.



# D — Dependency Inversion Principle (DIP)

## Definition

High-level modules should not dep
end on low-level modules. Both should depend on abstractions
## Simple Meaning

Depend on interfaces or abstractions instead of concrete implementations.

## Problem

Suppose UserService directly depends on MySQLDatabase.

If the application later needs MongoDB, UserService must be modified.

This creates tight coupling between the high-level business logic and the database implementation.

## Solution

Introduce an abstraction such as a Database interface.

Then:

- UserService → depends on Database abstraction
- MySQLDatabase → implements Database
- MongoDB → implements Database

Now UserService does not care which database implementation is being used.

## Key Point

High-Level Module → Abstraction ← Low-Level Module

## Goal

DIP reduces tight coupling and makes the system easier to change, test, and extend.