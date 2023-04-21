package Client;
import Entity.Singer;
import Entity.Song;
import Entity.Voter;
import adt.DoublyLinkListInterface;
import adt.HashMapInterface;
import adt.MyHashMap;

import java.util.Scanner;
// Name : Tan Jun Keat
// ID   : 21WMR12547
public class SingerBooth {
    Scanner scanner = new Scanner(System.in);
    private HashMapInterface<String, Singer> singerList;

    public SingerBooth(HashMapInterface<String, Singer> singerList) {
        this.singerList = singerList;
    }

    public Singer login(HashMapInterface<String, Singer> singerList){

        Singer foundSinger = null;
        do{
            System.out.println("\nPlease enter your singer id:");
            String studID = scanner.nextLine();

            System.out.println("Please enter your password:");
            String password = scanner.nextLine();

            // verify identity of voter
            if (singerList.containsKey(studID)) {
                Singer singer = singerList.get(studID);
                if (singer.getPassword().equals(password)) {
                    foundSinger = singer;
                    System.out.println("Welcome " + foundSinger.getName() + "!");
                }
            } else {
                System.out.println("Invalid singer ID or password!");
                break;
            }

            if (foundSinger == null) {
                System.out.println("Invalid singer ID or password!");
            }

        }while(foundSinger == null);

        return foundSinger;
    }

    public void addSinger(HashMapInterface<String, Singer> singerList) {
        // Generate a new ID for the singer by getting the next available number
        System.out.println("Please Enter the SingerID of [S00$] ");
        System.out.println("Enter Singer ID: ");
        String singerId = scanner.nextLine();
        while (!singerId.startsWith("S00")) {
            System.out.println("Invalid Singer ID. \nPlease enter a valid ID (starting with S00):");
            singerId = scanner.nextLine();
        }

        System.out.println("Enter Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        System.out.println("Enter IC Number: ");
        String icNo = scanner.nextLine();

        System.out.println("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.println("Enter Age: ");
        String age = scanner.nextLine();

        // Create new Singer object
        Singer newSinger = new Singer(singerId, name, password, icNo, gender, age);

        // Add the new singer to the map
        singerList.put(singerId, newSinger);

        System.out.println("[ " + name + "] have been added to the List !");
        System.out.println("        A P P R O V I N G");

    }

    public void removeSinger(HashMapInterface<String, Singer> singerList, String singerId) {
        // Remove the singer with the given ID from the map, if it exists
        if (singerList.containsKey(singerId)) {
            singerList.remove(singerId);
        } else {
            System.out.println(singerId + " is not existed !");
        }
    }

    public void displayAllSingerSong(HashMapInterface<String, Singer> singerList) {
        int index = 1;
        for (int i = 1; i <= singerList.size(); i++) {
            String key = Integer.toString(i);
            Singer singer = singerList.get("S00" + key);
            if (singer != null) {

                HashMapInterface<String, Song> songs = singer.getSongs();
                System.out.println("============================");
                System.out.println( singer.getName() + " Performed Song");
                System.out.println("============================");
                int index1 = 1;
                for (int j = 1; j <= songs.size(); j++) {
                    String key1 = Integer.toString(i);
                    Song song = songs.get("S" + key1);
                    if (songs != null) {
                        System.out.println("Title       : " + song.getTitles());
                        System.out.println("Category    : " + song.getCategory());
                        System.out.println("Produced By : " + song.getProduceBy());
                        System.out.println("=======================");
                        System.out.println();
                        index1 = index1+1;
                    }
                }

                index = index+1;
            }

        }
    }

    public void DisplaySinger (HashMapInterface<String, Singer> singerList){
        int index = 1;
        for (int i = 1; i <= singerList.size(); i++) {
            String key = Integer.toString(i);
            Singer singer = singerList.get("S00"+key);
            if (singer != null) {
                System.out.println("[" + index + "] " + singer.getName() + " --> " + singer.getId() + " <-- ");
                index++;
            }
        }
    }
    public void searchSingerById(String singerId){

        Singer singer = singerList.get(singerId);
        if (singer != null) {
            System.out.println("=======================");
            System.out.println("|----Singer Details---|");
            System.out.println("=======================");
            System.out.println("ID     : " + singer.getId());
            System.out.println("Name   : " + singer.getName());
            System.out.println("IC     : " + singer.getIcNo());
            System.out.println("Gender : " + singer.getGender());
            System.out.println("Age    : " + singer.getAge());
        } else {
            System.out.println("Singer with ID " + singerId + " not found.");
        }
    }

    public void editSingerInfo(String singerID) {

        System.out.println(singerID);
        System.out.println(singerList.containsKey(singerID));
        // Check if singer exists in HashMap
        if (singerList.containsKey(singerID)) {
            Singer singer = singerList.get(singerID);

            // Display current singer information
            System.out.println("Current singer information:");
            System.out.println(singer);

            // Prompt user for new singer information
            System.out.print("Enter new name (press Enter to keep current name): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                singer.setName(name);
            }

            System.out.print("Enter new password (press Enter to keep current password): ");
            String password = scanner.nextLine();
            if (!password.isEmpty()) {
                singer.setPassword(password);
            }

            System.out.print("Enter new IC number (press Enter to keep current IC number): ");
            String icNumber = scanner.nextLine();
            if (!icNumber.isEmpty()) {
                singer.setIcNo(icNumber);
            }

            System.out.print("Enter new gender (press Enter to keep current gender): ");
            String gender = scanner.nextLine();
            if (!gender.isEmpty()) {
                singer.setGender(gender);
            }

            System.out.print("Enter new age (press Enter to keep current age): ");
            String age = scanner.nextLine();
            if (!age.isEmpty()) {
                singer.setAge(age);
            }

            // Update singer information in HashMap
            singerList.put(singer.getId(), singer);

            System.out.println("Singer information updated successfully.");
        } else {
            System.out.println("Singer not found.");
        }
    }
}


