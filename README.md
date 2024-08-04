# Refactor Code Course - JAVA

By **Eng.Ahmad Emad in Takhareef** channel <br/>
**Link:** [https://www.youtube.com/playlist?list=PLkzDzmo9y3VFz8SFgucOKI2vebiyqti86] <br/> 
It is a private course, so this link will not work if not register in it.

## Course Topics:
### Refactoring VS Rewriting

| Factors                         | Refactor  | Rewrite |
|---------------------------------|-----------|---------|
| **Risk of losing the market**   | true      | false   |
| **Accumulated knowledge**       | true      | false   |
| **Modify some features or add new ones** | true | false |
| **State of the art technology** | false     | true    |

### Solid principles

| Principle                       | Description                                                                                                                                                      |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **S**ingle responsibility       | A class should have one, and only one, reason to change. This means it should have only one function.                                                             |
| **O**pen/closed                 | Software objects should be open for extension, but closed for modification.                                                                                       |
| **L**iskov substitution         | Objects of the same type (children) should be replaceable with others from the same category without altering the function of the program.                        |
| **I**nterface segregation       | No client should be forced to depend on methods it does not use. The program’s interfaces should always be kept smaller and separate from one another.            |
| **D**ependency inversion        | High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details, details should depend on abstractions. |

### DRY (Don’t repeat Yourself)
Every piece of code or logic must have a single representation within your system.

**The DRY principle cases**

| Case                           | Description                                                                           |
|--------------------------------|---------------------------------------------------------------------------------------|
| **Code duplication**           | Same code appears in multiple places.                                                 |
| **Hardcoding values**          | When values are hardcoded instead of being stored as variables or constants.           |
| **Copy-pasting code**          | Can lead to duplication.                                                              |
| **Similar logic in multiple places** | Similar logic is used in multiple places, making it challenging to maintain and update. |

**Techniques**

### KISS: Keep It Simple, Stupid
### Techniques
### YAGNI Principle: You Ain’t Gonna Need It.
### When will the YAGNI be applied?
### How to implement?
### Identifying Code Smells
### Duplicate code
### Long methods
### How to solve
### Large classes
### Definition
### Signs
### How to solve
### Switch Cases
### Definition
### Signs
### How to solve
### Identifying Code Smells - Shotgun Surgery
### Definition
### Signs
### How to solve
### Data Clumps
### Definition
### Signs
### How to solve
