public class SuperArray{
private String[] data;
    private int size;
    //Phase 1//
    //Constructor//
    public SuperArray(){
	data= new String[10];
	size=0;
    }
	public SuperArray(int _startingcapacity){
		data=new String[_startingcapacity];
		size=0;
	}
    //1.//
    public void clear(){
	data= new String[data.length];
	size=0;
    }
    //2.//
    public int size(){
	return size;
    }

    public boolean isEmpty(){
	return size==0;
    }
     //3.//
    public boolean add(String element){
	if(size==data.length){
		resize();
	}
	    data[size]=element;
	    size++;
	    return true;
    }
    //4.//
    public String toString(){
	//Needed some help with this kept getting errors//
	String temp = "[";
	for (int i=0; i< size;i++){
	    temp+=data[i]+",";
	}
	return temp.substring(0,temp.length()-2)  + "]";
    }
    //5.//
    public String get(int index){
	if (index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	    else{
	    return data[index];
	}
    }
    //6.//
    public String set(int index, String element){
	String temp;
	if (index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    temp=data[index];
	    data[index]=element;
	    if (index>=size){
		size++;
	    }
	    return temp;
	}
    }
    //Phase 2//
    //7.//
    private void resize(){
	String[] temp = new String[size*2];
	for (int i=0;i<size;i++){
	    temp[i]=data[i];
        }
	data = temp;
    }
    //Phase 3//
    //8.//
    public boolean contains(String element){
	for (int i=0; i<size;i++){
	    if (data[i].equals(element)){
		return true;
	    }
	}
	    return false;
	
    }
    //9.//
    public int indexOf(String element){
	for (int i=0;i<size;i++){
	    if (data[i].equals(element)){
		return i;
	    }
	}
	    return -1;
		
    }
		
    public int lastIndexOf(String element){
	for (int i=size-1;i>=0;i--){
	    if (data[i].equals(element)){
		return i;
	    }
	}
	    return -1;
		
    }
    //10.//
    public void add(int index, String element){
	if (index<0||index>=size){
	    throw new IndexOutOfBoundsException();
	}
	if(index==size){
	    add(element);
	}
	if (index<size){
	    resize();
	    size++;
	    for (int i=size-1;i>index;i--){
		data[i]=data[i-1];
	    }
	    data[index]=element;
	}
    }
    //11.//
    public String remove(int index){
	if (index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	String temp  = data[index];
	String[] temp2 = new String[size - 1];
	for (int i = 0; i < index; i++){
        temp2[i] = data[i];
	}
	size--;
	for (int i = index; i < size; i++){
	temp2[i] = data[i+1];
	}
	data=temp2;
	return temp;
    }

    //12.//
    public boolean remove(String element){
	if(contains(element)){
	    remove(indexOf(element));
	    return true;
	}
	return false;
    }
    
}
