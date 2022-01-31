package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLDatatype;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.frames.events.DatatypeFrameChanged")
public record DatatypeFrameChangedEvent(ProjectId projectId,
                                        UserId userId,
                                        OWLDatatype entity) implements EntityFrameChangedEvent<OWLDatatype> {

    public static final String CHANNEL = "webprotege.frames.events.DatatypeFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
