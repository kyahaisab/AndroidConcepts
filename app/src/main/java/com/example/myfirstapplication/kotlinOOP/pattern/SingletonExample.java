package com.example.myfirstapplication.kotlinOOP.pattern;

public class SingletonExample {

    public static class CounterSingleton {
        // Step 1: Create a private static instance of the class
        private static CounterSingleton instance;

        // Step 2: Create a private constructor to prevent instantiation
        private CounterSingleton() {
            // Initialize any resources if needed
        }

        // Step 3: Provide a public static method for getting the instance
        public static synchronized CounterSingleton getInstance() {
            if (instance == null) {
                instance = new CounterSingleton();
            }
            return instance;
        }

        private int counter = 0;

        public int getCounter() {
            return counter;
        }

        public void incrementCounter() {
            counter++;
        }
    }

    public static void main(String[] args) {
        // Get the singleton instance
        CounterSingleton counterSingleton = CounterSingleton.getInstance();

        // Use the singleton
        counterSingleton.incrementCounter();
        int count = counterSingleton.getCounter();
        System.out.println("Counter: " + count); // Output: Counter: 1

        // Increment the counter again
        counterSingleton.incrementCounter();
        System.out.println("Counter: " + counterSingleton.getCounter()); // Output: Counter: 2
    }
}

