package org.demo.documentation.widgets.statsblock.tag;

import java.util.List;
import java.util.Objects;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
public class MyExample4234Dao extends AbstractAnySourceBaseDAO<MyExample4234DTO> implements
		AnySourceBaseDAO<MyExample4234DTO> {

	@Override
	public String getId(final MyExample4234DTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyExample4234DTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4234DTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<MyExample4234DTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStats());
	}

	@Override
	public MyExample4234DTO update(BusinessComponent bc, MyExample4234DTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public MyExample4234DTO create(final BusinessComponent bc, final MyExample4234DTO entity) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getStats]
	private List<MyExample4234DTO> getStats() {
		return List.of(
				card("1", "New claims", 42007L, "+35 %", "#B5473A"),
				card("2", "Open portfolio", 44499L, "-0.7 %", "#2E7D4F"),
				card("3", "Closed claims", 1518L, null, null)
		);
	}

	private static MyExample4234DTO card(String id, String title, Long value, String tag, String tagColor) {
		MyExample4234DTO card = new MyExample4234DTO()
				.setTitle(title)
				.setValue(value)
				.setTag(tag)
				.setTagColor(tagColor);
		card.setId(id);
		return card;
	}
	// --8<-- [end:getStats]

}
