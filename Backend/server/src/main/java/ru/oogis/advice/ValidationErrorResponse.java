package ru.oogis.advice;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();

    public void addViolation(Violation violation) {
        violations.add(violation);
    }

    public List<Violation> getViolations() {
        return violations;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Violation violation : violations) {
            stringBuilder.append("filed : " + violation.getFieldName());
            stringBuilder.append(" / message : " + violation.getMessage() + "\n");
        }
        return stringBuilder.toString();
    }
}
