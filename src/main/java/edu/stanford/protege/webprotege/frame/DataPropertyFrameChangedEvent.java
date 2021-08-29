package edu.stanford.protege.webprotege.frame;


import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 18/12/2012
 */
@JsonTypeName("DataPropertyFrameChangedEvent")
public record DataPropertyFrameChangedEvent(ProjectId projectId,
                                            UserId userId,
                                            OWLDataProperty entity) implements EntityFrameChangedEvent<OWLDataProperty> {

    public static final String CHANNEL = "webprotege.frames.events.DataPropertyFrameChanged";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
