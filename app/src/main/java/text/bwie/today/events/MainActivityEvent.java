package text.bwie.today.events;

/**
 * date: 2017/5/12
 * author: 李志强
 * function:
 */

public class MainActivityEvent {
    public boolean white ;

    public MainActivityEvent(boolean white){
        this.white = white;
    }


    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

}
