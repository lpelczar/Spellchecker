package spellchecker;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * A common interface used by all hash functions for strings.  This allows
 * the spellchecker.HashTable class to be built to use any hash function.
 */

public interface StringHasher
{
	/** 
   * Returns an integer that is a hash value for the given string s.
   * The integer can potentially be any value in the range of Java ints
   * (i.e. Integer.MIN_VALUE .. Integer.MAX_VALUE).
   *
   * @param s String to hash
   * @return hash code for the input string
   */
	public int hash(String s);
}
