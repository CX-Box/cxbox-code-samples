package org.demo.documentation.widgets.assoc.actions.create;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3054Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3054(MyExample3054Service.class), myEntity3054MultiAssocListPopup(myexample3054, MyEntity3054MultiMultivalueService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3054Controller> Holder = new Holder<>(
            CxboxMyExample3054Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3054Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3054Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3054Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3054Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3054Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3054Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3054Controller> {

        public BcSupplier() {
            super(CxboxMyExample3054Controller.Holder);
        }

    }

}