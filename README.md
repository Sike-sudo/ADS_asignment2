# ADS Assignment 2 – Custom Data Structures

This project is part of an Advanced Data Structures (ADS) coursework assignment, focused on implementing and testing core data structures from scratch using Java.

## 🛠️ Implemented Data Structures

- **MyArrayList** – Custom dynamic array implementation
- **MyLinkedList** – Singly linked list with internal Node management
- **MyStack** – Stack built using a linked list
- **MyQueue** – Queue implementation (likely with circular array or linked list)
- **MyMinHeap** – Binary min-heap using array-based storage

Each class is implemented manually without using Java’s built-in collections.

## Unit Tests

Every data structure has a corresponding `*Test.java` file for validation:
- `MyArrayListTest`, `MyLinkedListTest`, etc.
- Tests written in plain Java and structured in `src/main/java/structures/`

## Getting Started

### Requirements
- Java 17+
- Gradle (comes with wrapper)

### Running the Project

```bash
# Clone the repo
git clone https://github.com/your-username/ADS-asik2.git
cd ADS-asik2

# Run tests
./gradlew test
