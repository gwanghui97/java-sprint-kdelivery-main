package jungmin.ref.v3;

import java.util.*;

public class Shop {
  /**
   * 등록 가능한 음식 수, 음식 초기화 변수, 가격 필드 생성
   * 매장명, 메뉴명, 가격 필드 생성
   * */
//  private static final int FOOD_MAX = 5;
//  private static final String EMPTY_FOOD = "";
//  private static final int EMPTY_PRICE = 0;
  private String shopName;
  private String[] foodNames;
  private int[] prices;
  private Map<String, Integer> menus = new HashMap<>();

  /**
   * @Shop() : 생성자 정의
   * 매장만 먼저 입력받도록 합니다.
   * 나머지 변수는 initValues() 에서 정의합니다.
   * */

  // getter 임시로 체크용
  public String getShopName() {
    return shopName;
  }

  public Shop(Map<String, Integer> menus) {
    this.menus = menus;
  }


  /**
   * @addFood() : 위 코드에서 정의된 변수를 받아 출력과 객체에 저장합니다.
   */
  public boolean addFood(String foodName, int price) {
    // 메뉴를 추가하는 역할
    // 자기 자신(객체)에게 추가해야 함
    // 기존에는 중복도 거르고, NULL 혹은 비어있는 가장 앞의 인덱스를 찾아서 저장해야 했으나,
    // 맵을 사용하면 그런걸 고려할 필요 X
    // 중복은 맵에서 키는 중복 허용이 안되고,
    // 크기가 고정되어 있지 않기 때문에 전부 다 무시해도 됨
    if (menus.containsKey(foodName)) {
      return false;
    } else {
      menus.put(foodName, price);
      return true;
    }
  }

  public boolean isExistMenu(String foodName) {
    return menus.containsKey(foodName);
  }
}
