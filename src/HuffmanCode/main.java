package HuffmanCode;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Huffman Code Project");
        System.out.println("Enter any string:");

        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        FrequencyTable front = new FrequencyTable(message);

        PriorityQueue queue = new PriorityQueue(256);
        for (int i = 0; i < 256; i++) {
            if (front.freq[i] > 0) {
                queue.insert(new HuffmanNode((char) i, front.freq[i]));
            }
        }

        while (queue.front > 1) {
            HuffmanNode left = queue.delete();
            HuffmanNode right = queue.delete();
            HuffmanNode merged = new HuffmanNode('\0', left.data + right.data);
            merged.left = left;
            merged.right = right;
            queue.insert(merged);
        }

        HuffmanNode root = queue.delete();
        HuffmanTree tree = new HuffmanTree(root);

        CodeTable table = new CodeTable(message.length());
        tree.generateCodes(root, "", table);

        table.print();

        String encoded = tree.encode(message);
        System.out.println("Encoded Hello World: " +encoded);

        String decoded = tree.decode(encoded);
        System.out.println("Decoded Hello World: " +decoded);

}
}
