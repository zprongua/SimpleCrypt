import java.io.*;

public class ROT13 {
    Character charStart;
    Character charFinish;

    ROT13(Character cs, Character cf) {
        this.charStart = cs;
        this.charFinish = cf;
    }

    ROT13() {
        this(' ', ' ');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        return encrypt(text);
    }

    public String encrypt(String text) {
        return rotate(text, charFinish);
    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public static String rotate(String s, Character c) {
        int cf = String.valueOf(c).codePointAt(0);
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : s.split("")) {
            int pc = p.codePointAt(0);
            if (pc > 64 && pc < 91 || pc > 96 && pc < 124) {
                int cs = 65;
                if (pc > 90) cs = 97;
                int dif = cf - cs;
                if (dif > 13) dif -= 32;
                if (pc > (cs + dif - 1)) newChar = (char) (pc - dif);
                else newChar = (char) (pc + dif);
                str.append(newChar);
            } else str.append(p);
        }
        return String.valueOf(str);
    }

    public void encryptFile(String input, String output) throws Exception {
        try (
                BufferedReader br = new BufferedReader(new FileReader(input));
                BufferedWriter bf = new BufferedWriter(new FileWriter(output));
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bf.write(encrypt(line));
                bf.newLine();
            }
        }
    }
}
