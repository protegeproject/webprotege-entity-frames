package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-01
 */
@AutoValue

@JsonTypeName(PlainDataPropertyFrame.DATA_PROPERTY_FRAME)
public abstract class PlainDataPropertyFrame extends PlainEntityFrame {

    public static final String DATA_PROPERTY_FRAME = "DataPropertyFrame";

    public static final String DOMAINS = "domains";

    public static final String RANGES = "ranges";

    public static final String FUNCTIONAL = "functional";

    @JsonCreator
    public static PlainDataPropertyFrame get(@Nonnull @JsonProperty(SUBJECT) OWLDataProperty subject,
                                             @Nonnull @JsonProperty(PROPERTY_VALUES) ImmutableSet<PlainPropertyAnnotationValue> annotations,
                                             @Nonnull @JsonProperty(DOMAINS) ImmutableSet<OWLClass> domains,
                                             @Nonnull @JsonProperty(RANGES) ImmutableSet<OWLDatatype> ranges,
                                             @JsonProperty(FUNCTIONAL) boolean functional) {
        return new AutoValue_PlainDataPropertyFrame(subject, annotations, domains, ranges, functional);
    }

    public static PlainDataPropertyFrame empty(OWLDataProperty property) {
        return PlainDataPropertyFrame.get(property, ImmutableSet.of(), ImmutableSet.of(), ImmutableSet.of(), false);
    }

    @Nonnull
    @Override
    public abstract OWLDataProperty getSubject();

    @Nonnull
    public abstract ImmutableSet<PlainPropertyAnnotationValue> getPropertyValues();

    @JsonProperty(DOMAINS)
    @Nonnull
    public abstract ImmutableSet<OWLClass> getDomains();

    @JsonProperty(RANGES)
    @Nonnull
    public abstract ImmutableSet<OWLDatatype> getRanges();

    @JsonProperty(FUNCTIONAL)
    public abstract boolean isFunctional();

    @Nonnull
    @Override
    public PlainDataPropertyFrame toPlainFrame() {
        return this;
    }
}
