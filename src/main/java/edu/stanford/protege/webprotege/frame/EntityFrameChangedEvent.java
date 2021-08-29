package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import edu.stanford.protege.webprotege.common.Event;
import edu.stanford.protege.webprotege.common.ProjectEvent;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 17/12/2012
 */
@JsonSubTypes({
        @Type(AnnotationPropertyFrameChangedEvent.class),
        @Type(ClassFrameChangedEvent.class),
        @Type(DataPropertyFrameChangedEvent.class),
        @Type(DatatypeFrameChangedEvent.class),
        @Type(NamedIndividualFrameChangedEvent.class),
        @Type(ObjectPropertyFrameChangedEvent.class)
})
public interface EntityFrameChangedEvent<E extends OWLEntity> extends ProjectEvent {

    UserId userId();

    E entity();
}
