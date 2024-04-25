package jungmin.ref.v2;

public class Shop {
  /**
   * 등록 가능한 음식 수, 음식 초기화 변수, 가격 필드 생성
   * 매장명, 메뉴명, 가격 필드 생성
   * */
  private static final int FOOD_MAX = 5;
  private static final String EMPTY_FOOD = "";
  private static final int EMPTY_PRICE = 0;
  private String shopName;
  private String[] foodNames;
  private int[] prices;

  /**
   * @Shop() : 생성자 정의
   * 매장만 먼저 입력받도록 합니다.
   * 나머지 변수는 initValues() 에서 정의합니다.
   * */
  public Shop(String shopName) {
    this.shopName = shopName;
    initValues();
  }

  // getter 임시로 체크용
  public String getShopName() {
    return shopName;
  }

  public String[] getFoodNames() {
    return foodNames;
  }

  public int[] getPrices() {
    return prices;
  }

  /**
   * @initValues() : 메뉴명와 가격정보를 담는 배열 생성 및 초기화
   * EMPTY_FOOD = "", EMPTY_PRICE = 0
   */
  //상수에 들어있는 값을 가지고 초기화 , 생성자와 약간 다른 역할
  private void initValues() {
    foodNames = new String[FOOD_MAX];
    prices = new int[FOOD_MAX];

    for (int i = 0; i < foodNames.length; i++) {
      foodNames[i] = EMPTY_FOOD;
    }
  }

  /**
   * @addFood() : 위 코드에서 정의된 변수를 받아 출력과 객체에 저장합니다.
   */
  public void addFood(String foodName, int price) {
    int currentIdx = -1;
    for (int i = 0; i < foodNames.length; i++) {
      if (foodNames[i].equals(foodName)) {
        System.out.println("[시스템] 같은 이름의 상품은 등록할 수 없습니다.");
      } else if (foodNames[i].equals("")) {
        currentIdx = i;
        break;
      }
    }
    if (currentIdx != -1) {
      foodNames[currentIdx] = foodName;
      prices[currentIdx] = price;
    } else {
      // 예외일 경우
    }
  }
}
