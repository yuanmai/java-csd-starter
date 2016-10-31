package csd.starter;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by MSAFWAT on 10/30/2016.
 */
public class ReservationService {
    private Club _club;
    private int _count = 0;

    public ReservationService(Club club) {

        _club = club;

    }

    public ReservationResponse ReserveCourtService(String courtname, int playerid, Date date,int numofunits,int rateofunit) {
        ReservationResponse response = new ReservationResponse("Reservation Service Done Successfully",true);
        try {
            Court court = _club.GetCourtByName(courtname);
            if (court == null)
                throw new InvalidCourtException();
            if(court.HasFreeSlotAt(date,numofunits))
                court.Reservations.add(new Reservation(date,playerid,court.Id,numofunits,rateofunit));
            else
                throw new NotAvailableSlotsException();
        }
        catch (InvalidCourtException ex){
            response.Success = false;
            response.Message = ex.getMessage();
        } catch (NotAvailableSlotsException e) {
            response.Success = false;
            response.Message = e.getMessage();
        }

        return response;
    }
}
