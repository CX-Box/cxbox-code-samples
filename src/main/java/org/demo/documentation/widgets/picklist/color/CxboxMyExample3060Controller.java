package org.demo.documentation.widgets.picklist.color;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3060Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3060(MyExample3060Service.class), myEntity3061PickListPopup(myexample3060, MyEntity3061PickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3060Controller> Holder = new Holder<>(
            CxboxMyExample3060Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3060Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3060Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3060Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3060Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3060Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3060Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3060Controller> {

        public BcSupplier() {
            super(CxboxMyExample3060Controller.Holder);
        }

    }

}