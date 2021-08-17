package edu.stanford.protege.webprotege.frame;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public record DataPropertyFrameChangedEvent(ProjectId projectId,
                                            UserId userId,
                                            OWLDataProperty entity) implements EntityFrameChangedEvent<OWLDataProperty> {

    @Override
    public String getChannel() {
        return "frames.events.DataPropertyFrameChanged";
    }
}
