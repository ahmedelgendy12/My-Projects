
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;


public class WebScrape {
public static void main(String[] args) throws IOException {
	int z = 0;
	int i = 0;
	int j = 0;
	String path = new java.io.File(".").getCanonicalPath();
;
	Store[] stores = new Store[241];
	for (int n = 0; n < 241; n++) {
	    stores[n] = new Store();
	}
	
	String url = "https://www.yelp.com/search?find_desc=&find_loc=+Connecticut+&l=g%3A-72.78717041015625%2C41.68265602330117%2C-72.58255004882812%2C41.83631627521813&start";
	for(int k = 0; k < 240; k = k+10) {
		i = k;
		z = k;
		j = k;
	try {
		String numURL = String.valueOf(k);
    //iterate through the URLs
		Jsoup.connect(url+"="+numURL).userAgent("Safari").timeout(6000).get();

		Document document = Jsoup.connect(url+"="+numURL).userAgent("Safari").timeout(6000).get();
		
		// Get the Ul tag
		Elements body = document.getElementsByTag("ul");
		
		//Get elements by class
		Elements content = document.getElementsByClass(" undefined list__09f24__ynIEd");
		Elements subContent = content.first().getElementsByTag("li");

	
		// gets all the links from the website
		Elements links = document.getElementsByClass("border-color--default__09f24__NPAKY").select("a[href]");
		
	
		//If rating doesn't exist keep reconnecting until they do
		 while(getDouble(document.select("span.css-gutk1c").text()) == 0) {
       Jsoup.connect(url+"="+numURL).userAgent("Safari").timeout(6000).get();
			document = Jsoup.connect(url+"="+numURL).userAgent("Safari").timeout(6000).get();
			 body = document.getElementsByTag("ul");
			//Get elements by class
			 content = document.getElementsByClass(" undefined list__09f24__ynIEd");
			 subContent = content.first().getElementsByTag("li");
		 }
		System.out.println (document.select("span.css-gutk1c").text());
			 
    // Gets title of each restaurant and stores it to the array
    Elements title = document.select("span.css-1egxyvc");
		for (Element link : title) {
			stores[i].name = link.text();
			System.out.println(stores[i++].getName());
			}
		   
    // Gets rating of each restaurant and stores it to the array
		Elements linkas = document.select("span.css-gutk1c");
		for (Element link : linkas) {
		String temp = link.text();
		double num = getDouble(temp);
		if(num != 0) {
			stores[j].rating = num;
		System.out.println(stores[j++].rating);
		}
		}		
		
    // Gets reviews of each restaurant and stores it to the array 
		Elements reviews = document.select("span.css-chan6m");
		for (Element link : reviews) {
			String temp = link.text();
			int num = getInt(temp);
			if(num != 0) {
			stores[z].reviews = num;
			System.out.println(stores[z++].reviews);
			}
		}	
	}catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	
	
  //Sorts the array by reviews from highest to lowest
	for (int outer = 0; outer < stores.length; outer++) {
	      // iterate through and swap out of order array
	      for (int inner = 0; inner < stores.length - 1; inner++) {
	        if (stores[inner].getReviews() < stores[inner + 1].getReviews()) {
	          Store rateMe = stores[inner];
	          stores[inner] = stores[inner + 1];
	          stores[inner + 1] = rateMe;
	        }
	      }
	}
	for(int lengthy = 0; lengthy < 240; lengthy = lengthy+10) {
	for (int outer = lengthy; outer < lengthy+10; outer++) {
	      // iterate through and swap out of order array
	      for (int inner = lengthy; inner < lengthy+10; inner++) {
		        if (stores[inner].getRating() < stores[inner + 1].getRating()) {
	          Store temp = stores[inner];
	          stores[inner] = stores[inner + 1];
	          stores[inner + 1] = temp;
	        }
	      }
	}
	}
  //Creates the file if doesn't exist and starts printing to the file
	File file = new File("RESULT.txt");
	 PrintStream stream = new PrintStream(file);
     System.out.println("Data going to " + file.getAbsolutePath());
     System.setOut(stream);
     for(int printNum = 0; printNum < stores.length; printNum++) {
         System.out.println(stores[printNum].name + ',' + stores[printNum].rating + ',' + stores[printNum].reviews);
     }
  
     stream.close();
 	File file2 = new File("RESULTCOPY.txt");
	 PrintStream stream2 = new PrintStream(file2);
    System.out.println("Data going to " + file2.getAbsolutePath());
    System.setOut(stream2);
    for(int printNum = 0; printNum < stores.length; printNum++) {
        System.out.println(stores[printNum].name + ',' + stores[printNum].rating + ',' + stores[printNum].reviews);
    }
 
    stream.close();
     System.exit(0);
     
}
	//Parse through the String and gets only the double
   public static double getDouble(String input) {
	    int count = 0;
	    String acceptDouble = ".0123456789";
	    String result = "";
	    // iterate through the String
	    for (int index = 0; index < input.length(); index++) {
	      char letter = input.charAt(index);
	      // Checks for '.' and if the second one was typed in replace with 'a'
	      if (letter == '.') {
	        count++;
	        if (count > 1) {
	          letter = 'a';
	        }
	      }
	      if (acceptDouble.indexOf(letter) > -1) {
	        result += letter;
	      }
	    }
	  
	    if (result.equals("")) {
	      return 0;
	    }
	    double finalResult = Double.parseDouble(result);

	    return finalResult;
	  }

  //Parse through the String and gets only the Integer
   public static int getInt(String input) {
	    String acceptInt = "0123456789";
	    String result = "";
	    // iterate through the String
	    for (int index = 0; index < input.length(); index++) {
	      char letter = input.charAt(index);
	      if (acceptInt.indexOf(letter) > -1) {
	        result += letter;
	      }
	    }
	    if (result.equals("")) {
	      return 0;
	    }
	    int finalResult = Integer.parseInt(result);
	    return finalResult;
	  }
   
}
