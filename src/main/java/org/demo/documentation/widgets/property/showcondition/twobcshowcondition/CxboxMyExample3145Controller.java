package org.demo.documentation.widgets.property.showcondition.twobcshowcondition;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyExample3145Service;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyExample3146Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3145Controller implements EnumBcIdentifier {



    myexample3146(MyExample3146Service.class),
    myexample3145(myexample3146, MyExample3145Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3145Controller> Holder = new Holder<>(
            CxboxMyExample3145Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3145Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3145Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3145Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3145Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3145Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3145Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3145Controller> {

        public BcSupplier() {
            super(CxboxMyExample3145Controller.Holder);
        }

    }

}