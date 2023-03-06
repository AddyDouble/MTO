
import java.io.*;

class lab2 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'k')){
				String nParam = swapcase(param);
				System.out.print(nParam);
				i++;
			}else if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == '.') && i + 3 < format_string.length()){
				int result = trim(format_string.substring(i+2), param);
                if(result != -1){
                    i += result + 2;
                }
                else{
                    System.out.print(format_string.charAt(i));
                }
			}
			else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		String format_string, param;
		while(bufferReader.ready()) {
			format_string=bufferReader.readLine();
			param=bufferReader.readLine();
			my_printf(format_string,param);
		}
	}

	public static String swapcase(String text){
        String newText = "";
        for(int i = 0; i < text.length(); i++){
            if(Character.isUpperCase(text.charAt(i))){
                newText = newText + Character.toLowerCase(text.charAt(i));
            }
            else if(Character.isLowerCase(text.charAt(i))){
                newText = newText + Character.toUpperCase(text.charAt(i));
            }
            else{
                newText = newText + text.charAt(i);
            }
        }
        return newText;
    }

	public static int trim(String text, String r){
        int i = 0;
        for(; i < text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                continue;
            }
            else if(text.charAt(i) == 'k'){
                break;
            }
            else{
                return -1;
            }
        }
        try {
            int val = Integer.parseInt(text.substring(0, i));
            String newText = "";
            for(int k = 0; k < val && k < r.length(); k++)
                newText = newText + r.charAt(k);
            System.out.print(swapcase(newText));
            return i;
        }
        catch (Exception e){
            return -1;
        }
    }
}
