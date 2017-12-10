import java.util.Arrays;
public class Sorts{
  public static String name(){
	return "09.Liu.Claire"; 
    }
  

	
    
    
public static void selectionSort(int[] data){
  int temp=0;
  int currentSmallest=0;
  int currentSmallestIndex=0;
	for (int i = 0; i < data.length; i++){
      	temp = data[i];
	currentSmallest = data[i];
	    for (int x = i; x < data.length; x++){
		    if (currentSmallest > data[x]){
		    currentSmallest=data[x];
        		currentSmallestIndex=x;
		     }
	    }
		data[currentSmallestIndex] = temp;
	    data[i] = currentSmallest;
	    
	}
  }

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
	
public static void insertionSort(int[] data){
	for (int i=0;i<data.length;i++){
		int index=i;
	while(index>0 &&data[index]<data[index-1]){
		swap(data, index,index-1);
		index--;
	}
	}
}
	
public static void bubbleSort(int[] data){
	int x = data.length-1;
	while(x>0){
	    for(int i = 1; i<=x; i++){
		if(data[i] < data[i-1]){
			swap(data,i,x);
       		}
	    }
	    x--;
	}
    }
	
				
		
		
  
  public static void main(String[]artie){                                         
        int[] randish = new int[5];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                                                           
        System.out.println(Arrays.toString(randish));                               
             // selectionSort(randish); 
	   //insertionSort(randish);
	  bubbleSort(randish);
        System.out.println(Arrays.toString(randish));                               
                                                                                    
    }                                                                               


  
}
