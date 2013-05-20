package komponenten.AktiveRedundanz.monitor;

import enums.StatusEnum;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public interface IMonitorManager {

    void setInstanceStatus(StatusEnum status,int systemInstanzID);

}
