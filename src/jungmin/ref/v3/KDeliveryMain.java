package jungmin.ref.v3;

import jungmin.kdelivery.Feedback;
import jungmin.kdelivery.Order;
import jungmin.kdelivery.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

  public KDeliveryMain() {
    this.s = new Scanner(System.in);
    initValue();
  }

  /**
   * @KDeliveryMainV1() : 매장 정보, 주문 정보, 리뷰 정보 초기화
   * initValues() 메서드 사용
   * */

  /**
   * @initValues() : 객체에 저장될 수 있는 크기 지정
   * SHOP_MAX, ORDER_MAX, FEEDBACK_MAX = 5
   * */
  private void initValue() {
    this.shops = new Shop[SHOP_MAX];
    this.orders = new Order[ORDER_MAX];
    this.feedbacks = new Feedback[FEEDBACK_MAX];
  }


  /**
   * @close() : 프로그램 종료를 위해 사용되는 메서드
   * 사용자가 종료를 선언하면 동작합니다.
   * main()에서 활용됩니다.
   * */
  public void close() {
    s.close();
  }

  /**
   * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
   * */
  public int selectMainMenu() {
    System.out.println("[치킨의 민족 프로그램 V1]");
    System.out.println("-".repeat(35));
    System.out.println("1) [사장님 용] 음식점 등록하기");
    System.out.println("2) [고객님과 사장님 용] 음식점 별점 조회하기");
    System.out.println("3) [고객님 용] 음식 주문하기");
    System.out.println("4) [고객님 용] 별점 등록하기");
    System.out.println("5) 프로그램 종료하기");
    System.out.println("-".repeat(35));
    System.out.println("[시스템] 무엇을 도와드릴까요?");

    String choiceNumber = s.nextLine();
    int choice = 6;
    if (!isValidNumber(choiceNumber)) {
      System.out.println("[시스템] 숫자만 입력해야 합니다.");
    } else {
      choice = Integer.parseInt(choiceNumber);
    }
    return Integer.parseInt(s.nextLine());
  }

  /**
   * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
   * @shops   : 가게 정보를 저장합니다.
   * @shopIdx : 가게 정보의 인덱스
   * */
  public void selectAddShopMenu() {
    System.out.println("[안내] 반갑습니다, 가맹주님!");
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.print(">>>");
    // 입력
    String shopName = s.nextLine();
    System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
    System.out.print(">>>");
    // 입력
    String foodName = s.nextLine();
    System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
    System.out.print(">>>");
    // 입력
    String priceStr = s.nextLine();
    int price;
    if (isValidNumber(priceStr)) {
      price = Integer.parseInt(priceStr);
    } else {
      System.out.println("[시스템] 숫자만 입력해야 합니다.");
      return;
    }

    /**
     * @Shop.java 의 Shop 클래스를 활용한 객체 생성
     * @public 클래스 : 동일 패키지 및 다른 패키지에서 사용가능
     * @addFood() : Shop.java 의 Shop 클래스의 addFood() 메서드
     * 해당 메서드는 매장명, 음식명, 가격을 입력받아 객체에 저장
     * 값이 저장될 때 마다 shopIdx 값 증가
     */
    Shop shop = new Shop(shopName);

    shop.addFood(foodName, price);
      int shopIndex = getShopIndex(shops, shopName);

      if (shopIndex != -1) {
        Shop existShop = shops.get(shopIndex);
        if(!shops.get(shopIndex).addFood(foodName, price)) {
          System.out.println("[시스템] 동일한 이름의 메뉴를 추가할 수 없습니다.");
        }
      } else {
        Shop shop = new Shop(shopName);
        shop.addFood(foodName, price);
        shops.add(shop);
      }
      System.out.printf("[안내] %s에 음식(%s, %d) 추가되었습니다.", shopName, foodName, price);
      System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");

  }

  /**
   * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
   * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
   * */
  public void selectDashboardMenu() {
    if (feedbacks.length == 0) {
      System.out.println("[시스템] 현재 등록된 평가가 없습니다.");
    }
    for (Feedback feedback : feedbacks) {
      feedback.printInfo();
    }
  }


  /**
   * @selectOrderMenu() : 주문 기능
   * 사용자의 입력을 받아 orders 객체에 저장
   * */
  public void selectOrderMenu() {
    System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
    System.out.println("[안내] 주문자 이름을 알려주세요!");
    System.out.println(">>>");
    // 사용자 이름 입력
    String customerName = s.nextLine();

    System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    // 음식점 이름 입력
    String shopName = s.nextLine();

    System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
    System.out.println(">>>");
    // 메뉴 이름 입력
    String foodName = s.nextLine();

    int currentIndex = isValidIndex(orders);

    if (currentIndex != -1) {
      // shopName이 실제로 존재하는지 확인
      // else 라면 아예 주문 자체가 불가능
      int shopIndex = getShopIndex(shops, shopName);
      
      if (getShopIndex(shops, isValidIndex(shops), shopName) != -1) {
        // 이제는 상점은 찾았으니, 메뉴가 있는지 검증해야 합니다.
        Order order = new Order(customerName, shopName, foodName);
        orders.add(order);
      } else {
        System.out.println("[시스템] 정확한 가게 이름을 입력해 주세요.");
        return;
      }
      System.out.printf("[안내] %s님!", customerName);
      System.out.printf("[안내] %s 매장에 %s 주문이 완료되었습니다.", shopName, customerName);
    } else {
      System.out.println("[시스템] 해당 점포가 존재하지 않습니다.");
    }
  }

  /**
   * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
   * */
  public void selectFeedbackMenu() {
    System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
    System.out.println("[안내] 주문자 이름은 무엇인가요?");
    System.out.println(">>>");
    // 주문자 이름 입력
    String customerName = s.nextLine();

    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    // 음식점 이름 입력
    String shopName = s.nextLine();

    System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
    System.out.println(">>>");
    // 메뉴 이름 입력
    String foodName = s.nextLine();

    boolean isChecked = false;
    for (Order order : orders) {
      if (order.isExistOrder(customerName, shopName, foodName)) {
        //일치하는 영수증이 있을 경우
        isChecked = true;
      }
    }

    if(!isChecked) {
      System.out.println("[시스템] 주문을 다시 확인해주세요.");
      return;
    }

    System.out.println("[안내] 음식 맛은 어떠셨나요? (1점 ~ 5점)");
    System.out.println(">>>");

    // 별점 입력
    int grade = Integer.parseInt(s.nextLine());

    Feedback feedback = new Feedback(customerName, shopName, foodName, grade);
    feedback.add(feedback);

    int currentIndex = isValidIndex(feedbacks);

    if (currentIndex != -1) {
      feedbacks[currentIndex] = feedback;
      System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
    } else {
      System.out.println("더 이상 리뷰를 등록할 수 없습니다.");
    }

  }

  public static void main(String[] args) {
    KDeliveryMain kDeliveryMain = new KDeliveryMain();
    int count = 5;
    do {
      count = kDeliveryMain.selectMainMenu();
      switch (count) {
        case 1: kDeliveryMain.selectAddShopMenu();
                break;
        case 2: kDeliveryMain.selectDashboardMenu();
                break;
        case 3: kDeliveryMain.selectOrderMenu();
                break;
        case 4: kDeliveryMain.selectFeedbackMenu();
                break;
        case 5: {
          System.out.println("아래는 상점 목록입니다.");
          System.out.println(Arrays.toString(kDeliveryMain.shops));
          for (Shop shop : kDeliveryMain.shops) {

          }
        }
      }
    } while(count != 5);

    kDeliveryMain.close();
    System.out.println("[안내] 이용해 주셔서 감사합니다.");

  }

  public int isValidIndex(Object[] arr) {
    int currentIdx = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) {
        return i;
      }
    }
    return currentIdx;
  }

  public int getShopIndex(ArrayList<Shop> shopList, String shopName) {
    int currentIdx = -1;
    for (int i = 0; i < shopList.size(); i++) {
      if (shopList.get(i).getShopName().equals(shopName)) {
        return i;
      }
    }
    return currentIdx;
  }
  
  public boolean isValidNumber(String str) {
    if (str.isEmpty()) return false;
    char[] arr = str.toCharArray();
    String table = "0123456789";

    for (int i = 0; i < arr.length; i++) {
      if (table.indexOf(arr[i]) == -1) return false;
    }
    return true;
  }
}