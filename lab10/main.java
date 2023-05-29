
import java.io.*;

class lab10 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'a')){
				printNum(param);
				i++;
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

	private static void printNum(String param){
		int N = param.length();
		if(param.charAt(0) == '-')
			N -= 1;

		int O = Integer.parseInt(param);

		int F = (int) (O*2)/N;

		if(F % 2 == 0){
			System.out.print(F);
		}
		else{
			String hexa = String.format("%x", F);
			System.out.print(hexa);
		}
	}
}
