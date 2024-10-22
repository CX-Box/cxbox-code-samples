package org.demo.documentation.widgets.assoc.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoc.basic.forfield.MyEntity3053MultiMultivalueService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3053Controller implements EnumBcIdentifier {



    myexample3053(MyExample3053Service.class), myEntity3053MultiAssocListPopup(myexample3053, MyEntity3053MultiMultivalueService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3053Controller> Holder = new Holder<>(
            CxboxMyExample3053Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3053Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3053Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3053Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3053Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3053Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3053Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3053Controller> {

        public BcSupplier() {
            super(CxboxMyExample3053Controller.Holder);
        }

    }

}