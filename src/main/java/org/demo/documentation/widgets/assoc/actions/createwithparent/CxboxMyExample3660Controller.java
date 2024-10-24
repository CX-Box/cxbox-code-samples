package org.demo.documentation.widgets.assoc.actions.createwithparent;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.assoc.actions.createwithparent.assoc.MyEntity3662MultivalueService;
import org.demo.documentation.widgets.assoc.actions.createwithparent.assocreq.MyEntity3663MultivalueService;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyExample3661Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3660Controller implements EnumBcIdentifier {



    myexample3661(MyExample3661Service.class),
    myexample3660(myexample3661,MyExample3660Service.class),
    myEntity3663AssocListPopup(myexample3660, MyEntity3663MultivalueService.class),
    myEntity3662AssocListPopup(myexample3660, MyEntity3662MultivalueService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3660Controller> Holder = new Holder<>(
            CxboxMyExample3660Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3660Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3660Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3660Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3660Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3660Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3660Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3660Controller> {

        public BcSupplier() {
            super(CxboxMyExample3660Controller.Holder);
        }

    }

}