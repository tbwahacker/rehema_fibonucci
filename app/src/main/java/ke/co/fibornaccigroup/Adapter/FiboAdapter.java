package ke.co.fibornaccigroup.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

import ke.co.fibornaccigroup.MainActivity;
import ke.co.fibornaccigroup.Model.ModelFibo;
import ke.co.fibornaccigroup.R;

public class FiboAdapter extends RecyclerView.Adapter<FiboAdapter.MyViewHolder> {
    private List<ModelFibo> fiboList;
    private Context context;


    public FiboAdapter(MainActivity mainActivity, List<ModelFibo> fiboList) {
        this.context = mainActivity;
        this.fiboList = fiboList;

    }

    @NonNull
    @Override
    public FiboAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fibo_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        ModelFibo fibnum = fiboList.get(position);
        holder.position_tv.setText("Position: " + String.valueOf(fibnum.getPosition()));
        holder.fibo_tv.setText(String.valueOf(fibnum.getFibonumber()));
    }

    @Override
    public int getItemCount() {
        return fiboList.size();
    }

    public void setFilter(List<ModelFibo> FilteredDataList) {  //for user input search
        fiboList = FilteredDataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView fibo_tv, position_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            fibo_tv = itemView.findViewById(R.id.number);  //views initiallized
            position_tv = itemView.findViewById(R.id.position);

        }
    }


}
