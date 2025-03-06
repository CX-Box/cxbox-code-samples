package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.demo.documentation.feature.microservice.conf.IntegrationConfiguration;
import org.demo.services.utils.IntegrationURLBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyEntity4600Dao extends AbstractAnySourceBaseDAO<MyEntity4600OutServiceDTO> implements AnySourceBaseDAO<MyEntity4600OutServiceDTO> {
    private static final String DELIMITER = ",";
    private final IntegrationConfiguration integrationConfig;

    private final RestTemplate restTemplate;

    private final IntegrationURLBuilder integrationURLBuilder;

    @Override
    public String getId(final MyEntity4600OutServiceDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyEntity4600OutServiceDTO entity) {
        entity.setId(id);
    }


    // --8<-- [start:getByIdIgnoringFirstLevelCache]
    @Override
    public MyEntity4600OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        try {
            return getData().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // --8<-- [end:getByIdIgnoringFirstLevelCache]

    // --8<-- [start:getList]
    @Override
    public Page<MyEntity4600OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        try {
            return new PageImpl<>(getData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // --8<-- [end:getList]


    @Override
    // --8<-- [start:delete]
    public void delete(BusinessComponent bc) {
        throw new IllegalStateException();
    }
    // --8<-- [end:delete]


    @Override
    // --8<-- [start:create]
    public MyEntity4600OutServiceDTO create(BusinessComponent bc, MyEntity4600OutServiceDTO entity) {
        throw new IllegalStateException();
    }
    // --8<-- [end:create]

    @Override
    // --8<-- [start:update]
    public MyEntity4600OutServiceDTO update(BusinessComponent bc, MyEntity4600OutServiceDTO entity) {
        throw new IllegalStateException();
        // --8<-- [end:update]
    }

    @NonNull
    private List<MyEntity4600OutServiceDTO> getData() throws IOException {

        String filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "db","data","custom","product.csv").toString();
        return Files.readAllLines(Paths.get(filePath))
                .stream()
                .map(line -> line.split(DELIMITER)) // Разделяем строку по разделителю
                .map(parts -> {
                    MyEntity4600OutServiceDTO dto = new MyEntity4600OutServiceDTO();
                    dto.setId(parts[0]);
                    dto.setCustomField(parts[1]);
                    return dto;
                })
                .collect(Collectors.toList()); // Собираем результат в список
    }

}