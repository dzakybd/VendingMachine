package id.co.dzaky.vendingmachine;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.dzaky.vendingmachine.Util.Adapter;
import id.co.dzaky.vendingmachine.Util.ItemClickSupport;
import id.co.dzaky.vendingmachine.Util.eMoney;

public class VendingMachine extends AppCompatActivity {
    RecyclerView Recycler;
    Adapter adapter;
    TextView textView;
    Item singleitem;
    Button button;
    Item buyitem;
    int pos;
    public VendingMachine(){
        pos=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final List<Item> items = new ArrayList<>();
        singleitem = new Item();
        singleitem.setName("Coke");
        singleitem.setImage(R.drawable.coke);
        singleitem.setPrice(6000);
        singleitem.setQuantity(5);
        items.add(singleitem);

        singleitem = new Item();
        singleitem.setName("Sprite");
        singleitem.setImage(R.drawable.sprite);
        singleitem.setPrice(4000);
        singleitem.setQuantity(5);
        items.add(singleitem);

        singleitem = new Item();
        singleitem.setName("Pepsi");
        singleitem.setImage(R.drawable.pepsi);
        singleitem.setPrice(5000);
        singleitem.setQuantity(5);
        items.add(singleitem);


        singleitem = new Item();
        singleitem.setName("Blueguy");
        singleitem.setImage(R.drawable.blueguy);
        singleitem.setPrice(10000);
        singleitem.setQuantity(5);
        items.add(singleitem);

        singleitem = new Item();
        singleitem.setName("Fireball");
        singleitem.setImage(R.drawable.fireball);
        singleitem.setPrice(7000);
        singleitem.setQuantity(5);
        items.add(singleitem);

        final eMoney emoney = new eMoney();
        emoney.setId("user1");
        emoney.setSaldo(50000);

        Recycler = (RecyclerView) findViewById(R.id.recycler);
        Recycler.setLayoutManager(new GridLayoutManager(this,2));
        Recycler.setHasFixedSize(true);
        adapter = new Adapter(this, items);
        Recycler.setAdapter(adapter);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Selamat datang");

        ItemClickSupport.addTo(Recycler).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        if(items.get(position).getQuantity()<1){
                            textView.setText("Item habis");
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText("Selamat datang");
                                }
                            }, 1000);
                        }else{
                            textView.setText("Letakan e-Money Anda,\nRp "+String.valueOf(items.get(position).getPrice()));
                            buyitem=items.get(position);
                            pos=position;
                        }
                    }
                }
        );

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(buyitem!=null){
                    if(emoney.getSaldo()-buyitem.getPrice()<0){
                        textView.setText("Maaf saldo Anda kurang!\nSaldo Anda: Rp "+String.valueOf(emoney.getSaldo()));
                    }else{
                        textView.setText("Memproses pembayaran,\nSaldo Anda: Rp "+ String.valueOf(emoney.getSaldo()));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Pembayaran berhasil!\n"+buyitem.getName()+": Rp "+String.valueOf(buyitem.getPrice())+"\nSaldo: Rp "+ String.valueOf(emoney.getSaldo()));
                            }
                        }, 1500);
                        emoney.setSaldo(emoney.getSaldo()-buyitem.getPrice());
                        items.get(pos).setQuantity(buyitem.getQuantity()-1);

                        adapter.notifyDataSetChanged();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Saldo Anda: Rp "+String.valueOf(emoney.getSaldo()));
                            }
                        }, 3000);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText("Selamat datang");
                                buyitem=null;
                            }
                        }, 4500);
                    }
                }else{
                    textView.setText("Pilih minuman Anda");
                }
            }
        });

    }

}
