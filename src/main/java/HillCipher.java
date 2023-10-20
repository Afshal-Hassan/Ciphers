
public class HillCipher {


    private int[][] key = {
            {7, 8},
            {11, 11}
    };


    private int[][] matrix = new int[2][1];
    private int[][] resultantMatrix = new int[2][1];


    public String encode(String plainText) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i += 2) {
            char a = plainText.charAt(i);
            char b = plainText.charAt(i + 1);

            matrix[0][0] = getIntegerValueOfCharacter(a);
            matrix[1][0] = getIntegerValueOfCharacter(b);
            String resultantText = multiplyMatrixAndGetCharacters(matrix);
            for (int j = 0; j < resultantText.length(); j++) {
                encodedText.append(resultantText.charAt(j));
            }
        }

        return encodedText.toString();

    }

    public String multiplyMatrixAndGetCharacters(int[][] matrix) {
        int result = 0;
        StringBuilder encodedText = new StringBuilder();
        for (int rowOfFirstMatrix = 0; rowOfFirstMatrix < 2; rowOfFirstMatrix++) {
            for (int column = 0; column < 1; column++) {
                for (int row = 0; row < 2; row++) {
                    int newResult = key[rowOfFirstMatrix][row] * matrix[row][column];
                    result = result + newResult;

                }
                result = result % 26;
                encodedText.append(getCharacterFromNumber(result));
                result = 0;
            }
        }
        return encodedText.toString();
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
