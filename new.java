import java.util.*;
class colour
{
	
	static String def = "\u001B[0m";
	static String blink = "\u001B[5m";
	static String red = "\u001B[31m";
	static String green = "\u001B[32m";
	static String yellow = "\u001B[33m";
	static String blue = "\u001B[34m";
	static String purple = "\u001B[35m";
	static String skblue = "\u001B[36m";
}
class login extends colour
{
	int count=0;
	static Scanner sc=new Scanner(System.in);
	String USER_ID;
	static String user_id="Sanjay1";
	static String password="Sanjay@1";
	String PASSWORD;
	String MOBILE;
	void register(){
		System.out.println(colour.yellow+"				REGISTRATION FORM"+colour.def);
		System.out.println();
		System.out.println(colour.skblue+"				ENTER YOUR NAME"+colour.def);
		String name=sc.next();
		mobile_valid();
		user_id();
		password();
		System.out.println(colour.green+"				<------REGISTRATION SUCESSFUL----->\n"+colour.def);
		System.out.println();
		System.out.println(colour.skblue+"				1.LOGIN");
		System.out.println("				2.EXIT"+colour.def);
		int x=sc.nextInt();
		if(x==1)
			login();
		else
		{
			System.exit(0);
		}
	}
	void mobile_valid()
	{
		System.out.println(colour.skblue+"			ENTER YOUR 10 DIGIT MOBILE NUMBER"+colour.def);
		String mobile_num=sc.next();
		int length_mobile=mobile_num.length();
		if(length_mobile==10)
		{
			System.out.println(colour.green+"			MOBILE NUMBER VERIFIED SUCESSFULLY"+colour.def);
			System.out.println(colour.red+colour.blink+"			OTP HAS BEEN SENT TO YOUR MOBILE NUMBER"+colour.def);
			otp_verify();
			MOBILE=mobile_num;
		}
		else
		{
			System.out.println(colour.red+colour.blink+"			INVALID MOBILE NUMBER PLEASE TRY AGAIN"+colour.def);
			mobile_valid();
		}
	}
	void otp_verify()
	{
		int random_otp=(int)(Math.random()*10000);
		if(random_otp<=999)
		{
			random_otp*=10;
		}
		System.out.println(colour.purple+"YOUR OTP : "+random_otp+"\n"+"ENTER OTP");
		int user_otp=sc.nextInt();
		if(user_otp==random_otp)
		{
			System.out.println(colour.green+"			OTP HAS BEEN VERIFIED\n\n"+colour.def);
		}
		else
		{
			System.out.println(colour.red+"			YOU HAVE ENTERED INVALID OTP");
			System.out.println("			PLEASE TRY AGAIN"+colour.def);
			otp_verify();
		}
	}
	void user_id()
	{
		System.out.println(colour.skblue+"			CREATE YOUR USER ID");
		System.out.println(colour.red+colour.blink+"			It must be consists of one capital letter and number"+colour.def);
		System.out.println();
		String user_id=sc.next();
		int u_id=user_id.length();
		int c=0,d=0,e=0,f=0;
		for(int i=(u_id-1);i>=0;i--)
		{
			char us_id=user_id.charAt(i);
			if(us_id >='A' && us_id <='Z')
				c++;
			else if(us_id >='a' && us_id <='z')
				d++;
			else if(us_id >='0' && us_id <='9')
				e++;
			else
				f++;
		}
		if(c!=0 && d!=0 && e!=0 && f==0)
		{
			System.out.println(colour.green+"			USER_ID CREATED"+colour.def);
			USER_ID=user_id;
		}
		else
		{
			System.out.println(colour.red+colour.blink+"			INVALID USER ID , PLEASE TRY AGAIN"+colour.def);
			user_id();
		}
	}
	void password()
	{
		System.out.println(colour.skblue+"			CREATE YOUR PASSWORD"+colour.def);
		System.out.println(colour.red+colour.blink+"			It must contain 1 capital letter,number and special character"+colour.def);
		System.out.println();
		String password=sc.next();
		int passcode=password.length();
		int c=0,d=0,e=0,f=0;
		for(int i=(passcode-1);i>=0;i--)
		{
			char passCode=password.charAt(i);
			if(passCode >='A' && passCode <='Z')
				c++;
			else if(passCode >='a' && passCode <='z')
				d++;
			else if(passCode >='1' && passCode <='9')
				e++;
			else
				f++;
		}
		if(c!=0 && d!=0 && e!=0 && f!=0)
		{
			System.out.println(colour.green+"			PASSWORD CREATED\n\n"+colour.def);
			PASSWORD=password;
		}
		else
		{
			System.out.println(colour.red+colour.blink+"		YOU HAVE ENTERED WEAK PASSWORD , PLEASE TRY AGAIN"+colour.def);
			password();
		}
	}

	void login()
	{
		System.out.println();
		System.out.println();
		System.out.println(colour.skblue+"				1.LOGIN \n 				2.FORGOT USER ID"+colour.def);
		int logi=sc.nextInt();
		if(logi==1)
		{
			System.out.println();
			System.out.println(colour.yellow+"		<-------------------USER LOGIN------------------->\n"+colour.def);
			System.out.println(colour.skblue+"		<-----------------ENTER USERNAME----------------->"+colour.def);
			String name=sc.next();
			if((name.equals(USER_ID)) || (name .equals (user_id))){
					login1();
			}
			else
			{
				System.out.println(colour.red+colour.blink+"			WRONG PLEASE ENTER CORRECT USER_ID"+colour.def);
				login();
			}
		}
		else if(logi==2)
		{
			mobile1();
		}
		else
		{
			System.out.println(colour.red+colour.blink+"				INVALID CHOICE"+colour.def);
			login();
		}
	}
	void mobile1()
	{
		System.out.print(colour.skblue+"			ENTER YOUR REGISTRED MOBILE NUMBER"+colour.def);
			String mobi=sc.next();
			if(mobi .equals (MOBILE))
			{
				otp_verify();
				System.out.print(colour.green+"			YOUR USER ID : "+this.USER_ID+colour.def);
				login();
			}
			else
			{
				System.out.println(colour.red+colour.blink+"		INVALID MOBILE NUMBER PLEASE TRY AGAIN"+colour.def);
				mobile1();
			}
	}
	void login1(){
		System.out.println();
		System.out.println(colour.skblue+"				1.LOGIN \n 				2.FORGOT PASSWORD"+colour.def);
		int logi=sc.nextInt();
		if(logi==1)
		{
			System.out.println(colour.skblue+"		<-----------------ENTER PASSWORD----------------->"+colour.def);
			String pass=sc.next();
			if((pass.equals(PASSWORD)) || (pass .equals (password)))
			{
				otp_verify();
				System.out.println(colour.green+"			*********LOGIN SUCCESSFUL*********       "+colour.def);
				System.out.println();
				count++;
			}
			else
			{
				System.out.println(colour.red+colour.blink+"			WRONG PLEASE ENTER CORRECT PASSWORD"+colour.def);
				login1();
			}
		}
		else if(logi==2)
		{
			mobile();
		}
		else
		{
			System.out.println(colour.red+colour.blink+"				INVALID CHOICE"+colour.def);
			login1();
		}
	}
	void mobile()
	{
		System.out.print(colour.skblue+"			ENTER YOUR REGISTRED MOBILE NUMBER"+colour.def);
			String mobi=sc.next();
			if(mobi.equals (MOBILE))
			{
				otp_verify();
				System.out.print(colour.green+"			YOUR PASSWORD : "+this.password+colour.def);
				login1();
			}
			else
			{
				System.out.println(colour.red+colour.blink+"				INVALID MOBILE NUMBER"+colour.def);
				mobile();
			}
	}
}
interface nonveg
{
	int biriyanis();
	int staters();
	int familypacks();
	
}
interface veg
{
	int biriyanis();
	int staters();
	int familypacks();
}
interface drinks
{
	int cooldrinks();
	int Milkshakes();
}	
abstract class A extends colour implements nonveg
{
	static int price=0;
	static String items="";
	public int biriyanis()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("			BIRIYANI ITEMS...... ");
		System.out.println(colour.skblue);
		System.out.println("			1.Mutton Biryani------------Rs.250");
		System.out.println("			2.Chicken Biryani-----------Rs.200");
		System.out.println("			3.Chicken frypiece Biryari--Rs.220");
		System.out.println("			4.Mutton frypiese  Biryani--Rs.300");
		System.out.println("			5.Prawns Biryani------------Rs.200");
		System.out.println("				             ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price+=250;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity.... ");
			System.out.print("				     ");
			
			int n = User.sc.nextInt();
			
			price=n*price;	
			items=items+"\n				Mutton Biriyani			"+n+"*250="+price;	
		}
		else if(a==2)
		{
			price+=200;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");	
			System.out.print("				     ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken  Biryani		"+n+"*200="+price;	
		}
		else if(a==3)
		{
			price= price+220;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken frypiese biriyani	"+n+"*220="+price;			
		}
		else if(a==4)
		{
			price= price+300;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("			             ");
 
			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Mutton frypiese Biryani		"+n+"*300="+price;		
		}
		else if(a==5)
		{
			price= price+200;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				prawns biriyani			"+n+"*200="+price;			
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			biriyanis();
		}
		return price;
		
	}
	public int staters()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("				STARTERS ITEMS......");
		System.out.println(colour.skblue);
		System.out.println("				1.Chicken 65-------------Rs.150");
		System.out.println("				2.Chicken manchuriyan----Rs.180");
		System.out.println("				3.Chicken thandoori------Rs.300");
		System.out.println("				4.Chicken lollipop-------Rs.80" );
		System.out.println("				5.Chicken kabab----------Rs.150");
		System.out.println("				6.Fish fry---------------Rs.150");
		System.out.println("				7.Egg 65-----------------Rs.50 ");
		System.out.println("				8.Chicken majestic-------Rs.160");
		System.out.print("				           ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+150;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken 65			"+n+"*150="+price;	
			
		}
		else if(a==2)
		{
			price= price+180;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken manchuriyan		"+n+"*180="+price;	
		}
		else if(a==3)
		{
			price= price+300;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken thandoori		"+n+"*300="+price;	
		}
		else if(a==4)
		{
			price= price+80;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken lollipop       		"+n+"*80="+price;	
		}
		else if(a==5)
		{
			price= price+150;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken kabab    		"+n+"*150="+price;	
		}
		else if(a==6)
		{
			price= price+150;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Fish fry 	               "+n+"*150="+price;	
		}
		else if(a==7)
		{
			price= price+50;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Egg 65    		      	"+n+"*50="+price;	
		}
		else if(a==8)
		{
			price= price+160;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Chicken majestic		"+n+"*160="+price;	
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			staters();
		}
		return price;
	}
	public int familypacks()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("			      	FAMILYPACKS ITEMS.......");
		System.out.println(colour.skblue);
		System.out.println("				1.Chicken familypack------------400");
		System.out.println("				2.Mutton familypack-------------600");
		System.out.println("				3.Chicken familypack large------600");
		System.out.println("				4.Mutton familypack large-------900");
		System.out.print("			 	        ");
		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+400;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Chicken familypack		"+n+"*400="+price;		
		}
		else if(a==2)
		{
			price= price+600;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Mutton familypack		"+n+"*600="+price;	
		}
		else if(a==3)
		{
			price= price+600;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Chicken familypack large	"+n+"*600="+price;	
		}
		else if(a==4)
		{
			price= price+900;
			System.out.println(colour.red);
			System.out.println("				Enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Mutton familypack large		"+n+"*900="+price;	
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			familypacks();
		}
		return price;
	}
	
	
}
class B extends colour implements veg{
	static int price =0;
	static String items = "";
	public int biriyanis()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("				BIRIYANI ITEMS........ ");
		System.out.println(colour.skblue);
		System.out.println("				1.Veg Pulav-----------------Rs.305");
		System.out.println("				2.Paneer Pulav--------------Rs.345");
		System.out.println("				3.Veg Biryani---------------Rs.250");
		System.out.println("				4.Veg FriedRice--------------Rs.99");
		System.out.println("				5.Avakay Biryani----------- Rs.450");
		System.out.println("                            	6.Aloo Dum Biryani------------Rs.260");
		System.out.print("				             ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+305;
			System.out.println(colour.red);
			System.out.println("				enter the quantity.... ");
			System.out.print("				     ");
			
			int n = User.sc.nextInt();
			
			price=n*price;	
			items=items+"\n				Veg Pulav			"+n+"*305="+price;	
		}
		else if(a==2)
		{
			price= price+345;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");	
			System.out.print("				     ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Paneer Pulav			"+n+"*345="+price;	
		}
		else if(a==3)
		{
			price= price+250;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Veg Biryani			"+n+"*250="+price;			
		}
		else if(a==4)
		{
			price= price+99;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			             ");
 
			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Veg FriedRice			"+n+"*99="+price;		
		}
		else if(a==5)
		{
			price= price+450;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				Avakay Biryani			"+n+"*450="+price;			
		}
		else if(a==6)
		{
			price= price+260;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				Aloo Dum Biryani		"+n+"*260="+price;			
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			biriyanis();
		}
		return price;
	}
	public int staters()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("				STARTERS ITEMS....");
		System.out.println(colour.skblue);
		System.out.println("				1.Dragon Paneer-------------Rs.260");
		System.out.println("				2.Babycorn65----------------Rs.170");
		System.out.println("				3.Mushroom Manchurian-------Rs.240");
		System.out.println("				4.Paneer65 ---------------- Rs.150");
		System.out.println("				5.Kaju Veg------------------Rs.180");
		System.out.println("				6.Gobi Manchurian-----------Rs.140");
		System.out.println("				7.Pepper Mushroom---------- Rs.250");
		System.out.print("				           ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+260;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Dragon Paneer			"+n+"*260="+price;	
			
		}
		else if(a==2)
		{
			price= price+170;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Babycorn65			"+n+"*170="+price;	
		}
		else if(a==3)
		{
			price= price+240;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Mushroom Manchurian		"+n+"*240="+price;	
		}
		else if(a==4)
		{
			price= price+150;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n			 	     Paneer65       		"+n+"*150="+price;	
		}
		else if(a==5)
		{
			price= price+180;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				    Kaju Veg    		"+n+"*180="+price;	
		}
		else if(a==6)
		{
			price= price+140;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Gobi Manchurian         	"+n+"*140="+price;	
		}
		else if(a==7)
		{
			price= price+250;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				   ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Pepper Mushroom			"+n+"*250="+price;	
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			staters();
		}
		return price;	
	}
	public int familypacks()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("			      	FAMILYPACK ITEMS.........");
		System.out.println(colour.skblue);
		System.out.println("				1.Veg Biryani familypack----------------399");
		System.out.println("				2.Paneer Biryani familypack-------------580");
		System.out.println("				3.Ulavacharu Biryani familypack large---659");
		System.out.println("				4.Gongura Veg familypack----------------790");
		System.out.print("			 	        ");
		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+399;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Veg Biryani familypack		"+n+"*399="+price;		
		}
		else if(a==2)
		{
			price= price+580;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Paneer Biryani familypack	"+n+"*580="+price;	
		}
		else if(a==3)
		{
			price= price+659;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Ulavacharu Bir familypack large	"+n+"*659="+price;	
		}
		else if(a==4)
		{
			price= price+790;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			            ");

			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Gongura Veg familypack		"+n+"*790="+price;	
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			familypacks();
		}
		return price;
	}
}
class C extends colour implements drinks{
	static int price =0;
	static String items = "";
	public int cooldrinks()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("				COOL DRINKS ITEMS....... ");
		System.out.println(colour.skblue);
		System.out.println("				1.Sprite-----------------Rs.90");
		System.out.println("				2.Thumsup----------------Rs.120");
		System.out.println("				3.Marinda----------------Rs.70");
		System.out.println("				4.Pepsi------------------Rs.90");
		System.out.println("				5.Maaza------- ----------Rs.85");
		System.out.print("				             ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+90;
			System.out.println(colour.red);
			System.out.println("				enter the quantity.... ");
			System.out.print("				     ");
			
			int n = User.sc.nextInt();
			
			price=n*price;	
			items=items+"\n				Sprite				"+n+"*90="+price;	
		}
		else if(a==2)
		{
			price= price+120;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");	
			System.out.print("				     ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Thumsup				"+n+"*120="+price;	
		}
		else if(a==3)
		{
			price= price+70;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Marinda				"+n+"*70="+price;			
		}
		else if(a==4)
		{
			price= price+90;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			             ");
 
			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Pepsi				"+n+"*90="+price;		
		}
		else if(a==5)
		{
			price= price+85;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				Maaza				"+n+"*85="+price;			
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			cooldrinks();
		}
		return price;
	}

	public int Milkshakes()
	{
		price=0;
		System.out.println(colour.yellow);
		System.out.println("				LIST OF MILKSHAKES........");
		System.out.println(colour.skblue);
		System.out.println("				1.Oreo Milk Shake----------------->Rs.90");
		System.out.println("				2.Honey Mist Milk Shake----------->Rs.120");
		System.out.println("				3.Black current------------------->Rs.140");
		System.out.println("				4.Vanilla Milk shake-------------->Rs.120");
		System.out.println("				5.Chocolate Malt------------------>Rs.135");
		System.out.println("				6.Kit kat Shake------------------->Rs.140");
		System.out.print("				             ");

		int a = User.sc.nextInt();
		if(a==1)
		{
			price= price+90;
			System.out.println(colour.red);
			System.out.println("				enter the quantity.... ");
			System.out.print("				     ");
			
			int n = User.sc.nextInt();
			
			price=n*price;	
			items=items+"\n				Oreo Milk Shake			"+n+"*90="+price;	
		}
		else if(a==2)
		{
			price= price+120;
			System.out.println(colour.red);
			System.out.println("				enter the quantity.... ");	
			System.out.print("				     ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Honey Mist Milk Shake		"+n+"*120="+price;	
		}
		else if(a==3)
		{
			price= price+140;
			System.out.println(colour.red);
			System.out.println("				enter the quantity.... ");
			System.out.print("				    ");

			int n = User.sc.nextInt();
			price=n*price;
			items=items+"\n				Black current			"+n+"*140="+price;			
		}
		else if(a==4)
		{
			price= price+120;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");
			System.out.print("			             ");
 
			int n = User.sc.nextInt();
			price=n*price;	
			items=items+"\n				Vanilla Milk shake		"+n+"*120="+price;		
		}
		else if(a==5)
		{
			price= price+135;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				Chocolate Malt			"+n+"*135="+price;			
		}
		else if(a==6)
		{
			price= price+140;
			System.out.println(colour.red);
			System.out.println("				enter the quantity....");					
			System.out.print("				     ");

			int n = User.sc.nextInt();
			
			price=n*price;
			items=items+"\n				Kit kat Shake			"+n+"*140="+price;			
		}
		else
		{
			System.out.println(colour.red);
			System.out.print("			INVAID PLEASE ENTER CORRECT OPTION");
			Milkshakes();
		}
		return price;
	}
}
class User extends A
{
	static Scanner sc=new Scanner(System.in);
	static double bill=0;
	static User obj = new User();
	static B obj1 =new B();
	static C obj2 =new C();
	 double payments()
	{
		double pri=0.00;
		System.out.println(colour.yellow+"				CHOOSE THE PAYMENT TYPE:"+colour.def);
		System.out.println();
		System.out.println(colour.skblue+"				1.GOOGLE PAY");
		System.out.println("                            	2.PHONE  PAY");
		System.out.println("				3.PAYTM     ");
		int ch=sc.nextInt();
		if(ch>=1&&ch<=3)
		{
		System.out.println();
		System.out.println("				ENTER THE MOBILE NUMBER"+colour.def);
		long m=sc.nextLong();
		long a=1000000000;
		if(m>a)
		{
			System.out.println(colour.red);
			System.out.println(colour.blink);
			System.out.println();
			System.out.printf("%.2f",bill);
			System.out.println("				ENTER AMOUNT: ");
			System.out.println("			                 ");
			double pric= sc.nextDouble();
			pri=pric;
			System.out.println("				ENTER YOUR PIN"+colour.def);
			int pin=sc.nextInt();
		}
		else
		{
			System.out.println(colour.red+"				INVALID MOBILE NUMBER OR PIN");
			System.out.println("				  	TRY AGAIN         ");   
			payments();                     

		}
		}
		else
		{
			System.out.print("			INVALID PLEASE SELECT THE ONLY BELOW OPTION");
			payments();
		}
		return pri;

	}
	void bill()
	{
		double gst = bill*0.12;
		System.out.println(colour.skblue);
		System.out.println(colour.yellow+"				<<-------------------------------->>");
		System.out.println("					RESTUARENT BILL RECIEPT");
		System.out.println("				...................................."+colour.def);
		System.out.println(items+B.items+C.items);
		System.out.printf("				GST                     	+ %.2f\n",gst);

		System.out.println();
		System.out.println();
		System.out.println("				______________________________________________");
		System.out.println();
		System.out.printf("				TOTAL AMOUNT:............	 %.2f\n",(bill+gst));
		System.out.println("			        ______________________________________________");
		System.out.println("				\n\n\n");
		bill=bill+gst;
		System.out.println(colour.yellow+"				SELECT THE OPTION:");
		System.out.println(colour.blue+"				1.GO FOR PAYMENTS ");
		System.out.println("				2.CANCEL ORDER"+colour.blue);
		System.out.print("			                 ");

		int choice = sc.nextInt();
		if(choice==1)
		{
			if(payments()>=bill)
			{
				System.out.println(colour.green);
				//System.out.println(bill);
				System.out.println(" 					PAYMENT SUCCESSFUL");
				System.out.println();
				System.out.println(colour.skblue+"					ENTER YOUR ADDRESS"+colour.def);
				System.out.println();
				String add=sc.next();
				System.out.println(colour.yellow+"			    <<--CHOOSE THE OPTION------->>"+colour.def);
				System.out.println();
				System.out.println(colour.skblue+"				1.FAST DELIVERY");
				System.out.println("                    		2.NORMAL "+colour.def);
				int g=sc.nextInt();
				if(g==1){
						System.out.println();
						System.out.println(colour.green+"					JUST WAIT 10 MINUTES");
						System.out.println();
					}
					else
					{
						System.out.println("  		            		WAIT PROCESSING");
						System.out.println();
						System.out.println("					JUST WAIT 30 MINUTES");
						System.out.println();
					}
				System.out.println(colour.green+"			<-----------YOUR ORDER IS COMPLETED-------->");
				System.out.println();
				System.out.println();
				System.out.println("			<-------------------THANKS----------------->"+colour.def);
				System.exit(0);
			}
			else
			{	System.out.println(colour.red);
				System.out.println("			          XXXXXXXXXXXXXXXXX");
				System.out.println("			....PLEASE ENETER CORRECT AMOUNT....");
				bill=bill-gst;
				obj.bill();
			}
		}
		else
		{
			System.out.println(colour.green);
			System.out.println("			<------YOUR ORDER WAS CANCEL------>");
			System.out.println();
			System.out.println("				     ***THANKS***");
			System.exit(0);
		}
	}
		
	static void display()
	{
		System.out.println(colour.yellow+"			PLEASE SELECT"+colour.def);
		System.out.println(colour.skblue);
		System.out.println("				1.NON-VEG");
		System.out.println("				2.VEG");
		System.out.println("				3.DRINKS");
		System.out.print("		         	            ");

		int  choose= sc.nextInt();
		if(choose==1)
		{
			System.out.println(colour.yellow+"			PLEASE SELECT"+colour.def);
			System.out.println(colour.skblue);
			System.out.println("				1. BIRYANIS");
			System.out.println("				2. STARTERS");
			System.out.println("				3. FAMILYPACKS");
			System.out.print("			    	      ");
			int n = sc.nextInt();
		
			switch(n)
			{
				case 1 :bill= bill + obj.biriyanis();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER     ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("			    	     ");
					int a= User.sc.nextInt();
					if(a==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
				case 2 : bill = bill+obj.staters();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER     ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				     ");
					int x= User.sc.nextInt();
					if(x==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
				case 3 : bill+=obj.familypacks();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER      ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				     ");

					int y= User.sc.nextInt();
					if(y==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					
					break;
			}
		}

		if(choose==2)
		{
			System.out.println(colour.yellow+"			PLEASE SELECT"+colour.def);
			System.out.println(colour.skblue);
			System.out.println("				1. BIRIYANIS");
			System.out.println("				2. STARTERS");
			System.out.println("				3. FAMILY PACKS");
		        System.out.print("				     ");

			int n = sc.nextInt();
		
			switch(n)
			{
				case 1 :bill= bill + obj1.biriyanis();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER             ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				      ");

					int z= User.sc.nextInt();
					if(z==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
				case 2 : bill = bill+obj1.staters();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER             ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				    ");

					int d=sc.nextInt();
					if(d==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
				case 3 : bill=bill+obj1.familypacks();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER              ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				     ");

					int x= User.sc.nextInt();
					if(x==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					
					break;
				
			}
		}
		if(choose==3)
		{
			System.out.println(colour.yellow+"			PLEASE SELECT"+colour.def);
			System.out.println(colour.skblue);
			System.out.println("				1. COOL DRINKS");
			System.out.println("				2. MILKSHAKES");
			System.out.print("			    	      ");
			int n = sc.nextInt();
		
			switch(n)
			{
				case 1 :bill= bill + obj2.cooldrinks();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER     ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("			    	     ");
					int x= User.sc.nextInt();
					if(x==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
				case 2 : bill = bill+obj2.Milkshakes();
					System.out.println(colour.yellow);
					System.out.println("				1. CONTINUE FURTHER FOR MORE ORDER     ");
					System.out.println("				2. IF YOUR ORDER IS COMPLETE GO FOR PAYMENT ");
					System.out.print("				     ");
					int y= User.sc.nextInt();
					
					if(y==1)
					{
						display();
					
					}
					else
					{
						obj.bill();
					}
					break;
			}
		}
		else
			{
				display();
			}


	}
	//here we create object for to access the login class properties
	static login obj5=new login();
	static void home(){
		System.out.println(colour.yellow+"			_________________________________________");
		System.out.println();
		System.out.println("			<<-----WE HAVE BRANCHES IN HYDRABAD---->>");
		System.out.println("			_________________________________________");
		System.out.println();
		System.out.println("				PLEASE SELECT THE BRANCH"+colour.def);
		System.out.println();
		System.out.println(colour.skblue+"					1.L.B NAGAR");
		System.out.println("					2.DILSIKNAGAR");
		System.out.println("					3.S.R.NAGAR");
		System.out.println("					4.KPHB COLONY");
		System.out.println("					5.SECUNDERABAD");
		System.out.println("					6.CHARMINAR");
		System.out.println("					7.UPPAL");
		System.out.println("					8.BEGUMPET");
		System.out.println("					9.MADHAPUR");
		System.out.println("					10.HI TECH CITY");
		int p=login.sc.nextInt();
		if(p>0&&p<=10)
		{
			display();
		}
		else
		{
			System.out.println("			PLEASE ENTER THE BELOW OPTIONS ONLY"+colour.def);
			home();
		}
		}
	static String user_id="Sanjay1";
	static String password="Sanjay@1";
	public static void main(String[]args)
	{
		//static login obj1=new login();
		System.out.println();
		System.out.println(colour.yellow+"			__________________________________________");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("			        WELCOME TO MAGIC RESTAURANT");
		System.out.println();
		System.out.println();
		System.out.println("			__________________________________________"+colour.def);
		System.out.println();
		System.out.println();
		System.out.println(colour.skblue+"				1.REGISTRATION \n				2.LOGIN"+colour.def);
		int n=login.sc.nextInt();
		if(n==1)
		{
			obj5.register();
		}
		if(n==2)
		{
			System.out.println(colour.skblue+"				YOUR USER ID : "+user_id);
			System.out.println("				YOUR PASSWORD : "+password+colour.def);
			obj5.login();
		}
		if(n>=3&&n<=9)
		{
			System.exit(0);
		}
		System.out.println(colour.skblue+"				1.TO ORDER FOOD\n				2.EXIT"+colour.def);
		int s=login.sc.nextInt();
		if(s==1)
		{
		System.out.println(colour.yellow);
		home();
		}
		else
		{
			System.exit(0);
		}

	}
}