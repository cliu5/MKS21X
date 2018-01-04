
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
	return getCode() + " (" + getZip() + ")";
    }
	
	// make compare to easier//
private int zipToInt(){
	return Integer.parseInt(zip);
    }

    public int compareTo(Barcode other){
	return zip.compareTo(other.getZip());
    }

    public static String toCode(String zip){
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
    Barcode x=new Barcode(zip);
	    return x.getCode();
    }
	
	//find the coded version of an int to help with throwing stuff for toZip//
	private static boolean checkSum(String code){
		code = code.substring(1, 31);
		int tot=0;
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<25;i+=5){
			int  x = code.indexOf(code.substring(i, i + 5));
			tot+=x;}
		return code.substring(25,30).equals(bus[tot%10]);
	}
	
	private static boolean allCode(String code){
		code = code.substring(1, 31);
		boolean ans = true;
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<25;i+=5){
			int  x = code.indexOf(code.substring(i, i + 5));
	    		if (x == -1){
				ans=false;
			}
		}
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


	
	//dis was hard + needed help//
	public static String toZip(String code){
		if (frontendBarlength(code)&&checkSum(code)){
	    throw new IllegalArgumentException();
	}
		code=code.substring(1,31);
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		String ans="";
		ArrayList<String> TEMP = new ArrayList<String>();
		for (int x = 0; x < 10; x++){
	    		TEMP.add(bus[x]);
		}
			for (int i=0;i<25;i++){
	    			int  n = TEMP.indexOf(code.substring(i, i + 5));
				if (n == -1){
					throw new IllegalArgumentException();
	    			}
				ans+=n;
				i+=4;
			}
		return ans;
	}

				
	
	
	public String getCode(){
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String numbers=zip+ CheckSum(zip);
	String ans = "|";
    
    for (int i = 0; i < numbers.length();i++){
      ans+=ConvertWeird(numbers.substring(i,i+1));
  }
	ans+="|";
	return ans;
}
	
	
    public String getZip(){
	return zip;
    }

}
	

   

   
    
