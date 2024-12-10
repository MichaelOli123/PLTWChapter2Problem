import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Scraper {
    private Document docu;
    private List<String> reviews;

    public static void main(String[] args) throws IOException {
        Scraper scrape = new Scraper();
        System.out.println("Print all reviews:");
        for (String review : scrape.getAllReviews()) {
            System.out.println(review);
        }
        // System.out.println("\nReview 1, name");
        // System.out.println(scrape.getReview(51));
        // System.out.println("\nReview 1, stars");
        // System.out.println(scrape.getReview(53));
        // System.out.println("\nReview 1, reviewName");
        // System.out.println(scrape.getReview(56));
        // System.out.println("\nReview 1, review");
        // System.out.println(scrape.getReview(57));

        // System.out.println("\nReview 1, name");
        // System.out.println(scrape.getReview(62));
        // System.out.println("\nReview 1, stars");
        // System.out.println(scrape.getReview(64));
        // System.out.println("\nReview 1, reviewName");
        // System.out.println(scrape.getReview(67));
        // System.out.println("\nReview 1, review");
        // System.out.println(scrape.getReview(68));
        
        int reviewStart = 51;
        for(int i = 1; i < 9; i++) {
            System.out.println("\nReview " + i + " name");
            System.out.println(scrape.getReview(reviewStart));
            System.out.println("\nReview " + i + " stars");
            System.out.println(scrape.getReview(reviewStart + 2));
            System.out.println("\nReview " + i + " reviewName");
            System.out.println(scrape.getReview(reviewStart + 5));
            System.out.println("\nReview " + i + " review");
            System.out.println(scrape.getReview(reviewStart + 6));
            reviewStart += 11;
        }
    }


    public Scraper(String url) throws IOException {
        docu = Jsoup.connect(url).get();
        parseReviews();
    }

    public Scraper() throws IOException {
        File input = new File("localreviews.html");
        docu = Jsoup.parse(input, "UTF-8", "");
        parseReviews();
    }

    private void parseReviews() {
        reviews = new ArrayList<>();
        Elements reviewElements = docu.select("span");
        for (Element reviewElement : reviewElements) {
            reviews.add(reviewElement.text());
        }
    }

    public List<String> getAllReviews() {
        return reviews;
    }

    public String getReview(int index) {
        if (index >= 0 && index < reviews.size()) {
            return reviews.get(index);
        } else {
            return "Review index out of bounds";
        }
    }
}
