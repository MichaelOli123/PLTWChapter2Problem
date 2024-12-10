import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;

public class Scraper {
    private Document docu;
    public static void main(String[] args) throws IOException{
        Scraper scrape = new Scraper();
        System.out.println("Print");
        System.out.println(scrape.getReviews().text());
        //scrape.getAllReviews();
        
    }
    public Scraper(String url) throws IOException{
        docu = Jsoup.connect(url).get();
    }
    public Scraper() throws IOException{
        File input = new File("localreviews.html");
        docu = Jsoup.parse(input, "UTF-8", "");
    }

    public Elements getReviews(){
        // return docu.select("span.tl-m db-m");
        return docu.getElementsByClass("f7 b mv0"); // tl-m db-m is reviews
    }

    public void getAllReviews() throws IOException{
        int totalPages =  Integer.valueOf(getReviews().text().split(" reviews 5 stars")[0].substring(getReviews().text().split(" reviews 5 stars")[0].length()-3));
        FileWriter writer = new FileWriter("socialMediaPosts.txt");
        for (int i=1;i<((totalPages/10)+2);i++){
            System.out.println(i);
            //docu = Jsoup.connect("https://www.walmart.com/reviews/product/5316226524?page=" + i).get();
            // whatever function that gets the reviews here
            // split the result of the function by whatever character it is, then write those to the text file
            // with writer.write("text here")
            // use writer.close() when done
        }

    }
}

