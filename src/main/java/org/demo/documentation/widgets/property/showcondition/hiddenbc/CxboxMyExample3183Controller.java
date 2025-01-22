package org.demo.documentation.widgets.property.showcondition.hiddenbc;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.child.MyExample3183Service;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc.MyExample3184Service;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.parent.MyExample3185Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3183Controller implements EnumBcIdentifier {


    myexample3184(MyExample3184Service.class),
    myexample3185(myexample3184, MyExample3185Service.class),
    myexample3183(myexample3185, MyExample3183Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3183Controller> Holder = new Holder<>(
            CxboxMyExample3183Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3183Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3183Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3183Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3183Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3183Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3183Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3183Controller> {

        public BcSupplier() {
            super(CxboxMyExample3183Controller.Holder);
        }

    }

}