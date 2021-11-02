package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

@JsonTypeName("webprotege.frames.UpdateClassFrame")
public record UpdateClassFrameResult(ClassFrame updatedFrame) implements Response {

}
