public class Seventeen extends ROT13 {

    public Seventeen() {
        super();
    }

    @Override
    public String encrypt(String text) {
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : text.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                if (pc > 73 && pc < 91 || pc > 105 && pc < 123) newChar = (char) (pc - 9);
                else newChar = (char) (pc + 17);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }

    @Override
    public String decrypt(String text) {
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : text.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                if (pc > 64 && pc < 82 || pc > 96 && pc < 114) newChar = (char) (pc + 9);
                else newChar = (char) (pc - 17);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }
}