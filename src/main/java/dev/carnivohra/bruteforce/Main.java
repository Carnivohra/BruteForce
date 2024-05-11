package dev.carnivohra.bruteforce;

public class Main {

    public static void main(String[] args) {
        BruteForce bruteForce = new BruteForce();
        bruteForce.addToWhitelist("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        bruteForce.addToWhitelist("abcdefghijklmnopqrstuvwxyz");
        bruteForce.setMinLength(1);
        bruteForce.setMaxLength(16);

        String password = "Penis"; // The correct password
        long startedTime = System.currentTimeMillis();
        String actualCode = bruteForce.getCurrentCode();

        while (!actualCode.equals(password)) {
            actualCode = bruteForce.generateNextCode();
        }

        long stoppedTime = System.currentTimeMillis();
        double differenceInSeconds = ((double) stoppedTime - startedTime) / 1000;
        System.out.println("Password '" + actualCode + "' found in '" + differenceInSeconds + "' seconds.");
    }
}
