package org.demo.documentation.widgets.form.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.form.colortitle.forfields.*;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3026Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3026(MyExample3026Service.class), myEntity3038AssocListPopup(myexample3026, MyEntity3038MultivalueService.class), myEntity3037AssocListPopup(myexample3026, MyEntity3037MultivalueService.class), myEntity3033AssocListPopup(myexample3026, MyEntity3033MultivalueService.class), myEntity3032PickListPopup(myexample3026, MyEntity3032PickService.class), myEntity3031PickListPopup(myexample3026, MyEntity3031PickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3026Controller> Holder = new Holder<>(
            CxboxMyExample3026Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3026Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3026Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3026Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3026Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3026Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3026Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3026Controller> {

        public BcSupplier() {
            super(CxboxMyExample3026Controller.Holder);
        }

    }

}