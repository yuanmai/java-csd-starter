package csd.starter;

import sun.plugin2.message.Message;

/**
 * Created by anassar on 10/30/2016.
 */
public  class ClubServices {

    public static CheckoutResponse ChekoutService(Reservation res, int totalpaid) {
        CheckoutResponse resp = new CheckoutResponse();
        int totalprice = res.getTotalPrice();
        if (totalpaid == totalprice){
            resp.Success = true;
            resp.Change = 0;
            resp.Message = "Checkout Done Successfully";
        } else if (totalpaid < totalprice){
            resp.Success = false;
            resp.Change = totalpaid - totalprice;
            resp.Message = "Total Paid is less than total price with "+ resp.Change;
        } else {
            resp.Success = true;
            resp.Change = totalprice - totalpaid;
            resp.Message = "Done Successfully with extra Change " + resp.Change;
        }
        return  resp;
    }
}
