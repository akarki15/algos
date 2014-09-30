public class sort{

	int [] l ={ 12,2,45,3,2,34,54};
	
	public static void main (String [] args){
		sort s= new sort();
		s.printArray();
		s.mergeSort();
		s.printArray();
	}

	//--------------------------//
	void bubble(){
		boolean unsorted = true;
		while (unsorted){
			unsorted = false;
			for (int i=0;i<l.length-1;i++){
				if (l[i]>l[i+1]){
					swap(i,i+1);
					unsorted = true;		
				}		
			}
		}			
	}

	void printArray(){
		for (int i=0;i<l.length;i++){
			System.out.print(l[i]+", ");			
		}
		System.out.println();
	}

	void swap(int i, int j){
		int temp = l[i];
		l[i] = l[j];
		l[j] = temp; 
	}
	//--------------------------//
	void selection(){
		for (int i=0; i<l.length;i++){
			int smallest = i;  
			for (int j=i+1; j<l.length;j++){
				if (l[j]<l[smallest]){
					smallest = j;
				}
			}
			if (i!=smallest)
				swap (i, smallest);
		}
	}
	//--------------------------//
	void insertion(){
		for (int i=0;i<l.length;i++){
			for (int j=i;j>0;j--){
				if (l[j]<l[j-1])
					swap(j,j-1);
				else 
					break;
			}
		}
	}
	//--------------------------//
	// Heap sort


	void heapsort(){
		heapify();
		printArray();
		sortHeap();
	}

	void heapify(){
		for (int i=l.length-1;i>0;i--){	
			if (l[parent(i)]<l[i]){
				swap(parent(i),i);
				siftdown(i, l.length-1);
			}
		}	
	}

	void sortHeap(){
		for (int i = l.length-1; i>0; i--){
			swap(0,i);
			siftdown(0, i-1);
			printArray();
		}
	}
	int lchild(int i){
		return (2*i)+1;
	}
	
	int rchild(int i){
		return (2*i)+2;
	}

	int parent(int i){		
		return (int) (i-1)/2;		
	}

	// added limit to allow in place sortHeap
	void siftdown(int i, int limit){		
		if (i >= ((int)(l.length-1)/2)){					
			return;			
		} 
		if (l[i]<l[lchild(i)] && lchild(i)<=limit){
			swap(i,lchild(i));
			siftdown(lchild(i), limit);
		}
		if(l[i]<l[rchild(i)] && rchild(i)<=limit){
			swap(i,rchild(i));
			siftdown(rchild(i), limit);
		}
	}

	//-----------------------//
	// Quick Sort
	void quickSort(){
		partition(0, l.length-1, l.length-1);
	}
	void partition(int first, int last, int pivot){
		if (first<last){
			pivot = arrange(first, last, pivot);
		}else {
			return;
		}
		if ((pivot-1)>first)
			partition(first, pivot-1, partitionElement(first, pivot-1));
		if ((pivot+1)<last)
			partition(pivot+1, last, partitionElement(pivot+1,last));
	}

	int arrange (int first, int last, int pivot){
		for (int i=first; i<last;i++){
			if (l[i]>l[pivot]){
				swap(i, pivot-1);
				swap(pivot, pivot-1);
				pivot--;
			}
		}
		return pivot;
	}
	// Pivot element policy 
	int partitionElement(int first, int last){
		return last;
	}

	//------------------------//
	// Merge Sort 
	// Literally spent an hour figuring out wtf was going on with my merge.
	// If you ever need to write an nlogn average case sort, go with quick
	// sort. There is a reason why they call it has a "quick" in its name. 
	
	void mergeSort(){
		divide(0, l.length-1);
	}
	
	int [] divide(int first, int last){
		if (first==last)
			return new int[]{first, last};
		int mid = (last + first) /2;

		int [] endPoints1 = divide(first ,mid);
		int [] endPoints2 = divide(mid + 1, last);
		merge(endPoints1[0], endPoints1[1], endPoints2[0], endPoints2[1]);
		
		return new int[]{endPoints1[0], endPoints2[1]};
	}

	void merge(int a, int b, int i, int j){
		int list1head = a;
		int list2head = i;
		int [] newList = new int [j-a+1];		

		int index =0 ;
		while (list1head<=b || list2head<=j){
			if (list1head>b){
				newList[index++] = l [list2head++];
			}else if (list2head>j){
				newList[index++] = l [list1head++];
			}
			else if (l[list1head]<=l[list2head]){
				newList[index++] = l[list1head++]; 
			} else {
				newList[index++] = l[list2head++]; 
			}			
		}
		// copying back the newlist to l
		for (int x = 0; x< newList.length; x++){			
			l[a + x] = newList[x];						
		}
	}




























}