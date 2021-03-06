package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.events.frames.NamedIndividualFrameChanged")
public record NamedIndividualFrameChangedEvent(EventId eventId,
                                               ProjectId projectId,
                                               UserId userId,
                                               OWLNamedIndividual entity) implements EntityFrameChangedEvent<OWLNamedIndividual> {

    public static final String CHANNEL = "webprotege.events.frames.NamedIndividualFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
