package baseball;

public class ReBall {
    private final int postion;
    private final int ballNo;

    public ReBall(int position, int ballNo) {
        this.postion = position;
        this.ballNo = ballNo;
    }

    public BallStatus play(ReBall reBall) {
        if(this.equals(reBall)){
            return BallStatus.STRIKE;
        }
        if(reBall.matchBallNo(ballNo)){
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo){
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null) return false;
        ReBall reBall = (ReBall) obj;
        return postion == reBall.postion &&
                ballNo == reBall.ballNo;
    }
}
