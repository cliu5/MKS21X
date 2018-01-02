import java.lang.CharSequence;
public class ReversedCharSequence implements CharSequence{
    private String stuff;
    public  ReversedCharSequence(String x){
	stuff="";
	for (int i=x.length()-1;i>=0;i--){
	    stuff+=x.substring(i,i+1);
	}    
    }
    public char charAt(int index){
	return stuff.charAt(index);
    }
    public int length(){
	return stuff.length();
    }
    public CharSequence subSequence(int start, int end){
	return stuff.substring( start , end);
    }


 public static void main(String[] args){
	ReverseCharSequence x = new ReversedCharSequence("ABCDEF");
	System.out.println(x);
	for (int i = 0; i < x.length(); i++){
	    System.out.println(x.charAt(i));
	}
	System.out.println(x.length());		       
	System.out.println(x.subSequence(0,4));
	
 }

}
