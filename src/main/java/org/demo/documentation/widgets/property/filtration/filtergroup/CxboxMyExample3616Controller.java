package org.demo.documentation.widgets.property.filtration.filtergroup;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.filtration.filtergroup.forassoc.MyEntity3623PickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3616Controller implements EnumBcIdentifier {

    myexample3616(MyExample3616Service.class),
    myEntity3623Pick(myexample3616, MyEntity3623PickService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3616Controller> Holder = new Holder<>(
            CxboxMyExample3616Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3616Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3616Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3616Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3616Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3616Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3616Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3616Controller> {

        public BcSupplier() {
            super(CxboxMyExample3616Controller.Holder);
        }

    }

}