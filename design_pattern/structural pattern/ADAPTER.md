````markdown
# Adapter Design Pattern

## What is Adapter Pattern?

> Adapter Pattern is a **structural design pattern** that allows incompatible interfaces to work together.

### Simple Meaning

An Adapter acts as a **bridge** between two incompatible classes or interfaces.

```text
Incompatible Class / Interface
            ↓
         Adapter
            ↓
     Required Interface
            ↓
          Client
````

The client does not need to change its code.
The Adapter converts the interface of the existing class into the interface expected by the client.

---

# Why Do We Need Adapter Pattern?

Sometimes we already have an existing class, but its interface does not match what our client expects.

For example:

```text
Client expects:

AppleCharger
     ↓
chargePhone()


Existing class provides:

AndroidCharger
     ↓
chargeAndroidPhone()
```

The two interfaces are different.

Therefore:

```text
Iphone
  ↓
AppleCharger
  ❌
AndroidCharger
```

They cannot work together directly.

We use an Adapter:

```text
AndroidCharger
      ↓
   Adapter
      ↓
AppleCharger
      ↓
    Iphone
```

---

# Real World Example

Think about a mobile charger adapter.

Suppose:

```text
Phone Port
    ↓
Type-C
```

but the available charger has a different connector.

An adapter converts the connection so that both can work together.

Similarly, in software, an Adapter converts one interface into another interface expected by the client.

---

# Basic Structure

```text
        Client
          |
          ↓
   Target Interface
          |
          ↓
       Adapter
          |
          ↓
      Adaptee
```

### Client

The class that needs to use the existing functionality.

### Target

The interface expected by the client.

### Adapter

The class that connects the Target and Adaptee.

### Adaptee

The existing class whose interface is incompatible with the client.

---

# Example

Suppose an iPhone expects:

```java
interface AppleCharger {

    void chargePhone();
}
```

But an existing Android charger provides:

```java
interface AndroidCharger {

    void chargeAndroidPhone();
}
```

The interfaces are incompatible.

We create an Adapter:

```java
class AdapterCharger implements AppleCharger {

    private AndroidCharger androidCharger;

    public AdapterCharger(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargePhone() {

        androidCharger.chargeAndroidPhone();
    }
}
```

Now the flow becomes:

```text
Iphone13
    ↓
AppleCharger
    ↓
AdapterCharger
    ↓
AndroidCharger
    ↓
DkCharger
```

The iPhone only knows about `AppleCharger`.

It does not need to know that the actual charger is an Android charger.

---

# Main Idea

Without Adapter:

```text
Client
  ↓
Required Interface
  ↓
Compatible Implementation
```

With Adapter:

```text
Client
  ↓
Required Interface
  ↓
Adapter
  ↓
Existing Incompatible Class
```

---

# Object Adapter

The most common approach uses **composition**.

```java
class AdapterCharger implements AppleCharger {

    private AndroidCharger androidCharger;

}
```

Here:

```text
AdapterCharger
      |
      | HAS-A
      ↓
AndroidCharger
```

The Adapter contains an object of the existing class/interface.

This is called an **Object Adapter**.

---

# Class Adapter

Another approach uses inheritance.

```java
class AdapterCharger
        extends DkCharger
        implements AppleCharger {

    @Override
    public void chargePhone() {

        chargeAndroidPhone();
    }
}
```

Here the Adapter:

```text
extends DkCharger
implements AppleCharger
```

This approach is called a **Class Adapter**.

---

# Object Adapter vs Class Adapter

| Object Adapter          | Class Adapter                                                      |
| ----------------------- | ------------------------------------------------------------------ |
| Uses Composition        | Uses Inheritance                                                   |
| HAS-A relationship      | IS-A relationship                                                  |
| Contains Adaptee object | Extends Adaptee                                                    |
| More flexible           | Less flexible                                                      |
| Common approach in Java | Uses multiple inheritance-like structure through class + interface |

---

# When to Use Adapter Pattern?

Use Adapter Pattern when:

1. Two interfaces are incompatible.
2. You already have an existing class that you cannot easily modify.
3. A client expects a different interface.
4. You want to reuse existing code.
5. You need to integrate old or third-party code with new code.

---

# Advantages

* Allows incompatible interfaces to work together.
* Promotes code reuse.
* Helps integrate existing or legacy code.
* Keeps the client independent from the incompatible implementation.
* Follows the Open/Closed Principle when used appropriately.

---

# Disadvantages

* Adds an extra layer between the client and the existing class.
* Can increase code complexity.
* Too many adapters can make a system harder to understand.

---

# Adapter Pattern Flow

```text
        Client
          ↓
   Target Interface
          ↓
       Adapter
          ↓
       Adaptee
          ↓
 Existing Functionality
```

---

# Easy Memory Trick

```text
INCOMPATIBLE INTERFACES
          ↓
        ADAPTER
          ↓
     COMPATIBLE
          ↓
    WORK TOGETHER
```

### Remember

> **Adapter = Convert one interface into another interface that the client expects.**

---

# Interview Definition

> **Adapter Pattern is a structural design pattern that converts the interface of an existing class into another interface expected by the client, allowing incompatible classes to work together.**



