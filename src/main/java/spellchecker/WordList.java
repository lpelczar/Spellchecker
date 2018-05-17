package spellchecker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordList {
    private final HashTable hashTable;

    public WordList(String var1, StringHasher var2) throws IOException {
        BufferedReader var3 = new BufferedReader(new FileReader(var1));
        int var4 = Integer.parseInt(var3.readLine());
        this.hashTable = new HashTable((int)((double)var4 * 1.2D), var2);

        for(int var5 = 0; var5 < var4; ++var5) {
            this.hashTable.add(var3.readLine().trim().toUpperCase());
        }

        var3.close();
    }

    public boolean lookup(String var1) {
        return this.hashTable.lookup(var1.toUpperCase());
    }
}
