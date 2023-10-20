public class CaesarEncrypt {


    public String encode(String text) {

        StringBuilder encryptedText = new StringBuilder();
        Character convertedChar;
        boolean isUpperLetter = false;
        for (Character character : text.toCharArray()) {

            if ((Character.isAlphabetic(character) || character == 32)) {

                if (character == 32) {
                    encryptedText.append(" ");
                    continue;

                }
                if (!(character > 96 && character < 123)) {
                    isUpperLetter = true;
                    character = (char) (character + 32);
                }
                convertedChar = (char) (character + 3);
                if (convertedChar > 122) {
                    convertedChar = (char) (97 + (convertedChar - 122 - 1));
                }
                if (isUpperLetter) {
                    convertedChar = (char) (convertedChar - 32);
                    isUpperLetter = false;


                }
                encryptedText.append(convertedChar);

            } else {
                encryptedText.setLength(0);
                encryptedText.append("Invalid input");
                return encryptedText.toString();
            }

        }
        return encryptedText.toString();

    }

    public String decode(String encryptedText) {
        StringBuilder text = new StringBuilder();
        Character convertedChar;
        boolean isUpperLetter = false;
        for (Character character : encryptedText.toCharArray()) {

            if ((Character.isAlphabetic(character) || character == 32)) {
                if (character == 32) {
                    text.append(" ");
                    continue;

                }
                if (!(character > 96 && character < 123)) {
                    isUpperLetter = true;
                    character = (char) (character + 32);

                }
                convertedChar = (char) (character - 3);
                if (convertedChar < 97) {
                    convertedChar = (char) (122 - (97 - convertedChar - 1));
                }
                if (isUpperLetter) {
                    convertedChar = (char) (convertedChar - 32);
                    isUpperLetter = false;


                }
                text.append(convertedChar);

            } else {
                text.setLength(0);
                text.append("Invalid input");
                return text.toString();
            }

        }
        return text.toString();
    }
}


// Cipher Text to Encrypted Text
