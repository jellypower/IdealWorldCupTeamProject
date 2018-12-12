import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;



public class FILEDB{
	
	String driver = "org.sqlite.JDBC";
	String url = "jdbc:mysql:MySQLiteDB";
	String user = "admin";
	String password = "admin";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	
	private EntryComponent allImgList[];
	private EntryComponent entryComp[];
	private int numOfImg=0;
	private int nRound=0; 
	private String gender;
	
	
	FILEDB(String gender,int nRound)  throws SQLException{
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		conn = DriverManager.getConnection("jdbc:sqlite:MySQLiteDB");
		stmt = conn.createStatement();
		this.nRound = nRound;
		
		
		this.gender=gender;
		initImgList(gender);
		initEntryComp();
	}
	
	public EntryComponent[] getRandomImgList() {
		
		return entryComp;
	}
	
	
	public EntryComponent[] getAllImgList() {
		return allImgList;
		
	}
	
	public void closeDB() throws SQLException{
		rs.close();
		stmt.close();
		conn.close();
	}
	
	public void sortAllImgList() {
		Arrays.sort(allImgList);
	}
	
	public int getNumOfImg(String gender) throws SQLException {
		rs = stmt.executeQuery("select num from NUMOFPEOPLE where fieldname=\'"+gender+"\'");
		rs.next();
		return rs.getInt(1);
	}
	public void writeEditedValues(EntryComponent winner) throws SQLException{
		System.out.println(gender);
		System.out.println("update "+gender+" set victoryNum="+(winner.victoryNum)+" where addr=\'"+winner.image.getDescription()+"\'");
		stmt.executeUpdate("update "+gender+" set victoryNum="+(winner.victoryNum)+" where addr=\'"+winner.image.getDescription()+"\'");
	}
	
	private int[] getRandArr() {
		
		Random rand = new Random();
		
		int last=numOfImg;
		int randNum;
		
		int[] randIndex = new int[nRound];
		int[] randChckArr=new int[last];
		for(int i=0;i<last;i++) randChckArr[i]=i;
		for(int i=0;i<nRound;i++) {
			randNum=rand.nextInt(last);
			randIndex[i]=randChckArr[randNum];
			randChckArr[randNum]=randChckArr[--last];
		}



		return randIndex;
	}
	
	
	
	private void initImgList(String gender) throws SQLException {
		
		int index=0;
		
		numOfImg=getNumOfImg(gender);
		allImgList = new EntryComponent[numOfImg];
		
		rs = stmt.executeQuery("select * from "+gender);
		
		
		
		while ( rs.next() ) {
			allImgList[index++] = new EntryComponent(
					rs.getString("addr"),
					rs.getString("addr"), 
					rs.getString("name"), 
					rs.getInt("victoryNum"));
			
		}
	}
	
	private void initEntryComp() {
		entryComp = new EntryComponent[nRound];
		
		
		int randIndex[] = getRandArr();
		for(int i=0;i<nRound;i++) {
			entryComp[i]=allImgList[randIndex[i]];
		}
	}
	
	
	
	private void printImgList() {
		for(int i=0;i<numOfImg;i++) {
			System.out.println(allImgList[i].name+":"+allImgList[i].victoryNum);
		}
	}

	public int getNumofImg() {
		return numOfImg;
	}
	
	
}
