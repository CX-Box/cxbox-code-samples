package org.demo.documentation.widgets.additionalinfo.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600MultiMultivalueService;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Pick2PickService;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600PickMultivalueService;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600PickPickService;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample3600Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc3600(MyExample3600Service.class), myEntity3600MultiAssocListPopup(myExampleBc3600, MyEntity3600MultiMultivalueService.class), myEntity3600PickAssocListPopup(myExampleBc3600, MyEntity3600PickMultivalueService.class), myEntity3600Pick2PickListPopup(myExampleBc3600, MyEntity3600Pick2PickService.class), myEntity3600PickPickListPopup(myExampleBc3600, MyEntity3600PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample3600Controller> Holder = new Holder<>(
            PlatformMyExample3600Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample3600Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample3600Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample3600Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample3600Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample3600Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample3600Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample3600Controller> {

        public BcSupplier() {
            super(PlatformMyExample3600Controller.Holder);
        }

    }

}