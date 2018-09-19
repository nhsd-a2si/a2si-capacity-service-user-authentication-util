package net.nhs.a2si.cd.auth;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void alphabet()
    {
        assertThat(App.ALPHABET, is("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertSame(App.ALPHABET.charAt(0), 'A');
        assertSame(App.ALPHABET.charAt(25), 'Z');
    }

    @Test
    public void zeroBasedRandomNumber(){
        for(int i = 0; i <= 100; i++) {
            assertThat(App.zeroBasedRandomNumber(0), is(0));
            assertThat(App.zeroBasedRandomNumber(2), anyOf(is(0), is(1), is(2)));
        }
    }

    @Test
    public void randomStringWithFixedSize(){
        for(int i = 0; i <= 100; i++) {
            assertThat(App.randomStringWithFixedSizeOf(40).length(), is(40));
        }
    }

    @Test
    public void enumByNumber(){
        for(int i = 0; i <= 100; i++){
            assertThat(App.Type.random(), anyOf(is(App.Type.NUMBER), is(App.Type.UPPER_LETTER), is(App.Type.LOWER_LETTER)));
        }
    }

}
