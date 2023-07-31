# JpMorganChase
Assignment

In multi-threaded env the compound operations can create race condition if not handled
properly. Here word count can cause race condition when multiple threads access the compound
operation asynchronously. Volatile keyword only helps for visibility issue and hence we need to
go for synchronization or atomic integer.

I have used the solution of synchronization here.  We can use synchronization on the entire method as shown
below or on the piece of code where compound operation is performed.Atomic Integer is very fast as no locking
required and readable than synchronization (due to locking there is some delay).
