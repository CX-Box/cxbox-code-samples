package org.demo.documentation.widgets.property.sethidden.graph.pie;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.cxbox.core.external.core.ParentDtoFirstLevelCache;
import org.demo.documentation.widgets.property.sethidden.graph.SalesProductDTO;
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
public class SaleStatsProductPieDao extends AbstractAnySourceBaseDAO<SalesProductPieDTO> implements
        AnySourceBaseDAO<SalesProductPieDTO> {

    private final MyEntity5020Repository repository;

    public static final int ROWS_TOTAL = 3;

    public static final String EQUIPMENT_ID = "0";

    public static final String EXPERTISE_ID = "1";


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
        return getStatistics(bc).stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
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
        long statEquipment = 0;
        long statExpertise = 0;
        statEquipment = countByProduct(ProductNameEnum.EQUIPMENT);
        statExpertise = countByProduct(ProductNameEnum.EXPERTISE);
       return createStatsList(statEquipment, statExpertise);
    }

    private List<SalesProductPieDTO> createStatsList(long statEquipment, long statExpertise) {
        List<SalesProductPieDTO> result = new ArrayList<>(ROWS_TOTAL);
        if (statEquipment != 0) {
            result.add(createStatsDTO(
                    ProductNameEnum.EQUIPMENT.getValue(),
                    statEquipment,
                    "#779FE9",
                    "team",
                    EQUIPMENT_ID,
                    "Equipment"
            ));
        }
        if (statExpertise != 0) {
            result.add(createStatsDTO(
                    ProductNameEnum.EXPERTISE.getValue(),
                    statExpertise,
                    "#5F90EA",
                    "calendar",
                    EXPERTISE_ID,
                    "Expertise"
            ));
        }
        return result;
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

    private long countByProduct(ProductNameEnum productNameEnum) {
            return repository.findAllByProductName(productNameEnum).size();
        }
}