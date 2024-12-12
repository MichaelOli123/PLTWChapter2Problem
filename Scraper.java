import java.io.File;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Scraper {
    private Document docu;
    public static void main(String[] args) throws IOException{
        Scraper scrape = new Scraper();
        //System.out.println(scrape.getNameReviewList());
        scrape.getAllReviews();
        
    }
    public Scraper(String url) throws IOException{
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

    public void getAllReviews() throws IOException{
        int totalPages =  Integer.valueOf(getReviews().text().split(" reviews 5 stars")[0].substring(getReviews().text().split(" reviews 5 stars")[0].length()-3));
        FileWriter writer = new FileWriter("socialMediaPosts.txt");
        for (int i=1;i<((totalPages/10)+2);i++){
        // for (int i=1; i<3; i++){
            System.out.println(i);
            docu = Jsoup.connect("https://www.walmart.com/reviews/product/5316226524?page=" + i).get(); // warning this will make 31 requests to the website in quick succession
            ArrayList<String> toWrite = getNameReviewList();
            for (String tw: toWrite){
                String[] temp = tw.split("}");
                writer.write(temp[0] + " "+temp[1]);
            }
        }
        writer.close();

    }
}

