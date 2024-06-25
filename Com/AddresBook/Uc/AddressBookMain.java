package Com.AddresBook.Uc;

public class AddressBookMain 
{
	private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private long phoneNumber;
    private String email;
    
    

	AddressBookMain(String firstName, String lastName, String address, String city, String state, int zipCode,
			long phoneNumber, String email) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	

	public static void main(String[] args) 
	{
		System.out.println(" Welcome to Address Book");
		AddressBookMain addressBook = new AddressBookMain("Gaurav","Dhande","Jay ashtvinayk bldg","Mumbai","Maharashtra",421202,977139767,"gpdhande12@gmail.com");

	}

}
