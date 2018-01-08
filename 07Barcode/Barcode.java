
import java.util.*;
import java.io.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
	
	
  public Barcode(String zip){
	  if(zip.length()==5){
	  for (int x = 0; x < zip.length(); x++){
		  //ppl helped me w this//
	    if (!Character.isDigit(zip.charAt(x))){
		throw new IllegalArgumentException();
	    }
	}
	this.zip=zip;
	  }
	  else{
	    throw new IllegalArgumentException();
	}

}
	 private static int CheckSum(String zip){
    int sum = 0;
    for (int i=0; i<zip.length(); i++){
      sum += Integer.parseInt(zip.substring(i,i+1));
    }
    return sum % 10;
  }

  public String toString(){
	return toCode() + " (" + getZip() + ")";
    }
	

	
	
	
	
	
	
	
	// make compare to easier//
private int zipToInt(){
	return Integer.parseInt(zip);
    }
	public String toCode(){
		String numbers = zip + CheckSum(zip);
    String ans = "|";
    for (int x=0; x<numbers.length();x++){
      ans += ConvertWeird(numbers.substring(x,x+1));
    }
    ans += "|";
    return ans;
  }

    public int compareTo(Barcode other){
	return zip.compareTo(other.getZip());
    }

    public static String getCode(String zip){
	    //added this bc it wasn't throwing properly//
	      if (zip.length() == 5){
      for (int i=0; i<zip.length();i++){
        if (!Character.isDigit(zip.charAt(i))){
          throw new IllegalArgumentException();
        }
      }
    }
    else {
      throw new IllegalArgumentException();
    }
    
	    String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String numbers=zip+ CheckSum(zip);
	String ans = "|";
    
    for (int i = 0; i < numbers.length();i++){
      ans+=ConvertWeird(numbers.substring(i,i+1));
  }
	ans+="|";
	return ans;
    }
	
	
	
	
	//more boolean methods to help with organizing throw if statements//
	private static boolean frontendBarlength(String code){
		return code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|';
	}
	
	private static String ConvertWeird(String str){
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    return bus[Integer.parseInt(str)];
  }

  public static String ConvertNumber(String code){
	  //given a code make it the corresponding int//
	  // this was kinda confusing at first but all u do is loop thru the bus variable and if it matches return the int//
	  
	  String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    for (int i=0;i<bus.length;i++){
      if (code.equals(bus[i])){
        return i+"";
      }
    }
    throw new IllegalArgumentException();
  }
	
	//dis was hard + needed help//
	public static String toZip(String code){
		//first make sure length and first last are correct//
		if (code.length() != 32){
      throw new IllegalArgumentException();
    }
    if (!(code.charAt(0)=='|' && code.charAt(31)=='|')){
      throw new IllegalArgumentException();
    }
		
		
    String ans = "";
    for (int i=1;i<27;i+=5){
      ans += ConvertNumber(code.substring(i,i+5));
    }
	//check if checksum is right//	
    int sum = 0;
    for (int i=0;i<5;i++){
      sum += Integer.parseInt(ans.substring(i,i+1));
    }
    if (sum % 10 == Integer.parseInt(ans.substring(5,6))){
      return ans.substring(0,5);
    }
		//otherwise throw//
    throw new IllegalArgumentException();
  }


				
	
	
	
		

	
	
    public String getZip(){
	return zip;
    }

}
	

   

   
    
