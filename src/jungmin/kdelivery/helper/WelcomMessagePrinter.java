package jungmin.kdelivery.helper;

public class WelcomMessagePrinter implements Printer{
    @Override
    public void print() {
        System.out.println("[치킨의 민족 프로그램 V1]");
        System.out.println("-".repeat(35));
        System.out.println("1) [사장님 용] 음식점 등록하기");
        System.out.println("2) [고객님과 사장님 용] 음식점 별점 조회하기");
        System.out.println("3) [고객님 용] 음식 주문하기");
        System.out.println("4) [고객님 용] 별점 등록하기");
        System.out.println("5) 프로그램 종료하기");
        System.out.println("-".repeat(35));
        System.out.println("[시스템] 무엇을 도와드릴까요?");
    }
}
