package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.EventId;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLDatatype;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.events.frames.DatatypeFrameChanged")
public record DatatypeFrameChangedEvent(EventId eventId,
                                        ProjectId projectId,
                                        UserId userId,
                                        OWLDatatype entity) implements EntityFrameChangedEvent<OWLDatatype> {

    public static final String CHANNEL = "webprotege.events.frames.DatatypeFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
