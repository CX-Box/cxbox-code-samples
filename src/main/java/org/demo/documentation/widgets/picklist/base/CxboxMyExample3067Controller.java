package org.demo.documentation.widgets.picklist.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.base.allfields.MyExample3067Service;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067MultiMultiMultivalueService;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067MultiMultivalueService;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickInlinePicklistPickService;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickPicklistPickService;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.picklist.MyEntity3067PickPick0Service;
import org.demo.documentation.widgets.picklist.base.onefield.MyExample3079Service;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.inline.MyEntity3079PickPick0Service;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.picklist.MyEntity3079PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3067Controller implements EnumBcIdentifier {


    myexample3079(MyExample3079Service.class),
        myEntity3079PickPick0(myexample3079, MyEntity3079PickPick0Service.class),
        myEntity3079PickPick(myexample3079, MyEntity3079PickPickService.class),
    myexample3067(MyExample3067Service.class),
        myEntity3067PickPick(myexample3067, MyEntity3067PickPick0Service.class),
        myEntity3067PickPickListPopup(myexample3067, MyEntity3067PickPick0Service.class),
            myEntity3067PickPicklistPickListPopup(myEntity3067PickPickListPopup, MyEntity3067PickPicklistPickService.class), myEntity3067PickInlinePicklistPickListPopup(myEntity3067PickPickListPopup, MyEntity3067PickInlinePicklistPickService.class), myEntity3067MultiAssocListPopup(myEntity3067PickPickListPopup, MyEntity3067MultiMultivalueService.class), myEntity3067MultiMultiAssocListPopup(myEntity3067PickPickListPopup, MyEntity3067MultiMultiMultivalueService.class);


    public static final EnumBcIdentifier.Holder<CxboxMyExample3067Controller> Holder = new Holder<>(
            CxboxMyExample3067Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3067Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3067Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3067Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3067Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3067Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3067Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3067Controller> {

        public BcSupplier() {
            super(CxboxMyExample3067Controller.Holder);
        }

    }

}