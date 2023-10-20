public class PlayFairCipher {


    private String key;
    private char[][] keyMatrix;

    public PlayFairCipher(String key) {
        this.key = key;
        this.keyMatrix = generateKeyMatrix();
    }

    private char[][] generateKeyMatrix() {
        String sanitizedKey = key.replace("J", "I").toUpperCase();
        boolean[] used = new boolean[26];
        char[][] matrix = new char[5][5];

        int row = 0, col = 0;
        for (char ch : sanitizedKey.toCharArray()) {
            if (!used[ch - 'A']) {
                matrix[row][col] = ch;
                used[ch - 'A'] = true;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (ch != 'J' && !used[ch - 'A']) {
                matrix[row][col] = ch;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        return matrix;
    }

    private String preparePlainText(String text) {
        text = text.replace("J", "I").toUpperCase();
        StringBuilder preparedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            preparedText.append(text.charAt(i));
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                preparedText.append('X');
            }
        }

        if (preparedText.length() % 2 != 0) {
            preparedText.append('X');
        }

        return preparedText.toString();
    }

    private String encryptDigraph(char a, char b) {
        int rowA = 0, colA = 0, rowB = 0, colB = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == a) {
                    rowA = i;
                    colA = j;
                }
                if (keyMatrix[i][j] == b) {
                    rowB = i;
                    colB = j;
                }
            }
        }

        if (rowA == rowB) {
            colA = (colA + 1) % 5;
            colB = (colB + 1) % 5;
        } else if (colA == colB) {
            rowA = (rowA + 1) % 5;
            rowB = (rowB + 1) % 5;
        } else {
            int temp = colA;
            colA = colB;
            colB = temp;
        }

        return String.valueOf(keyMatrix[rowA][colA]) + keyMatrix[rowB][colB];
    }

    public String encrypt(String plainText) {
        plainText = preparePlainText(plainText);
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i += 2) {
            char a = plainText.charAt(i);
            char b = plainText.charAt(i + 1);
            cipherText.append(encryptDigraph(a, b));
        }

        return cipherText.toString();
    }
}
