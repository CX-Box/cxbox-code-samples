package org.demo.documentation.navigation.tab.typestandard.businessexample;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.navigation.tab.typestandard.businessexample.client.MyExample3426Service;
import org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject.MyExample3427Service;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyExample3428Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3428Controller implements EnumBcIdentifier {

    

    myexample3428(MyExample3428Service.class),
    myexample3426(myexample3428, MyExample3426Service.class),
    myexample3427(myexample3428, MyExample3427Service.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3428Controller> Holder = new Holder<>(
            CxboxMyExample3428Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3428Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3428Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3428Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3428Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3428Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3428Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3428Controller> {

        public BcSupplier() {
            super(CxboxMyExample3428Controller.Holder);
        }

    }

}