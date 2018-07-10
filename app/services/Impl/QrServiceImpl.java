package services.Impl;

import com.google.inject.Inject;
import dao.QrDao;
import models.Qr;
import services.QrService;

import javax.inject.Named;

/**
 * Created by dulanjana on 7/9/18.
 */
public class QrServiceImpl implements QrService {

    @Inject
    @Named("qrDao")
    private QrDao qrDao;


    @Override
    public Qr addQr(Qr qr) {

        //qr.setBrowserToken("sdsds");
        //qr.setUuid("12345");
        return qrDao.addQr(qr);
    }

    @Override
    public Qr deleteQr(String qr) {

        Qr qrInDb = qrDao.searchUser(qr);

        if(qrInDb==null){
            return null;
        }
        return qrDao.deleteQr(qrInDb) ;
    }
}
