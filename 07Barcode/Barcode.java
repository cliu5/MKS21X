
import java.util.*;
import java.io.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
	
	
  public Barcode(String zip){
    if (zip.length()!=5|| (zip.matches("^[0-9]*$"))) {
    this.zip=zip;
    }
    throw new IllegalArgumentException();


}
	

  public String toString(){
	return getCode() + " (" + zip + ")";
    }
	
	// make compare to easier//
private int zipToInt(){
	return Integer.parseInt(zip);
    }

    public int compareTo(Barcode other){
	return zipToInt() - other.zipToInt() ;
    }

    public static String toCode(String zip){
	    Barcode x=new Barcode(zip);
	    if (zip.length()!=5|| (zip.matches("^[0-9]*$"))){
	    return x.getCode();
	    }
	    throw new IllegalArgumentException();
    }
	
	//find the coded version of an int to help with throwing stuff for toZip//
	private static boolean checkSum(String code){
		code = code.substring(1, 31);
		int tot=0;
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<25;i+=4){
			int  x = code.indexOf(code.substring(i, i + 5));
			tot+=x;}
		return code.substring(25,30).equals(bus[tot%10]);
	}
	
	private static boolean allCode(String code){
		code = code.substring(1, 31);
		boolean ans = true;
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<25;i+=4){
			int  x = code.indexOf(code.substring(i, i + 5));
	    		if (x == -1){
				ans=false;
			}
		}
		return ans;
	
	}
	
	//more boolean methods to help with organizing throw if statements//
	private static boolean frontendBarlength(String code){
		return code.length() == 32 && code.charAt(0) == '|' && code.charAt(code.length() - 1) == '|';
	}
	
	
	
	public static String toZip(String code){
		if (!(checkSum(code)&&allCode(code)&&frontendBarlength(code))){
			throw IllegalArgumentException();
		}
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		ans="";
		ArrayList<String> TEMP = new ArrayList<String>();
		for (int x = 0; x < 10; x++){
	    		TEMP.add(bus[x]);
		}
			for (int i=0;i<25;i++){
	    			int  n = TEMP.indexOf(code.substring(i, i + 5));
			}
	}
				
	


	
	public String getCode(){
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String ans = "|";
    	int check = 0;
    for (int i = 0; i < zip.length();i++){
      int temp = Integer.valueOf(zip.charAt(i)+"");
      check += temp;
      ans+=bus[temp];
    }
    ans += bus[check%10] + "|";
	return ans;
  }
	
	
    public String getZip(){
	return zip;
    }

}
	

   

   
    
