package spellchecker.hashers;

import spellchecker.StringHasher;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * A hash function for strings that uses multiplications and additions on
 * each character to ensure that the characters *and* the order in which
 * the characters appear are both considered significant.
 */

public class BetterStringHasher implements StringHasher {

	public int hash(String s) {
		int h = 0;
		for (int i = 0; i < s.length(); ++i)
		{
			h *= 37;
			h += s.charAt(i);
		}
		return h;
	}
}
