package csd.starter;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by MSAFWAT on 10/30/2016.
 */
public class ReservationService {
    private Club _club;
    private Logger logger;

    public ReservationService(Club club) {
        logger = Logger.getAnonymousLogger();
        _club = club;

    }

    public ReservationResponse ReserveCourtService(String courtname, int playerid, Date date,int numofunits,int rateofunit) {
        ReservationResponse response = new ReservationResponse("Reservation Service Done Successfully",true);
        try {
            Court court = _club.GetCourtByName(courtname);
            if (court == null)
                throw new InvalidCourtException();
            if(court.HasFreeSlotAt(date))
                court.Reservations.add(new Reservation(date,playerid,court.Id,numofunits,rateofunit));
            else
                throw new NotAvailableSlotsException();
        }
        catch (InvalidCourtException ex){
            Exception e1 = new Exception(ex);
            logger.log(Level.SEVERE, "an exception was thrown", e1);
            response.Success = false;
            response.Message = ex.getMessage();
        } catch (NotAvailableSlotsException e) {
            Exception e1 = new Exception(e);
            logger.log(Level.SEVERE, "an exception was thrown", e1);
            response.Success = false;
            response.Message = e.getMessage();
        }

        return response;
    }
}
