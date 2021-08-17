package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public record AnnotationPropertyFrameChangedEvent(ProjectId projectId,
                                                  UserId userId,
                                                  OWLAnnotationProperty entity) implements EntityFrameChangedEvent<OWLAnnotationProperty> {

    @Override
    public String getChannel() {
        return "frames.events.AnnotationPropertyFrameChanged";
    }
}
