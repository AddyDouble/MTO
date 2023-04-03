
import java.io.*;

class lab5 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'g')){
				System.out.print(param);
				i++;
			}else if((i + 2 < format_string.length() && format_string.charAt(i) == '#')){
				int result = pad(format_string.substring(1), param);
				if(result != -1){
					i += result + 1;
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

	public static int pad(String text, String r){
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
		try {
			int val = Integer.parseInt(text.substring(0, i));
			int toFill = val - r.length();
			int num = Integer.parseInt(r);
			r = Integer.toString(num);
			String newText = "";
			for (int k = 0; k < toFill; k++)
				newText = newText + " ";
			if(r.charAt(0) == '-'){
				System.out.print('-');
				r = r.substring(1);
			}
			r = lowerDigits(r);
			newText = newText + r;
			System.out.print(newText);
			return i;
		}
		catch (Exception e){
			return -1;
		}
	}

	public static String lowerDigits(String par){
		String newText = "";
		for(int i = 0; i < par.length(); i++){
			int num = Integer.parseInt(String.valueOf(par.charAt(i)));
			if(num == 0)
				num = 9;
			else
				num--;
			newText = newText + Integer.toString(num);
		}
		return newText;
	}
}
