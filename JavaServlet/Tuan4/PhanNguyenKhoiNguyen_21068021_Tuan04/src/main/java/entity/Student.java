package entity;

import java.util.Arrays;

public class Student {
	private String firstName;
	private String lastName;
	private int day;
	private int month;
	private int year;
	private String email;
	private String numberPhone;
	private String gender;
	private String address;
	private String city;
	private String pinCode;
	private String state;
	private String country;
	private String[] hoobies;
	private String course;
	private Qualification classX;
	private Qualification classXII;
	private Qualification graduation;
	private Qualification masters;

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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHoobies() {
		return hoobies;
	}

	public void setHoobies(String[] hoobies) {
		this.hoobies = hoobies;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Qualification getClassX() {
		return classX;
	}

	public void setClassX(Qualification classX) {
		this.classX = classX;
	}

	public Qualification getClassXII() {
		return classXII;
	}

	public void setClassXII(Qualification classXII) {
		this.classXII = classXII;
	}

	public Qualification getGraduation() {
		return graduation;
	}

	public void setGraduation(Qualification graduation) {
		this.graduation = graduation;
	}

	public Qualification getMasters() {
		return masters;
	}

	public void setMasters(Qualification masters) {
		this.masters = masters;
	}

	

	public Student(String firstName, String lastName, int day, int month, int year, String email, String numberPhone,
			String gender, String address, String city, String pinCode, String state, String country, String[] hoobies,
			String course, Qualification classX, Qualification classXII, Qualification graduation,
			Qualification masters) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
		this.email = email;
		this.numberPhone = numberPhone;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.hoobies = hoobies;
		this.course = course;
		this.classX = classX;
		this.classXII = classXII;
		this.graduation = graduation;
		this.masters = masters;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", day=" + day + ", month=" + month
				+ ", year=" + year + ", email=" + email + ", numberPhone=" + numberPhone + ", gender=" + gender
				+ ", address=" + address + ", city=" + city + ", pinCode=" + pinCode + ", state=" + state + ", country="
				+ country + ", hoobies=" + Arrays.toString(hoobies) + ", course=" + course + ", classX=" + classX
				+ ", classXII=" + classXII + ", graduation=" + graduation + ", masters=" + masters + "]";
	}

	

}
