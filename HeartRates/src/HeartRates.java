import java.util.GregorianCalendar;

public class HeartRates {
	private String firstName;
	private String lastName;
	private int yearOfBirth;
	private int higherTargetRate;
	private int lowerTargetRate;
	
	
	HeartRates(String firstName, String lastName, int yearOfBirth){
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setYearOfBirth(int yearOfBirth){
		this.yearOfBirth = yearOfBirth;
	}

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getYearOfBirth(){
		return yearOfBirth;
	}
	
	public int maxHeartRate(){
		int age = calculateAge();
		int maxRate = (int)(220 - age);
		
		return maxRate;		
	}
	
	public int getLowerTargetRate(){
		return (int) lowerTargetRate;
	}
	
	public void setLowerTargetRate(float low){
		this.lowerTargetRate = (int) low;
	}
	
	public int getHigherTargetRate(){
		return higherTargetRate;
	}
	
	public void setHigherTargetRate(int higher){
		this.higherTargetRate = higher;
	}
	
	
	public String targetHeartRate(){
		float low = (float) (maxHeartRate() * .50);
		int high = (int) (maxHeartRate() * .85);
		low = Math.round(low);
		
		setHigherTargetRate(high);
		setLowerTargetRate(low);
		
		return getLowerTargetRate() + " - " + getHigherTargetRate();
	}
	
	public int calculateAge(){
	    int currentYear = new GregorianCalendar().get(GregorianCalendar.YEAR);
		int age;
		
		age = currentYear - getYearOfBirth();
		
		return age;	
	}	
}
