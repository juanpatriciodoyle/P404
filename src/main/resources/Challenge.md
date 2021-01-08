# BookToHome Challenge

## Context

BookToHome is a new book rental store. We were hired to build the system that supports the service. 

The exercise consists of a sequence of iterations. Try to finish each iteration before reading the next one.

In every case prefer the simplest solution. You don’t need to worry about persistence or user interface.

Choose your preferred programming language and technologies.

### Iteration 1: Add the buy book feature

```gherkin
Feature: Buy books
    As a manager of the store
    I want to buy books for the store
    In order to increase the books available

    Scenario: A manager buys books
        Given there are no books in the store
        When the manager buys four units of a book titled "Rayuela"
        When the manager buys five units of a book titled "El Aleph" 
        Then the store has four units of a book titled "Rayuela"
        Then the store has five units of a book titled "El Aleph" 
```

### Iteration 2: Add the rent to customer feature
From now on customers will be able to rent books.

```gherkin
Feature: Rent a book
    As a customer of the store
    I want to rent a book
    In order to enjoy reading it

    Scenario: A customer rents a book
        Given there are four units of a book titled "Rayuela" in the store
        When a customer rents a book titled "Rayuela"
        Then the store has three units of a book titled "Rayuela" 

    Scenario: A customer returns a book
        Given there are three units of a book titled "Rayuela" in the store
        When a customer returns a book titled "Rayuela"
        Then the store has four units of a book titled "Rayuela"
```

### Iteration 3: Add quality considerations
A book degrades over time. Each book starts with an initial quality and after each day the quality diminishes by one.
When quality reaches 0 the store will have to remove the book from it's inventory.

### Iteration 4: Add a new item: "Comics"
In order to reach younger customers, the store now started to offer comics. Comics are similar to books but they degrades at double the speed.

### Iteration 5: Add a new item: "Collector's Edition"
The store incorporated a new kind of book, the "Collector's Edition". These books increases it's quality over time.

### Iteration 6: Add the minimum stock feature
The manager needs to know the books that reaches a minimum stock so he can buy more. Each book has different minimum stock requirements.

```gherkin
Feature: Minimum stock
    As a manager of the store
    I want to know which books have reached the minimum stock quantity
    In order to buy more units of those books
```