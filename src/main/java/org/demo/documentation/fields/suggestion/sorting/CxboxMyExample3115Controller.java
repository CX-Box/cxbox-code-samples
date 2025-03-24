package org.demo.documentation.fields.suggestion.sorting;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.sorting.forfield.MyExample3122Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3115Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample3122(MyExample3122Service.class),
    myexample3115(MyExample3115Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3115Controller> Holder = new Holder<>(
            CxboxMyExample3115Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3115Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3115Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3115Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3115Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3115Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3115Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3115Controller> {

        public BcSupplier() {
            super(CxboxMyExample3115Controller.Holder);
        }

    }

}