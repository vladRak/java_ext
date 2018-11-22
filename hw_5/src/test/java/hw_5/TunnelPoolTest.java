package hw_5;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class TunnelPoolTest {

    @Test
    public void getResource() throws Exception {

        LinkedList<Tunnel> list = new LinkedList<Tunnel>();
        list.add(new Tunnel(771));
        TunnelPool<Tunnel> pool = new TunnelPool<>(list);

        Tunnel tunnel = pool.getResource(100);

        Assert.assertNotNull(tunnel);
    }

    @Test(expected = ResourceException.class)
    public void getResourceWithException() throws Exception {

        LinkedList<Tunnel> list = new LinkedList<Tunnel>();
        list.add(new Tunnel(771));
        TunnelPool<Tunnel> pool = new TunnelPool<>(list);

        Tunnel tunnel = pool.getResource(100);
        Tunnel tunnel2 = pool.getResource(100);
    }

    @Test
    public void returnResource() throws Exception {
        LinkedList<Tunnel> list = new LinkedList<Tunnel>();
        list.add(new Tunnel(771));
        TunnelPool<Tunnel> pool = new TunnelPool<>(list);

        Tunnel tunnel1 = pool.getResource(100);
        pool.returnResource(tunnel1);
        Tunnel tunnel2 = pool.getResource(100);

        Assert.assertNotNull(tunnel2);
    }
}