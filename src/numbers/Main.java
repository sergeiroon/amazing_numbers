package numbers;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
        outputSupportedRequests();
        enterRequest();
        goodBye();
    }

    private static void enterRequest() {
        while (true) {
            System.out.print("Enter a request:");
            Request request = new Request(scanner);
            request.readRequest();
            if (request.exit) {
                break;
            }
            if (request.error != null && !request.error.isEmpty()) {
                System.out.println(request.error);
                continue;
            }
            if (request.count == 0) {
                Number number = new Number(request.number);
                number.printProperties();
            } else {
                SequenceNumber number = new SequenceNumber(request.number, request.count, request.properties, request.notProperties);
                number.printProperties();
            }
        }
    }

    private static void welcome() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    private static void outputSupportedRequests() {
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    private static void goodBye() {
        System.out.println("Goodbye!");
    }

}
