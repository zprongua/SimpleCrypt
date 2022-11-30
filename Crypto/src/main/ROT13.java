import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
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

        return "";
    }

    public String encrypt(String text) {
        return rotate(text, charFinish);
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {
        int cf = String.valueOf(c).codePointAt(0);
        int cs = 65;
        if (String.valueOf(c).codePointAt(0) > 90) cs = 97;
        int dif = cf-cs;
        char newChar;
        StringBuilder str = new StringBuilder();
        for (String p : s.split("")) {
            if (p.codePointAt(0) > cs + dif - 1) newChar = (char) (p.codePointAt(0) - dif);
            else newChar = (char) (p.codePointAt(0) + dif);
            str.append(newChar);
        }
        System.out.println(str);
        return str.toString();
    }

}
