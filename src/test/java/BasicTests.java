import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by armandosanchezmedina on 05/11/2015.
 */
public class BasicTests {
    @Test
    public void shouldGeneratePersonWithPersonalInformation(){
        assertThat(new Person(), CoreMatchers.instanceOf(Person.class));
    }
}
