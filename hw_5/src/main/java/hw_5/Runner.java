package hw_5;

import java.util.LinkedList;

public class Runner {

    public static void main(String[] args) {

        LinkedList<Tunnel> list = new LinkedList<Tunnel>() {
            {
                this.add(new Tunnel(771));
                this.add(new Tunnel(883));
            }
        };

        TunnelPool<Tunnel> pool = new TunnelPool<>(list);
        for (int i = 0; i < 10; i++) {
            new Train(pool).start();
        }
    }
}