package hw_5;

public class Train extends Thread {

    private boolean tunnelPassage = false;

    private TunnelPool<Tunnel> pool;

    public Train (TunnelPool<Tunnel> pool) {
        this.pool = pool;
    }

    public void run() {
        Tunnel tunnel = null;
        try {
            tunnel = pool.getResource(500);
            tunnelPassage = true;
            System.out.println("Tunnel Train #" + this.getId()

                    + " took Tunnel #" + tunnel.getTunnelId());
            tunnel.using();
        } catch (ResourceException e) {
            System.out.println("Train #" + this.getId() + " lost ->"
                    + e.getMessage());
        } finally {
            if (tunnel != null) {
                tunnelPassage = false;
                System.out.println("Tunnel Train #" + this.getId() + " : "

                        + tunnel.getTunnelId() + " tunnel released");
                pool.returnResource(tunnel);
            }
        }
    }

    public boolean isTunnelPassage() {
        return tunnelPassage;

    }
}
