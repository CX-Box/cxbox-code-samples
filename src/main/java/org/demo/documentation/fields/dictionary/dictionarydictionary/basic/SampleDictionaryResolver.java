package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dto.rowmeta.DictionaryMetadataResolver;
import org.cxbox.api.data.dto.rowmeta.OptionsMeta;
import org.cxbox.dictionary.Dictionary;
import org.cxbox.model.core.dao.JpaDao;
import org.cxbox.model.dictionary.entity.DictionaryItem;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class SampleDictionaryResolver
		implements DictionaryMetadataResolver {

	private final JpaDao jpaDao;

	@Override
	public OptionsMeta resolve(Dictionary dict) {

		DictionaryItem item =
				jpaDao.getList(DictionaryItem.class)
						.stream()
						.filter(d ->
								Objects.equals(
										d.getKey(),
										dict.key()
								))
						.findFirst()
						.orElse(null);

		if (item == null) {
			return null;
		}

		return OptionsMeta.builder()
				.description(item.getDescription())
				.build();
	}
}