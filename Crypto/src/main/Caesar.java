public class Caesar extends ROT13 {

    public Caesar() {
        super();
    }

    @Override
    public String encrypt(String text) {
        return rotate(text);
    }

    @Override
    public String decrypt(String text) {
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : text.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                if (pc > 64 && pc < 68 || pc > 96 && pc < 100) newChar = (char) (pc + 23);
                else newChar = (char) (pc - 3);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }

    public static String rotate(String s) {
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : s.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                if (pc > 87 && pc < 91 || pc > 119 && pc < 123) newChar = (char) (pc - 23);
                else newChar = (char) (pc + 3);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }
}
