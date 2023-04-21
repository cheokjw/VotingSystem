package Client;

import Entity.Voter;
import Entity.VotingRecorder;
import adt.*;

import Entity.Singer;

import java.util.HashMap;

// Name : Cheok Jia Wei
// Student ID : 21WMR12521
public class VotingClient {
    private DoublyLinkListInterface<VotingRecorder> voteList = new DoublyLinkList<>();
    private HashMapInterface<String, Singer> singerList;
    private PriorityQueueInterface<Singer> singerVoteList = null;
    public static int count = 0;

    // Constructor (the list will be updated after every vote to keep on track)
    public VotingClient() {
    }

    public VotingClient(HashMapInterface<String, Singer> singerList){
        this.singerList = singerList;
    }

    // Search for specific singer and display their votes
    public void searchSingerVote(String singerID, HashMapInterface<String, Singer> singerList, DoublyLinkListInterface<VotingRecorder> voteList){
        boolean found = false;

        if(count != VotingRecorder.totalVotes){
            singerVoteList = countSingerVotes(singerList, voteList);
        }

        for (int i = 0; i < singerVoteList.size(); i++){

            if(singerVoteList.get(i).getId().equals(singerID)){
                System.out.println("===========================================");
                System.out.println("   Singer Name : " + singerVoteList.get(i).getName() );
                System.out.println("   Total Votes : " + singerVoteList.get(i).getVoteCount());
                System.out.println("==========================================");
                found = true;
            }
        }
        if (!found){
            System.out.println("Singer Not Found !");
        }

    }

    // Display the whole ranking for voter to view
    public void displayCurrentResult(HashMapInterface<String, Singer> singerList, DoublyLinkListInterface<VotingRecorder> voteList){
        if(count != VotingRecorder.totalVotes){
            singerVoteList = countSingerVotes(singerList, voteList);
        }
        int totalVotes = VotingRecorder.totalVotes;
        double percentage1, percentage2, percentage3;

        System.out.println("========================================");
        System.out.println("|          Singer Final Report         |");
        System.out.println("========================================");

        if (singerVoteList.size() >= 1) {
            Singer singer1 = singerVoteList.get(0);
            percentage1 = ((double)singer1.getVoteCount() / totalVotes) * 100;
            String formattedStr1 = String.format("| 1. %-20s  %4d votes  %4.1f%% |", singer1.getName(), singer1.getVoteCount(), percentage1);
            System.out.println(formattedStr1);
        }
        if (singerVoteList.size() >= 2) {
            Singer singer2 = singerVoteList.get(1);
            percentage2 = ((double)singer2.getVoteCount() / totalVotes) * 100;
            String formattedStr2 = String.format("| 2. %-20s  %4d votes  %4.1f%% |", singer2.getName(), singer2.getVoteCount(), percentage2);
            System.out.println(formattedStr2);
        }
        if (singerVoteList.size() >= 3) {
            Singer singer3 = singerVoteList.get(2);
            percentage3 = ((double)singer3.getVoteCount() / totalVotes) * 100;
            String formattedStr3 = String.format("| 3. %-20s  %4d votes  %4.1f%% |", singer3.getName(), singer3.getVoteCount(), percentage3);
            System.out.println(formattedStr3);
        }

        System.out.println("========================================");
        System.out.println("|         Total Vote Count: " + totalVotes + "        |");
        System.out.println("========================================");

    }



    // Counts respective singer votes and store them into PQ to auto sort them
    public PriorityQueueInterface<Singer> countSingerVotes(HashMapInterface<String, Singer> singerList, DoublyLinkListInterface<VotingRecorder> voteList){
        count += 1;
        PriorityQueueInterface<Singer> singerTempList = new PriorityQueue<>();

        // Convert singerList to singerVoteList
        for (int i = 1; i < singerList.size() + 1; i++){
            String key = Integer.toString(i);
            Singer singer = singerList.get("S00"+key);
            singerTempList.add(singer);
        }


        // Loops through the votelist

        for(int i = 1; i<=voteList.size(); i++){
                VotingRecorder vote = voteList.getEntry(i);
            for(int j=0; j<singerList.size(); j++){
                Singer voteSinger = singerList.get("S00"+Integer.toString(j+1));
                // Register vote into singer vote count
                if(vote.getSinger().getId().equals(voteSinger.getId())){

                    int singerCurrentVote = voteSinger.getVoteCount();
                    int incrementVote = singerCurrentVote + 1;
                    voteSinger.setVoteCount(incrementVote);
                    singerTempList.update(voteSinger);
                }
            }
        }

        return singerTempList;
    }

    public VotingRecorder editVote(Voter voter, Singer singer, DoublyLinkListInterface<VotingRecorder> voteList){
        int voteIndex = 0;
        boolean found = voter.getVote();
        VotingRecorder tempVote = null;


        if(!found){
            return null;
        }else {
            for(int i = 1; i<= voteList.size(); i++){
                if(voteList.getEntry(i).getVoter().getStudentID().equals(voter.getStudentID())){
                    int currentVote = voteList.getEntry(i).getSinger().getVoteCount() - 1;
                    voteList.getEntry(i).getSinger().setVoteCount(currentVote);
                }
            }
            VotingRecorder.totalVotes -= 1;
            count -= 1;
            tempVote = new VotingRecorder(voter, singer);
        }

        return tempVote;
    }

}




