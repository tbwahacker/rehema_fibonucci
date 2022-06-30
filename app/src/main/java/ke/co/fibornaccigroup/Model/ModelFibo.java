package ke.co.fibornaccigroup.Model;
import java.math.BigInteger;

public class ModelFibo {
    private int position;
    private BigInteger fibonumber;


    public int getPosition() {
        return position;
    }

    void setPosition(int position) {
        this.position = position;
    }

    public BigInteger getFibonumber() {
        return fibonumber;
    }

    void setFibonumber(BigInteger fibonumber) {
        this.fibonumber = fibonumber;
    }


}