package standard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BabblingTest {
    public int solution(String[] babbling) {
        int answer = 0;
        List<String> strList = new ArrayList<>(Arrays.asList(babbling));

        for (String str : strList) {
            int length = str.length();
            do {
                if (length >= 3) {
                    if (str.substring(0, 3).equals("aya")) {
                        if (length >= 6) {
                            if (!str.substring(3, 6).equals("aya")) {
                                str = str.replaceFirst("aya", "");
                            } else
                                break;
                        } else
                            str = str.replaceFirst("aya", "");
                    } else if (str.substring(0, 3).equals("woo")) {
                        if (length >= 6) {
                            if (!str.substring(3, 6).equals("woo")) {
                                str = str.replaceFirst("woo", "");
                            } else
                                break;
                        } else
                            str = str.replaceFirst("woo", "");
                    }
                    length = str.length();
                }
                if (length >= 2) {
                    if (str.substring(0, 2).equals("ye")) {
                        if (length >= 4) {
                            if (!str.substring(2, 4).equals("ye")) {
                                str = str.replace("ye", "");
                            } else
                                break;
                        } else
                            str = str.replace("ye", "");
                    } else if (str.substring(0, 2).equals("ma")) {
                        if (length >= 4) {
                            if (!str.substring(2, 4).equals("ma")) {
                                str = str.replace("ma", "");
                            } else
                                break;
                        } else
                            str = str.replace("ma", "");
                    } else
                        break;
                    length = str.length();
                } else
                    break;
            } while (!str.equals(""));

            if (str.equals("")) {
                answer++;
            }

        }
        return answer;

    }

    public static void main(String[] args) {
        BabblingTest b = new BabblingTest();

        String[] babbling = { "aya", "yee", "u", "maa", "woayao", "wooyemawooye", "mayaa", "ymaeaya" };
        System.out.println(b.solution(babbling));

        String[] babbling2 = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" };
        System.out.println(b.solution(babbling2));
        
        String[] babbling3 = {"ayab","wooc","dye","fma","g","h","i","j","k","l","n","p","s","t","u","v","x","z"
        		,"aa","yy","ee","ww","mm","wooo","woowo","ey","mam","ow","ae","ao","yw","yo","eo","wu"
        		,"wy","wa","wm","oe","my","me","mw","mo"};
        System.out.println(b.solution(babbling3));
        
        String test = "a  b";
        System.out.println(test.replace(" ", ""));
    }
}
