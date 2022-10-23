package ebebek.first.pkgcase;

import java.util.Scanner;

/**
 *
 * @author deniz
 */

class Employee {

    public String name ;
    public static float salary ;
    public static int workHours;
    public static int hireYear;
    //public float tax;
    public Employee(String name, float salary, int workHours, int hireYear) {
        
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
     //   this.tax = tax;
    }

    public static float tax(float tax) {
        //Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
        //Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
        if (salary > 1000) {
            tax = (float) (salary * 0.03);
           
        } else {
            tax = 0;
         
        }
        return tax;
    }

    public static int bonus(int bonus) {
        //Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
        if (workHours > 40) {
            bonus = (workHours - 40) * 30;
           
           
        } else {
            bonus = 0;
            
        }
        return bonus;
    }

    public static float raiseSalary(float raiseSalary) {
        //Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
        //Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
        //Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
        //Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
        
        // 0-10,10-20,20+ olarak ele alınmıştır
        
        if ((2021 - hireYear) < 10) {
            raiseSalary = (float) (salary * 0.05);
            

        } else if ((2021 - hireYear) < 20) {
            raiseSalary = (float) (salary * 0.1);
           
        } else {
            raiseSalary = (float) (salary * 0.15);
            
        }
        return raiseSalary;
        
    }

    public String toString() {//overriding the toString() method  
        
        Employee emp =new Employee(name, salary, workHours, hireYear);
        
        float vergivebonuslarlamaas=(salary-emp.tax(salary)+emp.bonus(workHours));
        float toplammaas =(salary-emp.tax(salary)+emp.bonus(workHours)+emp.raiseSalary(hireYear));

        System.out.println("Adı :"              +name);
        System.out.println("Maaşı :"            +salary);
        System.out.println("Çalışma Saati :"    +workHours);
        System.out.println("Başlangıç Yılı :"   +hireYear);
        System.out.println("Vergi:"+emp.tax(salary));
        System.out.println("Bonus:"+emp.bonus(workHours));
        System.out.println("Maaş Artışı:"+emp.raiseSalary(hireYear));
        
        System.out.println("Vergi ve Bonuslar ile birlikte maaş :"+vergivebonuslarlamaas);
        System.out.println("Toplammaaş :"+toplammaas);
        
        
        return name + salary + workHours + hireYear;
        
    }

}

public class EbebekFirstCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        // TODO code application logic heres
        Employee e = new Employee("mehmet", (float) 2000.0, 45, 1985);
        e.toString();

        
    }

}
