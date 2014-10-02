import java.util.Scanner;

class dp{
	public static void main(String [] args){
	fibList = new ArrayList<int>();
	fibList.add(0);
	fibList.add(1);
	Scanner s = new Scanner (System.in);
	dp dp = new dp();
	int n = (int) reader.next();
	dp.fib();
}
	
ArrayList <int> fibList;
void fib(int n){
if (n<=(fibList.size())){
return fibList.get(n);
}
return (fib(n-1)+fib(n-2));
}
}
