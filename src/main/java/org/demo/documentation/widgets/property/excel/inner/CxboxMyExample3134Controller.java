package org.demo.documentation.widgets.property.excel.inner;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134InlinePickPickService;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134MultiHoverMultivalueService;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134MultiMultivalueService;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3134Controller implements EnumBcIdentifier {


    myexample3134GH(MyExample3134Service.class),
        myEntity3134PickPickListPopupGH(myexample3134GH, MyEntity3134PickPickService.class),
        myEntity3134InlinePickPickListPopupGH(myexample3134GH, MyEntity3134InlinePickPickService.class),
    myexample3134(MyExample3134Service.class), myEntity3134SuggectionPickPick(myexample3134, MyEntity3134SuggectionPickPickService.class),
        myEntity3134PickPickListPopup(myexample3134, MyEntity3134PickPickService.class),
        myEntity3134InlinePickPickListPopup(myexample3134, MyEntity3134InlinePickPickService.class),
        myEntity3134MultiAssocListPopup(myexample3134, MyEntity3134MultiMultivalueService.class),
        myEntity3134MultiHoverAssocListPopup(myexample3134, MyEntity3134MultiHoverMultivalueService.class),
        myEntity3134MultiAssocListPopupForPickListPopup(myexample3134, MyEntity3134MultiMultivalueService.class),
        myEntity3134PickPickListPopupForPick(myexample3134, MyEntity3134PickPickService.class);


    public static final EnumBcIdentifier.Holder<CxboxMyExample3134Controller> Holder = new Holder<>(
            CxboxMyExample3134Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3134Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3134Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3134Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3134Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3134Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3134Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3134Controller> {

        public BcSupplier() {
            super(CxboxMyExample3134Controller.Holder);
        }

    }

}