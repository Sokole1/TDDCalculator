package main.model;

// Collections operations and values that need to be computed
public class Operations {

    private String[] op;
    public static final String OPERATIONS_REGEX = "[+_x]";

    // EFFECTS: creates list of alternating numbers and operations
    // Valid operations include +, _ (MINUS IS REPRESENTED AS _), and x
    public Operations(String[] op) {
        this.op = op;
    }

    // EFFECTS: getter for op
    public String[] getOp() {
        return op;
    }

    // EFFECTS: checks if first and last values are not operators, and that there are no consecutive operators
    public boolean isValid() {
        if (this.op[0].matches(OPERATIONS_REGEX)
                || this.op[this.op.length - 1].matches(OPERATIONS_REGEX)) {
            return false;
        } else {
            for (int i = 0; i < this.op.length - 1; i++) {
                if (this.op[i].matches(OPERATIONS_REGEX)
                        && this.op[i + 1].matches(OPERATIONS_REGEX)) {
                    return false;
                }
            }
        }
        return true;
    }
}
