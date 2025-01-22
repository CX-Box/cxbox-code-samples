package org.demo.documentation.widgets.assoc.actions.other.buttonassoc;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3062Controller implements EnumBcIdentifier {



    myexample3062(MyExample3062Service.class),
    myexample3062Assoc(myexample3062, MyEntity3062MultiMultivalueService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3062Controller> Holder = new Holder<>(
            CxboxMyExample3062Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3062Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3062Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3062Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3062Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3062Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3062Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3062Controller> {

        public BcSupplier() {
            super(CxboxMyExample3062Controller.Holder);
        }

    }

}