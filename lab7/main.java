
import java.io.*;

class lab7 {
    public static void my_printf(String format_string, String param) {
        for (int i = 0; i < format_string.length(); i++) {
            if ((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == 'j')) {
                print_x(param);
                i++;
            } else {
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println("");
    }

    public static void print_x(String param) {
        int val = Integer.parseInt(param);
        String hex = Integer.toHexString(val);
        hex = swap_chars(hex);
        System.out.print(hex);
    }

    public static String swap_chars(String param) {
        StringBuilder nVal = new StringBuilder();
        for (int i = 0; i < param.length(); i++) {
            char c = param.charAt(i);
            c = switch (c) {
                case 'a' -> 'g';
                case 'b' -> 'h';
                case 'c' -> 'i';
                case 'd' -> 'j';
                case 'e' -> 'k';
                case 'f' -> 'l';
                default -> param.charAt(i);
            };
            nVal.append(c);
        }
        return nVal.toString();
    }

    public static void main(String[] args) throws IOException {
        //System.out.println("Hello, World!");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc=new Scanner(System.in);
        String format_string, param;
        while (bufferReader.ready()) {
            format_string = bufferReader.readLine();
            param = bufferReader.readLine();
            my_printf(format_string, param);
        }
    }
}
