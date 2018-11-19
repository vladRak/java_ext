package hw_5;

public class Tunnel {
    private int tunnelId;

    public Tunnel(int id) {
        super();
        this.tunnelId = id;
    }

    public int getTunnelId() {
        return tunnelId;
    }

    public void setTunnelId(int id) {
        this.tunnelId = id;
    }

    public void using() {
        try {
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
