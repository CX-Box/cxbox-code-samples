package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175InlinePickPickService;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiHoverPickService;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175MultiPickService;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3175Controller implements EnumBcIdentifier {

    

    myexample3175(MyExample3175Service.class), myEntity3175PickPick(myexample3175, MyEntity3175PickPickService.class), myEntity3175InlinePickPick(myexample3175, MyEntity3175InlinePickPickService.class), myEntity3175MultiPick(myexample3175, MyEntity3175MultiPickService.class), myEntity3175MultiHoverPick(myexample3175, MyEntity3175MultiHoverPickService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3175Controller> Holder = new Holder<>(
            CxboxMyExample3175Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3175Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3175Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3175Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3175Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3175Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3175Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3175Controller> {

        public BcSupplier() {
            super(CxboxMyExample3175Controller.Holder);
        }

    }

}