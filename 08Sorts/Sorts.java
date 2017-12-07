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
      int temp = data[i];
	    int currentSmallest = data[i];
	    int currentSmallestIndex = i;
	    for (int x = i; x < data.length; x++){
		    if (currentSmallest > data[x]){
		    currentSmallest=data[x];
        currentSmallestIndex=x;
		     }
	    }
	    data[index] = data[currentSmallest];
	    data[currentSmallestIndex] = temp;
	}
  }
  
  public static void main(String[]artie){                                         
        int[] randish = new int[5];                                                
        for(int i = 0 ; i < randish.length; i++){                                   
            randish[i] =(int)(Math.random()*100);                                   
        }                                                                           
                                                                                                                           
        System.out.println(Arrays.toString(randish));                               
              selectionSort(randish);                                                  
        System.out.println(Arrays.toString(randish));                               
                                                                                    
    }                                                                               
}                                                                                   
                                                         
  
}
