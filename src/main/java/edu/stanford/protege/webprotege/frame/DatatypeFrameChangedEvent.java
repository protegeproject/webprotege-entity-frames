package edu.stanford.protege.webprotege.frame;


import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLDatatype;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
public record DatatypeFrameChangedEvent(ProjectId projectId,
                                        UserId userId,
                                        OWLDatatype entity) implements EntityFrameChangedEvent<OWLDatatype> {

    @Override
    public String getChannel() {
        return "webprotege.frames.events.DatatypeFrameChanged";
    }
}
