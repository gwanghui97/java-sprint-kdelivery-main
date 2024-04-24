package jungmin.kdelivery;

import jungmin.kdelivery.helper.DisplayPrinter;
import jungmin.kdelivery.helper.Printer;
import jungmin.kdelivery.helper.WelcomMessagePrinter;

import java.util.Scanner;
import java.util.SequencedCollection;

// 클래스를 정의 합니다.
public class KDeliveryMain {
  /**
   * 음식점 등록 개수, 음식 주문 가능 횟수, 리뷰 등록 가능 횟수 정의
   * */
  private static int SHOP_MAX = 5;
  private static int ORDER_MAX= 5;
  private static int FEEDBACK_MAX = ORDER_MAX;

  /**
   * 배열을 담을 수 있는 객체 생성
   * 사용 범위, 객체 타입, 객체 이름
   */
  private Shop[] shops;
  private Order[] orders;
  private Feedback[] feedbacks;

  // 해당 변수를 제어하는 Idx변수를 정의하고 초기화
  int shopIdx = 0;
  int feedbackIdx = 0;
  int orderIdx = 0;

  private static Scanner s; // 사용자의 입력을 받는 객체 생성

  /**
   * @KDeliveryMainV1() : 매장 정보, 주문 정보, 리뷰 정보 초기화
   * initValues() 메서드 사용
   * */
  public KDeliveryMain() {
    initValues(SHOP_MAX, ORDER_MAX, FEEDBACK_MAX);
    s = new Scanner(System.in);
  }


  /**
   * @initValues() : 객체에 저장될 수 있는 크기 지정
   * SHOP_MAX, ORDER_MAX, FEEDBACK_MAX = 5
   * */
  private void initValues(int SHOP_MAX, int ORDER_MAX, int FEEDBACK_MAX) {
    shops = new Shop[SHOP_MAX];
    orders = new Order[ORDER_MAX];
    feedbacks = new Feedback[FEEDBACK_MAX];
  }

  /**
   * @close() : 프로그램 종료를 위해 사용되는 메서드
   * 사용자가 종료를 선언하면 동작합니다.
   * main()에서 활용됩니다.
   * */
  public static void close() {
    System.out.println("[안내] 이용해주셔서 감사합니다.");
  }

  /**
   * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
   * */
  public static int selectMenu(int number) {

    do {
      switch(number) {
        case 1:
//          Shop shop = new Shop()
//          selectAddShopMenu();
          break;
        case 2:
          System.out.println("XXX [고객님]");
          System.out.println("-".repeat(35));
          System.out.println("주문 매장 : XXX");
          System.out.println("주문 메뉴 : XXX");
          System.out.println("별점 : ★★★★★");
          break;
        case 3:
          System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
          System.out.println("[안내] 주문자 이름을 알려주세요!");
          String orderCustomerName = s.nextLine();
          System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
          String orderShopName = s.nextLine();
          System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
          String menuName = s.nextLine();

          System.out.println("[안내] " + orderCustomerName + "님!");
          System.out.println("[안내] " + orderShopName + "매장에 " + menuName + " 주문이 완료되었습니다.");
          break;
        case 4:
          System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
          System.out.println("[안내] 주문자 이름은 무엇인가요?");
          String customerName = s.nextLine();
          System.out.println("[안내] 음식점 상호는 무엇인가요?");
          String customerToShopName = s.nextLine();
          System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
          String customerFoodName = s.nextLine();

          System.out.println("[안내] 음식 맛은 어떠셨나요? (1점 ~ 5점)");
          String foodFavor = s.nextLine();
          System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
          break;
        case 5:
          close();
          break;
        default:
          wrongMessage();
          break;
      }
    } while(number != 5);
      return number;
  }

  /**
   * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
   * @shops   : 가게 정보를 저장합니다.
   * @shopIdx : 가게 정보의 인덱스
   * */
  public void selectAddShopMenu() {

    /**
     * @Shop.java 의 Shop 클래스를 활용한 객체 생성
     * @public 클래스 : 동일 패키지 및 다른 패키지에서 사용가능
     * @addFood() : Shop.java 의 Shop 클래스의 addFood() 메서드
     * 해당 메서드는 매장명, 음식명, 가격을 입력받아 객체에 저장
     * 값이 저장될 때 마다 shopIdx 값 증가
     */
    System.out.println("[안내] 반갑습니다, 가맹주님!");
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    String shopName = s.nextLine();

    Shop shop = new Shop(shopName);
    System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
    String mainItem = s.nextLine();
    System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
    String foodPrice = s.nextLine();
    System.out.println("[안내] " + shopName + "에 음식(" + mainItem + ", " + foodPrice + ")" +" 추가되었습니다.");
    System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");
  }

  /**
   * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
   * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
   * */
  public void selectDashboardMenu() {
  }


  /**
   * @selectOrderMenu() : 주문 기능
   * 사용자의 입력을 받아 orders 객체에 저장
   * */
  public void selectOrderMenu() {
    Order order = new Order("박코딩", "버거킹", "햄버거");
    order.getFoodName();
  }

  /**
   * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
   * */
  public void selectFeedbackMenu() {
  }

  public static void main(String[] args) {

    // 웰컴 메시지 출력
    welcomeMessage();

    // 메뉴 선택 (1~5)
    int number = 0;
    int selectNum = selectMenu(number);
    // 종료 메시지 출력
    close();
  }

  private static void welcomeMessage() {
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

  private static void wrongMessage() {
    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
  }
}