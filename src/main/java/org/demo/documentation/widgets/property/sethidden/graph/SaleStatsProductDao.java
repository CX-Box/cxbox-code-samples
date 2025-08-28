package org.demo.documentation.widgets.property.sethidden.graph;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.widgets.property.sethidden.graph.inner.MyEntity5020Repository;
import org.demo.documentation.widgets.property.sethidden.graph.inner.enums.ProductNameEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SaleStatsProductDao extends AbstractAnySourceBaseDAO<SalesProductDTO> implements
        AnySourceBaseDAO<SalesProductDTO> {

    private final MyEntity5020Repository repository;

    @Override
    public String getId(final SalesProductDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final SalesProductDTO entity) {
        entity.setId(id);
    }

    @Override
    public SalesProductDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<SalesProductDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getStats());
    }

    @Override
    public SalesProductDTO update(BusinessComponent bc, SalesProductDTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public SalesProductDTO create(final BusinessComponent bbc, final SalesProductDTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private List<SalesProductDTO> getStats() {
        var salesStats = repository.findAll();
        return salesStats.stream()
                .<SalesProductDTO>map(stat -> SalesProductDTO.builder()
                        .id(stat.getId().toString())
                        .clientName(stat.getClientName())
                        .productName(stat.getProductName())
                        .sum(stat.getSum())
                        .vstamp(0L)
                        .color(ProductNameEnum.EXPERTISE.equals(stat.getProductName()) ? "#4D83E7" : "#30BA8F")
                        .build())
                .toList();
    }


}
