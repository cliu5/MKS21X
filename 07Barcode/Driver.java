public class Driver{ 
public static void main(String[] args){
String[]badBarcodes = {"|||:::||:::||:::||:::||:::||:::",
      "|||:::||:::||:::||:::||:::||:::||||",
      "|||:::||:::||:::||:::||:::||::::",
      ":||:::||:::||:::||:::||:::||:::|",
      "||:|::||z::|:|::||::f:::|||:|::|",
      "|:::||||:::a::||||::::::||::||:|",
      "|||:::||:::||:::||:::||::::::|||"    };
	for (int i=0;i<8;i++){
		System.out.println(Barcode.toZip(badBarcodes[i]));
				   }
				   }
				   }
