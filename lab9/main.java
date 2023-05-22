
import java.io.*;

class lab9 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == '.') && i + 3 < format_string.length()){
				int result = printFloat(format_string.substring(i+2), param);
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

	public static int printFloat(String text, String r){
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
			int sep_index = r.indexOf('.');
			String before = "";
			if(sep_index < 0){
				before = r.substring(0);
				before = swap_to_chars(before);
				System.out.print(before);
				return i;
			}
			before = swap_to_chars(r.substring(0, sep_index));
			String nVal = before;

			String after = r.substring(sep_index+1);
			if(after.length() >= val){
				if(val == 0)
					after = "";
				else
					after = after.substring(0, val);
			}
			else{
				int toFill = val - after.length();
				for(int k = 0; k < toFill; k++)
					after = after + "0";
			}
			after = swap_values(after);
			nVal = nVal + "." + after;
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

	public static String swap_values(String r){
		StringBuilder nVal = new StringBuilder();
		for(int i = 0; i < r.length(); i++){
			int v = Integer.parseInt(String.valueOf(r.charAt(i)));
			v = (v+5) % 10;
			nVal.append(v);
		}
		return nVal.toString();
	}

	public static void main(String[] args) throws IOException {
		my_printf("bcc #.3h", "4.123");
	}
}
