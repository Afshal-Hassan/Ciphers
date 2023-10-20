import java.util.ArrayList;

public class VigenereCipher {


    private final char[][] cipherTable = new char[26][26];

    private final String key = "LOCK";


    public String encode(String plainText) {
        StringBuilder encryptedText = new StringBuilder();

        var plainTextList = new ArrayList<Character>();
        var keyTextList = new ArrayList<Character>();
        insertValuesInCipherTable();
         prepareEncryptedOrDecryptedList(plainText, plainTextList);
        prepareKeyList(plainTextList, keyTextList);


        for (int index = 0; index < plainTextList.size(); index++) {
            int keyTextNumber = getRowNumber(Character.toUpperCase(keyTextList.get(index)));
            int plainTextNumber = getColumnNumber(Character.toUpperCase(plainTextList.get(index)));
            Character convertedCipherCharacter = cipherTable[keyTextNumber][plainTextNumber];
            encryptedText.append(convertedCipherCharacter);
        }


        return encryptedText.toString();
    }


    public String decode(String cipherText) {
        StringBuilder decryptedText = new StringBuilder();
        var columnNumber = 0;
        var cipherTextList = new ArrayList<Character>();
        var keyTextList = new ArrayList<Character>();

        prepareEncryptedOrDecryptedList(cipherText, cipherTextList);
        prepareKeyList(cipherTextList, keyTextList);

        for (int index = 0; index < cipherTextList.size(); index++) {
            Character cipherTextCharacter = cipherTextList.get(index);
             int rowNumber = getRowNumber(Character.toUpperCase(keyTextList.get(index)));
            for (int j = 0; j < cipherTable.length; j++) {
                if (Character.toUpperCase(cipherTextCharacter) == cipherTable[rowNumber][j]) {

                    columnNumber = j;
                    break;
                }
            }

            Character decryptedCharacter = getCharacterFromColumnNumber(columnNumber);
            decryptedText.append(decryptedCharacter);


        }

        return decryptedText.toString();
    }


    private void prepareEncryptedOrDecryptedList(String plainText, ArrayList<Character> plainTextList) {
        for (Character character : plainText.toCharArray()) {
            if (character == ' ') {
                continue;
            }
            plainTextList.add(character);
        }
    }


    private void prepareKeyList(ArrayList<Character> plainTextList, ArrayList<Character> keyTextList) {
        int characterIndex = 0;
        char lastCharacter = key.charAt(key.length() - 1);

        for (int index = 0; index < plainTextList.size(); index++) {

            keyTextList.add(key.charAt(characterIndex));

            if (key.charAt(characterIndex) == lastCharacter) {
                characterIndex = 0;
                continue;
            }

            characterIndex = characterIndex + 1;

        }
    }


    public void insertValuesInCipherTable() {
        int asciiValueStart = 65;
        int asciiValueEnd = 90;


        for (int i = 0; i < cipherTable.length; i++) {
            asciiValueStart = asciiValueStart + i;

            for (int j = 0; j < cipherTable.length; j++) {

                cipherTable[i][j] = (char) asciiValueStart;


                if (asciiValueStart == asciiValueEnd) {
                    asciiValueStart = 65;
                    continue;
                }


                if (j == cipherTable.length - 1) {
                    asciiValueStart = 65;
                    break;
                }

                asciiValueStart = asciiValueStart + 1;
            }
        }
    }


    private void printCipherTable() {
        for (int i = 0; i < cipherTable.length; i++) {
            for (int j = 0; j < cipherTable.length; j++) {
                System.out.print(cipherTable[i][j]);
                System.out.print(" ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }


    private int getRowNumber(Character character) {
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


    private int getColumnNumber(Character character) {
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


    private char getCharacterFromColumnNumber(int columnNumber) {
        return switch (columnNumber) {
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

