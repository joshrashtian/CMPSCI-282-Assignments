package HuffmanCode;

public class FrequencyTable {
    int[] freq = new int[256];

    FrequencyTable(String message) {
        for (int i = 0; i < message.length(); i++) {
            freq[(int) message.charAt(i)]++;
        }

    }
    int get(char c) {
        return freq[(int) c];
    }
}
