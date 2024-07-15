package org.demo.documentation.fields.dictionary.validationannotationcustom;

import java.util.Arrays;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.demo.documentation.fields.dictionary.validationannotationcustom.enums.CustomFieldEnum;

public class CustomerTypeSubSetValidator implements ConstraintValidator<CustomerTypeSubset, CustomFieldEnum> {

	private CustomFieldEnum[] subset;

	@Override
	public void initialize(CustomerTypeSubset constraint) {
		this.subset = constraint.anyOf();
	}

	@Override
	public boolean isValid(CustomFieldEnum value, ConstraintValidatorContext context) {
		return value == null || Arrays.asList(subset).contains(value);
	}

}
