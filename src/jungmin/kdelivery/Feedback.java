package jungmin.kdelivery;

public class Feedback {
  private String customerName;
  private String shopName;
  private String foodName;
  private int grade;

  /**
   * @Feedback() : 정보를 저장합니다
   */

  public Feedback(String customerName, String shopName, String foodName, int grade) {
    this.customerName = customerName;
    this.shopName = shopName;
    this.foodName = foodName;
    this.grade = grade;
  }

  public String getCustomerName() {
    return customerName;
  }

  public String getShopName() {
    return shopName;
  }

  public String getFoodName() {
    return foodName;
  }

  public int getGrade() {
    return grade;
  }

  /**
   * @getStars() : 사용자가 입력한 점수가 별점(★★★★★)으로 전환'
   */
  public static int getStars(int number) {
    if (number == 1) {
      System.out.println("★");
    } else if (number == 2) {
      System.out.println("★★");
    } else if (number == 3) {
      System.out.println("★★★");
    } else if (number == 4) {
      System.out.println("★★★★");
    } else if (number == 5) {
      System.out.println("★★★★★");
    } else {
      System.out.println("잘못된 별점입니다. 다시 입력해 주세요.");
    }
    return number;
  }
  /**
   * @printInfo() : 출력
   */
//  public void printInfo() {
//  }
}
