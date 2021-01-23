/* ***********************
 * CSC-20004 PRACTICAL 1 *
 * Date: 3 Feb 2021      *
 * ***********************/
package uk.ac.keele.csc20004;

import java.util.Scanner;

/** The main class, implementing a round of the Mastermind board game
 * (see the <a href="https://en.wikipedia.org/wiki/Mastermind_(board_game)">Wikipedia page</a> for the basic rules)
 *
 * @author Marco Ortolani
 */
public class MasterMind {
  /** This is the standard main() method, which basically creates a
   *  master code (the code to be guessed), repeatedly asks the
   *  user to guess the code and prints out the "score" until the
   *  correct guess is entered.
   *
   * @param args the command line arguments (not used in this example)
   */
    public static void main(String[] args) {
        ColourCode masterCode = new ColourCode();
        System.out.println("Master code generated.");

        // Only for debugging purposes, we are showing the hidden code
        System.out.println("Master code: " + masterCode);

        Scanner scanner = new Scanner(System.in);

        int result = 0;
        while(result != 44) {
            System.out.print("Enter code: ");
            ColourCode inputCode = new ColourCode(scanner.next());
            result = inputCode.compareTo(masterCode);
            System.out.println("C:" + (result/10) + "  P:" + (result - ((result/10)*10)));
        }

    }
}
