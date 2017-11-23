import java.lang.CharSequence;
public class ReverseCharSequence implements CharSequence{
    private String stuff;
    public  ReverseCharSequence(String x){
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
	return stuff.subString(start,end);
    }
}
