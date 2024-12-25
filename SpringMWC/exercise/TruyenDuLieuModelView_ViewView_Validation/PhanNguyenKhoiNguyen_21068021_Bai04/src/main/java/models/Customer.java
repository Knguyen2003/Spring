package models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {
	private String firstName;
	@NotNull(message = "Last Name is required")
	@Size(min = 4, message = "Must not be less than 4 characters")
	private String lastName;

	@NotNull(message = "Postal Code is required")
	@Min(value = 0, message = "Must be greater than 0")
	@Max(value = 10, message = "Must be less than 10")
	private int freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters/digits")
	private String postalCode;
	private String courseCode;

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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName,
			@NotNull(message = "Last Name is required") @Size(min = 4, message = "Must not be less than 4 characters") String lastName,
			@NotNull(message = "Postal Code is required") @Size(min = 6, message = "Must not be less than 6 characters") @Min(value = 0, message = "Must be greater than 0") @Max(value = 10, message = "Must be less than 10") int freePasses,
			@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters/digits") String postalCode,
			String courseCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.freePasses = freePasses;
		this.postalCode = postalCode;
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses
				+ ", postalCode=" + postalCode + ", courseCode=" + courseCode + "]";
	}

}
