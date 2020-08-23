package RoomDisplay;

import RoomDisplay.Symbols.RoomSymbol;
/*@Kaylene
*06/02/2020
*abstract class that represents the 2D visual of the Room
*Holds a symbol based on items in room
*/
public abstract class Room2DDisplay {

    private RoomSymbol symbol;

    public void setRoomSymbol(RoomSymbol symbol) {
        if(symbol == null) {
            throw new IllegalArgumentException("Symbol is null");
        }
        this.symbol = symbol;
    }

    public RoomSymbol getSymbol() {
        return this.symbol;
    }

}
