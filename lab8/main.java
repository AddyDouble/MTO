
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
		my_printf("ab #.1j", "3");
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
			int toFill = val - hex.length();
			String nVal = "";
			for(int k = 0; k < toFill; k++)
				nVal = nVal + "0";
			nVal = nVal + hex;
			hex = swap_chars(nVal);
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
			switch (c) {
				case 'a': {c='g';break;}
				case 'b': {c='h';break;}
				case 'c': {c='i';break;}
				case 'd': {c='j';break;}
				case 'e': {c='k';break;}
				case 'f': {c='l';break;}
				case '0': {c='o';break;}
				default: {c=param.charAt(i);break;}
			};
			nVal.append(c);
		}
		return nVal.toString();
	}
}