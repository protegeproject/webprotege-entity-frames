package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.events.frames.ClassFrameChanged")
public record ClassFrameChangedEvent(EventId eventId,
                                     ProjectId projectId,
                                     UserId userId,
                                     OWLClass entity) implements EntityFrameChangedEvent<OWLClass> {

    public static final String CHANNEL = "webprotege.events.frames.ClassFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
