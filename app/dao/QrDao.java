package dao;

import models.Qr;


/**
 * Created by dulanjana on 7/9/18.
 */
public interface QrDao {

    Qr addQr(Qr qrToAdd);

    Qr deleteQr(Qr qrToDelete);

    Qr searchUser(String qr);


}