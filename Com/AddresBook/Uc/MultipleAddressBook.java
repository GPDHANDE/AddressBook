package Com.AddresBook.Uc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MultipleAddressBook 
{
	static HashMap<String, AddressBookMain> multipleAddressBook = new HashMap<>();
	static HashMap<String, Set<AddressBookMain>> cityPersonMap = new HashMap<>();
    static HashMap<String, Set<AddressBookMain>> statePersonMap = new HashMap<>();
    
    
    public static void updateDictionaries(String city, String state, AddressBookMain contact) {
        cityPersonMap.computeIfAbsent(city, k -> new HashSet<>()).add(contact);
        statePersonMap.computeIfAbsent(state, k -> new HashSet<>()).add(contact);
    }
	
    
	public static void searchPersonsInCityOrState(String cityOrState)
	{
		 Set<AddressBookMain> res = new HashSet<>(cityPersonMap.getOrDefault(cityOrState, new HashSet<>()));
	        res.addAll(statePersonMap.getOrDefault(cityOrState, new HashSet<>()));

		
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
	
	public static void viewPersonsByCity(String city) {
        Set<AddressBookMain> persons = cityPersonMap.getOrDefault(city, new HashSet<>());
        if (persons.isEmpty()) {
            System.out.println("No contacts found in " + city);
        } else {
            persons.forEach(contact -> {
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Address: " + contact.getAddress());
                System.out.println("City: " + contact.getCity());
                System.out.println("State: " + contact.getState());
                System.out.println("Zipcode: " + contact.getZipCode());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println();
            });
        }
    }

    public static void viewPersonsByState(String state) {
        Set<AddressBookMain> persons = statePersonMap.getOrDefault(state, new HashSet<>());
        if (persons.isEmpty()) {
            System.out.println("No contacts found in " + state);
        } else {
            persons.forEach(contact -> {
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName());
                System.out.println("Address: " + contact.getAddress());
                System.out.println("City: " + contact.getCity());
                System.out.println("State: " + contact.getState());
                System.out.println("Zipcode: " + contact.getZipCode());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email: " + contact.getEmail());
                System.out.println();
            });
        }

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) 
        {
            System.out.println("1.Enter the name of the address book: ");
            System.out.println("2. Search person by city or state");
            System.out.println("3. View persons by city");
            System.out.println("4. View persons by state");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            
            
            switch(choice)
            {
            case 1:
            	System.out.println("Enter the name of the address book: ");
            	String name = scanner.next();
            	multipleAddressBook.put(name, new AddressBookMain());
            	break;
            case 2:
            	System.out.println("Search person by city or state");
            	String cityOrState = scanner.next();
            	searchPersonsInCityOrState(cityOrState);
            	break;
            case 3 : 
                System.out.println("Enter city to view persons: ");
                String city = scanner.nextLine();
                viewPersonsByCity(city);
                break;
            
            case 4 : 
                System.out.println("Enter state to view persons: ");
                String state = scanner.nextLine();
                viewPersonsByState(state);
                break;
            case 5 :check = false; 
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

