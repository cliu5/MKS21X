abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String _author, String _title, String _ISBN, String _callNumber){
	author=_author;
	title=_title;
	ISBN=_ISBN;
	callNumber=_callNumber;
    }
    public string getCallNumber(){
	return callNumber;
    }
    public abstract void checkout(String patron,String _dueDate){
    }
    public abstract void returned(){
    }
    public abstract String circulationStatus(){
    }
    public int compareTo(LibraryBook other){
	return callNumber.compareTo(other.getCallNumber());
    }
    public String toString(){
	return super.toString() + " " + circulationStatus() + " " + callNumber;
    }
}
