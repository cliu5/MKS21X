
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
		int tot=0;
		String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
		for (int i=0;i<25;i+=4){
			int  x = code.indexOf(code.substring(i, i + 5));
			tot+=x;}
		return code.substring(25,30).equals(bus[tot%10]);
	}
	
	private static boolean allCode(String code){
		boolean ans = true;
		return ans;
	}
	
	
	
	
	public static String toZip(String code){
		
	return null;
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
	

   

   
    
