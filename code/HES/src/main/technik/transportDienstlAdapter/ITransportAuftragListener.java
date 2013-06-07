package main.technik.transportDienstlAdapter;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 07.06.13
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public interface ITransportAuftragListener {

    public void bestaetigeTransportauftrag(String transportAuftragsNummer, Date datum);
}
