package HuffmanCode;

import CircularLinkedList.Node;

public class HuffmanNode extends Node {
    char character;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char character, int frequency) {
        super(frequency);
        this.character = character;
        this.left = null;
        this.right = null;
    }
    }
