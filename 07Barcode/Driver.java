public class Driver{ 
public static void main(String[] args){
    Barcode jerry = new Barcode("36751");
    Barcode lerry = new Barcode("36749");
    Barcode serry = new Barcode("36751");
    Barcode merry = new Barcode("36753");
   
    System.out.println(jerry.getCode());
    System.out.println(jerry.zip);
    System.out.println(jerry);
    System.out.println(jerry.compareTo(lerry));
    System.out.println(jerry.compareTo(serry));
    System.out.println(jerry.compareTo(merry));
   
    System.out.println("----");
   
    System.out.println(jerry.getZip());
    System.out.println(toZip(jerry.getCode()));
    Barcode y = new Barcode("11133");
    Barcode x = new Barcode("11111");
    System.out.println(y);
    System.out.println(y.getZip());
    System.out.println(y.getCode());
    System.out.println(x.equals(y));
    System.out.println(x.compareTo(y));

    Barcode e = new Barcode("12sa1"); //Should throw an error, as not valid nums
    Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
    Barcode.toCode("131"); //Should throw an error, too little nums
    Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
    Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
    Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
    Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
    Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found
  }
				   }
