
import java.io.*;

class lab8 {
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
	public static void main(String[] args) throws IOException {
		//System.out.println("Hello, World!"); 
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		String format_string, param;
		while(bufferReader.ready()) {
			format_string=bufferReader.readLine();
			param=bufferReader.readLine();
			my_printf(format_string,param);
		}
	}

	public static int printHexa(String text, String r){
		int i = 0;
		for(; i < text.length(); i++){
			if(Character.isDigit(text.charAt(i))){
				continue;
			}
			else if(text.charAt(i) == 'j'){
				break;
			}
			else{
				return -1;
			}
		}

		try{
			int val = Integer.parseInt(text.substring(0, i));
			int num = Integer.parseInt(r);
			String hex = Integer.toHexString(num);
			hex = swap_chars(hex);
			System.out.print(hex);
			return i;
		}catch (Exception e){
			return -1;
		}
	}

	public static String swap_chars(String param) {
		StringBuilder nVal = new StringBuilder();
		for (int i = 0; i < param.length(); i++) {
			char c = param.charAt(i);
			c = switch (c) {
				case 'a','A' -> 'g';
				case 'b','B' -> 'h';
				case 'c','C' -> 'i';
				case 'd','D' -> 'j';
				case 'e','E' -> 'k';
				case 'f','F' -> 'l';
				case '0' -> 'o';
				default -> param.charAt(i);
			};
			nVal.append(c);
		}
		return nVal.toString();
	}
}
