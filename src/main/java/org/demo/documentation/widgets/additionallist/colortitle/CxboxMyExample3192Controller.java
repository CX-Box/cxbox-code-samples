package org.demo.documentation.widgets.additionallist.colortitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192MultiHoverPickService;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192MultiPickService;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192PickPick0Service;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192PickPickService;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.MyExample3192Service;
import org.demo.documentation.widgets.additionallist.colortitle.twofields.MyExample3196Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3192Controller implements EnumBcIdentifier {

    myexample3196(MyExample3196Service.class),
    myexample3192(MyExample3192Service.class),
        myEntity3192PickPick0(myexample3192, MyEntity3192PickPick0Service.class),
        myEntity3192PickPick(myexample3192, MyEntity3192PickPickService.class),
        myEntity3192MultiPick(myexample3192, MyEntity3192MultiPickService.class),
        myEntity3192MultiHoverPick(myexample3192, MyEntity3192MultiHoverPickService.class);

    public static final EnumBcIdentifier.Holder<CxboxMyExample3192Controller> Holder = new Holder<>(
            CxboxMyExample3192Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3192Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3192Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3192Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3192Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3192Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3192Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3192Controller> {

        public BcSupplier() {
            super(CxboxMyExample3192Controller.Holder);
        }

    }

}