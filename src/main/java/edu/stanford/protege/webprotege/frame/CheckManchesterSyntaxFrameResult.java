package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
@JsonTypeName("CheckManchesterSyntax")
public record CheckManchesterSyntaxFrameResult(@Nullable ManchesterSyntaxFrameParseResult result,
                                               @Nullable ManchesterSyntaxFrameParseError error) implements Response {

    public Optional<ManchesterSyntaxFrameParseError> getError() {
        return Optional.ofNullable(error);
    }

    public static CheckManchesterSyntaxFrameResult create(ManchesterSyntaxFrameParseResult result) {
        return new CheckManchesterSyntaxFrameResult(result, null);
    }

    public static CheckManchesterSyntaxFrameResult create(ManchesterSyntaxFrameParseError error) {
        return new CheckManchesterSyntaxFrameResult(null, error);
    }
}
