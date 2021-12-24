package main.model;

import main.exceptions.InvalidInput;

public class Calculator {

    // EFFECTS: produce the string representation of a + b
    public static String sum(String a, String b) {
        return Long.toString(Long.parseLong(a) + Long.parseLong(b));
    }

    // EFFECTS: produce the string representation of a - b
    public static String sub(String a, String b) {
        return Long.toString(Long.parseLong(a) - Long.parseLong(b));
    }

    // EFFECTS: produce the string representation a * b
    public static String multiply(String a, String b) {
        return Long.toString(Long.parseLong(a) * Long.parseLong(b));
    }

    // EFFECTS: call the corresponding function based on the operation given
    public static String operate(String o, String a, String b) {
        switch (o) {
            case "+":
                return sum(a, b);
            case "_":
                return sub(a, b);
            case "x":
                return multiply(a, b);
        }
        return "";
    }
    // EFFECTS: produce the Operations object representation for a string of inputs
    public static Operations parse(String s) {
        final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
        String noSpaceStr = s.replaceAll("\\s", "");
        return new Operations(noSpaceStr.split(String.format(WITH_DELIMITER, Operations.OPERATIONS_REGEX)));
    }

    // EFFECTS: calculate a string if it is not empty and is valid
    public static String calculate(String s) throws InvalidInput {
        Operations oper = parse(s);
        String ans = "0";
        if (s.equals("")) {
            return ans;
        } else if (!oper.isValid()) {
            throw new InvalidInput();
        } else {
            ans = oper.getOp()[0];
            for (int i = 1; i < oper.getOp().length - 1; i += 2) {
                ans = operate(oper.getOp()[i], ans, oper.getOp()[i + 1]);
            }
        }
        return ans;
    }
}
