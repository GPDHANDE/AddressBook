package Com.AddresBook.Uc;

import java.util.HashMap;
import java.util.Scanner;

public class MultipleAddressBook 
{
	static HashMap<String, AddressBookMain> multipleAddressBook = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book program.");
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("Enter the name of the address book: ");
            String name = scanner.next();
            multipleAddressBook.put(name, new AddressBookMain());
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

