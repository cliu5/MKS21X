public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String _author, String _title, String _ISBN, String _callNumber, String _collection){
	super(_author, _title, _ISBN, _callNumber);
	collection = _collection;
    }

    public String getCollection(){
    return collection;
    }

    public void checkout(String patron, String _dueDate){
	System.out.println("Cannot check out a reference book");
    }
    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus(){
	return "non-circulating reference book";
    }
    public String toString(){
	return super.toString() + " " + collection;
    }
}
