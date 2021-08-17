package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-04-01
 */
@AutoValue

@JsonTypeName(PlainAnnotationPropertyFrame.ANNOTATION_PROPERTY_FRAME)
public abstract class PlainAnnotationPropertyFrame extends PlainEntityFrame {

    public static final String ANNOTATION_PROPERTY_FRAME = "AnnotationPropertyFrame";

    private static final String DOMAINS = "domains";

    private static final String RANGES = "ranges";

    @JsonCreator
    @Nonnull
    public static PlainAnnotationPropertyFrame get(@Nonnull @JsonProperty(SUBJECT) OWLAnnotationProperty subject,
                                                   @Nonnull @JsonProperty(PROPERTY_VALUES) ImmutableSet<PlainPropertyAnnotationValue> annotations,
                                                   @Nonnull @JsonProperty(DOMAINS) ImmutableSet<IRI> domains,
                                                   @Nonnull @JsonProperty(RANGES) ImmutableSet<IRI> ranges) {
        return new AutoValue_PlainAnnotationPropertyFrame(subject, annotations, domains, ranges);
    }

    public static PlainAnnotationPropertyFrame empty(OWLAnnotationProperty property) {
        return PlainAnnotationPropertyFrame.get(property, ImmutableSet.of(), ImmutableSet.of(), ImmutableSet.of());
    }

    @Nonnull
    @Override
    public abstract OWLAnnotationProperty getSubject();

    @Nonnull
    public abstract ImmutableSet<PlainPropertyAnnotationValue> getPropertyValues();

    @JsonProperty(DOMAINS)
    @Nonnull
    public abstract ImmutableSet<IRI> getDomains();

    @JsonProperty(RANGES)
    @Nonnull
    public abstract ImmutableSet<IRI> getRanges();

    @Nonnull
    @Override
    public PlainAnnotationPropertyFrame toPlainFrame() {
        return this;
    }
}
