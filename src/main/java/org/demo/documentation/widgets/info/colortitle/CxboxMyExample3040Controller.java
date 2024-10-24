package org.demo.documentation.widgets.info.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040InlinePicklistPickService;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMultiMultivalueService;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMultivalueService;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040PicklistPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3040Controller implements EnumBcIdentifier {

    

    myexample3040(MyExample3040Service.class), myEntity3040PicklistPickListPopup(myexample3040, MyEntity3040PicklistPickService.class), myEntity3040InlinePicklistPickListPopup(myexample3040, MyEntity3040InlinePicklistPickService.class), myEntity3040MultiMultiAssocListPopup(myexample3040, MyEntity3040MultiMultiMultivalueService.class), myEntity3040MultiAssocListPopup(myexample3040, MyEntity3040MultiMultivalueService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3040Controller> Holder = new Holder<>(
            CxboxMyExample3040Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3040Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3040Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3040Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3040Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3040Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3040Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3040Controller> {

        public BcSupplier() {
            super(CxboxMyExample3040Controller.Holder);
        }

    }

}