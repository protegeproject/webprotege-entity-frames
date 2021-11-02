package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("webprotege.frames.UpdateClassFrame")
public record UpdateClassFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                     @JsonProperty("from") PlainClassFrame from,
                                     @JsonProperty("to") PlainClassFrame to) implements ProjectRequest<UpdateClassFrameResult>, UpdateFrame {

    public static final String CHANNEL = "webprotege.frames.UpdateClassFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
