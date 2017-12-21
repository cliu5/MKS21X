import java.util.Arrays;
public class Sorts{
  public static String name(){
	return "09.Liu.Claire"; 
    }
	
    //Helpers//
 public static boolean isSorted(int[]ary){                                       
        for(int i = 0; i < ary.length - 1 ; i++){                                   
            if(ary[i] > ary[i+1]){                                                  
                return false;                                                       
            }                                                                       
        }                                                                           
        return true;                                                                
    }               
	
	private static void swap(int[]ary,int a, int b){
    int c =ary[a];
    ary[a] = ary[b];
    ary[b] = c;
}
	
    // 1. Selection Sort//
public static void selectionSort(int[] data){
  int currentSmallest=0;
  int currentSmallestIndex=0;
	for (int i = 0; i < data.length; i++){
	    int index=i;
	    currentSmallestIndex=i;
	currentSmallest = data[i];
	    for (int x = i+1; x < data.length; x++){
		    if (currentSmallest > data[x]){
		    currentSmallest=data[x];
        		currentSmallestIndex=x;
		     }
	    }
	    swap(data,index,currentSmallestIndex);
	    
	}
  }

	
    // 2. Insertion Sort//
public static void insertionSort(int[] data){
	for (int i=0;i<data.length;i++){
		int index=i;
	while(index>0 &&data[index]<data[index-1]){
		swap(data, index,index-1);
		index--;
	}
	}
}

  // 3. Bubble Sort//
public static void bubbleSort(int[] data){
	int x = data.length-1;
	while(x>0){
	    for(int i = 1; i<=x; i++){
		if(data[i] < data[i-1]){
			swap(data,i,i-1);
       		}
	    }
	    x--;
	}
    }
	
				
		
		
  /*Driver
  public static void main(String[]artie){                                         
        int[] randish = new int[5];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                                                           
        System.out.println(Arrays.toString(randish));                               
             // selectionSort(randish); 
	     //insertionSort(randish);
	     //bubbleSort(randish);
        System.out.println(Arrays.toString(randish));                               
                                                                                    
    }                                                                               


  */
}
