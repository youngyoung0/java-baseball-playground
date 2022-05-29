package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.Array;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void contains(){
        String str = "1,2";

        String[] array = str.split(",");
        assertThat(array).contains("1","2");

    }

    @Test
    void isEqualTo(){
        String str = "(1,2)";
        str = str.substring(1, str.length());
        str = str.substring(0, str.length() -1);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    void containsExactly(){
        String str = "1,2";

        String[] array = str.split(",");
        assertThat(array).containsExactly("1","2");
    }

    @DisplayName("set 사이즈를 확인하는 테스트 코드입니다.")
    @Test
    void setSeizeConfirm(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("set안에 1,2,3값이 있는지 확인")
    @Test
    void setContains(){
        assertThat(numbers.contains(1));
        assertThat(numbers.contains(2));
        assertThat(numbers.contains(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setNumbersParameterizedTest(int input){
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void csvSourceTest(int input, boolean expected){
        assertEquals(numbers.contains(input),expected);
    }
}
