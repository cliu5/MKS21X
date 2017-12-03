public class CirculatingBook extends LibraryBook{
  private String currentHolder;
  private String dueDate;
  public CirculatingBook(String _author, String _title, String _ISBN, String _callNumber){
    super(_author,_title,_ISBN,_callNumber);
    currentHolder=null;
    dueDate=null;
  }
  public void checkout(String patron, String _dueDate){
    currentHolder=patron;
    dueDate=_dueDate;
  }
  public void returned(){
    currentHolder=null;
    dueDate=null;
  }
  public String circulationStatus(
    if (currentHolder != null){
      return currentHolder+ " " + dueDate;
    }
      return "book available on shelves" ;
    }
    
}
