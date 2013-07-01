package cvPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.csvreader.CsvWriter;

public class ApplicationManagerClass implements ApplicationManager {
    private List<Application> allApplications;
    Scanner input = new Scanner(System.in);

    public ApplicationManagerClass() {
        allApplications = new ArrayList<Application>();
    }

    private Date enterDateOfBirth() {
        String year;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        Date date = null;
        boolean valid;
        do {
            valid = true;
            System.out.println("<<Enter date of birth (dd/mm/yyyy)>>");
            year = input.nextLine();
            try {
                date = format.parse(year);
                System.out.println(date);
            } catch (ParseException e) {
                System.out.println("Not valid date!");
                valid = false;
            }
        } while (!valid);
        return date;
    }

    private Address enterAddress() {
        String answer;
        Address address = new Address();
        System.out.println("<<Enter your address>>");
        System.out.println("Country: ");
        address.setCountry(input.nextLine());
        System.out.println("City: ");
        address.setCity(input.nextLine());
        System.out.println("Address 1: ");
        address.setAddressLine1((input.nextLine()));
        System.out.println("Enter yes to add second adress or any key to not add it:");
        answer = input.nextLine();
        if (answer.equals("yes"))
        {
            System.out.println("Address 2: ");
            address.setAddressLine2((input.nextLine()));
        }
        System.out.println("Zip (Postal code): ");
        address.setZip((input.nextLine()));
        return address;

    }

    private PersonalInformation enterInfo() {
        String email = null;
        PersonalInformation info = new PersonalInformation();
        System.out.println("<<< ENTER YOUR PERSONAL INFORMATION >>>");
        System.out.println("Enter your  first name: ");
        info.setFirstName(input.nextLine());
        System.out.println("Enter your last name: ");
        info.setLastName(input.nextLine());
        do {
            System.out.println("Enter your email: ");
            email = input.nextLine();
        } while (email.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?") == false);
        info.setEmail(email);
        System.out.println("Enter your phone: ");
        info.setPhone(input.nextLine());
        info.setAddress(enterAddress());
        info.setDateOfBirth(enterDateOfBirth());
        return info;
    }

    private Application enterApplication() {
        String prev;
        String education;
        String position;
        System.out.println("Enter your previous experience: ");
        prev = input.nextLine();
        System.out.println("Enter your education: ");
        education = input.nextLine();
        System.out.println("What job position are you applying for? ");
        position = input.nextLine();
        return new Application(enterInfo(), prev, education, position);
    }

    /**
     * Method which creates the user UI, which consists of menu for choosing actions
     */
    public void menu()
    {
        int choose;
        String exit;
        do
        {
            System.out.println("<<  MENU    >>");
            System.out.println("To add new application press 1");
            System.out.println("To view all applications press 2");
            System.out.println("To view application by number press 3");
            System.out.println("To export the list press 4");
            choose = input.nextInt();
            input.nextLine();
            switch (choose)
            {
            case 1:
                add();
                break;
            case 2:
                view();
                break;
            case 3:
                System.out.println("Number of CV:");
                view(input.nextInt());
                input.nextLine();
                break;
            case 4:
                export();
                break;
            default:
                System.out.println("Enter valid command!");
                break;
            }
            System.out.println("Type exit to exit or ay key to continue");
            exit = input.nextLine();
        } while (!exit.equalsIgnoreCase("exit"));
    }

    public void add() {
        allApplications.add(enterApplication());
    }

    /**
     * Prints all applications in the list
     */
    public void view() {
        Iterator<Application> app = allApplications.iterator();
        while (app.hasNext())
            System.out.println(app.next());

    }

    /**
     * @see cvPackage.ApplicationManager#view(int)
     */
    public void view(int position) {

        try {
            System.out.println(allApplications.get(position));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not valid number");
        }

    }

    /**
     * Exporting data in CSV format.
     * Exports firstname, lastname, date of birth and job position
     * for all records in the list
     */
    public void export() {
        boolean alreadyExists = new File("CsvTest").exists();
        CsvWriter file = null;
        try {
            file = new CsvWriter((new FileWriter("CsvTest.csv", true)), ',');
            if (!alreadyExists)
            {
                file.write("FIRSTNAME");
                file.write("LASTNAME");
                file.write("DATEOFBIRTH");
                file.write("POSITION");
                file.endRecord();
            }

            Iterator<Application> app = allApplications.iterator();
            while (app.hasNext())
            {
                Application current = app.next();
                file.write(current.getPersonalInfo().getFirstName());
                file.write(current.getPersonalInfo().getLastName());
                file.write(current.getPersonalInfo().getDateOfBirthAsSimpleDate());
                file.write(current.getApplicationPosition());
                file.endRecord();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            file.close();
        }

    }

}
