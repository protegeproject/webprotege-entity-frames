package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

@JsonTypeName("webprotege.frames.UpdateDataPropertyFrame")
public record UpdateDataPropertyFrameResult(DataPropertyFrame updatedFrame) implements Response {

}
