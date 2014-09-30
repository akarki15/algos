import java.util.*;

class hashString{
	public static void main(String[]args){
		Scanner reader = new Scanner(System.in);
		String s= reader.next();
		hashString hs= new hashString();
		hs.convert(s);
	}

	void convert(String s){
		char [] inputChar = new char [s.length()];
		
		for (int i = 0; i< s.length(); i++){
			inputChar[i] = s.charAt(i);
			System.out.println((int)inputChar[i]);
		}						
	}
}