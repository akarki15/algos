public class BitTrick{
	public static void main(String[]args){
		BitTrick bt = new BitTrick();
		// System.out.println(bt.set(4,1));
		System.out.println(bt.update(4,0,1));
	}

	int set(int i, int pos){
		return (i | (1<<pos));
	}

	boolean get(int i, int pos){
		return ((i & (1<<pos))!=0);
	}

	int clear(int i, int pos){
		return (i ^ (1<<pos));
	}

	int clearAllBeforeInclusive (int i, int pos){		
		return (((1<<pos)-1)&i);
	}

	int clearAllAfterInclusive(int i, int pos){
		int mask = 1 << pos;
		int temp = mask -1;
		temp += mask;
		temp = ~temp;
		return (i & temp);
	}

	int update(int i, int pos, int value){
		// assumes a valid value 
		// First clear the pos in i, then shift value to that pos and or it with i
		int mask = ~(1<<pos);		
		int temp = i & mask; 
		value = value << pos;
		return (temp | value);
	}

}