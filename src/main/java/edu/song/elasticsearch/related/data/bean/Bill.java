package edu.song.elasticsearch.related.data.bean;

import edu.song.elasticsearch.related.data.BillDataMock.Address;

public class Bill {
	private String firstName;
	private String lastName;
	private String gender;
	private long balance;
	private long age;
	private String address;
	private String email;
	private String city;
	private String state;
	private String employer;
	private int account_number;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	
	@Override
	public String toString() {
		return "{ firstName: " + firstName + ",\n" +
				"lastName:" + lastName + ",\n" +
				"age:" + age + ",\n" + 
				"gender:" + gender + ",\n" +
				"balance:" + balance + ",\n" +
				"employer:" + employer + ",\n" +
				"email:" + email + ",\n" +
				"city:" + city + ",\n" +
				"state:" + state + ",\n" +
				"address:" + address + ",\n" +
				"account number:" + account_number + "}";
	}
	
	public String toJson(){
		return "{ \"firstName\": \"" + firstName + "\",\n" +
				"\"lastName\": \"" + lastName + "\",\n" +
				"\"age\": " + age + ",\n" + 
				"\"gender\": \"" + gender + "\",\n" +
				"\"balance\": " + balance + ",\n" +
				"\"employer\": \"" + employer + "\",\n" +
				"\"email\": \"" + email + "\",\n" +
				"\"city\": \"" + city + "\",\n" +
				"\"state\": \"" + state + "\",\n" +
				"\"address\": \"" + address + "\",\n" +
				"\"account_number\": " + account_number + "}";
	}
}
