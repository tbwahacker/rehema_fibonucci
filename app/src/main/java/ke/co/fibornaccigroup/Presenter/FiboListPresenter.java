package ke.co.fibornaccigroup.Presenter;

import java.util.List;

import ke.co.fibornaccigroup.Interface.IFibo;
import ke.co.fibornaccigroup.Model.ModelFibo;
import ke.co.fibornaccigroup.Model.ModelFiboList;

public class FiboListPresenter implements IFibo.Presenter, IFibo.Model.OnFinishedListener {
    private IFibo.View fibolistView;

    private IFibo.Model fibolListModel;

    public FiboListPresenter(IFibo.View dealistView) {
        this.fibolistView = dealistView;
        fibolListModel = new ModelFiboList();
    }

    public List<ModelFibo> validateInput(String s, List<ModelFibo> list) {
        List<ModelFibo> data;
        fibolistView.showProgress();
        data = fibolListModel.validateInput(s, list);
        fibolistView.CheckValidation(data);
        fibolistView.hideProgress();
        return data;
    }

    @Override
    public void onFinished(List<ModelFibo> fibolist) {
        fibolistView.setDataToRecyclerView(fibolist);
        if (fibolistView != null) {
            fibolistView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (fibolistView != null) {
            fibolistView.hideProgress();
        }
    }

    @Override
    public void getMoreData() {
        if (fibolistView != null) {
            fibolistView.showProgress();
        }
        fibolListModel.getFiboList(this);

    }


    @Override
    public void onDestroy() {
        this.fibolistView = null;

    }

    @Override
    public void requestDataFromUser() {
        if (fibolistView != null) {
            fibolistView.showProgress();
        }
        fibolListModel.getFiboList(this);
    }


}