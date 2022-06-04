package study;

import baseball.BallStatus;
import baseball.ReBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReBaseBallTest {
    private ReBall com;

    @BeforeEach
    void setup(){
        com = new ReBall(1,4);
    }

    @Test
    void strike(){
        BallStatus status = com.play(new ReBall(1,4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        BallStatus status = com.play(new ReBall(2,4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        BallStatus status = com.play(new ReBall(2,5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
