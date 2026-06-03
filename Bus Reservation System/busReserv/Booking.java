package busReserv;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat ;
public class Booking {
    String passengerName ;
    int busNo ;
    Date date ;

    Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passenger : ");
        passengerName = sc.next() ;
        System.out.print("Enter Bus no : ");
        busNo = sc.nextInt() ;
        System.out.print("Enter date dd-mm-yyyy");
        String dateInput= sc.next();
        SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dataFormat.parse(dateInput);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }
    public boolean isAvailable(ArrayList<Booking> bookings , ArrayList <Bus> Buses ){
        int capcity = 0;
        for(Bus bus : Buses){
            if(bus.getBusNo() == busNo){
                capcity = bus.getCapacity() ;
            }
        }
        int booked = 0;

        for(Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }
        return booked < capcity ;
    }
}
