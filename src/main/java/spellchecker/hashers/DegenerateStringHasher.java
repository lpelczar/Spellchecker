package spellchecker.hashers;

import spellchecker.StringHasher;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * The worst hash function imaginable: it always returns 0, meaning that all
 * strings will always hash to the same location in a hash table.  This causes
 * the performance of the hash table to generate to that of an unsorted linked
 * list.
 */

public class DegenerateStringHasher implements StringHasher {

	public int hash(String s)
	{
		return 0;
	}
}
