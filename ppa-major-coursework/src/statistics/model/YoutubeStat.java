package statistics.model;


//This class is used to print the amount of videos that exist on youtube between the dates selected .
//It will as well show only videos , videos that are related to the key "Ufo Sightings"

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.DateTime;
import com.google.api.services.samples.youtube.cmdline.Auth;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PageInfo;
import com.google.api.services.youtube.model.SearchListResponse;

import model.IncidentsFetcher;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class YoutubeStat {
	
	//We first create  a variable that as a String take the value of our YOutube key in our "youtube.properties" file
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    //We then call the Youtube class by creating an object 
    private static YouTube youtube;
    //We then create a variable that will be used in a get method to be called and then used by other classes to show the amount of videos
    private static Integer totalResults;
    //We then create an object of the IncidentFetcher that will be used to obtain the user's dateRange selection
    private static IncidentsFetcher incidents;
	
    public YoutubeStat(IncidentsFetcher incidents){
    	this.incidents=incidents;
    	//We then created a constructor and pass it the object of the IncidentFetcher and initialise the class variable
    }
    
    //We then create a method that will modify the value of the totalResults variable
    public void updateYoutubeStat(){
    	// Read the developer key from the properties file.
        Properties properties = new Properties();
        try {
            InputStream in = YoutubeStat.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
        
        //Create a temporary variable that will give its value to the totalResults variable
        Integer totalR;
		try {
            // This object is used to make YouTube Data API requests. 
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // We then create a String that has our searching query and that will be passed to the search later on in the method
            String queryTerm = "Ufo Sightings";

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key 
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            //Passes the query term to the search 
            search.setQ(queryTerm);

            // Restrict the search results to videos only
            search.setType("video");
           
            //We here create two String variables that will receive the incident fetcher start and end Dates
            String dTo = Integer.toString(incidents.getEndDate());
            String dFrom = Integer.toString(incidents.getStartDate());
            //We here then create a format to format the String into Dates
            DateFormat dF=new SimpleDateFormat("yyyy-MM-dd");
            
            //And we then Formatted the String into a Date with time
            Date dateFrom =dF.parse(dFrom+"-01-01 00:00:00");
            Date dateTo = dF.parse(dTo+"-12-30 00:00:00");
            //And set the Date to the youtube DateTime 
            DateTime df = new DateTime(dateFrom);
            DateTime dt = new DateTime(dateTo); 
            
            //We then searched between those time all the videos 
            search.setPublishedAfter(df); 
            search.setPublishedBefore(dt);
                
            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            PageInfo pageInfo = searchResponse.getPageInfo();
            
            totalR = pageInfo.getTotalResults();
            if(incidents.getEndDate()<2000){
            	totalR=0;
            }
            totalResults= totalR;
            
		} catch (Throwable t) {
            t.printStackTrace();
        }    
    }
    //Get method to return all the values 
    public static int getYoutubeStat(){
    	return totalResults;
    }
}