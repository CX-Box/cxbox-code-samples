package org.demo.documentation.fields.richtext.filtrationplaintext;

import java.lang.reflect.Field;
import java.util.List;
import lombok.EqualsAndHashCode;
import org.cxbox.core.controller.param.FilterParameter;
import org.cxbox.core.dao.ClassifyDataParameter;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.ClassifyDataProvider;
import org.cxbox.core.util.filter.provider.impl.AbstractClassifyDataProvider;
import org.springframework.stereotype.Component;

/**
 * Keeps only the letters and digits of the value the user typed in the filter,
 * the same way the column customFieldPlain keeps them.
 */
@Component
@EqualsAndHashCode(callSuper = false)
public class PlainTextValueProvider extends AbstractClassifyDataProvider implements ClassifyDataProvider {

	@Override
	protected List<ClassifyDataParameter> getProviderParameterValues(Field dtoField, ClassifyDataParameter dataParameter,
			FilterParameter filterParam, SearchParameter searchParam, List<ClassifyDataProvider> providers) {
		dataParameter.setValue(filterParam.getStringValue().replaceAll("[^\\p{L}\\p{N}]", ""));
		return List.of(dataParameter);
	}

}
