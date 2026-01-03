# Design Choices in the Project

## 1. Why ArrayList Instead of Array?

- **Dynamic size:** ArrayList can grow and shrink at runtime, so there is no need to know the size in advance like arrays. [web:1][web:8]
- **Built‑in methods:** It provides helpful methods such as `add()`, `remove()`, `contains()`, and `size()`, which makes code simpler and more readable compared to manual index management in arrays. [web:1][web:8]
- **Better for frequently changing data:** When elements are frequently added or removed, ArrayList is easier to work with than a fixed-size array. [web:5][web:8]

> In short: ArrayList was used because the collection size was not fixed and needed easy insertions/removals.

---

## 2. Where Static Members Were Used and Why

- **Utility/helper methods:** Static methods were used in utility classes (for example, `MathUtils.calculateSomething()`), so they can be called without creating an object. This is useful for stateless, general-purpose operations. [web:6][web:12][web:15]
- **Constants/configuration:** Static `final` variables were used for constants like `MAX_SIZE`, `DEFAULT_TIMEOUT`, or messages, so there is a single shared value for the whole application. [web:6][web:15]
- **Shared counters or metadata:** Static fields can be used to maintain data common to all objects, such as `instanceCount` to track how many objects of a class are created. [web:9][web:12]

> Static was used whenever data or behavior belonged to the **class as a whole**, not to a specific object.

---

## 3. Where Inheritance Was Used and Benefits

- **Base class for common behavior:** A parent class (for example, `User`, `Shape`, `Account`, or `Vehicle`) was created to hold common fields and methods, and child classes like `AdminUser`, `Circle`, `SavingsAccount`, or `Car` extended it. [web:13][web:16]
- **Code reusability:** Common logic (e.g., validation, logging, common calculations) was written once in the parent class and reused in all child classes, reducing duplicate code. [web:13][web:16][web:19]
- **Polymorphism and flexibility:** Inheritance allowed working with parent references (e.g., `List<Shape>` or `List<Account>`) while actually storing different child objects, making the design more flexible and easier to extend. [web:7][web:16][web:19]

> Inheritance was used to **reuse common code**, **organize related classes**, and **enable polymorphism** for more flexible designs.
