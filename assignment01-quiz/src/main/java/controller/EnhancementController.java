package controller;

import model.Weapon;

public class EnhancementController {

  // TODO:Weapon객체를 파라미터로 전달받으세요.
  public void enhanceWeapon(Weapon weapon) {

    // TODO:파라미터로 받은 Weapon 클래스의 enhance 메소드가 호출되게 하세요.
	  //weapon.enhance();

    // TODO: 이때, 적절한 예외처리 방법을 통해, 예외 발생시 실행이 중단되고 해당 예외를 처리하는 코드를 작성하세요.
	  try {
		  weapon.enhance();
	  }catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
  }
}
