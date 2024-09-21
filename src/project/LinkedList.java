// Mahmoud Riyad Mahmoud Dawoud


package project;

import java.io.*;
import java.util.Scanner;

public class LinkedList{
      
     static LinkedList list = new LinkedList();
     
    private class Node {

        String name;
        String address;
        int level;
        int age;
        double average;
        String graduatestudent;
        Node next;

        @Override
        public String toString() {
            return "Node{" + "name=" + name + ", address=" + address + ", level=" + level + ", age=" + age + ", average=" + average + ", graduatestudent=" + graduatestudent + ", next=" + next + '}';
        }     
    }

    static int count = 0;
    Node head;   
     
    
/*********************************************************************************************************/
    
    //#1
    public LinkedList append(LinkedList list, String name, String address, int level, int age, double  average , String graduatestudent) {
             
        
        Node new_node = new Node();
        new_node.next = null;
        new_node.name = name;
        new_node.address = address;
        new_node.level = level;
        new_node.age = age;
        new_node.average = average;
        new_node.graduatestudent = graduatestudent;
        
        if (list.head == null) {
            list.head = new_node;
            
        } else {
          
            Node ptr = list.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
          
            ptr.next = new_node;
        }
        return list;
    }
    
    
/*********************************************************************************************************/

    //#1
    public LinkedList First_Add(LinkedList list, String name, String address, int level, int age, double   average , String graduatestudent) {
      
           
        Node new_node = new Node();
        new_node.next = null;

        new_node.name = name;
        new_node.address = address;
        new_node.level = level;
        new_node.age = age;
        new_node.average = average;
        new_node.graduatestudent = graduatestudent;
        
        if (list.head == null) {
            list.head = new_node;
        } else {
            new_node.next = list.head;
            list.head = new_node;
            Node last = new_node;
        }
        return list;
    }
   
    
/*********************************************************************************************************/    
    
    //#1
    public void append_add(){
        
        
        Scanner in = new Scanner(System.in);   
        list.append(list, in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextDouble(),in.next());

        count++;
        
    }
    
    
/*********************************************************************************************************/
       
    //#1
    public void Add_First_Add(){
        

        Scanner in = new Scanner(System.in);

        list.First_Add(list, in.next(), in.next(), in.nextInt(), in.nextInt(), in.nextDouble(),in.next());

        count++;
    }
    
    
/*********************************************************************************************************/
    
    //#2
    public boolean  update(LinkedList list , int n ){

        
        Scanner in = new Scanner(System.in);
        boolean flage = true;
        int i = 0;
        Node tail = list.head;
        
           for (int j = 1; j <= count; j++) {
              
               if ( j == n ){
                 System.out.println("\n j is: "+j);
                 
                 System.out.println("{name , "+"+"+"address , "+"level , "+"age , "+"average , "+"graduatestudent  }"); 
                 
                   tail.name = in.next();
                   tail.address = in.next();
                   tail.level = in.nextInt();
                   tail.age = in.nextInt();
                   tail.average = in.nextDouble();
                   tail.graduatestudent = in.next();

                   tail = tail.next;    
                   return flage = true;
            }
           tail = tail.next;    
        }
        System.out.println("There is no data in the written index :( ");
        return false; 
    }

       
/*********************************************************************************************************/
    
    //#3
    public LinkedList delete(LinkedList list,String na ,int lev) {
        
        
        if (list.head.level == lev && list.head.name.equalsIgnoreCase(na)) {
            head = head.next;
        } else{
            Node curr = head;
        
            Node prev = null;
            
            while (curr != null && curr.level != lev ) {
                
                prev = curr;           
                curr = curr.next;                
            }
            prev.next = curr.next;
        }
        System.out.println("The deletion process has been completed successfully :) ");
        return list;      
    }


/*********************************************************************************************************/
        
    //#4 
    public boolean LinSearch(LinkedList list , int count,String name){
        

        boolean flage = true;
        int i = 0;
       
         Node ptr = list.head;
           for (int j = 0; j < count; j++) {
              
               if (name.equals(ptr.name)){
                 System.out.println("\n j is: "+j);
                 System.out.println("The name you searched for is found :)");     
                 ptr = ptr.next;
                 return flage = true;
           }      
          
           ptr = ptr.next;           
       }
         System.out.println("The name you searched for is Notfound :(");   
         return false;  
    }

    
/*********************************************************************************************************/    
    
     //#4     
    public boolean BinSearch(LinkedList list , int level) {
        
        int left = 0;
        int right = count - 1;
        int mid;
        
        while (left <= right) {
            Node re = list.head;   
            
            mid = (left + right) / 2;
            
            for (int i = mid; i > 0; i--) {
                re = re.next;
            }
            
            if (level > re.level) {
                left = mid + 1;
                
            } else if (level < re.level) {
                right = mid - 1;
                
            } else {            
                System.out.println(re.toString());
                return true;
            }
        }	
        System.out.println("There are no data :( ");
        return false;
    }

    
/*********************************************************************************************************/

    //#4    
    public String name(){
               
      Scanner in = new Scanner(System.in); 
      
      System.out.print("Enter the name:= ");
      String name = in.next();     
      LinSearch(list , count ,name);
    
      return name;
    }
    
    
/*********************************************************************************************************/ 
 
    //#5
    public LinkedList travers_show(LinkedList list) {
        
        Node currNode = list.head;
        System.out.println("LinkedList: ");
       
        while (currNode != null) {
            
            System.out.println("{"+currNode.name +" , "+currNode.address+" , "+currNode.level + " , "+currNode.age + " , "+currNode.average + " , "+currNode.graduatestudent + " }   ");
            
            currNode = currNode.next;
        }
        return list;
    }
    
    
/*********************************************************************************************************/     
    
    //#5
    public LinkedList GPAprint(){
        
    Node curr = list.head;
    
       while (curr != null) {
           
           if (curr.average > 90) {
                 System.out.println("{"+curr.name +" , "+curr.address+" , "+curr.level + " , "+curr.age + " , "+curr.average + " , "+curr.graduatestudent + " }   ");
               
           }
           curr = curr.next;
       }
       System.out.println("No data matching the value :( ");
       return list;
    }
    
    
/*********************************************************************************************************/ 

    //#5
    public LinkedList Addressprint(){
        
    Node cr = list.head;
    
       while (cr != null) {
           
           if (cr.address.matches("palestine") || cr.address.matches("gaza")) {
                 System.out.println("{"+cr.name +" , "+cr.address+" , "+cr.level + " , "+cr.age + " , "+cr.average + " , "+cr.graduatestudent + " }   ");
               
           }
           cr = cr.next;
       }
       System.out.println("No data matching the value :( ");
       return list;
    }

    
/*********************************************************************************************************/
   
    //#5
    public LinkedList Graduatestudent(){
        
    Node cr = list.head;
    
       while (cr != null) {
           
           if (cr.graduatestudent.matches("yes") || cr.graduatestudent.matches("YES")|| cr.graduatestudent.matches("Yes")) {
                 System.out.println("{"+cr.name +" , "+cr.address+" , "+cr.level + " , "+cr.age + " , "+cr.average + " , "+cr.graduatestudent + " }   ");
                 System.out.println("Goodbye, university :)");
           }
           cr = cr.next;
       }
       System.out.println("No data matching the value :( ");
       return list;
    }

    
/*********************************************************************************************************/

    //#6 
    public LinkedList bubbleSort(){
    

               for (int i = 0; i < count - 1; i++) { 
                   Node pt = list.head;              
                   Node la = pt.next;
                   for (int j = 0; j < count - i - 1; j++) {
               
                       if (pt.level > la.level) {
                           
                           String name = pt.name;
                           pt.name = la.name;
                           la.name = name;
                           
                           String address = pt.address;
                           pt.address = la.address;
                           la.address = address;
                           
                           int level = pt.level;
                           pt.level = la.level;
                           la.level = level;
                           
                           int age = pt.age;
                           pt.age = la.age;
                           la.age = age;
                           
                           double  average = pt.average;
                           pt.average = la.average;
                           la.average = average;
                           
                           String graduatestudent = pt.graduatestudent;
                           pt.graduatestudent = la.graduatestudent;
                           la.graduatestudent = graduatestudent;
                                            
                       }
                        pt = pt.next;      
                       la = la.next;                                     
                   }                   
              }        

    return list;
    }
    
    
/*********************************************************************************************************/   
   
    //#6 
    public LinkedList SelectSort(){
    
            Node pt = list.head;
               for (int i = 0; i < count - 1 && pt != null; i++) { 
                                
                   Node la = pt.next;
                   for (int j = 0; j < count - i - 1 && la != null; j++) {
               
                       if (pt.level > la.level) {
                           
                           String name = pt.name;
                           pt.name = la.name;
                           la.name = name;
                           
                           String address = pt.address;
                           pt.address = la.address;
                           la.address = address;
                           
                           int level = pt.level;
                           pt.level = la.level;
                           la.level = level;
                           
                           int age = pt.age;
                           pt.age = la.age;
                           la.age = age;
                           
                           double  average = pt.average;
                           pt.average = la.average;
                           la.average = average;
                           
                           String graduatestudent = pt.graduatestudent;
                           pt.graduatestudent = la.graduatestudent;
                           la.graduatestudent = graduatestudent;
                                            
                       }                          
                       la = la.next;                                     
                   }   
                   pt = pt.next;    
              }        

    return list;
    }

    
/*********************************************************************************************************/
 
    //#main
    public static void main(String[] args) {      
      
       
        Scanner in = new Scanner(System.in);       
        boolean str = true;
        
           
        System.out.println("---------------------------------------------");
        System.out.println("                   Welcome                   ");
        System.out.println("---------------------------------------------");

        
        while (str) {
            System.out.println("*************************");
            System.out.println("1- Add");
            System.out.println("2- Update");
            System.out.println("3- Delete");
            System.out.println("4- Search");
            System.out.println("5- Reports");
            System.out.println("6- Sort");
            System.out.println("7- Exit");
            System.out.println("Enter your choice : ");
            System.out.println("*************************");
        
            
            int choose = in.nextInt();

            switch (choose) {
                
            /******************************************************************/ 
                
                
                case 1:
                                       
                    while (str) {                       
                    System.out.println("-------------------------");
                    System.out.println("1- Add");
                    System.out.println("2- Add in first");
                    System.out.println("3- Press 3 to back...");
                    System.out.println("-------------------------");
                                       
                    int cho = in.nextInt();
                    
                    switch (cho) {            
                        
                        
                    /**********************************************************/    
                        
                        
                    case 1:   
                    
                    System.out.println("Enter the elements");
                    System.out.println("{ name , "+"address , "+"level , "+"age , "+"average , "+"graduatestudent }");                
                    list.append_add();     
                    
                    
                    break;
                    
                    
                    /**********************************************************/
                    
                    
                    case 2 :
                        
                    System.out.println("Enter the first element ");     
                    System.out.println("{ name , "+"address , "+"level , "+"age , "+"average , "+"graduatestudent }"); 
                    list.Add_First_Add();
                    
                    break;
                    
                    
                    /**********************************************************/
             
                    
                    case 3 :
                        
                    boolean y = false;
                    break;       
                    
                    }
                     break;
                    }
                   break;

                   
            /******************************************************************/    
                    
                    
                case 2:
                    
                    System.out.print("Enter index :"); 
                    list.update(list, in.nextInt());
                  
                    break;
                    
                    
            /******************************************************************/      
                    
                       
                case 3:
                    
                    System.out.println("Enter the name and level of the student : ");
                    list.delete(list,in.next(),in.nextInt());
                    count --;
                    //System.out.println("count : "+count);
                    
                    break;
                          
                    
            /******************************************************************/  
                    
                    
                case 4:                   
                    
                      while (str) {                       
                    System.out.println("-------------------------");
                    System.out.println("1- Sequential Search");
                    System.out.println("2- Binary Search");
                    System.out.println("3- Press 3 to back...");
                    System.out.println("-------------------------");
                    
                    int c = in.nextInt();
                    
                    switch (c) {
                        
                        case 1 :
                                                          
                            list.name();
                            
                            break;
                            
                       /*******************************************************/ 
                            
                        case 2 :
                            
                            System.out.print("Enter the number level := ");
                            int level = in.nextInt();                                                   
                            System.out.println(list.BinSearch(list , level));
                            
                            break;
                            
                       /*******************************************************/   
                            
                        case 3 :
                              
                            boolean y = false;
                         
                            break;       
   
                       /*******************************************************/ 
                    }
                    break;
                    }   
                    break;
                  
             
            /******************************************************************/   
     
                case 5:
                    
                    
                    boolean st = true;
                     while (st) {                       
                    System.out.println("-------------------------");
                    System.out.println("1- Show all students");
                    System.out.println("2- Display  students information with GPA>90 ");
                    System.out.println("3- Show  students lives in a specific address ");
                    System.out.println("4- Show graduated students");
                    System.out.println("5- Show Size");                       
                    System.out.println("-------------------------");
                    
                    int w = in.nextInt();
                    
                    switch (w) {
                        
                    
                        case 1:     
                            
                            list.travers_show(list);
                            break;
                            
                       /*******************************************************/     
                            
                        case 2:
                            
                            list.GPAprint();
                            break;
                            
                       /*******************************************************/     
                        case 3:
                            
                            list.Addressprint();
                            break;
                            
                        /*******************************************************/    
                            
                        case 4:
                            
                            list.Addressprint();
                            break;
                            
                        /*******************************************************/    
                            
                        case 5:
                            
                            System.out.println("size:= "+count);
                            break;
                            
                        /*******************************************************/    
                            
                    }
                    break;
                    }
                    break;
                    
            /******************************************************************/
                    
                    
                case 6:
                 
                      
                     boolean std = true;
                     
                     while (std) {                       
                    System.out.println("-------------------------");
                    System.out.println("1- Bubble Sort");
                    System.out.println("2- Select Sort");
                    System.out.println("3- Press 3 to back...");
                    System.out.println("-------------------------");
                    
                    
                    System.out.println("PLEASE SELECT:=");
                    int w = in.nextInt();
                    
                    switch (w) {
                   
                        case 1 :
                            
                            list.bubbleSort();
                            
                            break;
                            
                       /*******************************************************/
                            
                        case 2 :
                            
                            list.SelectSort();
                            
                            break;
                            
                       /*******************************************************/
                            
                        case 3 :
                                                
                            boolean y = false; 
                            
                            break;   
                            
                       /*******************************************************/   
                            
                    }      
                    break;
                    }
                    break;
                  
            /******************************************************************/  
                    
                    
                case 7:
                    
                    System.out.println("Exit");
                    System.exit(0);
                    
                    break; 
        
        }}}}
/*******************************************************************************/    
    

// Mahmoud Riyad Mahmoud Dawoud

