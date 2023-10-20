import java.util.Random;

public class OneTimePadCipher {

    public String key;


    private void prepareKey(String plainText) {
        int keyLength = plainText.length();
        StringBuilder keyBuilder = new StringBuilder();

        Random random = new Random();

        char character = 'A';

        while (keyBuilder.length() < keyLength) {
            int randomOffset = random.nextInt(26); // Generates a random number between 0 and 25
            int asciiValue = character + randomOffset;

            char newCharacter = (char) asciiValue;
            keyBuilder.append(newCharacter);
        }

        key = keyBuilder.substring(0, keyLength);
    }


    public String encode(String plainText) {
        prepareKey(plainText);
        StringBuilder cipherText = new StringBuilder();


        for (int i = 0; i < plainText.length(); i++) {
            int plainTextCharacterNumber = getIntegerValueOfCharacter(plainText.charAt(i));
            int cipherTextCharacterNumber = getIntegerValueOfCharacter(key.charAt(i));

            int resultantNumber = plainTextCharacterNumber + cipherTextCharacterNumber;

            if (resultantNumber > 25) {
                resultantNumber = resultantNumber - 25;
            }

            char finalCharacter = getCharacterFromNumber(resultantNumber);
            cipherText.append(finalCharacter);
        }

        return cipherText.toString();
    }


    private int getIntegerValueOfCharacter(Character character) {
        return switch (character) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            case 'G' -> 6;
            case 'H' -> 7;
            case 'I' -> 8;
            case 'J' -> 9;
            case 'K' -> 10;
            case 'L' -> 11;
            case 'M' -> 12;
            case 'N' -> 13;
            case 'O' -> 14;
            case 'P' -> 15;
            case 'Q' -> 16;
            case 'R' -> 17;
            case 'S' -> 18;
            case 'T' -> 19;
            case 'U' -> 20;
            case 'V' -> 21;
            case 'W' -> 22;
            case 'X' -> 23;
            case 'Y' -> 24;
            case 'Z' -> 25;
            default -> 26;
        };
    }


    private char getCharacterFromNumber(int number) {
        return switch (number) {
            case 0 -> 'A';
            case 1 -> 'B';
            case 2 -> 'C';
            case 3 -> 'D';
            case 4 -> 'E';
            case 5 -> 'F';
            case 6 -> 'G';
            case 7 -> 'H';
            case 8 -> 'I';
            case 9 -> 'J';
            case 10 -> 'K';
            case 11 -> 'L';
            case 12 -> 'M';
            case 13 -> 'N';
            case 14 -> 'O';
            case 15 -> 'P';
            case 16 -> 'Q';
            case 17 -> 'R';
            case 18 -> 'S';
            case 19 -> 'T';
            case 20 -> 'U';
            case 21 -> 'V';
            case 22 -> 'W';
            case 23 -> 'X';
            case 24 -> 'Y';
            case 25 -> 'Z';
            default -> ' '; // Space character for invalid column numbers
        };

    }
}
