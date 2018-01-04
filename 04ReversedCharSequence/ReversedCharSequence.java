import java.lang.CharSequence;
public class ReversedCharSequence implements CharSequence{
    private String stuff;
    public  ReversedCharSequence(String x){
	stuff="";
	for (int i=x.length()-1;i>=0;i--){
	    stuff+=x.substring(i,i+1);
	}    
    }
	//jack at the dojo told me to put this in//
	  public ReversedCharSequence (ReversedCharSequence x) {
    this(x.toString());
  }
    public char charAt(int index){
	return stuff.charAt(index);
    }
    public int length(){
	return stuff.length();
    }
public String toString(){
	return stuff;
}
    public ReversedCharSequence subSequence(int start, int end){
	    String temp=stuff.substring(start,end);
	    ReversedCharSequence ans=new ReversedCharSequence(temp);
	    return new ReversedCharSequence(ans);
    }

//borrowed someone's driver//
public static void main(String[] args){
	ReversedCharSeq a = new ReversedCharSeq("ABCDEF");
	for (int x = 0; x < a.length(); x++){
	    System.out.println(a.charAt(x));
	}
			       
	System.out.println(a.subSequence(0,4));
	System.out.println(a);
	System.out.println(a.subSequence(0,6));
	
    }

}
