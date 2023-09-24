//Ahmed Elgendy
//CS-152
//Problem 2: Books

public class Book {
  
  String title;
  String author;
  
  public Book(String title,  String author){
    this.title = title;
    this.author = author;
  }
  
  public Book() {
    this.title = "Undefined";
    this.author = "Undefined";
  }
  
  public void setTitle(String newTitle){
    title = newTitle;
  }
  
  public void setAuthor(String newAuthor){
    author = newAuthor;
  }
  
  public String getTitle(){
    return title;
  }
  
  public String getAuthor(){
    return author;
  }
  
  public boolean equals(Book thatBook){
    if(title.equals(thatBook.getTitle())){
    if(author.equals(thatBook.getAuthor())){
      return true;
    } else {
      return false;
    }
  } else {
    return false;
  }
  }

 @Override  
 public String toString(){
    return title + "(by " + author + ")";
  } 
}