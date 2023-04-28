package view;

import Util.Print;
import controller.EnhancementController;
import model.*;

import java.util.Scanner;

public class GameUI {
  public static void main(String[] args) {
    /*스캐너*/
    Scanner scanner = new Scanner(System.in);

    /*게임시작*/
    Print.gameStart();

    /*입력값*/
    int choice = scanner.nextInt();
    
    Weapon weapon = null;
    
    //TODO:Weapon 객체를 생성하고, 선택한 무기에 따라 weapon 변수에 할당하고, 올바르지 않은 입력이라면 게임을 종료시키세요.
    switch (choice) {
    	case 1:
    		weapon = new Bow();
    		break;
    	case 2:
    		weapon = new Mace();
    		break;
    	case 3:
    		weapon = new Staff();
    		break;
    	case 4:
    		weapon = new Sword();
    		break;
    	default:
    		System.out.println("종료");
    		
    }
    
    //TODO:컨트롤러 객체를 생성하세요.
    EnhancementController enhancementController = new EnhancementController();


    /*게임 강화 코드*/
    while (!weapon.isBroken()) {
      System.out.println("무기를 강화하시겠습니까? (yes/no)");
      String response = scanner.next();
      if (response.equalsIgnoreCase("yes")) {

        //TODO:컨트롤러 객체를 이용해 무기를 강화하는 메소드를 호출하고, 무기 변수를 파라미터로 전달하세요.
    	  enhancementController.enhanceWeapon(weapon);

      } else {
        System.out.println(
            "게임을 종료합니다. 무기 최종 스텟\n강화단계 : "
                + weapon.getEnhancementLevel()
                + "\n무기 공격력 :  "
                + weapon.getAttackPower());
        break;
      }
    }
  }
}
