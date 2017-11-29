abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(aut,t,is,cal){
	Author=aut;
	Title=t;
	ISBN=is;
	callNumber=cal;
    }
    public string getCallNumber(){
	return callNumber;
    }
    public abstract void checkout(String patron,String due){
    }
    public abstract void returned(){
    }
    public abstrat String circulationStatus(){
    }
