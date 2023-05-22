
import java.io.*;

class lab9 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == '.') && i + 3 < format_string.length()){
				int result = printHexa(format_string.substring(i+2), param);
				if(result != -1){
					i += result + 2;
				}
				else{
					System.out.print(format_string.charAt(i));
				}
			}else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}

	public static int printHexa(String text, String r){
		int i = 0;
		for(; i < text.length(); i++){
			if(Character.isDigit(text.charAt(i))){
				continue;
			}
			else if(text.charAt(i) == 'h'){
				break;
			}
			else{
				return -1;
			}
		}

		try{
			int val = Integer.parseInt(text.substring(0, i));
			float num = Float.parseFloat(r);
			int toFill = val - r.length();
			String before = swap_to_chars(r.substring(0, r.indexOf('.')));
			String nVal = before;
			System.out.print(nVal);
			return i;
		}catch (Exception e){
			return -1;
		}
	}

	public static String swap_to_chars(String r){
		StringBuilder nVal = new StringBuilder();
		for(int i = 0; i < r.length(); i++){
			char c = r.charAt(i);
			if(c == '0')
				c = 'a';
			else if(c == '1')
				c = 'b';
			else if(c == '2')
				c = 'c';
			else if(c == '3')
				c = 'd';
			else if(c == '4')
				c = 'e';
			else if(c == '5')
				c = 'f';
			else if(c == '6')
				c = 'g';
			else if(c == '7')
				c = 'h';
			else if(c == '8')
				c = 'i';
			else if(c == '9')
				c = 'j';
			nVal.append(c);
		}
		return nVal.toString();
	}

	public static void main(String[] args) throws IOException {
		my_printf("#.3h", "0123.3");
	}
}
