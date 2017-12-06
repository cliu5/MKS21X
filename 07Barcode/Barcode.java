
import java.util.*;
import java.io.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;
	
	
  public Barcode(String zip){
    if (zip.length()!=5|| (zip.matches("^[0-9]*$"))) {
    this.zip=zip;
    }
    throw new IllegalArgumentException();
String[] bus = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};

}
	

  public String toString(){
	return getCode() + " (" + zip + ")";
    }
	
	// make compare to easier//
private int zipToInt(){
	return Integer.parseInt(zip);
    }

    public int compareTo(Barcode other){
	return zipToInt() - other.ziptoInt() ;
    }

    public static String toCode(String zip){
	    Barcode x=new Barcode(zip);
	    if (zip.length()!=5|| (zip.matches("^[0-9]*$"))){
	    return x.getCode();
	    }
	    throw new IllegalArgumentException();
    }
	
	//find the coded version of an int to help w/ throwing stuff for toZip//
	private static String barToChar(int x){
		return bus[x];
	}
	
	public static String toZip(String code){
	return null;
    }
	
	
	public String getCode(){
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
	

   

   
    
