
import java.io.*;

class lab0 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'k')){
				String nParam = swapcase(param);
				System.out.print(nParam);
				i++;
			}else{
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
}
