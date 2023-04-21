package Client;

// Name : Ong Tzi Min
// Student ID : 21WMR12541
import Entity.Singer;
import Entity.Voter;
import Entity.VotingRecorder;
import adt.DoublyLinkList;
import adt.DoublyLinkListInterface;
import adt.HashMapInterface;


import java.util.Scanner;

public class VoterBooth{

    private static DoublyLinkListInterface<Voter> voterList = new DoublyLinkList<>();


    static Scanner input = new Scanner(System.in);

    public static void register(DoublyLinkListInterface<Voter> dvoterList){
        System.out.println("\nPlease enter your name:");
        String name = input.nextLine();

        System.out.println("Please enter your student id:");
        String studID = input.nextLine();

        System.out.println("Please enter your password:");
        String password = input.nextLine();

        // add voter info to object
        Voter voter = new Voter(name, password, studID);

        boolean isRegistered = dvoterList.add(voter);

        if (isRegistered) {
            System.out.println("You have successfully registered as a voter!");

        } else {
            System.out.println("Failed to register as a voter!");
        }
    }

    public Voter login(DoublyLinkListInterface<Voter> voterList){

        Voter foundVoter = null;
        do{
            System.out.println("\nPlease enter your student id:");
            String studID = input.nextLine();

            System.out.println("Please enter your password:");
            String password = input.nextLine();

            // verify identity of voter
            for(int i = 1; i < voterList.size()+1; i++) {
                String pass = voterList.getEntry(i).getPassword();
                if(voterList.getEntry(i).getStudentID().compareTo(studID) == 0 && password.equals(pass)) {
                    foundVoter = voterList.getEntry(i);
                    break;
                }
            }

            if (foundVoter != null) {
                System.out.println("Welcome " + foundVoter.getName() + "!");
            } else {
                System.out.println("Invalid IC number or password!");
            }
        }while(foundVoter == null);

        return foundVoter;
    }

    public VotingRecorder castVote(Voter voter, HashMapInterface<String, Singer> singerList) {
        boolean foundSinger;
        VotingRecorder newVote = null;
        do {
            System.out.println("\nCast Vote");
            System.out.println("Please enter candidate id to cast your vote: ");
            String castVoteID = input.nextLine();

            // access singer list
            foundSinger = singerList.containsKey(castVoteID);
            if (foundSinger) {
                if(!voter.getVote()){
                    newVote = new VotingRecorder(voter, singerList.get(castVoteID));
                    voter.setVote(true);

                    System.out.println("VB " + newVote.getVoter().getName());
                    System.out.println("VB " + newVote.getSinger().getName());

                    System.out.println("You have successfully cast your vote!");
                }else{
                    System.out.println("You have already voted!");
                }
            }else{
                System.out.println("The candidate id is invalid");
            }
        } while (!foundSinger);

        return newVote;
    }

    public DoublyLinkListInterface<VotingRecorder> deleteAccount(Voter voter, DoublyLinkListInterface<VotingRecorder> voteList){

        boolean cont = true;
        do {

            System.out.println("Confirm to delete account permanently? (Y/N)");
            String deleteAcc = input.nextLine();

            if (deleteAcc.equals("Y") || deleteAcc.equals("y")) {
                boolean deleteVoter = voterList.remove(voter);
                if (deleteVoter) {

                    for(int i = 1; i <= voteList.size(); i++){
                        if(voteList.getEntry(i).getVoter().getStudentID().equals(voter.getStudentID())){
                            voteList.remove(voteList.getEntry(i));
                            System.out.println("Your voter account has been deleted!");
                            return voteList;
                        }
                    }

                    cont = false;
                }

            } else {
                System.out.println("Failed to delete your voter account!");
            }
        } while (cont);
        return voteList;
    }

    public static DoublyLinkListInterface<Voter> getVoterList() {
        return voterList;
    }



}