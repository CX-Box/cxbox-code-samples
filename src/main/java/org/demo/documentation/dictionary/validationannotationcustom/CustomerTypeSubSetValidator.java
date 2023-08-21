package org.demo.documentation.dictionary.validationannotationcustom;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.demo.documentation.dictionary.validationannotationcustom.enums.CustomFieldEnum;

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
