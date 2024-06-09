package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Volatile:
Ordinarily the value of an attribute may be written into a thread's local cache and not updated in the
main memory for some amount of time. In this case, other threads will see a different value for the attribute.
The volatile keyword makes sure that threads always update the value of an attribute in main memory.


Serialization:
Serialization is the process of converting an object into a byte stream, so it can be easily saved to a file,
sent over a network, or stored in a database. Deserialization is the reverse process, where the byte stream is
converted back into a copy of the object.

Transient:
When an object is serialized, all of its fields (variables) are included in the byte stream by default.
However, there might be certain fields that you don't want to serialize. This is where the transient keyword comes in.
By marking a field as transient, you indicate that this field should not be included in the serialized representation of the object.

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    String username;
    transient String password;

    serializeData()
    deserializeData()

 }
 When object is deserialized, the username field is restored, but the password field is not. It will be set to null (or the default value if it were a primitive type).
 */