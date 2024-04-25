package jungmin.ref.v2;

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



  /**
   * @getStars() : 사용자가 입력한 점수가 별점(★★★★★)으로 전환'
   */
  public String getGrade() {
    String star = "";
    for (int i = 0; i < this.grade; i++) {
      star += "★";
    }
    return star;
  }

  /**
   * @printInfo() : 출력
   */
  public void printInfo() {
    System.out.println(this.customerName + " [고객님]");
    System.out.println("-".repeat(35));
    System.out.println("주문 매장 : " + this.shopName);
    System.out.println("주문 메뉴 : " + this.foodName);
    System.out.println("별점 : " + getGrade());
  }
}
