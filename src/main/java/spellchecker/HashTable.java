package spellchecker;

import java.util.LinkedList;

/**
 *
 * ICS 23 Summer 2004
 * Project #5: Lost for Words
 *
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */

public class HashTable<K, V> {

    private int bucketSize = 16;
    private int size = 0;
    private StringHasher hasher;

    @SuppressWarnings("unchecked")
    private LinkedList<String>[] elements = new LinkedList[bucketSize];

	/**
   * The constructor is given a table size (i.e. how big to make the array)
   * and a StringHasher, which is used to hash the strings.
   *
   * @param tableSize number of elements in the hash array
   *        hasher    Object that creates the hash code for a string
   * @see StringHasher
   */
	public HashTable(int tableSize, StringHasher hasher) {

	    this.hasher = hasher;
	    this.bucketSize = tableSize;
        initializeLinkedListsInArray();
	}


	/**
   * Takes a string and adds it to the hash table, if it's not already
   * in the hash table.  If it is, this method has no effect.
   *
   * @param s String to add
   */
	public void add(String s) {

        int position = getHashPosition(s);
        LinkedList<String> list = elements[position];

        for (String string : list) {
            if (s.equals(string)) return;
        }

        list.add(s);
        size++;
        resizeIfNeeded();
	}
	

	/**
  * Takes a string and returns true if that string appears in the
	* hash table, false otherwise.
  *
  * @param s String to look up
  */
	public boolean lookup(String s) {
        int position = getHashPosition(s);
        LinkedList<String> list = elements[position];

        for (String string : list) {
            if (string.equals(s)) return true;
        }
        
        return false;
	}
	

	/**
   * Takes a string and removes it from the hash table, if it
   * appears in the hash table.  If it doesn't, this method has no effect.
   *
   * @param s String to remove
  */
	public void remove(String s)
	{

	}

    private void resizeIfNeeded() {
        if (size > bucketSize * 2) {
            bucketSize *= 2;
            createNewArrayAndCopyElements();
        }
        if (size < bucketSize / 2) {
            bucketSize /= 2;
            createNewArrayAndCopyElements();
        }
    }

    @SuppressWarnings("unchecked")
    private void createNewArrayAndCopyElements() {
        LinkedList<String>[] elementsCopy = elements.clone();
        elements = new LinkedList[bucketSize];
        initializeLinkedListsInArray();

        for (LinkedList<String> list : elementsCopy) {
            for (String string : list) {
                int position = getHashPosition(string);
                elements[position].add(string);
            }
        }
    }

    private void initializeLinkedListsInArray() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new LinkedList<>();
        }
    }

    private int getHashPosition(String s) {
        return s.hashCode() % bucketSize;
    }
}
