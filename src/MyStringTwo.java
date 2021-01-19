import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyStringTwo {

    public static boolean getValidityString(String str) {

        String regex1 = "([A-Za-z0-9_]{1,}[\\.-]{0,1}[A-Za-z0-9_]{1,})" +
                "+(@)([A-Za-z0-9_]{1,}[\\.-]{0,1}[A-Za-z0-9_]{1,})" +
                "+([\\\\.]{1}[a-z]{2,4})";

        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.replaceFirst("$3$2$1$4"));
        System.out.println(matcher.replaceFirst("$0"));
        return matcher.matches();
    }

    //TODO 4.3.2 - 4.3.6
    public static void searchText() {
        String regex2 = "(\s{1,}+[Aa]{1}.{2}[Aa]{1})";//4.3.2
        String regex3 ="([Aa][Bb])"; //4.3.3
        String regex4 ="(20\\d{2})"; //4.3.4
        String regex5 = "(\\*[А-Яа-яЁё]+\\*)"; //4.3.5
        String regex6 = "(\\b[Ss]\\w*[Ss]\\b)"; //4.3.6

        String field1 ="abba aba a!a abba adca abea abbbbbAbba abba";
        String field2 ="fskldjflksd2012rwerkjwekrj2021423423kjfksldjf2021 rwerwer20202000";
        String field3 ="*-ки *должны* примыкать к *СЛОВУ*)апривапшвоапдл*плодвлоап**лвоадлыв*****алывдалоылв* *лдоывдалоыдвлоа*** *-***";
        String field4 = """ 
                Regular Expressions or Regex is an API for defining StringS patterns\
                 that can be used for searching, manipulating and editing a text.\
                 It is widely used to define a constraint on streqweqwe312312ings\
                 such as a password. Regular Expressions SS s_s ss are provided under java.\
                 util.regex package.sfdfs Sfdfdss sewoeiS""";


        Pattern pattern = Pattern.compile(regex6);
        Matcher matcher = pattern.matcher(field4);
        int count = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("find position %d-%d-> %s\n", start, end, matcher.group(1));
            count++;
        }
        System.out.println(matcher.groupCount());
        System.out.println(count);

    }

    //TODO 4.3.1

    /**
     * Testing the speed of work StringBuilder.
     *
     * @param operationsType - type of operations
     *                       <p>1-append
     *                       <p>2-delete
     *                       <p>3-insert
     *                       <p>4-insert in the middle
     *                       <p>5-reverse
     *                       <p>6-setCharAt
     * @param repeat         - iteration count
     * @param str            - string to process
     * @author Smerdin Anton
     * @see java.lang.StringBuilder
     */
    public static void rowRaces(int operationsType, int repeat, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        long time = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            switch (operationsType) {
                case 1 -> stringBuilder.append(str);
                case 2 -> {
                    stringBuilder.delete(0, 1);
                    stringBuilder=new StringBuilder(str);
                }
                case 3 -> stringBuilder.insert(0, str);
                case 4 -> stringBuilder.insert(stringBuilder.length() / 2, str);
                case 5 -> stringBuilder.reverse();
                case 6 -> stringBuilder.setCharAt(0, 'Z');
            }
        }
        System.out.println(System.currentTimeMillis() - time);
    }


}
