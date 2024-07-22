package Com.AddresBook.Uc;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook 
{
	static HashMap<String, AddressBookMain> multipleAddressBook = new HashMap<>();
	
	public static void searchPersonsInCityOrState(String cityOrState)
	{
		List<AddressBookMain> res = multipleAddressBook.values().stream()
                .flatMap(ab -> ab.contacts.stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(cityOrState) || contact.getState().equalsIgnoreCase(cityOrState))
                .toList();
		if (res.isEmpty()) 
		{
            System.out.println("No contacts found in " + cityOrState);
        } 
		else 
        {
            res.forEach(contact -> 
            {
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Address: " + contact.getAddress());
                System.out.println("City, State: " + contact.getCity() + ", " + contact.getState());
                System.out.println("Zipcode: " + contact.getZipCode());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println();
            });
        }

	}

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) 
        {
            System.out.println("Enter the name of the address book: ");
            System.out.println("2. Search person by city or state");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            
            String name = scanner.next();
            switch(choice)
            {
            case 1:
            	System.out.println("Enter the name of the address book: ");
            	multipleAddressBook.put(name, new AddressBookMain());
            	break;
            case 2:
            	System.out.println("Search person by city or state");
            	String cityOrState = scanner.nextLine();
            	searchPersonsInCityOrState(cityOrState);
            	break;
            case 3:
            	check = false;
            default :
            	System.out.println("Wrong number/key pressed.");
            	
            	
            }
            
            System.out.println("Do you want to add new address book?");
            String question = scanner.next();
            if (question.equalsIgnoreCase("no")) {
                check = false;
            }
        }
        for (String key : multipleAddressBook.keySet()) {
            System.out.println("Details of " + key);
            multipleAddressBook.get(key).printInfoDetails();
            System.out.println("");
        }
    }
}

