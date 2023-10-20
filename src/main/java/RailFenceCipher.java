import java.util.ArrayList;

public class RailFenceCipher {


    public String encode(String plainText) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i += 2) {
            encryptedText.append(plainText.charAt(i));
        }

        for (int i = 1; i < plainText.length(); i += 2) {
            encryptedText.append(plainText.charAt(i));
        }

        return encryptedText.toString();
    }


    public String decode(String plainText) {
        char[] row1 = new char[plainText.length()];
        ArrayList<Character> row2 = new ArrayList<>();
        StringBuilder decodedText = new StringBuilder();

        int size = (int) Math.floor(plainText.length() / 2);
        int even = 0;
        int odd = 1;

        for (int i = 0; i < size; i++) {
            row1[odd] = plainText.charAt(i);
            odd = odd + 2;
         }


        for (int i = size; i < plainText.length(); i++) {
            row1[even] = plainText.charAt(i);
            even = even + 2;
        }

        for (int i = 1; i < row1.length; i = i + 2) {
            decodedText.append(row1[i]);
            decodedText.append(row1[i - 1]);
        }

        return decodedText.toString();
    }

}
