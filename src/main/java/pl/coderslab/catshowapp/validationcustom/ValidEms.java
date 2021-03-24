package pl.coderslab.catshowapp.validationcustom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmsValidator.class)
@Documented
public @interface ValidEms {

    String message() default "Enter correct EMS code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
