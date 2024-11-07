package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3154Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3154(MyExample3154Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3154Controller> Holder = new Holder<>(
            CxboxMyExample3154Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3154Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3154Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3154Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3154Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3154Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3154Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3154Controller> {

        public BcSupplier() {
            super(CxboxMyExample3154Controller.Holder);
        }

    }

}