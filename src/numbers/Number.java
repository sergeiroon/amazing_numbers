package numbers;

import java.util.List;

public class Number {
    long number;

    public Number(long naturalNumber) {
        this.number = naturalNumber;
    }

    public boolean isOdd() {
        return number % 2 != 0;
    }

    public boolean isBuzz() {
        return number % 7 == 0 || number % 10 == 7;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isDuck() {
        boolean isDuck = false;
        long tmp = number;
        while (!isDuck && tmp != 0) {
            long reminder = tmp % 10;
            tmp = tmp / 10;
            isDuck = reminder == 0;
        }
        return isDuck;
    }

    public boolean isPalindromic() {
        long result = 0;
        long factor = 10;
        long temp = number;
        while (temp > 0) {
            long reminder = temp % 10;
            result = result * factor + reminder;
            temp = temp / 10;
        }

        return number == result;
    }

    public boolean isGapful() {
        int countNumber = 0;
        long temp = number;

        while (temp > 0) {
            temp = temp / 10;
            countNumber++;
        }

        if (countNumber < 3) {
            return false;
        } else {
            long rightNumber = number % 10;
            long leftNumber = number / (long) Math.pow(10, countNumber - 1);
            return number % (rightNumber + leftNumber * 10) == 0;
        }
    }

    public boolean isSpy() {

        long sum = 0;
        long product = 1;

        long tmp = number;

        while (tmp > 0) {
            long reminder = tmp % 10;
            tmp = tmp / 10;

            sum = sum + reminder;
            product = product * reminder;
        }
        if (sum == product) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSunny() {

        long tmp = number + 1;
        Double sqrt = Math.sqrt(tmp);
        if (Math.floor(sqrt) == sqrt) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isSquare() {
        Double sqrt = Math.sqrt(number);
        if (Math.floor(sqrt) == sqrt) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isJumping() {
        boolean isJumping = true;
        long tmp = number;
        long a = tmp % 10;
        tmp = tmp / 10;
        long b;
        while (tmp > 0 && isJumping) {
            b = tmp % 10;
            tmp = tmp / 10;
            if (Math.abs(b - a) != 1) {
                isJumping = false;
            }
            a = b;
        }
        return isJumping;
    }

    public boolean isHappy() {
        boolean isHappy = false;
        long tmp = number;
        long sum = 0;
        while (tmp > 0) {
            long a = tmp % 10;
            tmp = tmp / 10;
            sum = sum + a * a;
        }
        if (sum == 1) {
            isHappy = true;
        } else {
            tmp = sum;
            while (tmp != 4 && !isHappy) {
                sum = 0;
                while (tmp > 0) {
                    long a = tmp % 10;
                    tmp = tmp / 10;
                    sum = sum + a * a;
                }
                if (sum == 1) {
                    isHappy = true;
                }
                tmp = sum;
            }
        }
        return isHappy;
    }

    public boolean isSad() {
        return !isHappy();
    }

    public void printProperties() {
        System.out.println("Properties of " + number);
        System.out.println("buzz: " + isBuzz());
        System.out.println("duck: " + isDuck());
        System.out.println("palindromic: " + isPalindromic());
        System.out.println("gapful: " + isGapful());
        System.out.println("even: " + isEven());
        System.out.println("odd: " + isOdd());
        System.out.println("spy: " + isSpy());
        System.out.println("sunny: " + isSunny());
        System.out.println("square: " + isSquare());
        System.out.println("jumping: " + isJumping());
        System.out.println("happy: " + isHappy());
        System.out.println("sad: " + isSad());


    }

    public String properties() {
        //StringJoiner stringJoiner = new StringJoiner(", ");
        String result = "";
        result = result + (isBuzz() ? "buzz" : "");
        if (!result.isEmpty()) {
            result = result + ", ";

        }
        result = result + (isDuck() ? "duck" : "");
        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isPalindromic() ? "palindromic" : "");
        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isGapful() ? "gapful" : "");
        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isEven() ? "even" : "");
        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isOdd() ? "odd" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isSpy() ? "spy" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isSunny() ? "sunny" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isSquare() ? "square" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isJumping() ? "jumping" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isHappy() ? "happy" : "");

        if (!result.isEmpty() && !result.endsWith(", ")) {
            result = result + ", ";

        }
        result = result + (isSad() ? "sad" : "");

        if (result.endsWith(", ")) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }

    public boolean isMatchProperties(List<Property> properties, List<Property> notProperties) {

        boolean matchAllProperties = true;

        for (Property p : properties) {
            matchAllProperties = matchAllProperties && matchProperty(p);
        }
        for (Property p : notProperties) {
            matchAllProperties = matchAllProperties && !matchProperty(p);
        }
        return matchAllProperties;
    }

    public boolean matchProperty(Property property) {

        boolean isMatch = false;
        switch (property) {
            case BUZZ:
                isMatch = isBuzz();
                break;
            case EVEN:
                isMatch = isEven();
                break;
            case ODD:
                isMatch = isOdd();
                break;
            case DUCK:
                isMatch = isDuck();
                break;
            case PALINDROMIC:
                isMatch = isPalindromic();
                break;
            case GAPFUL:
                isMatch = isGapful();
                break;
            case SPY:
                isMatch = isSpy();
                break;
            case SUNNY:
                isMatch = isSunny();
                break;
            case SQUARE:
                isMatch = isSquare();
                break;
            case JUMPING:
                isMatch = isJumping();
                break;
            case HAPPY:
                isMatch = isHappy();
                break;
            case SAD:
                isMatch = isSad();
                break;
        }
        return isMatch;
    }
}
