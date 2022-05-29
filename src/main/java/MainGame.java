import java.util.Scanner;

public class MainGame {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int randomInt = (int) (Math.random() * (999 - 111) + 111);
        String randomStr = Integer.toString(randomInt);


        while(true){
            int strike = 0;
            int ball = 0;
            System.out.println(randomInt);
            System.out.println("숫자를 입력하세요 : ");
            String input = scanner.next();

            int[] score =positionCheck(randomStr, input, strike, ball);
            gamePrint(score);
            if(score[0]  == 3){
                System.out.println("정답입니다");
                break;
            }
        }
    }

    private static int[] positionCheck(String result, String input, int strike, int ball){
        String[] resultArr = stringBySplit(result);
        String[] inputArr = stringBySplit(input);
        for(int i = 0; i < resultArr.length; i++){
            if(resultArr[i].equals(inputArr[i])){
                strike += 1;
                continue;
            }
            ball += ballCheck(resultArr[i], inputArr);
        }
        int[] score = {strike, ball};
        return score;
    }

    private static String[] stringBySplit(String str){
        return str.split("");
    }

    private static int ballCheck(String value, String[] result){
        for(int j = 0; j < result.length; j++){
            if(result[j].equals(value)){
                return 1;
            }
        }
        return 0;
    }

    private static void gamePrint(int[] score){
        if(score[0] != 0){
            System.out.println(score[0] + " 스트라이크");
        }
        if(score[1] != 0){
            System.out.println(score[1] + " 볼");
        }
        if(score[0] == 0 && score[1] == 0){
            System.out.println("낫띵");
        }
    }
}
