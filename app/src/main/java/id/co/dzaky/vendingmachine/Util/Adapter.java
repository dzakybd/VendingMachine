package id.co.dzaky.vendingmachine.Util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.co.dzaky.vendingmachine.Item;
import id.co.dzaky.vendingmachine.R;


public class Adapter extends RecyclerView.Adapter<Adapter.ReyclerViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<Item> items;

    public Adapter(Context context, List<Item> items) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.items = items;

    }

    @Override
    public ReyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View acara = layoutInflater.inflate(R.layout.item, parent, false);
        return new ReyclerViewHolder(acara);
    }

    @Override
    public void onBindViewHolder(final ReyclerViewHolder holder, int position) {
            holder.nama.setText(items.get(position).getName());
            holder.tersedia.setText("Qty: "+String.valueOf(items.get(position).getQuantity()));
            holder.harga.setText("Rp "+String.valueOf(items.get(position).getPrice()));
            holder.image.setImageResource(items.get(position).getImage());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class ReyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView nama,tersedia,harga;

        private ReyclerViewHolder(final View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.grid_image);
            nama = (TextView) v.findViewById(R.id.nama);
            harga = (TextView) v.findViewById(R.id.harga);
            tersedia = (TextView) v.findViewById(R.id.tersedia);
        }
    }
}
