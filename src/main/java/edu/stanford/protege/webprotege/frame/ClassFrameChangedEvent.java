package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.frames.events.ClassFrameChanged")
public record ClassFrameChangedEvent(ProjectId projectId,
                                     UserId userId,
                                     OWLClass entity) implements EntityFrameChangedEvent<OWLClass> {

    public static final String CHANNEL = "webprotege.frames.events.ClassFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
