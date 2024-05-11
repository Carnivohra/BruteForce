# BruteForce
A simple optimized brute force library written in Java.
This library is full documented and easy to use.

# Usage

```java
BruteForce bruteForce = new BruteForce();
bruteForce.addToWhitelist("0123456789"); // Generates codes included with numbers.
bruteForce.removeFromWhitelist('5'); // Generates codes without the number 5.
bruteForce.clearWhitelist(); // Removes all current whitelisted characters.
bruteForce.setMinLength(1); // Generates codes with a minimum amount of 1 character only.
bruteForce.setMaxLength(16); // Generates codes with a maximum amount of 16 characters only.
String code = bruteForce.getCurrentCode(); // Returns the last Generated code.
code = bruteForce.generatedNextCode(); // Returns the next code to brute force with.
bruteForce.reset(); // Resets the actual code to the initial code depending on the minimum amount of characters.
```

# Example

```java
BruteForce bruteForce = new BruteForce();
bruteForce.addToWhitelist("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
bruteForce.addToWhitelist("abcdefghijklmnopqrstuvwxyz");
bruteForce.setMinLength(1);
bruteForce.setMaxLength(16);

String password = "Penis"; // The correct password
long startedTime = System.currentTimeMillis();
String currentCode = bruteForce.getCurrentCode();

while (!currentCode.equals(password)) {
    currentCode = bruteForce.generateNextCode();
}

long stoppedTime = System.currentTimeMillis();
double differenceInSeconds = ((double) stoppedTime - startedTime) / 1000;
System.out.println("Password '" + currentCode + "' found in '" + differenceInSeconds + "' second(s).");
```

**Output:**
`Password 'Penis' found in '4.589' second(s).`
