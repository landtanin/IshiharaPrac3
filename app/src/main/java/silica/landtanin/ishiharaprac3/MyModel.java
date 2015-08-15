package silica.landtanin.ishiharaprac3;

/**
 * Created by landtanin on 8/15/15 AD.
 */
public class MyModel {

    //Explicit
    private int ModelAnInt;

    //create interface class
    public interface OnMyModelChangeListener {
        void onMyModelChangeListener(MyModel myModel);//abstract method, MyModel is class and myModel is new variable


    }//interface class

    private OnMyModelChangeListener onMyModelChangeListener;//onMyModelChangeListener is field

    public void setOnMyModelChangeListener(OnMyModelChangeListener onMyModelChangeListener) {
        this.onMyModelChangeListener = onMyModelChangeListener;
    }//setter of interface


    public int getModelAnInt() {
        return ModelAnInt;
    }//getter for interface


    public void setModelAnInt(int modelAnInt) {
        ModelAnInt = modelAnInt;

        //initial point of interface, interface will activate automatically
        if (this.onMyModelChangeListener != null) {

            this.onMyModelChangeListener.onMyModelChangeListener(this);
        }

    }//setter for controller
}//My Model Class
