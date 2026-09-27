# Observer Design Pattern

## What is Observer Pattern?

> Observer Pattern is a behavioral design pattern that defines a one-to-many relationship between objects. When the state of one object changes, all its dependent objects are automatically notified.

### Simple Meaning

One object maintains a list of multiple objects and notifies them whenever something changes.

```text
                 Subject
                    |
          ┌─────────┼─────────┐
          ↓         ↓         ↓
      Observer   Observer   Observer
````

In simple words:

```text
One Subject
     ↓
Many Observers
     ↓
Subject changes
     ↓
Notify all Observers
```

---

# Real World Example

Consider a YouTube Channel.

A YouTube channel can have many subscribers.

```text
                YouTube Channel
                    Subject
                       |
          ┌────────────┼────────────┐
          ↓            ↓            ↓
      Subscriber    Subscriber    Subscriber
        Aman          Raman         Raj
```

When the channel uploads a new video:

```text
New Video Uploaded
        ↓
YouTube Channel
        ↓
Notify Subscribers
        ↓
┌───────┼────────┐
↓       ↓        ↓
Aman   Raman     Raj
```

Every subscriber receives the notification.

---

# Problem

Suppose we have a YouTube channel and multiple subscribers.

Without a proper Observer Pattern structure, the YouTube channel would have to manage every subscriber separately.

For example:

```text
YouTube Channel
      |
      ├── Aman
      ├── Raman
      ├── Raj
      └── Rahul
```

If the number of subscribers increases, managing them individually becomes difficult.

We need a way where:

```text
Subject
   ↓
maintains list of observers
   ↓
automatically notifies all observers
```

This is where the Observer Pattern is useful.

---

# Main Components

Observer Pattern mainly contains:

```text
Subject
Observer
Concrete Subject
Concrete Observer
```

---

# 1. Subject

The Subject is the object whose state changes.

It maintains a list of Observers and provides methods to:

```text
Subscribe
Unsubscribe
Notify
```

Example:

```java
interface Subject {

    void subscribe(Observer ob);

    void unsubscribe(Observer ob);

    void notifyChanges(String title);
}
```

---

# 2. Observer

Observer is the object that wants to receive updates from the Subject.

```java
interface Observer {

    void notified(String title);
}
```

The Observer defines the method that will be called when the Subject changes.

---

# 3. Concrete Subject

Concrete Subject is the actual implementation of the Subject.

In our example:

```java
class YoutubeChannel implements Subject {

    List<Observer> subscribers = new ArrayList<>();
}
```

The YouTube channel maintains a list of subscribers.

```java
List<Observer> subscribers = new ArrayList<>();
```

---

# 4. Concrete Observer

Concrete Observer is the actual implementation of the Observer.

In our example:

```java
class Subscriber implements Observer {

    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String title) {
        System.out.println(
            "Hello " + name +
            " new video uploaded notified : " + title
        );
    }
}
```

Each subscriber receives the notification.

---

# Subscribe

When a subscriber wants to receive notifications:

```java
channel.subscribe(aman);
```

The Subject adds the observer to its list.

```java
@Override
public void subscribe(Observer ob) {
    this.subscribers.add(ob);
}
```

Flow:

```text
Subscriber
    ↓
subscribe()
    ↓
Subject
    ↓
Observer added to list
```

---

# Unsubscribe

When a subscriber no longer wants notifications:

```java
channel.unsubscribe(aman);
```

The Subject removes the observer from its list.

```java
@Override
public void unsubscribe(Observer ob) {
    this.subscribers.remove(ob);
}
```

Flow:

```text
Subscriber
    ↓
unsubscribe()
    ↓
Subject
    ↓
Observer removed from list
```

---

# Notify Observers

When the YouTube channel uploads a video:

```java
channel.notifyChanges("Learn Design Pattern");
```

The Subject loops through all subscribers:

```java
@Override
public void notifyChanges(String title) {

    for (Observer ob : this.subscribers) {
        ob.notified(title);
    }
}
```

Flow:

```text
notifyChanges()
       ↓
Subscribers List
       ↓
┌──────┼──────┐
↓      ↓      ↓
Aman  Raman   Raj
↓      ↓      ↓
notify notify notify
```

---

# Complete Flow

```text
                YoutubeChannel
                   Subject
                      |
                      |
                subscribers
                      |
          ┌───────────┴───────────┐
          ↓                       ↓
      Subscriber               Subscriber
        Aman                     Raman
          |                       |
          └───────────┬───────────┘
                      ↓
                New Video
                      ↓
                notifyChanges()
                      ↓
                notified()
                      ↓
                 All receive
                 notification
```

---

# Example

```java
YoutubeChannel channel = new YoutubeChannel();

Observer aman = new Subscriber("aman");

Observer raman = new Subscriber("raman");

channel.subscribe(aman);

channel.subscribe(raman);

channel.notifyChanges("Learn Design Pattern");
```

Output:

```text
Hello aman new video uploaded notified : Learn Design Pattern

Hello raman new video uploaded notified : Learn Design Pattern
```

If another video is uploaded:

```java
channel.notifyChanges("DSA Java");
```

Both subscribers are notified again.

---

# Multiple Observers

A single Subject can have many Observers.

```text
                Subject
                   |
        ┌──────────┼──────────┐
        ↓          ↓          ↓
    Observer    Observer    Observer
       A            B           C
```

When the Subject changes:

```text
Subject changes
      ↓
notifyChanges()
      ↓
┌─────┼─────┐
↓     ↓     ↓
A     B     C
↓     ↓     ↓
Update Update Update
```

This is why the pattern is called a:

> **One-to-Many Relationship**

One Subject → Many Observers.

---

# Important Relationship

Observer Pattern creates:

```text
One Subject
     ↓
Many Observers
```

The Subject knows about its Observers because it maintains their list.

```java
List<Observer> subscribers;
```

But the Subject does not need to know the concrete class of each observer.

It works with:

```java
Observer
```

instead of:

```java
Subscriber
```

This provides flexibility.

---

# Why Use Interface?

Instead of:

```java
List<Subscriber> subscribers;
```

we use:

```java
List<Observer> subscribers;
```

This allows different classes to become Observers.

For example:

```java
class Subscriber implements Observer {
}

class MobileNotification implements Observer {
}

class EmailNotification implements Observer {
}
```

All of them can be stored in:

```java
List<Observer>
```

and notified by the Subject.

---

# Advantages

1. One Subject can notify many Observers.
2. Observers can subscribe and unsubscribe dynamically.
3. Subject does not need to know the concrete Observer class.
4. New Observer types can be added easily.
5. Useful for event-based systems.
6. Creates a one-to-many relationship.

---

# Disadvantages

1. Large number of Observers can make notification management complex.
2. A notification may trigger many operations.
3. Debugging the flow can become difficult when many Observers exist.
4. Observers depend on notifications from the Subject.

---

# When to Use Observer Pattern?

Use Observer Pattern when:

1. One object needs to notify multiple objects.
2. Multiple objects depend on the state of another object.
3. Changes in one object should automatically trigger updates.
4. Objects need dynamic subscribe/unsubscribe functionality.
5. You are building an event or notification-based system.

---

# Real World Examples

```text
YouTube Channel → Subscribers

News Channel → News Subscribers

Stock Price → Investors

Weather Station → Weather Applications

Order System → Notification Services

Social Media → Followers
```

---

# Observer Pattern vs Normal Approach

| Normal Approach                         | Observer Pattern          |
| --------------------------------------- | ------------------------- |
| Directly manage objects                 | Maintain Observer list    |
| More tightly coupled                    | More flexible             |
| Difficult to add new notification types | Easy to add new Observers |
| Manual notification handling            | Automatic notification    |
| Harder to maintain                      | Easier to maintain        |

---

# UML Structure

```text
┌──────────────────────────┐
│       <<interface>>      │
│         Subject          │
├──────────────────────────┤
│ + subscribe()            │
│ + unsubscribe()          │
│ + notifyChanges()        │
└────────────▲─────────────┘
             |
             | implements
             |
┌────────────┴─────────────┐
│      YoutubeChannel      │
├──────────────────────────┤
│ - subscribers            │
├──────────────────────────┤
│ + subscribe()            │
│ + unsubscribe()          │
│ + notifyChanges()        │
└──────────────────────────┘
             |
             | has many
             ↓
┌──────────────────────────┐
│       <<interface>>      │
│         Observer         │
├──────────────────────────┤
│ + notified()             │
└────────────▲─────────────┘
             |
             | implements
             |
┌────────────┴─────────────┐
│        Subscriber        │
├──────────────────────────┤
│ - name                   │
├──────────────────────────┤
│ + notified()             │
└──────────────────────────┘
```

---

# Interview Definition

> **Observer Pattern is a behavioral design pattern that establishes a one-to-many relationship between a Subject and its Observers, so that when the Subject changes, all registered Observers are automatically notified.**

---

# Easy Memory Trick

```text
ONE SUBJECT
     ↓
MANY OBSERVERS
     ↓
STATE CHANGES
     ↓
NOTIFY ALL
```

### Remember

```text
Observer → NOTIFY
```

The easiest real-world example to remember:

```text
YouTube Channel
      ↓
New Video
      ↓
Notify Subscribers
```
