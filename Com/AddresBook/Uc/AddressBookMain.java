package Com.AddresBook.Uc;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class AddressBookMain 
{
	private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    public int numOfContacts = 0;
    ArrayList<AddressBookMain> contacts = new ArrayList<AddressBookMain>();
    static Scanner scanner = new Scanner(System.in);
    
    
    public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public ArrayList<AddressBookMain> getContacts() {
		return contacts;
	}
	AddressBookMain()
    {
        addContact();
    }
    AddressBookMain(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public void printInfoDetails() 
    {
        contacts.stream().sorted((a,b)->(a.firstName+" "+a.lastName).compareToIgnoreCase(b.firstName+" "+b.lastName)).forEach(System.out::println);
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AddressBookMain that = (AddressBookMain) obj;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }
    public void addContact() 
    {
                    System.out.print("Enter the first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter the last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter the address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter the city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter the state: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter the zip code: ");
                    String zipCode = scanner.nextLine();
                    System.out.print("Enter the phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter the email: ");
                    String email = scanner.nextLine();
                    
                    AddressBookMain newContact =new AddressBookMain(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
                    if (contacts.stream().anyMatch(contact -> contact.equals(newContact))) {
                        System.out.println("This contact already exists.");
                    }
                    else 
                    {
                        contacts.add(newContact);
                        MultipleAddressBook.updateDictionaries(city, state, newContact);
                    }

    }
    public void editContact() 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name of the contact you want to edit: ");
        String name = scanner.next();
        for (AddressBookMain cont : contacts) {
            if (Objects.equals(cont.firstName, name)) {
                System.out.println("What do you want to edit?");
                System.out.println("1. Address");
                System.out.println("2. City");
                System.out.println("3. State");
                System.out.println("4. Zip code");
                System.out.println("5. Phone number");
                System.out.println("6. Email");
                int scase = scanner.nextInt();
                scanner.nextLine();
                switch (scase) {
                    case 1 -> {
                        System.out.println("Enter the new address: ");
                        cont.address = scanner.nextLine();
                        System.out.println("The address has been changed.");
                    }
                    case 2 -> {
                        System.out.println("Enter the new City: ");
                        cont.city = scanner.nextLine();
                        System.out.println("The City has been changed.");
                    }
                    case 3 -> {
                        System.out.println("Enter the new State: ");
                        cont.state = scanner.nextLine();
                        System.out.println("The state has been changed.");
                    }
                    case 4 -> {
                        System.out.println("Enter the new Zip code: ");
                        cont.zipCode = scanner.nextLine();
                        System.out.println("The zip code has been changed.");
                    }
                    case 5 -> {
                        System.out.println("Enter the new phone number: ");
                        cont.phoneNumber = scanner.nextLine();
                        System.out.println("The phone number has been changed.");
                    }
                    case 6 -> {
                        System.out.println("Enter the new email: ");
                        cont.email = scanner.nextLine();
                        System.out.println("The email has been changed.");
                    }
                    default -> System.out.println("Wrong number/key entered.");
                }
                MultipleAddressBook.updateDictionaries(cont.city, cont.state, cont);
                System.out.println("The new contact info is: ");
                return;
            }
        }
        System.out.println("Contact not found.");
    }    
    
    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the contact you want to delete");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).firstName.equals(name)) {
                AddressBookMain contact = contacts.remove(i);
                MultipleAddressBook.cityPersonMap.get(contact.city).remove(contact);
                MultipleAddressBook.statePersonMap.get(contact.state).remove(contact);
                System.out.println("Contact has been deleted");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
       public void manageContacts() 
       {
           Scanner scanner = new Scanner(System.in);
           boolean condi = true;
           while (condi) 
           {
               System.out.println("1. Add contact\t 2. Edit contact\t 3. Delete contact\t 4. Exit");
               int choice = scanner.nextInt();
               scanner.nextLine();
               switch (choice) 
               {
                 case 1 : addContact();
                 case 2 : editContact();
                 case 3 : deleteContact();
                 case 4 : condi = false;
                 default: System.out.println("Wrong number/key pressed.");
               }
           }
       }
       
       
	@Override
	public String toString() {
		return "AddressBookMain firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + ", email="
				+ email + "";
	}
	public static void main(String[] args) 
	{


	}

}
