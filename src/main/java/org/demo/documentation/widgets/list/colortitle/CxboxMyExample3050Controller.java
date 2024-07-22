package org.demo.documentation.widgets.list.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050InlinePicklistPickService;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMultiMultivalueService;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMultivalueService;
import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050PicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3050Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3050(MyExample3050Service.class), myEntity3050PicklistPickListPopup(myexample3050, MyEntity3050PicklistPickService.class), myEntity3050InlinePicklistPickListPopup(myexample3050, MyEntity3050InlinePicklistPickService.class), myEntity3050MultiMultiAssocListPopup(myexample3050, MyEntity3050MultiMultiMultivalueService.class), myEntity3050MultiAssocListPopup(myexample3050, MyEntity3050MultiMultivalueService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3050Controller> Holder = new Holder<>(
            CxboxMyExample3050Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3050Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3050Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3050Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3050Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3050Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3050Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3050Controller> {

        public BcSupplier() {
            super(CxboxMyExample3050Controller.Holder);
        }

    }

}