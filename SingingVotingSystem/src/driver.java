import Client.Administrator;
import Client.SingerBooth;
import Client.VoterBooth;
import Client.VotingClient;
import Entity.*;
import adt.*;

import java.util.Objects;
import java.util.Scanner;

public class driver {
    public static void clearScreen(){
        for(int i = 0 ; i < 40; i++){
            System.out.println("\n");
        }
    }
    public static void Menu(){

        System.out.println("=====================================================");
        System.out.println("************** Singing Voting System ****************");
        System.out.println("=====================================================");
        System.out.println("                 1.     Voter                         ");
        System.out.println("                 2.     Singer                        ");
        System.out.println("                 3.     Admin                         ");
        System.out.println("                 4.     Exit                          ");
        System.out.println("=====================================================");

    }

    public static void VoterMenu(){

        System.out.println("=====================================================");
        System.out.println("******************* Voter Menu **********************");
        System.out.println("=====================================================");
        System.out.println("                 1.   Register                        ");
        System.out.println("                 2.    Login                          ");
        System.out.println("                 3.    Back                           ");
        System.out.println("=====================================================");

    }

    public static void VoterNestedMenu(){

        System.out.println("=====================================================");
        System.out.println("******************* Voter Action ********************");
        System.out.println("=====================================================");
        System.out.println("                1. Candidate Profile                  ");
        System.out.println("                2. Search Candidate Result            ");
        System.out.println("                3.  Delete Account                    ");
        System.out.println("                4.    Back                            ");
        System.out.println("=====================================================");

    }

    public static void SingerMenu(){

        System.out.println("=====================================================");
        System.out.println("******************* Singer Menu **********************");
        System.out.println("=====================================================");
        System.out.println("                 1.    Login                          ");
        System.out.println("                 2.    Back                           ");
        System.out.println("=====================================================");

    }

    public static void SingerNestedMenu(){

        System.out.println("=====================================================");
        System.out.println("******************* Singer Action ********************");
        System.out.println("=====================================================");
        System.out.println("                 1.  Edit Info                        ");
        System.out.println("                 2. Search Singer                     ");
        System.out.println("                 3. Show all Song                     ");
        System.out.println("                 4.    Back                           ");
        System.out.println("=====================================================");

    }

    public static void AdminMenu(){

        System.out.println("=====================================================");
        System.out.println("******************** Admin Menu **********************");
        System.out.println("=====================================================");
        System.out.println("                 1.    Login                          ");
        System.out.println("                 2.    Back                           ");
        System.out.println("=====================================================");

    }

    public static void AdminNestedMenu(){

        System.out.println("=====================================================");
        System.out.println("******************** ADMIN PAGE *********************");
        System.out.println("=====================================================");
        System.out.println("             1.  Delete Candidate                     ");
        System.out.println("             2.  Insert Candidate                     ");
        System.out.println("             3. Generate Result Report                ");
        System.out.println("             4.  Show all the Voters                  ");
        System.out.println("             5.   Search Admins                       ");
        System.out.println("             6.  Show Admins' Events                  ");
        System.out.println("             7.  Show Overall Vote History            ");
        System.out.println("             8.         Back                          ");
        System.out.println("=====================================================");

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Validation check
        boolean cont = true;
        // Initialize ADT ===============================================================================================
        DoublyLinkListInterface<Voter> voterList = new DoublyLinkList<>();
        DoublyLinkListInterface<VotingRecorder> votingList = new DoublyLinkList<>();
        HashMapInterface<String, Singer> singerList = new MyHashMap<>();
        AVLTreeInterface<Admin> adminList = new AVLTree<>();
        AVLTreeInterface<Event> eventList = new AVLTree<>();
                // ==============================================================================================================

        // Insert Dummy Data into list for Testing purposes ========================================================================================================================
        Singer SingerDetails1 = new Singer("S001", "James", "abc001", "010101-01-0101", "Male", "22");
        SingerDetails1.addSong("S1", "Bohemian Rhapsody", "Rock", "Queen");
        singerList.put(SingerDetails1.getId(), SingerDetails1);

        Singer SingerDetails2 = new Singer("S002", "Jimmy", "abc002", "000601-01-0101", "Male", "23");
        SingerDetails2.addSong("S2", "Stairway to Heaven", "Rock", "Led Zeppelin");
        singerList.put(SingerDetails2.getId(), SingerDetails2);

        Singer SingerDetails3 = new Singer("S003", "Rebeca", "abc003", "991230-01-0101", "Female", "24");
        SingerDetails3.addSong("S3", "Smells Like Teen Spirit", "Grunge", "Nirvana");
        singerList.put(SingerDetails3.getId(), SingerDetails3);

        Singer SingerDetails4 = new Singer("S004", "Alexandra", "abc004", "020710-01-0101", "Female", "21");
        SingerDetails4.addSong("S4", "Billie Jean", "Pop", "Michael Jackson");
        singerList.put(SingerDetails4.getId(), SingerDetails4);

        Singer SingerDetails5 = new Singer("S005", "Albert", "abc005", "970620-01-0101", "Male", "26");
        SingerDetails5.addSong("S5", "Hey Jude", "Rock", "The Beatles");
        singerList.put(SingerDetails5.getId(), SingerDetails5);


        Admin Adminlist1 = new Admin("21WMR12518", "abc0710", "BOO");
        Admin Adminlist2 = new Admin("21WMR12521", "abc1121", "JW");
        Admin Adminlist3 = new Admin("21WMR12541", "abc1119", "TM");
        Admin Adminlist4 = new Admin("21WMR12547", "abc0930", "JJ");

        Event event1 = new Event("Music Festival", "12/01/2023", "Central Park");
        Event event2 = new Event("Concert", "12/02/2023", "Madison Square Garden");
        Event event3 = new Event("TARUC concert", "12/03/2023", "TARUMT");
        Event event4 = new Event("Malaysia International Gastronomy Festival ", "12/04/2023", "Perak");
        Event event5 = new Event("Cameron Highlands Tea Festival", "12/05/2023", "Cameron Highlands");
        Event event6 = new Event("Royal Belum Rainforest Music Festival ", "12/06/2023", "Madison Square Garden");
        Event event7 = new Event("Penang Durian Festival ", "12/07/2023", "Penang");
        Event event8 = new Event("Kota Kinabalu Food Festival", "12/08/2023", "Kota Kinabalu");

        Adminlist1.addEvent(event1);
        Adminlist1.addEvent(event2);
        Adminlist2.addEvent(event3);
        Adminlist2.addEvent(event4);
        Adminlist3.addEvent(event5);
        Adminlist3.addEvent(event6);
        Adminlist4.addEvent(event7);
        Adminlist4.addEvent(event8);

        eventList.insert(event1);
        eventList.insert(event2);
        eventList.insert(event3);
        eventList.insert(event4);
        eventList.insert(event5);
        eventList.insert(event6);
        eventList.insert(event7);
        eventList.insert(event8);

        adminList.insert(Adminlist1);
        adminList.insert(Adminlist2);
        adminList.insert(Adminlist3);
        adminList.insert(Adminlist4);

        VoterBooth voterBooth = new VoterBooth();
        SingerBooth singerBooth = new SingerBooth(singerList);
        VotingClient votingClient = new VotingClient(singerList);
        Administrator administrator = new Administrator();


        // ======================================================================================================================================================================

        while (cont) {

            boolean validVoter = true;
            boolean validUser = true;

            do {
                Menu();
                System.out.println("Enter Your Option :");
                String MenuOption = sc.nextLine();
                if (MenuOption.equals("1")){
                    // Voter Menu ================================================================================================================================================1
                    do {
                        VoterMenu();
                        System.out.println("Enter Your Option :");
                        String VoterOption = sc.nextLine();

                        if (VoterOption.equals("1")){
                            // Input information for register purpose -----------------------------------
                            voterBooth.register(voterList);
                            voterList.sort();

                            for (int i = 1; i <= voterList.size(); i++){
                                System.out.println("voter list sequence" +voterList.getEntry(i).getStudentID());
                            }

                            // Finish Register ----------------------------------------------------------
                        } else if (VoterOption.equals("2")) {
                            // Input information for Login purposes -------------------------------------
                            Voter voter = voterBooth.login(voterList);

                            boolean VldCast = true;
                            boolean validVA = true;

                            do {
                                // Allow voter to choose with his wish ========================================================
                                VoterNestedMenu();
                                System.out.println("Enter Your Option : ");
                                String OptionVA = sc.nextLine();
                                VotingRecorder temp = null;

                                if (OptionVA.equals("1")){
                                    do {
                                        // Display Singer List to let user vote for =======================================
                                        System.out.println("Cast Vote");
                                        System.out.println("1. Cast your vote");
                                        System.out.println("2. Update your vote");


                                        if(voter.getVoteHistoryList().size() != 0){
                                            System.out.println("==================================");
                                            System.out.println("          H I S T O R Y");
                                            System.out.println("===================================");
                                            for(int i = 1; i <= voter.getVoteHistoryList().size(); i++){
                                                System.out.println("You have voted for: " + voter.getVoteHistoryList().getEntry(i).getSingerVoted());
                                            }
                                            System.out.println("=======================================");
                                        }

                                        String choiceVote = sc.nextLine();
                                        if (choiceVote.equals("1")){
                                            singerBooth.DisplaySinger(singerList);
                                            temp = voterBooth.castVote(voter, singerList);
                                            votingList.add(temp);
                                            VldCast = false;
                                            validVA = true;

                                        }else if (choiceVote.equals("2") ){
                                            Singer editSinger = null;
                                            System.out.println("Please enter the singer you want to vote now");
                                            String singerID = sc.nextLine();
                                            if(voter.getVote()){
                                                if (singerList.containsKey(singerID)){
                                                    editSinger = singerList.get(singerID);
                                                }
                                                VotingRecorder tempVote = votingClient.editVote(voter, editSinger, votingList);

                                                for(int i = 1; i <= votingList.size(); i++){
                                                    if(votingList.getEntry(i).getVoter().getStudentID().compareTo(voter.getStudentID()) == 0){
                                                        VotingHistory voteHistory = new VotingHistory(votingList.getEntry(i).getSinger().getName());
                                                        DeleteHistory deleteHistory = new DeleteHistory(votingList.getEntry(i).getVoter().getName(),votingList.getEntry(i).getSinger().getName());
                                                        voter.addVoteHistory(voteHistory);
                                                        VotingRecorder.addVoteHistory(deleteHistory);
                                                        votingList.remove(votingList.getEntry(i));
                                                    }
                                                }

                                                votingList.add(tempVote);
                                                System.out.println("Now you have changed to " + votingList.getEntry(1).getSinger().getName());
                                                VldCast = false;
                                            }else{
                                                System.out.println("You have not vote yet! Please vote before edit vote");
                                            }
                                            validUser = true;

                                        }else{
                                            System.out.println("Invalid Choice!");

                                        }

                                        //votingClient.displayCurrentResult(singerList, votingList);

                                    } while (VldCast);


                                } else if (OptionVA.equals("2")) {
                                    // Display current result
                                    System.out.println("VA" + votingList.size());
                                    System.out.println("VA" + votingList.getEntry(1).getSinger().getName());
                                    singerBooth.DisplaySinger(singerList);
                                    System.out.println("Enter [SingerID] to see all the candidate results !\n");
                                    System.out.println("Enter ANYTHING to back to the Main Menu !\n");
                                    String resultInput = sc.nextLine();
                                    resultInput = resultInput.toUpperCase();

                                    if (singerList.containsKey(resultInput)) {
                                        // search for specific singer Vote


                                        votingClient.searchSingerVote(resultInput, singerList, votingList);
                                        System.out.println("Enter [EXIT] to exit !");
                                        System.out.println("Enter ANYTHING to back to the previous page !");
                                        String afterCurrrent = sc.nextLine();
                                        afterCurrrent.toUpperCase();

                                        if (afterCurrrent.equals("EXIT")){
                                            System.exit(0);
                                        }else {
                                            validUser = false;
                                        }

                                    } else {
                                        System.out.println("Enter a valid ID !");
                                        validUser = false;
                                    }

                                } else if (OptionVA.equals("3")){
                                    // allow user to delete it account
                                    votingList = voterBooth.deleteAccount(voter, votingList);


                                } else if (OptionVA.equals("4")) {
                                    validVA = false;



                                } else {
                                    System.out.println("Invalid Option !!!");
                                    validUser = false;
                                }


                            } while(validVA);

                        } else if (VoterOption.equals("3")) {
                            validVoter = false;
                        } else {
                            System.out.println("Wrong Input, Please Enter Again !\n");
                            validVoter = true;
                        }

                    } while(validVoter);
                // Voter end =====================================================================================================================================


                // Singer Menu ====================================================================================================================================
                } else if (MenuOption.equals("2")) {
                    boolean validSinger = true;
                    boolean validSA = false;

                    do {
                        // Singer Menu
                        // Input to select Login or back ----------------------------------------------
                        SingerMenu();
                        System.out.println("Select Your Option : ");
                        String SingerOp = sc.nextLine();

                        // If user enter 1 for Login --------------------------------------------------
                        if (SingerOp.equals("1")){
                            // User input singer Id
                            Singer singer = singerBooth.login(singerList);

                            if (singer != null) {
                                // Successfully login
                                do {
                                    // Singer Action Menu -----------------------------------------------------------------
                                    SingerNestedMenu();
                                    System.out.println("Select Your Option : ");
                                    String SAOption = sc.nextLine();

                                    // Singer 1: Edit Info --------------------------------------------------------------
                                    if (SAOption.equals("1")) {
                                        singerBooth.editSingerInfo(singer.getId());
                                        validSA = true;

                                    } else if (SAOption.equals("2")) {
                                        // Singer 2: Search Singer ------------------------------------------------------------
                                        singerBooth.DisplaySinger(singerList);
                                        System.out.print("Enter Singer ID: ");
                                        String searchSingerId = sc.nextLine();
                                        singerBooth.searchSingerById(searchSingerId);
                                        validSinger = false;

                                    } else if (SAOption.equals("3")){
                                        // Singer 4: Show all the Song with the Singer
                                        singerBooth.displayAllSingerSong(singerList);
                                        System.out.println("Enter Any key to continue !");
                                        String showSong = sc.nextLine();
                                        if (showSong != null){
                                            validSinger = false;
                                        }
                                    }else if (SAOption.equals("4")) {
                                        // Singer 3: Logout -------------------------------------------------------------------
                                        validSinger = false;
                                        validSA = true;
                                    } else {
                                        // Validation for when user types in invalid option -----------------------------------
                                        System.out.println("Please Enter Valid Option !");
                                        validSinger = false;
                                    }
                                } while (!validSA);
                                    // ========================================================================================
                            } else {
                                validSinger = false;
                                   // -----------------------------------------------------------------------------------------
                            }
                        } else if (SingerOp.equals("2")) {
                            // If user choose back instead of login -----------------------------------------------------------
                            break;
                        } else {
                            System.out.println("Please Enter Valid Option !");
                        }
                    } while (!validSinger);
                    // ========================================================================================================

                } else if (MenuOption.equals("3")) {

                    boolean vldAdminLog = true;

                    do {
                        //Admin Menu
                        AdminMenu();
                        System.out.println("Select Your Option : ");
                        String AdLoginOpt = sc.nextLine();

                        if (AdLoginOpt.equals("1")) {

                            Admin admin = administrator.login(adminList);

                            boolean validAdmin = true;

                            if (admin != null) {
                                // Successfully login
                                do {
                                    // Admin Action Menu -----------------------------------------------------------------
                                    AdminNestedMenu();
                                    System.out.println("Select Your Option : ");
                                    String AdminOp = sc.nextLine();

                                    // Admin 1: Edit Info --------------------------------------------------------------
                                    if (AdminOp.equals("1")) {

                                        boolean vldSingerID = true;
                                        do {
                                            singerBooth.DisplaySinger(singerList);
                                            System.out.println("Enter the Singer ID to remove : ");
                                            String removeID = sc.nextLine();
                                            if (singerList.containsKey(removeID)) {
                                                singerBooth.removeSinger(singerList, removeID);
                                                System.out.println("You have removed " + removeID + " successfully !");
                                                vldSingerID = false;

                                            } else {
                                                System.out.println("Please enter a valid Id !");
                                            }
                                        } while (vldSingerID);

                                    } else if (AdminOp.equals("2")) {
                                        // Admin 2: Add Singer ------------------------------------------------------------
                                        singerBooth.addSinger(singerList);
                                        validAdmin = true;

                                    } else if (AdminOp.equals("3")) {
                                        // Admin 3: Generate full Report -------------------------------------------------------------------
                                        votingClient.displayCurrentResult(singerList, votingList);
                                        System.out.println("Enter [EXIT] to exit the system !");
                                        System.out.println("Enter ANYTHING to back the system !");
                                        String adminReport = sc.nextLine();
                                        adminReport = adminReport.toUpperCase();
                                        if (adminReport.equals("EXIT")) {
                                            System.exit(0);
                                        } else {
                                            validUser = false;
                                        }

                                        validAdmin = false;
                                    } else if (AdminOp.equals("4")) {
                                        // verify identity of voter
                                        // student id only start with 21, 22, 23, and 24
                                        // if student id begins with 21 and 22, search ascending, else, search descending

                                        System.out.println("As an Admin which Voter ID You Wish to View At the First ? ");
                                        System.out.println("Enter [21] or [23] for your choice : ");
                                        String adminVoterCh = sc.nextLine();

                                        //boolean searchAscending = voter.getStudentID().startsWith("21") || targetVoter.getStudentID().startsWith("22");

                                        if (adminVoterCh.equals("21") ){
                                            // ascending Order of Voter Id
                                            System.out.println(voterList.size());
                                            System.out.println(voterList.printAscending());
                                        }else if (adminVoterCh.equals("23")){
                                            // descending Order of Voter Id
                                            System.out.println(voterList.printDescending());
                                        }else {
                                            System.out.println("You can only enter [21] or [23] !");
                                            System.out.println("   Please enter again !");
                                        }

                                        System.out.println("");

                                    } else if (AdminOp.equals("5")){
                                        // allow user to search admin
                                        administrator.displayAdmin(adminList);
                                        administrator.searchAdmin(adminList);
                                        validUser = false;
                                    }else if (AdminOp.equals("6")) {

                                        administrator.displayAdminEvents(adminList);

                                        boolean addRemoveVld = true;
                                        do {
                                            System.out.println("Enter [ADD] to add new Admin !");
                                            System.out.println("Enter [REMOVE] to remove Admin !");
                                            System.out.println("Enter ANYTHING to back to the previous page !");
                                            String addRemove = sc.nextLine();
                                            addRemove = addRemove.toUpperCase();

                                            if (addRemove.equals("ADD")) {
                                                administrator.addAdmin(adminList);

                                            } else if (addRemove.equals("REMOVE")) {
                                                administrator.displayAdmin(adminList);
                                                administrator.deleteAdmin(adminList);

                                            } else {
                                                addRemoveVld = false;
                                            }
                                        } while (addRemoveVld);

                                    } else if (AdminOp.equals("7")) {
                                        System.out.println("             ======================");
                                        System.out.println("                 H I S T O R Y");
                                        System.out.println("             ======================");
                                        for(int i = 1; i <= VotingRecorder.getHistoryList().size(); i++){
                                            System.out.println("Voter: " + VotingRecorder.getHistoryList().getEntry(i).getVoterName());
                                            System.out.println("Voted For: " + VotingRecorder.getHistoryList().getEntry(i).getSingerName());
                                        }

                                    } else if(AdminOp.equals("8")){
                                        validAdmin = false;
                                    }else {
                                        // Validation for when user types in invalid option -----------------------------------
                                        System.out.println("Please Enter Valid Option !");
                                        validUser = false;
                                    }
                                } while (validAdmin);

                                // ========================================================================================
                            } else {
                                System.out.println("You are not Admin ! ! !");
                                System.out.println("Please enter the correct Option !");
                                // -----------------------------------------------------------------------------------------
                            }
                        } else if (AdLoginOpt.equals("2")){
                            vldAdminLog = false;

                        } else {
                            System.out.println("Please enter a Valid Option !");
                        }

                    } while (vldAdminLog);
                } else if (MenuOption.equals("4")){
                    System.exit(0);
                } else {
                    System.out.println("Please Enter Valid Option !");
                    validUser = false;
                }
            } while (validUser);
        }

        System.exit(0);
    }
}
