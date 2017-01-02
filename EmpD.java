import java.util.Scanner;
abstract class Employee {

	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	
	int paid_leave, sick_leave, casual_leave,no_of_leaves;
	double basic, hra,pf,t;
	
	abstract int calculate_balance_leaves();
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	abstract void calculate_salary();
	abstract void details();
	abstract void print_leave_details();
	

}

class PermanentEmp extends Employee
{
	
	Scanner obj = new Scanner(System.in);
	@Override
	void details()
	{
		System.out.println("Enter Employee details.");
		System.out.println("Enter empid.");
		empId = obj.nextInt();
		System.out.println("Enter the name of the employee.");
		empName = obj.next();
	}
	@Override
	void print_leave_details()
	{
		System.out.println("No. of paid leaves taken.");
		paid_leave = obj.nextInt();
		System.out.println("No. of sick leaves taken.");
		sick_leave = obj.nextInt();
		System.out.println("No. of casual leaves taken.");
		casual_leave = obj.nextInt();
	}
	@Override
	int calculate_balance_leaves() {
		// TODO Auto-generated method stub
		System.out.println("Total no. of leaves taken : "+(paid_leave+sick_leave+casual_leave));
		total_leaves = (paid_leave+sick_leave+casual_leave);
		no_of_leaves = 22 - total_leaves;
		if(no_of_leaves>0)
		System.out.println("No. of leaves left are "+no_of_leaves);
		else 
		System.out.println("We are sorry, there are no leaves available for you.");
		return no_of_leaves;
	}
	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		if (no_of_leaves>0)
		return true;
		else
		return	false;
	}
	@Override
	void calculate_salary() {
		// TODO Auto-generated method stub
		System.out.println("Enter basic salary of the employee.");
		basic = obj.nextDouble();
		pf = 0.12*basic;
		hra = 0.5*basic;
		t=basic+hra;
		total_salary = t-pf;
		System.out.println("Salary of the employee is "+total_salary);
	}
	
}
class TemporaryEmp extends Employee
{
	Scanner obj1 = new Scanner(System.in);
	@Override
	void details()
	{
		System.out.println("Enter Employee details.");
		System.out.println("Enter empid.");
		empId = obj1.nextInt();
		System.out.println("Enter the name of the employee.");
		empName = obj1.next();
	}
	@Override
	void print_leave_details()
	{
		System.out.println("No. of paid leaves taken.");
		paid_leave = obj1.nextInt();
		System.out.println("No. of sick leaves taken.");
		sick_leave = obj1.nextInt();
		System.out.println("No. of casual leaves taken.");
		casual_leave = obj1.nextInt();
	}
	@Override
	int calculate_balance_leaves() {
		// TODO Auto-generated method stub
		System.out.println("Total no. of leaves taken : "+(paid_leave+sick_leave+casual_leave));
		total_leaves = (paid_leave+sick_leave+casual_leave);
		no_of_leaves = 17 - total_leaves;
		if(no_of_leaves>0)
		System.out.println("No. of leaves left are "+no_of_leaves);
		else 
		System.out.println("There are no leaves available for you.");
		return no_of_leaves;
		
	}

	@Override
	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		if (no_of_leaves>0)
			return true;
			else
			return	false;
	}

	@Override
	void calculate_salary() {
		// TODO Auto-generated method stub
		System.out.println("Enter basic salary of the employee.");
		basic = obj1.nextDouble();
		pf = 0.12*basic;
		hra = 0.5*basic;
		t=basic+hra;
		total_salary = t-pf;
		System.out.println("Salary of the employee is "+total_salary);
	}
	void calculate_salaryy()
	{
		System.out.println("Enter basic salary of the employee.");
		basic = obj1.nextDouble();
		pf = 0.12*basic;
		hra = 0.5*basic;
		t=basic+hra;
		total_salary = t-pf-0.2*total_leaves;
		System.out.println("Your salary is "+total_salary);
	}
	
}
class EmpD
{
	public static void main(String args[])
	{
		PermanentEmp p = new PermanentEmp();
		System.out.println("P E R M A N E N T    E M P L O Y E E .");
		p.details();
		p.print_leave_details();
		int no_of_leaves = p.calculate_balance_leaves();
		p.avail_leave(no_of_leaves, 't');
		p.calculate_salary();
		
		TemporaryEmp w = new TemporaryEmp();
		System.out.println("\nT E M P O R A R Y    E M P L O Y E E .");
		w.details();
		w.print_leave_details();
		int no_of_leaves12 = w.calculate_balance_leaves();
		boolean b = w.avail_leave(no_of_leaves12, 'e');
		if ( b == true)
		{
		w.calculate_salary();
		}
		else
		{
		System.out.println("We are sorry to say that you took leaves out of the criteria so there will be 20% deduction in your salary this time.");
		w.calculate_salaryy();
		}
	}
}