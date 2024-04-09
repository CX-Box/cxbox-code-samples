package org.demo.documentation.other.alltypes;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;


@Getter
public enum PlatformMyExample421Controller implements EnumBcIdentifier {

    // @formatter:on
    myExampleBc421(MyExample421Service.class), myEntity424AssocListPopup(myExampleBc421, MyEntity424MultivalueService.class), myEntity422AssocListPopup(myExampleBc421, MyEntity422MultivalueService.class), myEntity423PickListPopup(myExampleBc421, MyEntity423PickService.class), myEntity422PickListPopup(myExampleBc421, MyEntity422PickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<PlatformMyExample421Controller> Holder = new Holder<>(
            PlatformMyExample421Controller.class);

    private final BcDescription bcDescription;

    PlatformMyExample421Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    PlatformMyExample421Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    PlatformMyExample421Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    PlatformMyExample421Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    PlatformMyExample421Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    PlatformMyExample421Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<PlatformMyExample421Controller> {

        public BcSupplier() {
            super(PlatformMyExample421Controller.Holder);
        }

    }

}