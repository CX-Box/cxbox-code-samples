package org.demo.documentation.widgets.property.sethidden.graph.pie;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.property.sethidden.graph.inner.MyEntity5020Repository;
import org.demo.documentation.widgets.property.sethidden.graph.inner.MyExample5020DTO;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleStatsProductPieDao extends AbstractAnySourceBaseDAO<SalesProductPieDTO>
		implements AnySourceBaseDAO<SalesProductPieDTO> {

	private final MyEntity5020Repository repository;

	@Override
	public String getId(final SalesProductPieDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final SalesProductPieDTO entity) {
		entity.setId(id);
	}

	@Override
	public SalesProductPieDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return getStatistics(bc).stream()
				.filter(s -> Objects.equals(s.getId(), bc.getId()))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void delete(final BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Page<SalesProductPieDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return new PageImpl<>(getStatistics(bc));
	}

	@Override
	public SalesProductPieDTO update(BusinessComponent bc, SalesProductPieDTO entity) {
		throw new IllegalStateException();
	}

	@Override
	public SalesProductPieDTO create(final BusinessComponent bc, final SalesProductPieDTO entity) {
		throw new IllegalStateException();
	}

	public List<SalesProductPieDTO> getStatistics(BusinessComponent bc) {

		List<MyExample5020DTO> salesStats = repository.findAll().stream()
				.map(MyExample5020DTO::new)
				.toList();

		Map<ProductNameEnum, Long> stats = salesStats.stream()
				.collect(Collectors.groupingBy(
						MyExample5020DTO::getProductName,
						Collectors.counting()
				));

		Map<ProductNameEnum, SalesProductPieDTO> config = new HashMap<>();
		SalesProductPieDTO equipment = new SalesProductPieDTO()
				.setColor("#779FE9").setIcon("team")
				.setDescription("Equipment");
		config.put(ProductNameEnum.EQUIPMENT, equipment);
		SalesProductPieDTO expertise =
				new SalesProductPieDTO()
						.setColor("#5F90EA").setIcon("calendar")
						.setDescription("Expertise");
		config.put(ProductNameEnum.EXPERTISE, expertise);
		List<SalesProductPieDTO> salesStatsList = new ArrayList<>();
		stats.entrySet().stream()
				.filter(e -> e.getValue() > 0)
				.forEach(kv -> {
							SalesProductPieDTO salesProduct = createStatsDTO(
									kv.getKey().getValue(),
									kv.getValue(),
									config.get(kv.getKey()).getColor(),
									config.get(kv.getKey()).getIcon(),
									config.get(kv.getKey()).getDescription(),
									kv.getKey().getValue());
							salesStatsList.add(salesProduct);
						}
				);
		return salesStatsList;
	}

	private SalesProductPieDTO createStatsDTO(String title, long value, String color, String icon, String id,
											  String description) {
		SalesProductPieDTO clientStatsDTO = new SalesProductPieDTO();
		clientStatsDTO.setTitle(title)
				.setValue(value)
				.setColor(color)
				.setIcon(icon)
				.setDescription(description)
				.setId(id);
		return clientStatsDTO;
	}
}
