package dao.Impl;


import com.avaje.ebean.Model;
import dao.QrDao;
import models.Qr;

/**
 * Created by dulanjana on 7/9/18.
 */
public class QrDaoImpl implements QrDao {
    public static final Model.Finder<String, Qr> find = new Model.Finder<>(Qr.class);

    @Override
    public Qr addQr(Qr qrToAdd) {
        qrToAdd.save();
        return qrToAdd;
    }

    @Override
    public Qr deleteQr(Qr qrToDelete) {
        qrToDelete.delete();
        return qrToDelete;
    }

    @Override
    public Qr searchUser(String qr) {
        return find.byId(qr);


    }


}
