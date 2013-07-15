package net.narusas.jstl.validate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({ FIELD, })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface ValidDateTimeFormat {
	String message() default "{net.narusas.jstl.validate.ValidDateTimeFormat}";
}
