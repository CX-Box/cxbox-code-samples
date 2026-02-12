package org.demo.documentation.fields.dictionary.validationannotationcustom;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.demo.documentation.fields.dictionary.validationannotationcustom.enums.CustomFieldEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CustomerTypeSubSetValidator.class)
public @interface CustomerTypeSubset {

	CustomFieldEnum[] anyOf();

	String message() default "can contain any of  {anyOf}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}