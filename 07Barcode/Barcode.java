public class Barcode {
  private String zip;
private match = new String[10];
	match[1]=  ":::||";
match[2]=  "::|:|";
match[3]=  "::||:";
match[4]=  ":|::|";
match[5]=  ":|:|:";
match[6]=  ":||::";
match[7]=  "|:::|";
match[8]=  "|::|:";
match[9]=  "|:|::";
match[0]=  "||:::";  
  public Barcode(String _zip){
    if (zip.length()!=5|| (zip.matches("^[0-9]*$"))) {
    zip=_zip;
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
