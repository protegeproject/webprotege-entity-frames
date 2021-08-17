package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 20/03/2014
 */


@JsonTypeName("GetManchesterSyntaxFrameCompletions")
public record GetManchesterSyntaxFrameCompletionsResult(AutoCompletionResult autoCompletionResult) implements Response {

    interface AutoCompletionResult {

    }

}
