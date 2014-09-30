public class Stack{

int index = 0;
int [] stack;

public static void main(String [] args){
	Q q = new Q();
	q.stack = new int[(int)args[0].charAt(0)];
}

public void push(int i){
	check();
	stack[index++]=i;
}
void check(){
	if (index==stack.length-1){
		int [] newstack = new int [stack.length*2];
		for (int i=0; i<stack.length;i++){
			newstack [i] = stack[i];
		}
		stack = newstack;
	}
}


}