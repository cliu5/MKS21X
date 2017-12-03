public class Book{
  private String author;
  private String title;
  private String ISBN;
  
  public Book(){
  }
  
  public Book(String _author, String _title, String _ISBN){
    author=_author;
    title=_title;
    ISBN=_ISBN;
  }
  public String getAuthor(){
    return author;
  }
  public String getTitle(){
    return title;
  }
  public String getISBN(){
    return ISBN;
  }
  public String toString(){
    return title+" "+ author + " "+ISBN;
  }
}
