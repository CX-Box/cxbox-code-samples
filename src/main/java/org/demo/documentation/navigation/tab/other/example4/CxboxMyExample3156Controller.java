package org.demo.documentation.navigation.tab.other.example4;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3156Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3156(MyExample3156Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3156Controller> Holder = new Holder<>(
            CxboxMyExample3156Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3156Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3156Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3156Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3156Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3156Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3156Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3156Controller> {

        public BcSupplier() {
            super(CxboxMyExample3156Controller.Holder);
        }

    }

}