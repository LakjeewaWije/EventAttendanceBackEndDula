package services;

import models.Qr;

/**
 * Created by dulanjana on 7/9/18.
 */
public interface QrService {

    Qr addQr(Qr qr);

    Qr deleteQr(String qr);
}
