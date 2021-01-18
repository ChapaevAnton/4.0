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

    //TODO 4.3.2
    public static void searchText(){
        String regex2="([Aa].{2}[Aa])";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher("aba aba a!a abba adca abea abbbbbA");
        int count = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("find position %d-%d-> %s\n",start,end,matcher.group(1));
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
     *                       <p>2-insert
     *                       <p>3-insert in the middle
     *                       <p>4-reverse
     *                       <p>5-setCharAt
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
                case 2 -> stringBuilder.insert(0, str);
                case 3 -> stringBuilder.insert(stringBuilder.length() / 2, str);
                case 4 -> stringBuilder.reverse();
                case 5 -> stringBuilder.setCharAt(0, 'Z');
            }
        }
        System.out.println(System.currentTimeMillis() - time);
    }


}
