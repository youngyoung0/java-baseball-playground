package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class baseBallTest {

    @Test
    @DisplayName("랜덤 숫자 구하는 테스트")
    void random() {
        int max = 111;
        int min = 999;
        System.out.println((int) (Math.random() * (max - min + 1) + min));
    }

    @Test
    @DisplayName("자리수 맞는 확인하는 코드")
    void positionCheck(){
        String[] result = {"1", "3", "2"};
        int number = 123;
        String str= Integer.toString(number);
        String[] values = str.split("");

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i].equals(result[i])){
                strike ++;
                continue;
            }
            ball += ballCheck(values[i], result);
        }
        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);
    }

    private int ballCheck(String value, String[] result) {
        for(int j = 0; j < result.length; j++){
            if(result[j].equals(value)){
                return 1;
            }
        }
        return 0;
    }
}
