package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        String first = Console.readLine();

        if (first != null && first.startsWith("//") && first.indexOf('\n') < 0) {
            String second = Console.readLine();
            if (second != null) first = first + "\n" + second;
        }

        BigInteger result = new Calculator().add(first);
        System.out.println("결과 : " + result);
    }
}