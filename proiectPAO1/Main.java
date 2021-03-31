package proiectPAO1;

import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ClasaServiciu servicii = new ClasaServiciu();
        DoctorsManagement doctorsManagement = new DoctorsManagement();
        NursesManagement nursesManagement = new NursesManagement();
        AppointmentsManagement appointmentsManagement = new AppointmentsManagement();
        for(int i=0;i<3;i++) {
            Doctor d = servicii.readDoctor();
            doctorsManagement.addDoctor(d);
        }
        for(int i=0;i<2;i++) {
            Nurse n = servicii.readNurse();
            nursesManagement.addNurse(n);
        }
        for(int i=0;i<2;i++) {
            Appointment p = servicii.readAppointment(doctorsManagement);
            appointmentsManagement.addAppointment(p);
        }
        //Sort the ArayList with doctors
        Collections.sort(doctorsManagement.getDoctors(), new DoctorComparator());

//        System.out.println("Enter an option \n " +
//                "1. Show doctors that work at the clinic \n " +
//                "2. Show doctors that have the following speciality \n" +
//                " 3. Show a doctor working hours: \n" +
//                " 4. Show nurses that work at the clinic \n" +
//                " 5. Add an appointment \n" +
//                " 6. Change an appointment \n" +
//                " 7. Delete an appointment  \n " +
//                "8. Print the appointments that were set\n " +
//                "9. Print appointments of a specific pacient" +
//                "\n 10. Add a prescription for a patient \n " +
//                "11. Show patients that have been to the clinic \n " +
//                "12. Show information about the clinic \n");

        doctorsManagement.showDoctors();

        System.out.println("Enter the speciality");
        String speciality = scanner.next();
        doctorsManagement.showDoctorsSpeciality(speciality);


        System.out.println("Enter the doctor's last name: ");
        String lastName = scanner.next();
        System.out.println("Enter the doctor's first name: ");
        String firstName = scanner.next();
        doctorsManagement.showDoctorWorkingHours(lastName, firstName);


        nursesManagement.showNurses();


        servicii.changeAppointment(appointmentsManagement);


        servicii.deleteAppointment(appointmentsManagement );


        appointmentsManagement.showAppointments();


        servicii.printAppointments(appointmentsManagement);


        servicii.writePrescription( appointmentsManagement);


        appointmentsManagement.showPatients();
        doctorsManagement.showClinicInfo();


    }
}
