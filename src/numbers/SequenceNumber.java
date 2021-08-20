package numbers;

import java.util.List;

public class SequenceNumber {
    Number[] numbers;

    public SequenceNumber(long startNumber, int count, List<Property> properties, List<Property> notProperties) {
        Number[] numbers = new Number[count];
        if (properties.isEmpty() && notProperties.isEmpty()) {
            for (int i = 0; i < count; i++) {
                numbers[i] = new Number(startNumber + i);
            }
        } else {
            numbers = generateNumbers(startNumber, count, properties, notProperties);
        }
        this.numbers = numbers;
    }

    public void printProperties() {
        for (Number number : numbers) {
            System.out.println(number.number + " is " + number.properties());
        }
    }

    private Number[] generateNumbers(long startNumber, int count, List<Property> properties, List<Property> notProperties) {
        Number[] numbers = new Number[count];
        Number currentNumber = new Number(startNumber);
        if (currentNumber.isMatchProperties(properties, notProperties)) {
            numbers[0] = currentNumber;
            for (int i = 1; i < count; i++) {
                Number n = nextNumberByProperties(currentNumber.number, properties, notProperties);
                numbers[i] = n;
                currentNumber = n;
            }
        } else {
            for (int i = 0; i < count; i++) {
                Number n = nextNumberByProperties(currentNumber.number, properties, notProperties);
                numbers[i] = n;
                currentNumber = n;
            }
        }

        return numbers;
    }

    private Number nextNumberByProperties(long number, List<Property> properties, List<Property> notProperties) {
        long tmp = number;
        while (true) {
            tmp++;
            Number n = new Number(tmp);
            if (n.isMatchProperties(properties, notProperties)) {
                return n;
            }
        }
    }
}
