package me.zgy.registry;

import me.zgy.cst.Constant;
import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Rayee on 2017/12/11.
 */
public class ServiceRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ServiceRegistry.class);

    private String host;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public ServiceRegistry(String host) {
        this.host = host;
    }

    public void register(String data){
        if(data != null){
            ZooKeeper zk = connect();
            if(zk != null){
                createNode(zk, data);
            }
        }
    }

    public ZooKeeper connect(){
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(host, Constant.ZK_SESSION_TIMEOUT, watchedEvent -> {
                if(watchedEvent.getState() == Watcher.Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                }
            });
        } catch (IOException e) {
            logger.error("connect zk error", e);
        }
        return zooKeeper;
    }

    private void createNode(ZooKeeper zooKeeper, String data){
        try {
            zooKeeper.create(Constant.ZK_DATA_PATH, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (KeeperException e) {
            logger.error("create node error", e);
        } catch (InterruptedException e) {
            logger.error("create node error", e);
        }
    }
}
