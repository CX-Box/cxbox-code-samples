package org.demo.documentation.widgets.additionalinfo.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3029PickService;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3030PickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3025Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3025(MyExample3025Service.class), myEntity3030PickListPopup(myexample3025, MyEntity3030PickService.class), myEntity3029PickListPopup(myexample3025, MyEntity3029PickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3025Controller> Holder = new Holder<>(
            CxboxMyExample3025Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3025Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3025Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3025Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3025Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3025Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3025Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3025Controller> {

        public BcSupplier() {
            super(CxboxMyExample3025Controller.Holder);
        }

    }

}