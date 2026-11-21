package org.demo.documentation.feature.drilldown.drilldownfilter;


import java.util.List;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.BaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;


/**
 * Counts through the same search providers as the list, including dates and multivalue fields.
 */
@Service
@RequiredArgsConstructor
public class MyExample4300DashboardStatsDao extends AbstractAnySourceBaseDAO<MyExample4300DashboardStatsDTO> {
	private final BaseDAO baseDAO;
	private final MyEntity4300PostActionWithCustomBuilderRepository formRepository;

	@Override
	public String getId(MyExample4300DashboardStatsDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(String id, MyExample4300DashboardStatsDTO entity) {
		entity.setId(id);
	}

	@Override
	public MyExample4300DashboardStatsDTO getByIdIgnoringFirstLevelCache(BusinessComponent bc) {
		var entity = formRepository.findById(bc.getParentIdAsLong()).orElseThrow();
		var dto = new MyExample4300PostActionWithCustomBuilderDTO(entity);
		return rows(dto, MyExample4300DashboardFilters.parameters(dto)).stream().filter(row -> row.getId().equals(bc.getId())).findFirst().orElseThrow();
	}

	@Override
	public Page<MyExample4300DashboardStatsDTO> getList(BusinessComponent bc, QueryParameters parameters) {
		var dto = new MyExample4300PostActionWithCustomBuilderDTO(formRepository.findById(bc.getParentIdAsLong()).orElseThrow());
		return new PageImpl<>(rows(dto, MyExample4300DashboardFilters.parameters(dto)));
	}

	private List<MyExample4300DashboardStatsDTO> rows(MyExample4300PostActionWithCustomBuilderDTO form, QueryParameters parameters) {
		return List.of(
				stat("matching", "Matching records", count(parameters), "filter", MyExample4300DashboardFilters.isEmpty(form) ? "No form conditions. Use Clear filters above the list to show all records." : "Click to apply the form conditions to the list"),
				stat("total", "All records", count(QueryParameters.emptyQueryParameters()), "database", "Total records before filtering"),
				stat("conditions", "Active conditions", MyExample4300DashboardFilters.activeConditions(form), "control", "Values within a field: OR; different fields: AND"));
	}

	private long count(QueryParameters parameters) {
		return baseDAO.getCount(MyEntityWithDrilldown4300.class, MyExample4300WithDrilldownDTO.class, null, parameters);
	}

	private MyExample4300DashboardStatsDTO stat(String id, String title, long value, String icon, String description) {
		var dto = new MyExample4300DashboardStatsDTO();
		dto.setId(id);
		dto.setTitle(title);
		dto.setValue(value);
		dto.setIcon(icon);
		dto.setDescription(description);
		return dto;
	}

	@Override
	public void delete(BusinessComponent bc) {
		throw new UnsupportedOperationException("Read only stats");
	}

	@Override
	public MyExample4300DashboardStatsDTO update(BusinessComponent bc, MyExample4300DashboardStatsDTO entity) {
		throw new UnsupportedOperationException("Read only stats");
	}

	@Override
	public MyExample4300DashboardStatsDTO create(BusinessComponent bc, MyExample4300DashboardStatsDTO entity) {
		throw new UnsupportedOperationException("Read only stats");
	}
}
