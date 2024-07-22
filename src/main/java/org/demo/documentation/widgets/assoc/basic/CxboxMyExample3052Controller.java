package org.demo.documentation.widgets.assoc.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052MultiAssocMultivalueService;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052MultiMultiAssocMultivalueService;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052PicklistAssocPickService;
import org.demo.documentation.widgets.assoc.basic.forfields.MyEntity3052PicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3052Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3052(MyExample3052Service.class), myEntity3052MultiAssocListPopup(myexample3052, MyEntity3052MultiMultivalueService.class), myEntity3052PicklistAssocPickListPopup(myEntity3052MultiAssocListPopup, MyEntity3052PicklistAssocPickService.class), myEntity3052PicklistPickListPopup(myEntity3052MultiAssocListPopup, MyEntity3052PicklistPickService.class), myEntity3052MultiMultiAssocAssocListPopup(myEntity3052MultiAssocListPopup, MyEntity3052MultiMultiAssocMultivalueService.class), myEntity3052MultiAssocAssocListPopup(myEntity3052MultiAssocListPopup, MyEntity3052MultiAssocMultivalueService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3052Controller> Holder = new Holder<>(
            CxboxMyExample3052Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3052Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3052Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3052Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3052Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3052Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3052Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3052Controller> {

        public BcSupplier() {
            super(CxboxMyExample3052Controller.Holder);
        }

    }

}