
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
	return getCode + "(" + getZip + ")";
    }
    public int compareTo(Barcode other){
	return zip.compareTo(other);
    }
}

  
    public String getZip(){
	return zip;
    }

    public String getCode(){
	String ans = "|";
	int tot = 0;
	for (int i = 0; i < zip.length(); i++){
	    tot += Integer.parseInt(zip.substring(x,x+1));
	    ans += findBarChar(Integer.parseInt(zip.substring(x,x+1)));
	}
	ans += findBarChar(tot % 10);
	return ans + "|";
    }

    public String toString(){
	return getCode() + " (" + zip + ")";
    }

    public int compareTo(Barcode b){
	return zipToInt() - b.zipToInt();
    }

    public boolean equals(Barcode b){
	return zipToInt() == b.zipToInt();
    }

    public static String toCode(String zip){
	Barcode b = new Barcode(zip);
	return b.getCode();
    }

    public static String toZip(String code){
	if (code.length() != 32 || code.charAt(0) != '|' || code.charAt(code.length() - 1) != '|'){
	    throw new IllegalArgumentException();
	}
	code = code.substring(1, 31);
	String ans = "";
	int total = 0;
	String[] tem = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
	ArrayList<String> a = new ArrayList<String>();
	for (int x = 0; x < 10; x++){
	    a.add(tem[x]);
	}
	for (int x = 0; x < 25; x++){
	    int  n = a.indexOf(code.substring(x, x + 5));
	    if (n == -1){
		throw new IllegalArgumentException();
	    }
	    total += n;
	    ans += n;
	    x += 4;
	}
	if (!(code.substring(25,30).equals(findBarChar(total % 10)))){
	    throw new IllegalArgumentException();
	}
	return ans;
    }
    
    private int zipToInt(){
	return Integer.parseInt(zip);
    }

    private static String findBarChar(int x){
	String[] temp = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:", "|:|::"};
	return temp[x];
    }

    
