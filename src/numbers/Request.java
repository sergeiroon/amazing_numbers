package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class Request {
    private final Scanner scanner;
    private static final String[] availableProperties = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SQUARE", "SUNNY", "JUMPING"};

    long number;
    int count;
    boolean exit = false;
    List<Property> properties = new ArrayList<>();
    List<Property> notProperties = new ArrayList<>();

    String error;

    public Request(Scanner scanner) {
        this.scanner = scanner;
    }

    public void readRequest() {
        String[] strings = scanner.nextLine().split(" ");
        readNumber(strings);
        readCount(strings);
        readProperties(strings);

    }

    private void readProperties(String[] strings) {
        List<String> wrongProperties = new ArrayList<>();
        if (strings.length > 2 && isNull(error) && !exit) {
            for (int i = 2; i < strings.length; i++) {
                String propertyAsString = strings[i];
                if (propertyAsString.startsWith("-")) {
                    Property property = Property.getProperty(propertyAsString.replace("-", ""));
                    if (isNull(property)) {
                        wrongProperties.add(propertyAsString.toUpperCase());
                    } else {
                        if (!notProperties.contains(property)) {
                            notProperties.add(property);
                        }
                    }
                    continue;
                }
                Property property = Property.getProperty(propertyAsString);
                if (isNull(property)) {
                    wrongProperties.add(propertyAsString.toUpperCase());
                } else {
                    if (!properties.contains(property)) {
                        properties.add(property);
                    }
                }
            }
            if (!wrongProperties.isEmpty()) {
                if (wrongProperties.size() == 1) {
                    error = String.format("The property [%s] is wrong.\n" +
                        "Available properties: %s", wrongProperties.get(0), Arrays.toString(Property.values()));
                } else {
                    error = String.format("The properties [%s] are wrong.\n" +
                        "Available properties: %s", String.join(", ", wrongProperties), Arrays.toString(Property.values()));
                }
            }

            if (wrongProperties.isEmpty() && (!properties.isEmpty() || !notProperties.isEmpty())) {
                checkMutuallyProperties();
            }
        }

    }

    private void readCount(String[] strings) {
        if (strings.length > 1 && isNull(error) && !exit) {
            String secondParam = strings[1];

            if (!checkStringAsDigit(secondParam)) {
                error = "The second parameter should be a natural number or zero.";
            } else {
                count = Integer.parseInt(secondParam);
                if (count == 0) {
                    exit = true;
                }
            }
        }
    }

    private void readNumber(String[] strings) {
        if (strings.length > 0) {
            String firstParam = strings[0];
            if (!checkStringAsDigit(firstParam)) {
                error = "The first parameter should be a natural number or zero.";
            } else {
                number = Long.parseLong(firstParam);
                if (number == 0) {
                    exit = true;
                }
            }
        }
    }

    private static boolean checkStringAsDigit(String string) {
        for (Character ch : string.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private void checkMutuallyProperties() {

        List<String> mutuallyProperties = new ArrayList<>();
        for (int i = 0; i < properties.size() - 1; i++) {
            Property propertyOne = properties.get(i);
            for (int j = i + 1; j < properties.size(); j++) {
                Property propertyTwo = properties.get(j);
                if ((propertyOne == Property.EVEN || propertyOne == Property.ODD)
                    && (propertyTwo == Property.EVEN || propertyTwo == Property.ODD)) {
                    if (!mutuallyProperties.contains(propertyOne.name())) {
                        mutuallyProperties.add(propertyOne.name());
                    }
                    if (!mutuallyProperties.contains(propertyTwo.name())) {
                        mutuallyProperties.add(propertyTwo.name());
                    }
                }
                if ((propertyOne == Property.DUCK || propertyOne == Property.SPY)
                    && (propertyTwo == Property.DUCK || propertyTwo == Property.SPY)) {
                    if (!mutuallyProperties.contains(propertyOne.name())) {
                        mutuallyProperties.add(propertyOne.name());
                    }
                    if (!mutuallyProperties.contains(propertyTwo.name())) {
                        mutuallyProperties.add(propertyTwo.name());
                    }
                }
                if ((propertyOne == Property.SUNNY || propertyOne == Property.SQUARE)
                    && (propertyTwo == Property.SUNNY || propertyTwo == Property.SQUARE)) {
                    if (!mutuallyProperties.contains(propertyOne.name())) {
                        mutuallyProperties.add(propertyOne.name());
                    }
                    if (!mutuallyProperties.contains(propertyTwo.name())) {
                        mutuallyProperties.add(propertyTwo.name());
                    }
                }
                if ((propertyOne == Property.HAPPY || propertyOne == Property.SAD)
                    && (propertyTwo == Property.HAPPY || propertyTwo == Property.SAD)) {
                    if (!mutuallyProperties.contains(propertyOne.name())) {
                        mutuallyProperties.add(propertyOne.name());
                    }
                    if (!mutuallyProperties.contains(propertyTwo.name())) {
                        mutuallyProperties.add(propertyTwo.name());
                    }
                }
            }
        }
        for (int i = 0; i < notProperties.size() - 1; i++) {
            Property propertyOne = notProperties.get(i);
            for (int j = i + 1; j < notProperties.size(); j++) {
                Property propertyTwo = notProperties.get(j);
                if ((propertyOne == Property.EVEN || propertyOne == Property.ODD)
                    && (propertyTwo == Property.EVEN || propertyTwo == Property.ODD)) {
                    if (!mutuallyProperties.contains("-" + propertyOne.name())) {
                        mutuallyProperties.add("-" + propertyOne.name());
                    }
                    if (!mutuallyProperties.contains("-" + propertyTwo.name())) {
                        mutuallyProperties.add("-" + propertyTwo.name());
                    }
                }
                if ((propertyOne == Property.DUCK || propertyOne == Property.SPY)
                    && (propertyTwo == Property.DUCK || propertyTwo == Property.SPY)) {
                    if (!mutuallyProperties.contains("-" + propertyOne.name())) {
                        mutuallyProperties.add("-" + propertyOne.name());
                    }
                    if (!mutuallyProperties.contains("-" + propertyTwo.name())) {
                        mutuallyProperties.add("-" + propertyTwo.name());
                    }
                }
                if ((propertyOne == Property.SUNNY || propertyOne == Property.SQUARE)
                    && (propertyTwo == Property.SUNNY || propertyTwo == Property.SQUARE)) {
                    if (!mutuallyProperties.contains("-" + propertyOne.name())) {
                        mutuallyProperties.add("-" + propertyOne.name());
                    }
                    if (!mutuallyProperties.contains("-" + propertyTwo.name())) {
                        mutuallyProperties.add("-" + propertyTwo.name());
                    }
                }
            }
        }
        for (Property p : properties) {
            if (notProperties.contains(p)) {
                if (!mutuallyProperties.contains(p.name())) {
                    mutuallyProperties.add(p.name());
                }
                if (!mutuallyProperties.contains("-" + p.name())) {
                    mutuallyProperties.add("-" + p.name());
                }
            }
        }
        if (!mutuallyProperties.isEmpty()) {
            error = String.format("The request contains mutually exclusive properties: [%s]\n" +
                "There are no numbers with these properties.", String.join(", ", String.join(", ", mutuallyProperties)));

        }
    }
}
