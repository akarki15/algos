public class Q{
	int [] q;
	int first = last = 0;

	public static void main(String []args){
		q = new int[(int)args[0].charAt(0)];
	}

	public int enqueue(int i){
		q[last]= i;
		if (last==q.length-1){
			if (first>0){
				last=0;
			}else {
				doubleQ();
			}
		}else {
			last++;
		}

		return q[((last-1)mod (q.length-1))];
	}

	public void dequeue(){
		first = (first-1) mod (q.length-1);
	}
	
}