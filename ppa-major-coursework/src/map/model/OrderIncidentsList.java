package map.model;

import java.util.Comparator;

import api.ripley.Incident;

/**
 * The class implements Comparator of Incident to compare all the objects of the
 * incidentsList in order to sort them by different properties.
 * 
 * @author Dimitris Papatheodoulou
 *
 */
public class OrderIncidentsList implements Comparator<Incident> {
	
	private String sortProperty;
	
	/**
	 * The constructor initialises sortProperty.
	 * @param sortProperty
	 */
	public OrderIncidentsList(String sortProperty) {
		this.sortProperty = sortProperty;
	}
	
	/*
	 * Compares two Incident objects by Date, City, Shape, Duration or Posted. 
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
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
