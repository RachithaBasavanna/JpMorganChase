# JpMorganChase
Assignment

In multi-threaded env the compound operations can create race condition if not handled
properly. Here word count can cause race condition when multiple threads access the compound
operation asynchronously. Volatile keyword only helps for visibility issue and hence we need to
go for synchronization or atomic integer.

I have used the solution of synchronization here.  We can use synchronization on the entire method as shown
below or on the piece of code where compound operation is performed.Atomic Integer is very fast as no locking
required and readable than synchronization (due to locking there is some delay).

ConcurrentHashMap can also be used. This is best collection to be used in multi-threaded environment. This map 
does not apply lock on the entire map, instead it divides the map into segments and apply locks on each segment.
Thus applying the lock at the granular level. So, read operations in this map is not non-synchronized and reads 
very fast as multiple threads can access it asynchronously. But the update operation is synchronized thus avoiding 
the race condition to occur.
