package org.demo.documentation.fields.suggestion.required;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.required.forfield.MyExample3098Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3087Controller implements EnumBcIdentifier {

  // @formatter:on

    myexample3098(MyExample3098Service.class),
    myexample3087(MyExample3087SuggestionService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3087Controller> Holder = new Holder<>(
            CxboxMyExample3087Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3087Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3087Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3087Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3087Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3087Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3087Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3087Controller> {

        public BcSupplier() {
            super(CxboxMyExample3087Controller.Holder);
        }

    }

}