import java.util.Scanner;

import org.omg.PortableInterceptor.SUCCESSFUL;


public class Bankers {

    public static Scanner sc=new Scanner(System.in);
    public static int n;
    private int allocated[][];
    private int max[][];
    private int available[];   
    private int work[][];
    private int need[][];
    private int sequence[];
    private String sucess[];

    public Bankers(int n) {
        // TODO Auto-generated constructor stub
        allocated=new int[n+1][3];
        max=new int[n+1][3];
        available=new int[3];
        work=new int[n+5][3];
        need=new int[n+1][3];
        sequence=new int[n+5];
        sucess=new String[n];
        for(int i=0;i<n;i++){
            sucess[i]="F";
        }
    }

    private void getMatrix(int n) {
        int i,j;
        System.out.println("Enter Allocated Matrix :");
        for(i=0;i<n;i++){
            for(j=0;j<3;j++){
                allocated[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Max Matrix :");
        for(i=0;i<n;i++){
            for(j=0;j<3;j++){
                max[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter Available Matrix :");
        for(i=0;i<3;i++){

            available[i]=sc.nextInt();
            work[0][i]=available[i];
        }
    }

    private void safety(int n){

        int i,j,k,m,l,flag;
        for(i=0;i<n;i++){
            for(j=0;j<3;j++){
                need[i][j]=max[i][j]-allocated[i][j];
            }
        }

        i=0;
        j=0;
        l=0;
        k=0;
        m=0;
        while(l<(2*n)){
            flag=0;

            if(sucess[i].equals("T"))
                flag=1;

            for(j=0;j<3;j++){
                if(need[i][j]>work[k][j]){
                    flag=1;   
                }
            }   

            if(flag==0){
                for(j=0;j<3;j++){
                    work[k+1][j]=work[k][j]+allocated[i][j];
                }
                k++;
                sucess[i]="T";
                sequence[m++]=i;
            }
            i=(i+1)%n;
            l++;

        }

    }

    private void displayMatrix(int n){
        System.out.println("Allocated Matrix :");
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(allocated[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
       
        System.out.println("Max Matrix :");
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(max[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
       
        System.out.println("Available Matrix :");
        for(int i=0;i<3;i++){

            System.out.print(available[i]);
        }
        System.out.println("\n");

        System.out.println("Need Matrix :");
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                System.out.print(need[i][j]);
            }
            System.out.println();
        }   
        System.out.println("\n");
       
        System.out.println("Work  Matrix :");
        for(int i=0;i<(n+1);i++){
            for(int j=0;j<3;j++){
                System.out.print(work[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");
       
        System.out.print("Safe Sequence : < ");
        for(int i=0;i<n;i++){
            System.out.print("P"+sequence[i]+" , ");
        }
        System.out.print(" >");
        System.out.println("\n");
    }
    public static void main(String[] args) {

        System.out.println("Enter No. of Process :");
        n=sc.nextInt();
        Bankers b1=new Bankers(n);
        System.out.println("No. of Resources Used : 3");
        b1.getMatrix(n);
        b1.safety(n);
        b1.displayMatrix(n);

    }
}


