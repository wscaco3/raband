package top.ewind.raband.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import top.ewind.raband.R;

import java.util.List;
import java.util.Random;

public class MainViewAdapt extends RecyclerView.Adapter<MainViewAdapt.MainViewHolder> {

    private List<String> mdata;
    private Context mcontext;

    public MainViewAdapt(Context context,List<String> data){
        this.mdata = data;
        this.mcontext = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.tv.setText(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void removeItem(int position){
        mdata.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int position){
        mdata.add(position,new Random().nextInt(1000)+"--new");
        notifyItemInserted(position);
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public MainViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.num);
        }
    }
}