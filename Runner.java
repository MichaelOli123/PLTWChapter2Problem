import java.io.IOException;

public class Runner{
    public static void main(String[] args) throws IOException{
        Scraper scrape = new Scraper("https://www.walmart.com/reviews/product/5316226524?page=");
        //scrape.getAllReviews();
        // ^ commented out for now to not spam the website
        DataCollector datac = new DataCollector();
        datac.setData("socialMediaPosts.txt","targetWords.txt");
    }
} 
