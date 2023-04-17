import java.io.*;

class lab6 {
    public static void main(String[] args) throws IOException {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String format_string, param;
		while (bufferReader.ready()) {
			format_string = bufferReader.readLine();
			param = bufferReader.readLine();
			my_printf(format_string, param);
		}
    }

    public static void my_printf(String format_string, String param) {
        for (int i = 0; i < format_string.length(); i++) {
            if ((format_string.charAt(i) == '#') && (format_string.charAt(i + 1) == '.') && i + 3 < format_string.length()) {
                int result = padding(format_string.substring(i + 2), param);
                if (result != -1) {
                    i += result + 2;
                }
            } else {
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println("");
    }

    public static int padding(String text, String r){
        int i = 0;
        for(; i < text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                continue;
            }
            else if(text.charAt(i) == 'g'){
                break;
            }
            else{
                return -1;
            }
        }
        try{
            int val = Integer.parseInt(text.substring(0, i));
            if(r.charAt(0) == '-'){
                System.out.print("-");
                r = r.substring(1);
            }
            int toFill = val - r.length();
            int num = Integer.parseInt(r);
            r = Integer.toString(num);
            String newText = "";
            for (int k = 0; k < toFill; k++)
                newText = newText + "0";
            r = changeDigits(newText+r);
            newText = r;
            System.out.print(newText);
            return i;
        }
        catch (Exception e){
            return -1;
        }
    }

    private static String changeDigits(String par){
        String newText = "";
        for(int i = 0; i < par.length(); i++){
            int num = Integer.parseInt(String.valueOf(par.charAt(i)));
            num = swapDigit(num);
            newText = newText + Integer.toString(num);
        }
        return newText;
    }

    private static int swapDigit(int digit){
        return (digit*9+1)%10;
    }
}
