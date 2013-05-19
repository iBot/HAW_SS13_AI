package main.komponenten.dispatcher;

import main.komponenten.kunden.IKundenManager;
import main.komponenten.lager.ILagerManager;
import main.komponenten.verkauf.IVerkaufManager;

/**
 * Created with IntelliJ IDEA.
 * User: milena
 * Date: 19.05.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public interface IDispatcherManager extends IVerkaufManager, IKundenManager, ILagerManager {

}
