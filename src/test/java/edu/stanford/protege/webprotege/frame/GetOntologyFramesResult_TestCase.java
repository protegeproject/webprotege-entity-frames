
package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetOntologyFramesResult_TestCase {

    private GetOntologyFramesResult result;

    @Mock
    private ImmutableList ontologyFrames;

    @BeforeEach
    public void setUp()
        throws Exception
    {
        result = new GetOntologyFramesResult(ontologyFrames);
    }

    @Test
    public void shouldReturnSupplied_ontologyFrames() {
        MatcherAssert.assertThat(result.frames(), Matchers.is(this.ontologyFrames));
    }

    @Test
    public void shouldBeEqualToSelf() {
        MatcherAssert.assertThat(result, Matchers.is(result));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        MatcherAssert.assertThat(result.equals(null), Matchers.is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        MatcherAssert.assertThat(result, Matchers.is(new GetOntologyFramesResult(ontologyFrames)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_ontologyFrames() {
        MatcherAssert.assertThat(result, Matchers.is(Matchers.not(new GetOntologyFramesResult(Mockito.mock(ImmutableList.class)))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        MatcherAssert.assertThat(result.hashCode(), Matchers.is(new GetOntologyFramesResult(ontologyFrames).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        MatcherAssert.assertThat(result.toString(), Matchers.startsWith("GetOntologyFramesResult"));
    }

}
