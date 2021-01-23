/* ***********************
 * CSC-20004 PRACTICAL 1 *
 * Date: 3 Feb 2021      *
 * ***********************/
package uk.ac.keele.csc20004;

import java.util.Random;

/** The class holding the sequence of 4 pegs representing the hidden
 *  colour code, or the guess
 *
 * @author Marco Ortolani
 */
public class ColourCode {
    private ColourPeg[] codePegs = new ColourPeg[4];

    /** Constructor for the ColourCode, using a string for initialisation
     *  (see {@link ColourPeg#RED} for an example of the allowed colours)
     *
     * @param colourString a string of 4 characters, each representing the initial of a colour
     * @see ColourPeg
     */
    public ColourCode(String colourString) {
        if(colourString.length() != 4) {
            System.out.println("Code(String theCode): theCode.length() != 4");
        }

        for(int i=0; i<4; i++) {
            codePegs[i] = new ColourPeg(colourString.charAt(i));
        }
    }

    /** Constructor for the ColourCode, using a random code as initialisation
     *  (typically, for the master code)
     */
    public ColourCode() {
        Random rn = new Random();
        for(int i=0; i<4; i++) {
            codePegs[i] = new ColourPeg(rn.nextInt(6));
        }
    }

    /** Overridden method from Object(), to pretty print this code
     *
     * @return the String representing the sequence of 4 colours
     */
    @Override
    public String toString() {
        String codeString = "";
        for(int i=0; i<4; i++) {
            codeString += codePegs[i].toString();
        }
        return codeString;
    }

    private int[] tally() {
        int[] table = new int[ColourPeg.getNumberOfColours()];

        for(int i=0; i<4; i++) {
            table[codePegs[i].getColour()]++;
        }

        return table;
    }

    private int getColour(int index) {
        return codePegs[index].getColour();
    }


    /** Compares this code to another, passed as argument to check their
     *  similarity according to the rules of mastermind (number of pegs
     *  of the correct colour, even though in wrong position; number
     *  pegs of the correct colour AND position)
     *
     * @param masterCode the code to check against
     * @return a two digit integer; the first digit C indicates how many pegs are
     * of the correct correct colour, regardless of position, while second digit P
     * indicates how many are of the correct colour and in the right place.
     * Clearly,  {@literal C >= P. 0<=C<=4. 0<=P<=4}.
     */
    public int compareTo(ColourCode masterCode) {
        int C = 0;
        int P = 0;
        int[] thisTally = tally();
        int[] masterTally = masterCode.tally();

        int numColours = Math.min(thisTally.length, masterTally.length);

        for(int i=0; i<numColours; i++) {
            C += Math.min(thisTally[i], masterTally[i]);
        }

        for(int i=0; i<4; i++) {
            if(codePegs[i].getColour() == masterCode.getColour(i)) {
                P++;
            }
        }

        return ((C*10) + P);
    }

}
