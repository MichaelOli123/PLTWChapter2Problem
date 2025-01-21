import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.util.ArrayList;

public class Scraper {
    private Document docu;
    private String url;
    public static void main(String[] args) throws IOException{
        Scraper scrape = new Scraper("https://www.walmart.com/reviews/product/5316226524?page=");
        scrape.writeSocialMediaPosts();
        
    }
    public Scraper(String url) throws IOException{
        this.url = url;
        docu = Jsoup.connect(url).get();
    }
    public Scraper() throws IOException{
        File input = new File("localreviews.html");
        docu = Jsoup.parse(input, "UTF-8", "");
    }

    private Elements getReviews(){
        // return docu.select("");
        // return docu.getElementsByClass("");
        return docu.getElementsByClass("tl-m db-m"); // tl-m db-m is reviews
        /*
         * f7 b mv0 is the name of the reviewers and "Sold by Walmart.com"
         */
    }

    private Elements getNames(){
        return docu.getElementsByClass("f7 b mv0");
    }

    public ArrayList<String> getNameReviewList(){
        ArrayList<String> returnList = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();
        for (String name:getNames().text().split(" ")){
            if (!"SoldbyWalmart.comPLWalmartCustomer".contains(name.strip())){
                names.add(name.strip());
            }
        }
        ArrayList<String> reviews = new ArrayList<String>();
        for (String review:getReviews().html().split("<b></b>")){
            if (review.length() > 0){
                reviews.add(review);
            }
        }
        for (int i = 0; i< names.size(); i++){
            returnList.add(names.get(i) + "}" + reviews.get(i));
        }
        return returnList;
    }


    public void writeSocialMediaPosts() throws IOException{
        FileWriter writer = new FileWriter("socialMediaPosts.txt");
        int pageCount = 37;
        for (int i=1;i<pageCount;i++){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            docu = Jsoup.connect(url+i).get();
            String[] names = docu.getElementsByClass("f7 b mv0").text().split(" ");
            String[] reviews = docu.getElementsByClass("tl-m db-m").html().split("<b></b>");
            // System.out.println(docu.html());
            // System.out.println(Arrays.toString(names));
            // System.out.println(Arrays.toString(reviews));
            for (int j=0; j<10; j++){
                writer.write(names[j] + " " + reviews[j]);
            }
        }
        writer.close();
    }

    public void getAllReviews() throws IOException{
        int totalReviewCount = 366;
        FileWriter writer = new FileWriter("socialMediaPosts.txt");
        for (int i=1;i<((totalReviewCount/10)+2);i++){  // This will iterate through all of the pages(!) so be careful
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            docu = Jsoup.connect(url + i).get();
            ArrayList<String> toWrite = getNameReviewList();
            for (String tw: toWrite){
                String[] temp = tw.split("}");
                writer.write(temp[0] + " "+temp[1]);
            }
        }
        writer.close();

    }
}

