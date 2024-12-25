package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
	// fields
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;

	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private ArrayList<String> operatingSystemOptions;

	public Student() {
		// đổ dữ liệu
		favoriteLanguageOptions = new LinkedHashMap<>();
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");

		countryOptions = new LinkedHashMap<>();
		countryOptions.put("VN", "Viet Nam");
		countryOptions.put("US", "United States");
		countryOptions.put("UK", "United Kingdom");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");

		operatingSystemOptions = new ArrayList<>();
		operatingSystemOptions.add("MS Windows");
		operatingSystemOptions.add("Linux");
		operatingSystemOptions.add("Mac OS");
	}

	public Student(String firstName, String lastName, String country, String favoriteLanguage,
			String[] operatingSystems, LinkedHashMap<String, String> countryOptions,
			LinkedHashMap<String, String> favoriteLanguageOptions, ArrayList<String> operatingSystemOptions) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.favoriteLanguage = favoriteLanguage;
		this.operatingSystems = operatingSystems;
		this.countryOptions = countryOptions;
		this.favoriteLanguageOptions = favoriteLanguageOptions;
		this.operatingSystemOptions = operatingSystemOptions;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public void setFavoriteLanguageOptions(LinkedHashMap<String, String> favoriteLanguageOptions) {
		this.favoriteLanguageOptions = favoriteLanguageOptions;
	}

	public ArrayList<String> getOperatingSystemOptions() {
		return operatingSystemOptions;
	}

	public void setOperatingSystemOptions(ArrayList<String> operatingSystemOptions) {
		this.operatingSystemOptions = operatingSystemOptions;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", favoriteLanguage=" + favoriteLanguage + ", operatingSystems=" + Arrays.toString(operatingSystems)
				+ ", countryOptions=" + countryOptions + ", favoriteLanguageOptions=" + favoriteLanguageOptions
				+ ", operatingSystemOptions=" + operatingSystemOptions + "]";
	}

}
