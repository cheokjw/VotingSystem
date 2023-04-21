## <b>TARUMT Singing Idols Voting System</b>
<hr/>
This is a Student Singing Contest Voting System for BACS 2063 Data Structures and Algorithms

# Developer <br/>
<b><h4>1. Cheok Jia Wei </h4></b>
- Task: Priority Array Queue and Voting Module <br/>

<b><h4>2. Ong Tzi Min </h4></b>
- Task: Doubly Linked List and Voter Module <br/>

<b><h4>3. Boo Zheng Feng </h4></b>
- Task: AVL Tree and Admin Module <br/>

<b><h4>4. Tan Jun Keat </h4></b>
- Task: Hashmap and Singer Module <br/><br/>

IDE: Intellij IDEA <br/><br/>

## Package Description
<hr>
1. adt = Abstract Datatype specification and implementation <br/>
2. client = Client program that handle the module <br/>
3. driver = The combination of whole Client, entity and adt to form a working system <br/>
4. entity = Entity of each object <br/><br/>

## ADT used in this program
<hr>
Instructions: Read the java interface files for understand the method to manipulate each adt <br/>
1. AVLTree = AVLTreeInterface <br/>
2. DoublyLinkList = DoublyLinkListInterface <br/>
3. HashMapInterface = MyHashMap <br/>
4. PriorityQueue = PriorityQueueInterface <br/><br/>

## Steps to use our program 
<hr>
1. Main Menu <br>
<img src ="./img/mainmenu.png"><br/>
Press 1 to select Voter Menu <br/>
Press 2 to select Singer Menu <br/>
Press 3 to select Admin Menu <br/>
Press 4 to Exit <br/><br/>

<b>Voter </b>
<hr>
<img src ="./img/voterMenu.png"><br/>
Press 1 to Register as Voter <br/>
Press 2 to Login as Voter <br/>
Press 3 to Go Back to Main Menu <br/><br/>

The system will register the voter account into DoublyLinkList and voter is able to continue login<br/><br/>

<img src ="./img/voterNestedMenu.png"><br/>
Press 1 to Display all available candidate and voter is able to either cast or edit their votes <br/>
Press 2 to Search for specific candidate and display their current vote score <br/>
Press 3 to Delete voter's current account <br/>
Press 4 to go back to Main Menu <br/><br/>

<b> Singer </b><br/>
<hr/>
Note: User is able to access this page by pressing 2 in Main menu <br/>
<img src ="./img/singerMenu.png"><br/>
Press 1 to edit Singer's individual information <br/>
Press 2 to Search for other Singer's Profile <br/>
Press 3 to Show all songs that Singer had performed <br/>
Press 4 to Go Back to Main Menu <br/><br/>

<b> Admin </b><br/>
<hr/>
Note: User is able to access this page by pressing 3 in Main menu <br/>
<img src ="./img/adminMenu.png"><br/>
Press 1 to delete a certain candidate by searching their singerID<br/>
Press 2 to insert a new candidate <br/>
Press 3 to Generate Top 3 Candidate Vote Result which consists of Percentage of votes <br/>
Press 4 to Show all Voters in this system <br/>
Press 5 to search for a specific admin <br/>
Press 6 to show event handled by admins <br/>
Press 7 to show Overall vote history to see what is the past history of vote activities <br/>
Press 8 to Go back to Main Menu <br/>












