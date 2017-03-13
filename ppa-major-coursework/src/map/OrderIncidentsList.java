package map;

import java.util.Comparator;

import api.ripley.Incident;

public class OrderIncidentsList implements Comparator<Incident> {
	
	private String sortProperty;
	
	public OrderIncidentsList(String sortProperty) {
		this.sortProperty = sortProperty;
	}
	

	@Override
	public int compare(Incident o1, Incident o2) {
		
		
		if (sortProperty.equals("Date")) {
			return o1.getDateAndTime().compareTo(o2.getDateAndTime());
			
		} else if (sortProperty.equals("City")) {
			return o1.getCity().compareTo(o2.getCity());
			
		} else if (sortProperty.equals("Shape")) {
			return o1.getShape().compareTo(o2.getShape());
			
		} else if (sortProperty.equals("Duration")) {
			return o1.getDuration().compareTo(o2.getDuration());
			
		} else if (sortProperty.equals("Posted")) {
			return o1.getPosted().compareTo(o2.getPosted());
			
		} else {
		return 0;
		
		}
		
	}
	
}
