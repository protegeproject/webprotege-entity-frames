package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("webprotege.frames.UpdateClassFrame")
public record UpdateClassFrameAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                     @JsonProperty("projectId") ProjectId projectId,
                                     @JsonProperty("from") PlainClassFrame from,
                                     @JsonProperty("to") PlainClassFrame to) implements ProjectRequest<UpdateClassFrameResult>, UpdateFrame, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.frames.UpdateClassFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
