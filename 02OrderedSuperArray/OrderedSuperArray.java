public class OrderedSuperArray extends SuperArray{

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int startingCapacity){
	super(startingCapacity);
    }

    public OrderedSuperArray(String[] ary){
	super(ary.length);
	for (int i = 0; i < ary.length; i++){
	    add(ary[i]);
	}
    }


    public void add(int index, String value){
	add(value);
    }

    public boolean add(String element) {
	int i = findIndexBinary(element);
	if (i>=size()){
		super.add(element);
	}
	else{
		super.add(x,element);
	}
	return true;
    }
	
	
public String set(int index, String element){
	throw new UnsupportedOperationException();
    }







    private int findIndex(String val){
	for (int i = 0; i < size(); i++){
	    if (get(i).compareTo(val) > 0 ){
		return i;
	    }
	}
	return size();
    }

//CS DOJO HELP DID NOT DO ALONE//

    private int findIndexBinary(String val){
	int start = 0;
	int end = size();
	while (start != end){
	    if (get((start + end)/2).compareTo(val) > 0){
		end = (start + end) / 2;
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	return start;
    }
//CS DOJO HELP//

    

    public int indexOfBinary(String element){
       	int start = 0;
	int end = size;
	while (start != end){
	    if (get((start + end)/2+1).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2 +1).equals(element)){
		if (start == 0 || !(get((start + end) / 2 - 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	return start;
    }
//CSDOJO HELP //
    public int lastIndexOfBinary(String element){
	int start = indexOfBinary(element);
	int end = size;
	while (start != end){
	    if (get((start + end)/2+1).compareTo(element) > 0){
		end = (start + end) / 2;
	    }
	    else if (get((start + end)/2+1).equals(element)){
		if (start == size() - 1 || !(get((start + end) / 2 + 1).equals(element))){
		    return (start + end) / 2;
		}
		end = (start + end) / 2;
		start = (start + end) / 2 - 1; 
	    }
	    else {
		start = (start + end) / 2 + 1;
	    }
	}
	return start;
    }
//CS DOJO HELP// 
