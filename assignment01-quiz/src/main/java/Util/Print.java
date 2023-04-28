package Util;

public class Print {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";

  public static void gameStart() {
    System.out.println(ANSI_BLUE + "#################################");
    System.out.println(
        ANSI_BLUE + "#  " + ANSI_YELLOW + "무기 강화 게임에 오신것을 환영합니다." + ANSI_BLUE + "  #");
    System.out.println(ANSI_BLUE + "#################################" + ANSI_RESET);
    System.out.println(ANSI_PURPLE + "강화할 무기를 선택하세요.");
    System.out.println("1. 활\n2. 스태프\n3. 검\n4. 둔기");
    System.out.println("번호 입력 : " + ANSI_RESET);
  }

  public static void printSuccess(String message) {
    System.out.println(ANSI_GREEN + "==========================================");
    System.out.println(message);
    System.out.println("==========================================" + ANSI_RESET);
  }

  public static void printFailure(String message) {
    System.out.println(ANSI_RED + "==========================================");
    System.out.println("   " + message);
    System.out.println("==========================================" + ANSI_RESET);
  }

  public static void printGameOver() {
    System.out.println(
        ANSI_RED
            + "  ____                        ___                 \n"
            + " / ___| __ _ _ __ ___   ___  / _ \\__   _____ _ __ \n"
            + "| |  _ / _` | '_ ` _ \\ / _ \\| | | \\ \\ / / _ \\ '__|\n"
            + "| |_| | (_| | | | | | |  __/| |_| |\\ V /  __/ |   \n"
            + " \\____|\\__,_|_| |_| |_|\\___| \\___/  \\_/ \\___|_|   \n"
            + "                                                  \n"
            + "                                                  "
            + ANSI_RESET);
  }
}
