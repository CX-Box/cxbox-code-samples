package org.demo.documentation.widgets.assoc.actions.customsave;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3063Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3063(MyExample3063Service.class), myEntity3063MultiAssocListPopup(myexample3063, MyEntity3063MultiMultivalueService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3063Controller> Holder = new Holder<>(
            CxboxMyExample3063Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3063Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3063Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3063Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3063Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3063Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3063Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3063Controller> {

        public BcSupplier() {
            super(CxboxMyExample3063Controller.Holder);
        }

    }

}