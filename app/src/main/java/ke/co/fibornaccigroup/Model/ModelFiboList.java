package ke.co.fibornaccigroup.Model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import ke.co.fibornaccigroup.Interface.IFibo;

public class ModelFiboList implements IFibo.Model {

    @Override
    public void getFiboList(OnFinishedListener onFinishedListener) {
        List<ModelFibo> fibnumberList = new ArrayList<>(); //position 0 will be 0

        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("1");
        BigInteger n3;
        ModelFibo modelFibo = new ModelFibo();

        modelFibo.setPosition(1);
        modelFibo.setFibonumber(n1);
        fibnumberList.add(modelFibo);

        modelFibo = new ModelFibo();

        modelFibo.setPosition(2);
        modelFibo.setFibonumber(n2);
        fibnumberList.add(modelFibo);

        for (int i = 3; i <= 1000; i++) {
        modelFibo = new ModelFibo();

        n3 = n1.add(n2);   //creates fibonacci numbers
        modelFibo.setPosition(i);
        modelFibo.setFibonumber(n3);
        n1 = n2;
        n2 = n3;
        fibnumberList.add(modelFibo);
    }
        onFinishedListener.onFinished(fibnumberList);

    }

    @Override
    public List<ModelFibo> validateInput(String s, List<ModelFibo> list) {
        List<ModelFibo> fibnum = new ArrayList<>();
        String text;
        for (ModelFibo dataFromDataList : list) {
        text = String.valueOf(dataFromDataList.getPosition()); //matches user input
        if (text.contains(s)) {
            fibnum.add(dataFromDataList);
        }

    }
        return fibnum;
    }


}