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


	 public static void main(String[]args){
    ReversedCharSequence a = new ReversedCharSequence("Hello");
    ReversedCharSequence b = new ReversedCharSequence(a);
    
    System.out.println(a);//olleH
    System.out.println(b);//Hello
    System.out.println(a.charAt(3));//e
    System.out.println(a.length());//5
    System.out.println(a.toString());//olleH
    System.out.println(a.subSequence(2,4));//le
    System.out.println(a.subSequence(0,3));//oll
    System.out.println(a);//olleH
  }
	
	
}
