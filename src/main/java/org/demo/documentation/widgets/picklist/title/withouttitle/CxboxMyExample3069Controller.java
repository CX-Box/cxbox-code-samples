package org.demo.documentation.widgets.picklist.title.withouttitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3069Controller implements EnumBcIdentifier {

    

    myexample3069(MyExample3069Service.class), myEntity3069PickPickListPopup(myexample3069, MyEntity3069PickPickService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3069Controller> Holder = new Holder<>(
            CxboxMyExample3069Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3069Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3069Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3069Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3069Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3069Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3069Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3069Controller> {

        public BcSupplier() {
            super(CxboxMyExample3069Controller.Holder);
        }

    }

}