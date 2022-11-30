public class Caesar extends ROT13 {

    public Caesar() {
        super();
    }

    @Override
    public String encrypt(String text) {
        return rotate(text, 3);
    }

    @Override
    public String decrypt(String text) {
        return rotate(text, -3);
    }

    public static String rotate(String s, int i) {
        char newChar;
        int dif = i;
        int dif1;
        if (dif > 0) dif1 = dif + 20;
        else dif1 = dif - 20;
        StringBuilder str = new StringBuilder();
        for (String p : s.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                int cs = 65;
                if (pc > 90) {
                    cs = 97;
                }
                if (pc > 87 && pc < 91 || pc > 119 && pc < 123) newChar = (char) (pc - dif1);
                else newChar = (char) (pc + dif);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }
}
