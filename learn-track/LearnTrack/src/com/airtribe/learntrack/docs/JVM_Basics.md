# JDK, JRE, and JVM

## 1. JVM (Java Virtual Machine)
- **What it is:** JVM is the engine that runs Java programs.
- **Function:** It converts Java bytecode into machine code so your computer can execute it.
- **Role:** It provides platform independence — the same code can run anywhere with a JVM.
- **Key Tasks:**
    - Loads code
    - Verifies code
    - Executes code
    - Manages memory (through Garbage Collection)

---

## 2. JRE (Java Runtime Environment)
- **What it is:** JRE provides everything you need to run a Java program.
- **Contains:**
    - JVM
    - Libraries (like `java.lang`, `java.util`)
    - Other components needed at runtime.
- **Note:** You can **run** Java programs with JRE, but you **cannot develop** them.

---

## 3. JDK (Java Development Kit)
- **What it is:** JDK is a full package for developing Java applications.
- **Contains:**
    - JRE (for running code)
    - Development tools (like `javac` compiler, `java` command, debugger)
- **Usage:** Developers install JDK to compile and run Java programs.
