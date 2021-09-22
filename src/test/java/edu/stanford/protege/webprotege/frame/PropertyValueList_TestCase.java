package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.Lists;

import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15/01/15
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class PropertyValueList_TestCase {


    private PropertyValueList propertyValueList;

    private PropertyValueList otherPropertyValueList;

    private List<PropertyValue> propertyValues;

    @Mock
    private PropertyValue propertyValueA, propertyValueB;

    @BeforeEach
    public void setUp() throws Exception {
        propertyValues = Lists.newArrayList(propertyValueA, propertyValueB);
        propertyValueList = new PropertyValueList(propertyValues);
        otherPropertyValueList = new PropertyValueList(propertyValues);
    }

    @Test
    public void shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new PropertyValueList(null);
        });
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(propertyValueList, is(equalTo(propertyValueList)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(propertyValueList, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(propertyValueList, is(equalTo(otherPropertyValueList)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(propertyValueList.hashCode(), is(otherPropertyValueList.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(propertyValueList.toString(), startsWith("PropertyValueList"));
    }
}