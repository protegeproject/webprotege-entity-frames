package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */


@JsonTypeName("webprotege.frames.UpdateObjectPropertyFrame")
public record UpdateObjectPropertyFrameAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                              @JsonProperty("projectId") ProjectId projectId,
                                              @JsonProperty("from") PlainObjectPropertyFrame from,
                                              @JsonProperty("to") PlainObjectPropertyFrame to) implements ProjectRequest<UpdateObjectPropertyFrameResult>, UpdateFrame, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.frames.UpdateObjectPropertyFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}