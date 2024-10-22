package org.demo.documentation.other.savewithparent.examle0;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.savewithparent.examle0.child.MyExample3057Service;
import org.demo.documentation.other.savewithparent.examle0.parent.MyExample3058Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3057Controller implements EnumBcIdentifier {


    myexample3058(MyExample3058Service.class),
    myexample3057(myexample3058, MyExample3057Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3057Controller> Holder = new Holder<>(
            CxboxMyExample3057Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3057Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3057Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3057Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3057Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3057Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3057Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3057Controller> {

        public BcSupplier() {
            super(CxboxMyExample3057Controller.Holder);
        }

    }

}