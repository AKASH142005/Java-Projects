package busReserv;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList ;
public class BusDemo {
    public static void main(String[] args) throws ParseException {
       ArrayList<Bus> buses= new ArrayList<>();
       ArrayList<Booking> bookings = new ArrayList<>() ;

       buses.add(new Bus(1 ,true ,2));
       buses.add(new Bus(2 ,false ,50)) ;
       buses.add(new Bus(3 ,true , 30)) ;
       for(Bus bus: buses){
           bus.display() ;
       }

        int userOption = 1 ;
        Scanner sc = new Scanner (System.in);
        while(userOption == 1){
            System.out.println("Enter 1 to Book and 2 to Exit");
            userOption = sc.nextInt();
            if(userOption == 1){
               Booking booking = new Booking() ;
               if(booking.isAvailable(bookings ,buses)){
                   bookings.add(booking) ;
                   System.out.print("Your booking is confirmed");
               }
               else{
                   System.out.println("Sorry. Buses is Full. Try another Bus or Date");
               }
            }
        }

    }
}
