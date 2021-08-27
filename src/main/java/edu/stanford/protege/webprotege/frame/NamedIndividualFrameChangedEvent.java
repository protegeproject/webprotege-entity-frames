package edu.stanford.protege.webprotege.frame;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public record NamedIndividualFrameChangedEvent(ProjectId projectId,
                                               UserId userId,
                                               OWLNamedIndividual entity) implements EntityFrameChangedEvent<OWLNamedIndividual> {

    @Override
    public String getChannel() {
        return "webprotege.frames.events.NamedIndividualFrameChanged";
    }
}
