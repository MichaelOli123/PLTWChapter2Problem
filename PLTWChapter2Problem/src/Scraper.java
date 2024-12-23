import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {
    private Document docu;
    public static void main(String[] args) throws IOException{
        Scraper scrape = new Scraper();
        System.out.println("Print");
        System.out.println(scrape.getReviews().text());
        
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
        return docu.select("span");
    }
}
