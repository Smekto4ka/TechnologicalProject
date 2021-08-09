package validation;

import ru.oogis.transfer.Marker;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = CheckNickValidator.class)
public @interface EnableMatchConstraint  {
    String message() default "this nickname already exists";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default { };
}


