public class Barcode {
  private String zip;
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
