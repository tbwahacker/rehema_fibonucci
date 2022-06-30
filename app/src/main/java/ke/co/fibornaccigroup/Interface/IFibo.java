package ke.co.fibornaccigroup.Interface;

import java.util.List;

import ke.co.fibornaccigroup.Model.ModelFibo;

public interface IFibo {
    interface Model {

        void getFiboList(OnFinishedListener onFinishedListener);  //creates list of fibonacci elements 0>n<=1000

        List<ModelFibo> validateInput(String s, List<ModelFibo> list); //optimizes list on the basis of user input

        interface OnFinishedListener {
            void onFinished(List<ModelFibo> fiboArrayList); //returns list of fibonacci elements once all elements added

            void onFailure(Throwable t); //chceks if views are null
        }


    }

    interface View {

        void showProgress(); //shows progress bar on the screen

        void hideProgress();//hides progress bar on the screen

        void setDataToRecyclerView(List<ModelFibo> fiboArrayList); // sets list data to recyclerview

        void CheckValidation(List<ModelFibo> list); //validates  user input to display elements

    }

    interface Presenter {

        void onDestroy(); //

        void getMoreData();

        void requestDataFromUser(); // logic which implement getfibolist()


    }

}