package csd.starter;

/**
 * Created by anassar on 10/30/2016.
 */
public final class ClubServices {

    private ClubServices(){
    }

    public final static CheckoutResponse ChekoutService(Reservation res, int totalpaid) {
        int totalprice = res.getTotalPrice();
        int change = totalpaid - totalprice;
        if (totalpaid == totalprice)
            return new CheckoutResponse(true,0,"Checkout Done Successfully");
        if (totalpaid < totalprice)
            return new CheckoutResponse(false,totalpaid - totalprice,"Total Paid is less than total price with "+ change);
        return new CheckoutResponse(true,totalpaid - totalprice,"Done Successfully with extra Change " + change);
    }

}
