
# Builder Design Pattern

## What is Builder?

> Builder Pattern is a creational design pattern used to construct a complex object step by step.

### Simple Meaning

```text
Many fields / options
        ↓
Large and confusing constructor
        ↓
Builder
        ↓
Set values step-by-step
        ↓
build()
        ↓
Final Object
````

---

# Problem

Suppose we have a `Pizza` class.

A Pizza can have different properties:

```text
Size
Cheese
Pepperoni
Bacon
Mushrooms
```

Some properties are required and some are optional.

Without Builder Pattern, we may have to pass all values through a constructor.

```java
Pizza pizza = new Pizza(
        "Large",
        true,
        true,
        false,
        true
);
```

The problem is that it is difficult to understand what each `true` or `false` represents.

```text
"Large" → Size

true    → Cheese?
true    → Pepperoni?
false   → Bacon?
true    → Mushrooms?
```

As the number of fields increases, the constructor becomes difficult to read and maintain.

---

# Without Builder Pattern

In the normal approach, we use a constructor to create the object.

```text
Many fields
    ↓
Large Constructor
    ↓
Pass all values together
```

### Example

```java
Pizza pizza = new Pizza(
        "Large",
        true,
        true,
        false,
        true
);
```

### Problems

1. Constructor becomes large.
2. Parameter order must be remembered.
3. Code becomes difficult to read.
4. Optional parameters become difficult to handle.
5. Multiple constructors may be required.

For example:

```java
Pizza(String size)

Pizza(String size, boolean cheese)

Pizza(String size, boolean cheese, boolean pepperoni)

Pizza(String size, boolean cheese, boolean pepperoni, boolean bacon)

...
```

This can lead to the **Telescoping Constructor Problem**.

### Code

See `BuilderWithoutPattern.java`.

---

# With Builder Pattern

Builder Pattern solves the above problem by constructing the object **step by step**.

Instead of:

```java
Pizza pizza = new Pizza(
        "Large",
        true,
        true,
        false,
        true
);
```

we can write:

```java
Pizza pizza =
        new Builder("Large")
                .setCheese(true)
                .setPepperoni(true)
                .setBacon(false)
                .setMushrooms(true)
                .build();
```

Now the code clearly tells us what each value means.

### Flow

```text
Create Builder
      ↓
Set Required Values
      ↓
Set Optional Values
      ↓
build()
      ↓
Create Final Object
```

### Code

See `BuilderWithPattern.java`.

---

# How Builder Works

The Builder temporarily stores all the values.

```text
Builder
   |
   | size = Large
   | cheese = true
   | pepperoni = true
   | bacon = false
   | mushrooms = true
   |
   ↓
 build()
   |
   ↓
Pizza Object
```

The `build()` method creates the final Pizza object.

```java
public Pizza build() {
    return new Pizza(this);
}
```

---

# Why do we use `return this`?

Builder methods return the same Builder object.

```java
public Builder setCheese(boolean cheese) {

    this.cheese = cheese;

    return this;
}
```

Because of `return this`, we can call multiple methods one after another.

```java
builder
        .setCheese(true)
        .setPepperoni(true)
        .setBacon(false)
        .setMushrooms(true);
```

This is called **Method Chaining**.

---

# Why do we need `build()`?

The Builder is used to configure the object.

After all required and optional values are set:

```java
.build()
```

creates the actual object.

```text
Builder
   ↓
set values
   ↓
build()
   ↓
Pizza Object
```

So:

```java
public Pizza build() {
    return new Pizza(this);
}
```

returns the final `Pizza` object.

---

# Comparison

| Without Builder                           | With Builder                           |
| ----------------------------------------- | -------------------------------------- |
| Large constructor                         | Step-by-step construction              |
| Difficult to read                         | Easy to read                           |
| Parameter order matters                   | Method names explain values            |
| Optional parameters are difficult         | Optional parameters are easy           |
| Multiple constructors may be required     | Usually one constructor                |
| Can cause telescoping constructor problem | Avoids telescoping constructor problem |
| Less flexible                             | More flexible                          |

---

# Example

Suppose we want a large Pizza with cheese and pepperoni.

### Without Builder

```java
Pizza pizza = new Pizza(
        "Large",
        true,
        true,
        false,
        false
);
```

We have to remember what each value means.

### With Builder

```java
Pizza pizza =
        new Builder("Large")
                .setCheese(true)
                .setPepperoni(true)
                .build();
```

This is much easier to understand.

---

# Key Components

## 1. Product

The actual object that we want to create.

```java
Pizza
```

---

## 2. Builder

The Builder stores the values required to create the object.

```java
static class Builder {

    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean bacon;
    private boolean mushrooms;
}
```

---

## 3. Setter Methods

These methods configure the Builder.

```java
public Builder setCheese(boolean cheese) {

    this.cheese = cheese;

    return this;
}
```

Similarly:

```java
setPepperoni()
setBacon()
setMushrooms()
```

---

## 4. build()

Creates the final object.

```java
public Pizza build() {

    return new Pizza(this);
}
```

---

# Why is Builder Class Usually Static?

We generally define:

```java
static class Builder {
}
```

This allows us to create the Builder without creating a Pizza object first.

```java
new Pizza.Builder("Large");
```

We don't need:

```java
Pizza pizza = new Pizza();
```

before creating the Builder.

---

# Why is Pizza Constructor Usually Private?

The final object is generally created through the Builder.

```java
private Pizza(Builder builder) {
    this.size = builder.size;
    this.cheese = builder.cheese;
    this.pepperoni = builder.pepperoni;
    this.bacon = builder.bacon;
    this.mushrooms = builder.mushrooms;
}
```

This prevents direct construction from outside.

Instead of:

```java
new Pizza(...);
```

we use:

```java
new Pizza.Builder("Large")
        .setCheese(true)
        .setPepperoni(true)
        .build();
```

---

# When to Use Builder Pattern?

Builder Pattern is useful when:

1. A class has many fields.
2. Many fields are optional.
3. Constructor has many parameters.
4. Constructor becomes difficult to read.
5. Different combinations of fields are required.
6. Object creation should be readable.

---

# Real World Examples

Builder Pattern can be useful for objects such as:

```text
Pizza
Car
Computer
HTTP Request
SQL Query
Configuration Object
```

For example:

```java
Request request =
        new Request.Builder()
                .setUrl("example.com")
                .setMethod("GET")
                .setTimeout(5000)
                .build();
```

---

# Advantages

* Makes object creation readable.
* Handles many optional parameters.
* Avoids large constructors.
* Avoids telescoping constructors.
* Supports method chaining.
* Makes object creation flexible.
* Easier to maintain.

---

# Disadvantages

* Requires additional Builder code.
* More classes/code than a simple constructor.
* Not necessary for classes with only a few fields.

---

# Interview Definition

> **Builder Pattern is a creational design pattern that constructs a complex object step by step and provides a readable way to create objects with many optional parameters.**

---

# Easy Memory Trick

```text
MANY PARAMETERS

        ↓

Large / Confusing Constructor

        ↓

BUILDER

        ↓

Set Values Step-by-Step

        ↓

Method Chaining

        ↓

build()

        ↓

FINAL OBJECT

```
