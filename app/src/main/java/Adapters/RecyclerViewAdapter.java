package Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.reference.android.androidreferenceapp.R;

import java.util.List;
import Models.RecyclerViewItem;

/**
 * Created by Jonnelin Leonardo on 8/16/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<RecyclerViewItem> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.rvTitle);
            description = (TextView) view.findViewById(R.id.rvDescription);
        }
    }

    public RecyclerViewAdapter(List<RecyclerViewItem> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_content, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        RecyclerViewItem rcItem = list.get(position);
        holder.title.setText(rcItem.getTitle());
        holder.description.setText(rcItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
