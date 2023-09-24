import org.jsoup.nodes.Element;

public class Store {
   String name;
   double rating;
   int reviews;
   
   
   public void setName(String name) {
	    name = this.name;
   }

   public void setRating(Double rating) {
	    rating = this.rating;
  }

   public void setReviews(int reviews) {
	    reviews = this.reviews;
 }
  
   public String getName() {
	   return name;
   }
   
   public double getRating() {
	   return rating;
   }
   
   public int getReviews() {
	   return reviews;
   }
   
   

}