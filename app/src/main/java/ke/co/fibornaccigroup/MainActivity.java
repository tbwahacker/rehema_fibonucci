package ke.co.fibornaccigroup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import ke.co.fibornaccigroup.Adapter.FiboAdapter;
import ke.co.fibornaccigroup.Interface.IFibo;
import ke.co.fibornaccigroup.Model.ModelFibo;
import ke.co.fibornaccigroup.Presenter.FiboListPresenter;

public class MainActivity extends AppCompatActivity implements IFibo.View {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    EditText index_et;
    Button Action_btn;
    private FiboListPresenter fiboListPresenter;
    private ProgressBar pbLoad;
    private List<ModelFibo> fiboList;
    private List<ModelFibo> filteredDataList;
    private FiboAdapter fiboAdapter;
    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            filteredDataList = fiboListPresenter.validateInput(s.toString(), fiboList);
            fiboAdapter.setFilter(filteredDataList);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        fiboListPresenter = new FiboListPresenter(this);
        fiboListPresenter.requestDataFromUser();

    }

    private void initUI() {
        fiboList = new ArrayList<>();
        pbLoad = findViewById(R.id.pb_load); //progressbar
        Action_btn = findViewById(R.id.button);
        Action_btn.setVisibility(View.GONE);
        index_et = findViewById(R.id.index); //edittext
        index_et.addTextChangedListener(watcher);
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager recyce = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(recyce);
        fiboAdapter = new FiboAdapter(this, fiboList);
        recyclerView.setAdapter(fiboAdapter);
    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pbLoad.setVisibility(View.GONE);

    }

    @Override
    public void setDataToRecyclerView(List<ModelFibo> fiboArrayList) {
        fiboList.clear();
        fiboList.addAll(fiboArrayList);
        fiboAdapter.notifyDataSetChanged();
    }


    @Override
    public void CheckValidation(List<ModelFibo> list) {
        if (list.size() == 0) {
            Snackbar.make(Action_btn, getString(R.string.position_error), Snackbar.LENGTH_LONG)
                    .show();
            index_et.setText("");
            index_et.setHint(getString(R.string.enter_postion));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fiboListPresenter.onDestroy();
    }


}