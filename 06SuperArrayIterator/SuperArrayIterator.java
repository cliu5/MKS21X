import java.util.*
public class SuperArrayIterator implements Iterator<String>{
private String[] data;
private int current;
private int end;
public SuperArrayIterator (String[]data, int size){
  this.data=data;
  current=0;
  end=size-1;
  }
 public void remove(){
  throw new UnsupportedOperationException();
  }
  
 public boolean hasNext(){
 return current<=end;
 }
 public String next(){
 if (hasNext()){
 current++;
 }
 else{
 System.exit(0);
 }
 return data[current-1];
 }
 }
