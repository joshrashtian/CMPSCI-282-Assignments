package HuffmanCode;

import CircularLinkedList.Node;

public class HuffmanTree {
    private HuffmanNode root;
    private CodeTable table;
    HuffmanTree(HuffmanNode root) {
        this.root = root;
    }

    void generateCodes(HuffmanNode node, String code, CodeTable table) {
        this.table = table;
        if( node == null ) return;

        if(node.left == null && node.right == null) {
            table.add(node.character, code);
            return;
        }

        generateCodes(node.left, code + "0", table);
        generateCodes(node.right, code + "1", table);
    }

    String encode(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            result += table.getCode(message.charAt(i));
        }
        return result;

    }

    String decode(String binary) {
        String result = "";
        HuffmanNode current = root;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                result += current.character;
                current = root;
            }
        }
        return result;
    }

}
