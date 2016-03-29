Notes of Functional and Reactive Domain Modeling 
=========

### Chapter 1

1. Should avoid share mutable state with model

2. Should always design referentially transparent model components

3. Event driven also means the main thread of execution is never blocked.

4. Decouple state from behavior

- State resides within the ADT and the behaviors are modeled as standalone functions within modules.

5. Most of your model behaviors are built out of pure functions, you get the power of compositionality, then you can build larger funcitons out of smaller ones through composition.

6. DDD(Domain Drive Design) means, organize your model entities, value objects and services around pattern like repositories and factories. Also you need make each of these artifacts functional without voilating the priciples of purity and referential transparency.

7. Functional meets DDD means strive for immutability in each layer of your DDD code 

8. Pure functions are ideal because you can freely distribute them without worrying about mutating their state.

9. Always design for failure and manage failures as a separate concern without couping exception handles with bussiness logic code
- Use Try to hanlde exception logic.
- Have a separate module that handles failures - decouping failure make it pluggable

### Chapter 2

1. Referential transparent == pure function == a function does not have any side effect == the same output for the same set of inputs from an expression

2. Using case class, Scala creates an immutable abstraction by default. 

3. Modify attributes? Never, create another abstraction from the original one that has the modified value by using *copy* method

4. Traits can do mixin based composition 
