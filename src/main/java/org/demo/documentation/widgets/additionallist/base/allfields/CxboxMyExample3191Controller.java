package org.demo.documentation.widgets.additionallist.base.allfields;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191MultiHoverPickService;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191MultiPickService;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191PickPick0Service;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3191Controller implements EnumBcIdentifier {

    

    myexample3191(MyExample3191Service.class), myEntity3191PickPick0(myexample3191, MyEntity3191PickPick0Service.class), myEntity3191PickPick(myexample3191, MyEntity3191PickPickService.class), myEntity3191MultiPick(myexample3191, MyEntity3191MultiPickService.class), myEntity3191MultiHoverPick(myexample3191, MyEntity3191MultiHoverPickService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3191Controller> Holder = new Holder<>(
            CxboxMyExample3191Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3191Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3191Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3191Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3191Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3191Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3191Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3191Controller> {

        public BcSupplier() {
            super(CxboxMyExample3191Controller.Holder);
        }

    }

}