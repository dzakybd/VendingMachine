package id.co.dzaky.vendingmachine.Util;

/**
 * Created by Zaki on 17/12/2016.
 */

public class eMoney {
    private String id;
    private int saldo;

    public int getSaldo() {
        return saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
