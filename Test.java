package testing;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<String> personList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        
        
        System.out.println("Enter your first Name: ");
           String Name = stringScanner.next();

        System.out.println("Enter your last name: ");
           String name = stringScanner.next();

        System.out.println("What is your ID? ");
          String ID = stringScanner.next();

        System.out.println("Do you have a title? ");
            String title = stringScanner.next();

        System.out.println("Enter your YOB: ");
        while(!in.hasNextInt()) {
        	System.out.println("Please enter a valid birth year");
        	in.next();
        }
            int YOB = in.nextInt();

        String personInfo = "Name: " + Name + " " + name + ", " + "ID: " + ID + ", " + "Title: " + title + ", " +  "YOB: " + YOB;
                personList.add(personInfo);

        System.out.println("Do you have another person to input (Y/N): ");
            String input = stringScanner.next();
            String Y = "Y";
            String N = "N";
            
            if (input.equals(Y)) {
            	while(input.equals(Y)) {
            		
            	  System.out.println("Enter your first Name: ");
            	  	Name = stringScanner.next();

                  System.out.println("Enter your last name: ");
                  	name = stringScanner.next();

                  System.out.println("What is your ID? ");
                  	ID = stringScanner.next();

                  System.out.println("Do you have a title? ");
                  	title = stringScanner.next();

                  System.out.println("Enter your YOB: ");
                  	YOB = in.nextInt();

                  personInfo = "Name: " + Name + " " + name + ", " + "ID: " + ID + ", " + "Title: " + title + ", " +  "YOB: " + YOB;
                  	personList.add(personInfo);

                  System.out.println("Do you have another person to input (Y/N): ");
                       input = stringScanner.next();
            	}
            }
            
             if (input.equals(N)) {
				System.out.println("Information for all persons: ");
	        	for (String info : personList) {
	        		System.out.println(info);
            }
        	
        	}	
        	
        	in.close();
        	stringScanner.close();
        	
        	}
        
        }   
		

