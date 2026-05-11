package HuffmanCode;

import java.util.HashMap;

public class CodeTable {
    char[] characters;
    String[] codes;
    int size;


    CodeTable(int capacity) {
        characters = new char[capacity];
        codes = new String[capacity];
        size = 0;
    }

    void add(char c, String code) {
        characters[size] = c;
        codes[size] = code;
        size++;
    }

    String getCode(char c) {
        for (int i = 0; i < size; i++) {
            if (characters[i] == c) {
                return codes[i];
            }
        }
        return null;
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(codes[i] + "->" + characters[i]);
        }
    }

}
