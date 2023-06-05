
import java.io.*;

class lab11 {
	public static void my_printf(String format_string, String param){
		for(int i=0;i<format_string.length();i++){
			if((format_string.charAt(i) == '#') && (format_string.charAt(i+1) == 'b')){
				convertToBin(param);
				i++;
			}else{
				System.out.print(format_string.charAt(i));
			}
		}
		System.out.println("");
	}
	/*
	public static void main(String[] args) throws IOException{
		my_printf("A #b", "2");
	}
	 */
	public static void convertToBin(String param){
		char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j'};
		int num = Integer.parseInt(param);
		String bin = Integer.toBinaryString(num);
		StringBuilder nBin = new StringBuilder();
		for(int i = 0; i < bin.length(); i++){
			char c = bin.charAt(i);
			if(c == '0')
				nBin.append('0');
			else{
				nBin.append(letters[i % 10]);
			}
		}
		bin = nBin.reverse().toString();
		System.out.print(bin);
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
}
