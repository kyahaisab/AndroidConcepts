package com.example.myfirstapplication.dbms

/*
Atomicity:
By this, we mean that either the entire transaction takes place at once or does’t happen at all.
There is no midway i.e. transactions do not occur partially.

Consistency:
This means that integrity constraints must be maintained so that the database is consistent before and after the transaction.
It refers to the correctness of a database.

Isolation:
This property ensures that multiple transactions can occur concurrently without leading to the inconsistency of the database state.

Durability:
This property ensures that once the transaction has completed execution, the updates and modifications to the database are
stored in and written to disk and they persist even if a system failure occurs.
 */