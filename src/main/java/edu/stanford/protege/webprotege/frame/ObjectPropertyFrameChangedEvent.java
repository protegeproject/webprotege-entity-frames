package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLObjectProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("webprotege.frames.events.ObjectPropertyFrameChanged")
public record ObjectPropertyFrameChangedEvent(ProjectId projectId,
                                              UserId userId,
                                              OWLObjectProperty entity) implements EntityFrameChangedEvent<OWLObjectProperty> {

    public static final String CHANNEL = "webprotege.frames.events.ObjectPropertyFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
