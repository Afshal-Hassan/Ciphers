
public class Main {

    public static void main(String[] args) {



        String plainText = "EXAMDATE";
        System.out.println("Plain Text: " + plainText);
        RailFenceCipher railFenceCipher = new RailFenceCipher();
        String encodedText = railFenceCipher.encode(plainText);
        System.out.println("Encoded Text: " + encodedText);
        String decodedText = railFenceCipher.decode(encodedText);
        System.out.println("Decoded Text: " + decodedText);
    }
}
