public class Barcode {
  private String zip;
  public Barcode(String _zip){
    if (zip.length!=5|| (text.matches("^[0-9]*$"))) {
    zip=_zip;
    }
    throw new IllegalArgumentException();

}
}
