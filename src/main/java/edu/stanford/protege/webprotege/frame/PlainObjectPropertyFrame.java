package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-01
 */
@AutoValue

@JsonTypeName(PlainObjectPropertyFrame.OBJECT_PROPERTY_FRAME)
public abstract class PlainObjectPropertyFrame extends PlainEntityFrame {

    public static final String OBJECT_PROPERTY_FRAME = "ObjectPropertyFrame";

    private static final String CHARACTERISTICS = "characteristics";

    public static final String DOMAINS = "domains";

    public static final String RANGES = "ranges";

    public static final String INVERSES = "inverses";

    @Nonnull
    @JsonCreator
    public static PlainObjectPropertyFrame get(@Nonnull @JsonProperty(SUBJECT) OWLObjectProperty subject,
                                               @Nonnull @JsonProperty(PROPERTY_VALUES) ImmutableSet<PlainPropertyAnnotationValue> annotationValues,
                                               @Nonnull @JsonProperty(CHARACTERISTICS) ImmutableSet<ObjectPropertyCharacteristic> characteristics,
                                               @Nonnull @JsonProperty(DOMAINS) ImmutableSet<OWLClass> domains,
                                               @Nonnull @JsonProperty(RANGES) ImmutableSet<OWLClass> ranges,
                                               @Nonnull @JsonProperty(INVERSES) ImmutableSet<OWLObjectProperty> inverses) {
        return new AutoValue_PlainObjectPropertyFrame(subject, annotationValues, characteristics, domains, ranges, inverses);
    }

    public static PlainObjectPropertyFrame empty(OWLObjectProperty property) {
        return PlainObjectPropertyFrame.get(property, ImmutableSet.of(), ImmutableSet.of(), ImmutableSet.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    @Nonnull
    @Override
    public abstract OWLObjectProperty getSubject();

    @Nonnull
    public abstract ImmutableSet<PlainPropertyAnnotationValue> getPropertyValues();

    @JsonProperty(CHARACTERISTICS)
    @Nonnull
    public abstract ImmutableSet<ObjectPropertyCharacteristic> getCharacteristics();

    @JsonProperty(DOMAINS)
    @Nonnull
    public abstract ImmutableSet<OWLClass> getDomains();

    @JsonProperty(RANGES)
    @Nonnull
    public abstract ImmutableSet<OWLClass> getRanges();

    @JsonProperty(INVERSES)
    @Nonnull
    public abstract ImmutableSet<OWLObjectProperty> getInverseProperties();

    @Nonnull
    @Override
    public PlainObjectPropertyFrame toPlainFrame() {
        return this;
    }
}
