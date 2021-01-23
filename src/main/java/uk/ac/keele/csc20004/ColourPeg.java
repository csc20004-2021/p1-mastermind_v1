/* ***********************
 * CSC-20004 PRACTICAL 1 *
 * Date: 3 Feb 2021      *
 * ***********************/
package uk.ac.keele.csc20004;

/** The class representing the coloured peg used to play Mastermind
 *
 * @author Marco Ortolani
 */
public class ColourPeg {
    /** Constant defining colour red */
    public static final int RED     = 0;
    /** Constant defining colour yellow */
    public static final int YELLOW  = 1;
    /** Constant defining colour blue */
    public static final int BLUE    = 2;
    /** Constant defining colour orange */
    public static final int ORANGE  = 3;
    /** Constant defining colour green */
    public static final int GREEN   = 4;
    /** Constant defining colour purple */
    public static final int PURPLE  = 5;
    /** Constant reserved to signal invalid colour */
    public static final int INVALID = -1;

    /* a peg should not be able to change colour, once created;
       hence the final keyword
    */
    private final int colour;

    /** Constructor initialising the peg to one of the possible colours by its
     *  code.
     *  Note: no check is performed on the parameter.
     *
     * @param theColour the integer used as a colour code for initialisation.
     * This should be one of the constants defined above
     * @see ColourPeg#RED
     */
    public ColourPeg(int theColour) {
        colour = theColour;
    }

    /** Constructor initialising the peg to one of the possible colours by a
     *  char representing the initial of the colour.
     *
     * @param initial the char corresponding to the initial of the noun for the colour
     */
    public ColourPeg(char initial) {
        switch (initial) {
            case 'R':
            case 'r':
                colour = RED;
                break;
            case 'Y':
            case 'y':
                colour = YELLOW;
                break;
            case 'B':
            case 'b':
                colour = BLUE;
                break;
            case 'O':
            case 'o':
                colour = ORANGE;
                break;
            case 'G':
            case 'g':
                colour = GREEN;
                break;
            case 'P':
            case 'p':
                colour = PURPLE;
                break;
            default:
                System.out.println("CodePeg(char initial): colour = INVALID");
                colour = INVALID;
        }
    }

    /**
     * @return the number of defined colours
     */
    public static int getNumberOfColours() {
        return 6;
    }

    /** A 'getter' method for the integer code for the colour.
     *  Note: is it a good idea to return an internal coding of the colour?
     *
     * @see #RED
     * @return the integer representing the internal code for the colour.
     */
    public int getColour() {
        return colour;
    }

    /** Overridden equals() method to check if two pegs are of the same colour.
     *
     * @param o a generic Object to check against
     * @return false, whenever the object to compare against is not an instance
     * of {@link ColourPeg} class; true if it is AND the colours match
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ColourPeg) {
            return colour == ((ColourPeg)o).colour;
        } else
            return false;
    }

    /** Produces a printable version of the peg (a string for its colour)
     *
     * @return a 1-char string identifying the colour name
     */
    @Override
    public String toString() {
        switch (colour) {
            case RED:
                return "R";
            case YELLOW:
                return "Y";
            case BLUE:
                return "B";
            case ORANGE:
                return "O";
            case GREEN:
                return "G";
            case PURPLE:
                return "P";
            default:
                return null;
        }

    }

}
