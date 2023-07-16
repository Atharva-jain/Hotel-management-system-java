
package micro.project;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.Select;
 import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
 import java.util.Scanner;
import java.util.InputMismatchException;
class RoomValidity  
{
    protected String Date_gain="",Date_compare="",Date_provide="",File_name="",Data_gain="",stored_data="",User="";
    protected SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    protected int j=1,i;
    public int uniqueNumber()
    {
        int main=0;
        try
        {
            FileReader contentRead = new FileReader("number.txt");
            BufferedReader bRead = new BufferedReader(contentRead);
            String str = bRead.readLine();
            main = Integer.parseInt(str);
             
            main =main+1;
            String str1 = Integer.toString(main);
            
            bRead.close();
            contentRead.close();
            FileWriter contentWrite = new FileWriter("number.txt",false);
            BufferedWriter bWrite= new BufferedWriter(contentWrite);
            bWrite.write(str1);
            bWrite.close();
        }
        catch(IOException e){System.out.println("File are not Copied ");}
        catch(Exception e){System.out.println("Error "+e);}
        return main;
    }
    public void CopyContentFile(int fileno,int unino)
    {
        try{
            String filename="RoomNO"+fileno+".txt";
            String CopyName="DeletedFile"+unino+".txt";
            FileReader roomfile = new FileReader(filename);
            FileWriter copyfile = new FileWriter(CopyName);
            BufferedReader fileRead = new BufferedReader(roomfile);
            BufferedWriter filewrite = new BufferedWriter(copyfile);
            String store ="";
            while((store=fileRead.readLine())!=null)
            {
                filewrite.write(store);
                filewrite.newLine();
            }
            filewrite.close();
            fileRead.close();
        }
        catch(IOException e){System.out.println("File not Copied");}
        catch(Exception e){System.out.println("Error " +e);}
    }
    public void ValidDate(){
      try {
       
           for(i=1;i<=10;i++){
           
               File_name = "RoomNO"+i+".txt";
               FileReader findfile= new FileReader(File_name);
               BufferedReader b = new BufferedReader(findfile);
               stored_data=b.readLine();
               
               if(stored_data.contains("nobody"))
               {
                   System.out.println("---------------------------------------------------------------------------------------");
                   System.out.println(i+". "+" is occupied by "+stored_data);
                   System.out.println("---------------------------------------------------------------------------------------");
               }
               else
               {
                     j=0;
                     while ((Data_gain=b.readLine()) != null)
                     {    
                          
                           if(j==8)
                           {       
                                 Date_gain = Data_gain;
                                 Date date1 = formatter.parse(Date_gain);
                                 Date_provide =formatter.format(date1);
                                 LocalDate CompareDate = LocalDate.parse(Date_provide);
                                 LocalDate Difference = LocalDate.now();
                                 Period differenceDate = Period.between(CompareDate , Difference);
                                 int  i1 =differenceDate.getDays();
                                 if(i1>=0)
                                 {
                                    int unique = uniqueNumber();
                                    CopyContentFile(i, unique);
                                    Date_provide ="RoomNO"+i+".txt";
                                    FileWriter filewr= new FileWriter(Date_provide,false);
                                    BufferedWriter wr = new BufferedWriter(filewr);
                                    wr.write("nobody");
                                    wr.close();
                                 }
                                else
                                {
                                        System.out.println("---------------------------------------------------------------------------------------");
                                        System.out.println(i+". Room booked by " +stored_data);
                                        System.out.println("    Room available on After  " +((i1-i1)-i1)+" Days");
                                        System.out.println("---------------------------------------------------------------------------------------");
                                 }
                            }    
                             j=j+1;
                     }
               }
           }
        }
        catch(IOException e)
        {
            System.out.println("File NOT READ::::::");
        }
        catch(Exception e)
        {
            System.out.println("Erroe occur :: "+e);
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::-END-::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("---------------------------------------------------------------------------------------");
          System.out.println("");
          System.out.println("");
          System.out.println("");
    }
}
class DateValidity extends RoomValidity
{
    protected String vailedFileStore="",validFileDate="",valiedFileGain="",validDay="",validFileName="",info="";
    protected SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
    protected String validDataProvider="",Operation="";
    protected int  f=1,i2;
    public int  validDayCheck(int day)
    {
        try
        {
              validFileDate = "RoomNO"+day+".txt";
               FileReader findfile= new FileReader(validFileDate);
               BufferedReader b = new BufferedReader(findfile);
               validFileName=b.readLine();
               if(validFileName.contains("nobody")){}
               else
               {
                    f=0;
                     while ((valiedFileGain=b.readLine()) != null)
                     {    
                          
                           if(f==8)
                           {       
                                 info =valiedFileGain;
                                 Date date1 = formatter1.parse(info);
                                 validDataProvider =formatter1.format(date1);
                                 LocalDate CompareDate = LocalDate.parse(validDataProvider);
                                 LocalDate Difference = LocalDate.now();
                                 Period differenceDate = Period.between(CompareDate , Difference);
                                  i2 =differenceDate.getDays();
                                 if(i2>=0)
                                 {
                                    int unique = uniqueNumber();
                                    CopyContentFile(day, unique);
                                    Operation ="RoomNO"+day+".txt";
                                    FileWriter filewr= new FileWriter(Operation,false);
                                    BufferedWriter wr = new BufferedWriter(filewr);
                                    wr.write("nobody");
                                    wr.close();
                                 }
                           }    
                             f=f+1;
                     }
               }
             
        }
        catch(IOException e){System.out.println("File are not read properly ::::::");}
        catch(Exception e){System.out.println("Error::::"+e);}
        return ((i2-i2)-i2);
    }
}
class Customer extends DateValidity
{
    protected String Customer_name,Customer_email,Customer_address,Customer_city,Customer_state;
    protected int Days;
    protected long Customer_phoneno,Payment=0;
    protected String Current_date,Final_date,Str_phoneno,Str_date,Str_payment;
    public void Recursive_phoneno()
    {
        Scanner obj = new Scanner (System.in);
          try
             {
                  Customer_phoneno = obj.nextLong();
             }
             catch(InputMismatchException e)
             {
                  System.out.println("You enter sutable Phone Number");
                  Recursive_phoneno();          
             }
    }
    public void Recursive_Day()
    {
        Scanner obj = new Scanner (System.in);
          try
             {
                 Days = obj.nextInt();
                 if(Days <=0)
                      throw  new InputMismatchException();
             }
             catch(InputMismatchException e)
             {
                 System.out.println("Please enter valid Days :: ");
                 Recursive_Day();
             }
    }
    public void Payment_Rupees(int day)
    {
        for(int i=0;i<day;i++)
        {
            Payment =Payment +4000;
        }
    }
    public void DateAndTime(int day)
    {
        try
        {
            LocalDate CurrDate = LocalDate.now();
            LocalDate  FinDate ;
            Current_date = CurrDate.toString();
            FinDate = CurrDate.plusDays(day);
            Final_date =FinDate.toString();
            System.out.println("Booking  Date ::   " +Current_date);
            System.out.println("Leaving  Date :: " + Final_date);
        }
        catch(Exception e)
        {
            System.out.println("Date are not Store :" +e);
        }
    }
    protected void Customer_info(String str)
    {
        Scanner obj = new Scanner(System.in);
        try
        {
             FileWriter file = new FileWriter(str);
             BufferedWriter  b= new BufferedWriter(file);
             System.out.print("Enter Customer name :: ");
             Customer_name = obj.nextLine();
             System.out.println("---------------------------------------------------------------------------------------");
             b.write(Customer_name);
             System.out.print("Enter Customer city ::");
             Customer_city = obj.nextLine();
            System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Customer_city);
             System.out.print("Enter Customer state :: ");
             Customer_state = obj.nextLine();
             System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Customer_state);
             System.out.print("Enter Customer Address :: ");
             Customer_address = obj.nextLine();
             System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Customer_address);
             System.out.print("Enter the Email ID :: ");
             Customer_email = (obj.nextLine());
             System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Customer_email);
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.print("Enter the Phone NO :: ");
             try
             {
                  Customer_phoneno = obj.nextLong();
             }
             catch(InputMismatchException e)
             {
                  System.out.println("You enter sutable Phone Number");
                  Recursive_phoneno();
                  String str67 = obj.next();
             }
             b.newLine();
             Str_phoneno = Long.toString(Customer_phoneno);
             //System.out.println("---------------------------------------------------------------------------------------");
             b.write(Str_phoneno);
             System.out.println("How Many Days you live :: ");
             try
             {
                 Days = obj.nextInt();
                 if(Days <= 0)
                 {
                     throw  new InputMismatchException();
                 }
             }
             catch(InputMismatchException e)
             {
                 System.out.println("Please enter suitable Days :: ");
                 Recursive_Day();
                 String str99 = obj.next();
             }
             System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             Str_date = Integer.toString(Days);
             b.write(Str_date);
             Payment_Rupees(Days);
             b.newLine();
            // System.out.println("---------------------------------------------------------------------------------------");
             Str_payment = Long.toString(Payment);
              b.write(Str_payment);
             System.out.println("Your Bill is :" +Payment);
             Payment=0;
             DateAndTime(Days);
              //System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Current_date);
            // System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.write(Final_date);
          //  System.out.println("---------------------------------------------------------------------------------------");
             b.newLine();
             b.close();
        }
            
        catch(IOException e)
        {
            System.out.println("Error in  input Output stream::");
        }
        catch(Exception e)
        {
            System.out.println("Error:::"+e);
        }
    }
} 
class BookingRoom extends Customer
{
    protected int Book,element=0;
    protected String str = "",check="",k="",contain="";
    protected boolean ok=true;
    public void Recursive_book()
    {
        Scanner obj = new Scanner(System.in);
        try
        {
            Book=obj.nextInt();
            if(Book <= 0 || Book>=11)
            {
                throw new InputMismatchException();
            }
        }
        catch(InputMismatchException e)
        {
             System.out.println("Enter suitable Room name :::");
             Recursive_book();
              
        }
    }
    public void BookingARoom()
    {     
        Scanner obj = new Scanner(System.in);
        try{
                 while(ok == true)
                 {
                      System.out.println("---------------------------------------------------------------------------------------");
                      System.out.println("Enter Room Number You Won't to Book :::");
                      try
                      {
                       Book=obj.nextInt();
                        if(Book <= 0 || Book>=11)
                           {
                                 throw new InputMismatchException();
                            }
                      }
                      catch(InputMismatchException e)
                     {
                               System.out.println("Enter suitable Room Number :::");
                               Recursive_book();
                               
                      }
                     str = "RoomNO"+Book+".txt";
                       System.out.println("---------------------------------------------------------------------------------------");
                      FileReader read  = new FileReader(str);
                      BufferedReader b1 = new BufferedReader(read);
                      switch(Book)
                      {
                         case 1:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                     System.out.println("Room avialable on "+element+" Days:::::");                             
                             }       
                            System.out.println("---------------------------------------------------------------------------------------");
                            //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                         case 2:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}    
                               System.out.println("---------------------------------------------------------------------------------------");
                              // System.out.println("---------------------------------------------------------------------------------------");
                             break;
                        case 3:
                            element=validDayCheck(Book);
                            contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                      System.out.println("Room avialable on "+element+" Days:::::");}  
                               System.out.println("---------------------------------------------------------------------------------------");
                               //System.out.println("---------------------------------------------------------------------------------------");
                             break; 
                        case 4:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}  
                               System.out.println("---------------------------------------------------------------------------------------");
                               //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                        case 5:
                            element=validDayCheck(Book);
                            contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}  
                            System.out.println("---------------------------------------------------------------------------------------");
                            //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                        case 6:
                            element=validDayCheck(Book);
                            contain=b1.readLine();
                             if(contain.contains("nobody")||contain.contains(""))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");} 
                               System.out.println("---------------------------------------------------------------------------------------");
                              // System.out.println("---------------------------------------------------------------------------------------");
                             break;
                       case 7:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");        
                                    System.out.println("Room avialable on "+element+" Days:::::");}
                               System.out.println("---------------------------------------------------------------------------------------");
                               //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                       case 8:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}
                               System.out.println("---------------------------------------------------------------------------------------");
                              // System.out.println("---------------------------------------------------------------------------------------");
                             break;
                       case 9:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}   
                               System.out.println("---------------------------------------------------------------------------------------");
                               //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                       case 10:
                             element=validDayCheck(Book);
                             contain=b1.readLine();
                             if(contain.contains("nobody"))
                             {Customer_info(str);}
                             else{System.out.println("Room NO"+Book+" is already booked ::");
                                    System.out.println("Room avialable on "+element+" Days:::::");}  
                               System.out.println("---------------------------------------------------------------------------------------");
                               //System.out.println("---------------------------------------------------------------------------------------");
                             break;
                }
                   System.out.println("---------------------------------------------------------------------------------------");
                   System.out.println("You  won't Book More Room(Answer between yes / no) ::::::::::::::-- ");
                   check = obj.next();
                   System.out.println("---------------------------------------------------------------------------------------");
                   if(check.contains("yes") || check.contains("YES")||check.contains("YEs")||check.contains("Yes"))
                  {
                      ok=true;
                      
                    }
                  else
                  {
                      ok=false;
                      b1.close();
                  }
           }
       }
    catch(IOException e)
    {
        System.out.println("Data are not READ ::::::");
    }
    catch(Exception e)
    {
        System.out.println("Error : " +e);
    }
      System.out.println("---------------------------------------------------------------------------------------");
      System.out.println("::::::::::::::::::::::::::::::::::::::::::----END----::::::::::::::::::::::::::::::::::::::::::::::");
      System.out.println("---------------------------------------------------------------------------------------");
      System.out.println("");
      System.out.println("");
      System.out.println("");
 }
}
class CheckRoomAvailable extends BookingRoom
{
    protected int available=0;
    protected String contain_room ="",availableRoom="";
    public void CheekingRoom()
    {
        try{
        for(int i=1;i<=10;i++)
        {
             contain_room ="RoomNO"+i+".txt";
             FileReader cheFile = new FileReader(contain_room);
             BufferedReader b2 = new BufferedReader(cheFile);
             availableRoom = b2.readLine();
             if(availableRoom.contains("nobody"))
             {
                   System.out.println("---------------------------------------------------------------------------------------");
                   System.out.println(i+". "+"Room is Available to Book ::::::");       
                   System.out.println("---------------------------------------------------------------------------------------");
             }
             else
             {
                   System.out.println("---------------------------------------------------------------------------------------");
                   System.out.println("Room NO "+i+" booked By Mr/Ms ::::::::::::::::::--- "+availableRoom);
                   System.out.println("---------------------------------------------------------------------------------------");
             }  
             if(i==10){b2.close();}
          }  
        }
        catch(IOException e)
        {
            System.out.println("File are NOT READ ::::::::");   
        }
          System.out.println("---------------------------------------------------------------------------------------");
          System.out.println(":::::::::::::::::::::::::::::::::::::::::::----END---:::::::::::::::::::::::::::::::::::::::::::::::");
          System.out.println("---------------------------------------------------------------------------------------");
          System.out.println("");
          System.out.println("");
          System.out.println("");
    }
}
class SearchRoom extends CheckRoomAvailable
{
    protected String searchName ="",contain_search="",InputName="",Stored_contain="",first_date="",last_day="";
    SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
    public int datecompare(String firDate,String lastDate)
    {
        int i56=0;
        try{
            Date datefir = formatter6.parse(firDate);
            Date datelas = formatter6.parse(lastDate);
            String str1="",str2="";
            str1=formatter6.format(datefir);
            str2=formatter6.format(datelas);
            LocalDate locdatefir = LocalDate.parse(str1);
            LocalDate locdatelas = LocalDate.parse(str2);
            Period diff = Period.between(locdatefir,locdatelas);
            i56 =diff.getDays();
           }
        catch(Exception e){System.out.println("Date are performed : "+e);}
         return i56;
     }
    public void RoomSearch()
    {
        Scanner obj = new Scanner(System.in);
        try
       {
              System.out.println("---------------------------------------------------------------------------------------");          
              System.out.println("Enter your NAME to SEARCH your ROOM :::::::::::::::::::::::::::::----");
              InputName = obj.next();
              System.out.println("---------------------------------------------------------------------------------------");
              int flag =0,j=0,differencedate=0;
             for(int i=1;i<=10;i++)
             {
                 contain_search = "RoomNO"+i+".txt";
                 FileReader readSearch = new FileReader(contain_search);
                 BufferedReader b3 = new BufferedReader(readSearch);
                 searchName = b3.readLine();
                 if(searchName.contains(InputName))
                 {
                       j=0;
                      while((Stored_contain=b3.readLine())!=null)
                      {
                          flag=0;
                          if(j==7)
                          { first_date=Stored_contain;}
                          if(j==8)
                          {last_day= Stored_contain;}
                               j++;
                       }
                      differencedate = datecompare(first_date, last_day);
                      System.out.println("---------------------------------------------------------------------------------------");
                      System.out.println("Room No "+i+" is your room number ::::");
                      System.out.println("---------------------------------------------------------------------------------------");
                      System.out.println("Booking Date is "+ first_date);
                      System.out.println("---------------------------------------------------------------------------------------");
                      System.out.println("Your Leaving Date is "+last_day);
                      System.out.println("---------------------------------------------------------------------------------------");
                      System.out.println("Remaining day is "+differencedate);
                      System.out.println("---------------------------------------------------------------------------------------");
                      break;
                 }
                 else{
                     flag=1;
                     b3.close();
                 }
                 if(i==10){b3.close();}
             }
             if(flag==1){
                 System.out.println("---------------------------------------------------------------------------------------");
                 System.out.println("::::::::::::-------::::::::Sorry you are not book any room::::::-------:::::::::::");
                 System.out.println("---------------------------------------------------------------------------------------");
             }
       }
        catch(IOException e)
       {
           System.out.println("File are NOT READ:::::::");
       }
       catch(Exception e)
      {
          System.out.println("ERROR : " +e);
      }
        System.out.println("");
        System.out.println("");
    }
 }
class DeletingRoom extends SearchRoom
{
    public void DeleteARoom()
    {
        Scanner obj = new Scanner (System.in);
        try
        {
           System.out.println("---------------------------------------------------------------------------------------");
           System.out.println("You will not get money if you Cancel your Book Room :::::::::-------");
           System.out.println("Still you want to do then write Yes ::::::::::::::::::::::::::::::::::::::::::------");
           String shoure=obj.next();
           System.out.println("---------------------------------------------------------------------------------------");
           String roomname="",filenam="",stor="";
           int lag = 0;
           if(shoure.contains("Yes")||shoure.contains("YES")||shoure.contains("yes"))
           {
                 System.out.println("---------------------------------------------------------------------------------------");
                 System.out.println("Enter the NAME to DELETE your ROOM ::::::::::::::::::::::::::::------- ");
                 roomname = obj.next();
                 System.out.println("---------------------------------------------------------------------------------------");
                  for(int i=1;i<=10;i++)
                  {
                        filenam ="RoomNO"+i+".txt";
                        FileReader  read = new FileReader(filenam);
                        BufferedReader reader = new BufferedReader(read);
                        stor = reader.readLine();
                        if(stor.contains(roomname))
                        {
                              lag=0;
                              int unique = uniqueNumber();
                              CopyContentFile(i, unique);
                              FileWriter file = new FileWriter(filenam,false);
                              BufferedWriter writes = new BufferedWriter(file);
                              writes.write("nobody");
                              writes.close();
                              break;
                        } 
                        else
                        {
                            lag=1;
                        }
                        if(i==10)
                        {
                            reader.close();
                        }
                  }
           }
           if(lag==1)
           {
                
               System.out.println(":::::::::::This name is not Avialable :::::::");
           }
           else
                System.out.println("::::::::::::::::::::--ROOM CANCELED--:::::::::::::::::::::");
         }
        catch(IOException e){System.out.println(" Room are not Deleted ...");}
        catch(Exception e){System.out.println("Error" +e);}
        System.out.println("");
        System.out.println("");
       }
}
class ShowRoom extends DeletingRoom
{
    String str = "",store ="";
    String info[] = new String[10];
    Boolean non = true;
    public void AllRoom()
    {
        try
        {
            for(int i=1;i<=10;i++)
            {
                    str ="RoomNO"+i+".txt";
                    FileReader read = new FileReader(str);
                    BufferedReader b = new BufferedReader(read);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("--------->>>>>>>>>ROOM NO"+i+"<<<<<<<<<<<--------");
                    int num=0;
                    while((store = b.readLine()) != null)
                    {
                         non=true;
                         if(store.contains("nobody")){ non=false;}
                         info[num]=store;
                         num = num +1;
                    }
                    if(non==true){
                          System.out.println("Customer Name :: " +info[0]);
                          System.out.println("Customer city :: "+info[1]);
                          System.out.println("Customer state :: "+info[2]);
                          System.out.println("Customer Address ::"+info[3]);
                          System.out.println("Customer Email ID ::"+info[4]);
                          System.out.println("Customer Phone NO :: "+info[5]);
                          System.out.println("Days :: "+info[6]);
                          System.out.println("Bill :: " +info[7]);
                          System.out.println("Booking Date :: "+info[8]);
                          System.out.println("Leaving Date :: "+info[9]);
                          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");}
                    else
                    {
                          System.out.println("Room Occupied nobody::");                      
                    }
            }
       }
        catch(IOException e){System.out.println("File are not read ::::::::");}
        catch(Exception e){System.out.println("Error :::" +e);}        
    }
}
class ParticularRoom extends ShowRoom
{
    int n;
    String str = "",store ="";
    String info[] = new String[10];
    Boolean non = true;
    public void RecursiveRoom()
    {
        Scanner obj = new Scanner(System.in);
        try
        {
            n = obj.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("Enter the Room number Between (1 to 10)::");
            RecursiveRoom();
        }
    }
    public void particularRoom()
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the Room Number ::::");
         try {  
              try
             {
                n= obj.nextInt();
                if(n<=0 || n>=11)
               {
                throw new InputMismatchException();
               }
             }
              catch(InputMismatchException e)
              {
               System.out.println("Enter the Room number Between (1 to 10)::");
               RecursiveRoom();
               }
              str ="RoomNO"+n+".txt";
              FileReader read =new FileReader(str);
              BufferedReader b=  new BufferedReader(read);
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("----->>>>>>>>>>>ROOM NO"+n+"<<<<<<<<<<<------");
              int num =0;
              while((store=b.readLine())!=null)
              {
                   non=true;
                   if(store.contains("nobody")){ non=false;}
                   info[num]=store;
                   num = num +1;
              }
                    if(non==true){
                          System.out.println("Customer Name :: " +info[0]);
                          System.out.println("Customer city :: "+info[1]);
                          System.out.println("Customer state :: "+info[2]);
                          System.out.println("Customer Address ::"+info[3]);
                          System.out.println("Customer Email ID ::"+info[4]);
                          System.out.println("Customer Phone NO :: "+info[5]);
                          System.out.println("Days :: "+info[6]);
                          System.out.println("Bill :: " +info[7]);
                          System.out.println("Booking Date :: "+info[8]);
                          System.out.println("Leaving Date :: "+info[9]);
                       //   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    }
                    else
                    {
                          System.out.println("Room Occupied nobody::");                      
                    }              
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
         catch (IOException e)
         {
             System.out.println("File are not read :::");  
         }
         catch(Exception e)
         {
             System.out.println("Error :: "+e);
         }
    }
}
class SelectedOption extends ParticularRoom
{
    public void SelectedOptions()
    {
                while(true){
                Scanner obj = new Scanner(System.in); 
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println("Hello and Welcome to our Hotel Program\nPlease keep hands and feet in the vehicle at all time.");
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("B: Display Empty Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("C: View all Rooms.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("D: Delete customer from room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("E: Find room from customer name.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("F: View a perticular room.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("G: Display room validity.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("H: Exit.");
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                String Selection = obj.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookingARoom();
                        break;
                    case "B":
                        CheekingRoom();
                        break;
                    case "C":
                         AllRoom();
                        break;
                    case "D":
                        DeleteARoom();
                        break;
                    case "E":
                        RoomSearch();
                        break;
                    case "F":
                        particularRoom();
                        break;
                    case "G":
                        ValidDate();
                        break;
                    case "H":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
    }}}
}   
public class HoltelBookingManagementSystem 
{
    public static void main(String[] args) 
    {
    
      SelectedOption sel = new SelectedOption();
      sel.SelectedOptions();
    }
    
}
