package dev.carnivohra.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    private final List<Character> whitelist = new ArrayList<>();
    private int minLength = 1;
    private int maxLength = 16;
    private StringBuilder builder;

    /**
     * Returns the last code which was generated by the
     * generateNextCode() method. If generateNextCode()
     * wasn't called before, this method will return the initial
     * code to brute force with.
     *
     * @return The code
     */
    public String getActualCode() {
        return builder.toString();
    }

    /**
     * Returns the next code to brute force with.
     * Every time you call this method it returns a
     * new code.
     *
     * @return The code
     */
    public String generateNextCode() {
        final char firstWhitelistEntry = whitelist.getFirst();
        final int whitelistSize = whitelist.size();
        final char lastWhitelistEntry = whitelist.get(whitelistSize - 1);

        for (int i = builder.length() - 1; i >= 0; i--) {
            if (builder.charAt(i) == lastWhitelistEntry) {
                builder.setCharAt(i, firstWhitelistEntry);

                if (i != 0) continue;

                builder.insert(0, firstWhitelistEntry);
                return builder.toString();
            }

            final char actualCharFromIndex = builder.charAt(i);
            final int indexFromWhitelist = whitelist.indexOf(actualCharFromIndex);
            builder.setCharAt(i, whitelist.get(indexFromWhitelist + 1));
            return builder.toString();
        }

        return null;
    }

    /**
     * Resets the actual code to default.
     * The minimal and maximal length of the codes which should be generated
     * remain unaffected by this method.
     * The whitelist will not get emptied either.
     */
    public void reset() {
        builder = new StringBuilder();
        for (int i = 0; i < minLength; i++) builder.append(whitelist.getFirst());
    }

    /**
     * Adds a character to the list of all allowed
     * characters to be generated.
     *
     * @param character The character which should be added to the whitelist.
     */
    public void addToWhitelist(Character character) {
        if (whitelist.contains(character)) return;
        whitelist.add(character);
        reset();
    }

    /**
     * Adds characters to the list of all allowed
     * characters to be generated.
     *
     * @param characters The characters which should be added to the whitelist.
     */
    public void addToWhitelist(Character[] characters) {
        for (char character : characters) addToWhitelist(character);
    }

    /**
     * Adds all characters of a string to the list of all allowed
     * characters to be generated.
     *
     * @param string The string with all the characters which should be added to the whitelist.
     */
    public void addToWhitelist(String string) {
        for (int i = 0; i < string.length(); i++) {
            final char character = string.charAt(i);
            addToWhitelist(character);
        }
    }

    /**
     * Removes a character from the list of all allowed
     * characters to be generated.
     *
     * @param character The character which should be removed from the whitelist.
     */
    public void removeFromWhitelist(Character character) {
        if (!whitelist.contains(character)) return;
        whitelist.remove(character);
        reset();
    }

    /**
     * Removes characters from the list of all allowed
     * characters to be generated.
     *
     * @param characters The character which should be removed from the whitelist.
     */
    public void removeFromWhitelist(Character[] characters) {
        for (char character : characters) removeFromWhitelist(character);
    }

    /**
     * Removes all characters of a string from the list of all allowed
     * characters to be generated.
     *
     * @param string The string with all the characters which should be removed from the whitelist.
     */
    public void removeFromWhitelist(String string) {
        for (int i = 0; i < string.length(); i++) {
            final char character = string.charAt(i);
            removeFromWhitelist(character);
        }
    }

    /**
     * Removes all entries from the list of all allowed
     * characters to be generated.
     * Clearing the whitelist resets the whole brute force process,
     * so don't clear the whitelist while brute forcing.
     */
    public void clearWhitelist() {
        whitelist.clear();
        reset();
    }

    /**
     * Returns the list of all allowed characters to be generated.
     *
     * @return The list
     */
    public List<Character> getWhitelist() {
        return whitelist;
    }

    /**
     * Returns the minimum length of the codes which should be generated.
     * The default minimum length value is 1.
     *
     * @return The length
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the minimum length of the codes which should be generated.
     * Setting the length resets the whole brute force process,
     * so don't reset the maximum length of the codes while
     * brute forcing.
     * The default minimum length value is 1.
     */
    public void setMinLength(int length) {
        this.minLength = length;
        reset();
    }

    /**
     * Returns the maximum length of the codes which should be generated.
     * The default maximum length value is 16.
     *
     * @return The length
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the maximum length of the codes which should be generated.
     * Setting the length resets the whole brute force process,
     * so don't reset the maximum length of the codes while
     * brute forcing.
     * The default maximum length value is 16.
     */
    public void setMaxLength(int length) {
        this.maxLength = length;
        reset();
    }

}
