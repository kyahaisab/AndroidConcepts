package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Understanding @JvmField
When you declare a property in Kotlin, the Kotlin compiler typically generates a private field along
with public getter and (if the property is mutable) setter methods. However, when you need to expose
the field directly, you can use the @JvmField annotation.
Usage: Here’s a typical use case for @JvmField:

Without @JvmField
 */class Example {
    var property: String = "Hello"
}
/*
In the above example, the Kotlin compiler will generate:
A private field for property.
A public getter method getProperty().
A public setter method setProperty(String value).
With @JvmField
 */
class ExampleOne {
    @JvmField
    var property: String = "Hello"
}
/*
In this example, the @JvmField annotation tells the Kotlin compiler
to expose the field directly without generating getter and setter methods.

Benefits of Using @JvmField
Interoperability with Java: When interacting with Java code, having direct field access can
sometimes be necessary or more convenient. Java code can access the field directly without needing
to call getter or setter methods.
Performance: Avoids the slight overhead of method calls for getter and setter methods, though this is usually negligible.
 */

/*
Kotlin code
class Example {
    @JvmField var property: String = "Hello"
}

Java Code
public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.property);  // Direct field access
        example.property = "World";            // Direct field modification
    }
}
*/