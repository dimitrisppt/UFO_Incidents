package statistics;

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
	
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    private static YouTube youtube;
    private static Integer totalResults;
    private IncidentsFetcher incidents;
	
    
    public YoutubeStat(IncidentsFetcher incidents){
    	this.incidents=incidents;
    }
    
    public void getYoutubeStat(){
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

        Integer totalR;
		try {
            // This object is used to make YouTube Data API requests. 
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();

            // Prompt the user to enter a query term.
            String queryTerm = "Ufo Sightings";

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the {{ Google Cloud Console }} for
            // non-authenticated requests.
            String apiKey = properties.getProperty("youtube.apikey");
            search.setKey(apiKey);
            search.setQ(queryTerm);
            
            // Restrict the search results to only include videos
            search.setType("video");
           
            String dTo = Integer.toString(incidents.getEndDate());
            String dFrom = Integer.toString(incidents.getEndDate());
            DateFormat dF=new SimpleDateFormat("yyyy-MM-dd");
            Date dateFrom =dF.parse(dFrom);
            Date dateTo = dF.parse(dTo);
        
            DateTime df = new DateTime(dateFrom);
            DateTime dt = new DateTime(dateTo); 
            
            search.setPublishedAfter(df); 
            search.setPublishedBefore(dt);
                
            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
        
            PageInfo pageInfo = searchResponse.getPageInfo();
            totalR = pageInfo.getTotalResults();
            totalResults= totalR;
      //      setValue(totalR);            
           //System.out.println(totalR);

        } catch (Throwable t) {
            t.printStackTrace();
        }    
    }
    
   // public void setValue(int total){
    //	totalResults=total;
    //}
    
    public static int getValue(){
    	return totalResults;
    }
}